package br.com.blueshipping.blueshipping.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.activity.TrackingResultActivity;
import br.com.blueshipping.blueshipping.helper.ViewDialog;
import br.com.blueshipping.blueshipping.model.Tracking;
import br.com.blueshipping.blueshipping.model.TrackingStatusGeral;
import br.com.blueshipping.blueshipping.rest.TrackingService;
import br.com.blueshipping.blueshipping.utils.Constants;
import br.com.blueshipping.blueshipping.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrakingFragment extends Fragment {

    private TrackingService mTrackingService;
    private ProgressDialog mProgressDialog;

    Button searchButton;
    String mCode;
    boolean failedRequest;
    boolean serverError;
    String responseFailed;

    public TrakingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_traking, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        failedRequest = false;
        serverError = false;

        // Change Fonts
        TextView txtEnterCode = (TextView) getView().findViewById(R.id.fragment_tracking_txtEnterCode);
        txtEnterCode.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        final EditText edtTextEnterCode = (EditText) getView().findViewById(R.id.fragment_tracking_edtCode);
        edtTextEnterCode.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String code = preferences.getString("Code", "");
        if(!code.equalsIgnoreCase(""))
        {
            edtTextEnterCode.setText(code);
        }

        searchButton = (Button) getView().findViewById(R.id.fragment_tracking_btnTracking);
        searchButton.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));
        searchButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                mCode = edtTextEnterCode.getText().toString();

                if (!(mCode.isEmpty())) {

                    mProgressDialog = Utils.getProgressDialog(getActivity());
                    mProgressDialog.show();

                    new LongOperation().execute("");

//                    // Service
//                    mTrackingService = new TrackingService(TrakingFragment.this);
//                    mTrackingService.requestJsonResponse(mCode);
//                    mMyTrackingService = new MyTrackingService(getContext());
//                    if (!mMyTrackingService.requestMyTrackingService(TrakingFragment.this, mCode)){
//                        mProgressDialog.dismiss();
//                        //Utils.showDialogWithoutCancel(this, getString(R.string.dlg_network_error_title),getString(R.string.dlg_network_error_message),null);
//                    }

                }
                else {

                    ViewDialog alert = new ViewDialog();
                    alert.showDialog(getActivity(), "TYPE THE TRACKING NUMBER");
                }

            }

        });

    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String url = "https://www.blueshipping.com.br/index.php/wp-json/wp/v2/rastreamento?search=";
            String urlRequest = url + mCode;

            try{
                getJSONObjectFromURL(urlRequest);

                // Parse your json here

            } catch (IOException | JSONException e) {
                e.printStackTrace();

                serverError = true;
                responseFailed = "SERVER ERROR, TRY LATER";

            }

            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
            if (failedRequest){

                mProgressDialog.dismiss();

                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), responseFailed);
            }
            if (serverError){

                mProgressDialog.dismiss();

                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), responseFailed);
            }
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

    public void getJSONObjectFromURL(String urlString) throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        System.out.println("JSON: " + jsonString);

//        if (jsonString != null){
//
//
//        }

        JSONArray jsonArray = new JSONArray(jsonString);

        ArrayList<TrackingStatusGeral> statusGeralList = new ArrayList<>();

        if (jsonArray.length() != 0) {

            failedRequest = false;
            serverError = false;

            JSONObject acf = ((JSONObject) jsonArray.get(0)).getJSONObject("acf");

            JSONArray jsonStatus = acf.getJSONArray("statusgeral");

            for (int j = 0; j < jsonStatus.length(); j++) {

                JSONObject jsonStatu = ((JSONObject) jsonStatus.get(j));
                TrackingStatusGeral statusGeral = new TrackingStatusGeral(jsonStatu);
                statusGeralList.add(statusGeral);

            }
            TrackingStatusGeral mTrackStatusGeral = new TrackingStatusGeral(statusGeralList);
            Tracking mTrackACF = new Tracking(acf);

//            System.out.println(mTrackACF.getBlawb());
//            System.out.println(mTrackStatusGeral.getStatus());
            mProgressDialog.dismiss();

            Utils.saveCodeSharedPreferences(getActivity(), mCode);

            Intent intent = new Intent(getActivity(), TrackingResultActivity.class);
            intent.putExtra(Constants.PUT_TRACKING, mTrackACF);
            intent.putExtra(Constants.PUT_TRACKING_STATUS_GERAL, mTrackStatusGeral);
            startActivity(intent);

        }
        else {

            failedRequest = true;
            responseFailed = "TRACKING NUMBER NOT FOUND";
        }

//        return new JSONObject(jsonString);
//        return acf;
    }

//    @Override
//    public void onTrackingServiceSuccessfully(Tracking trackingService, TrackingStatusGeral trackingStatusGeral) {
//
//        mProgressDialog.dismiss();
//
//        Utils.saveCodeSharedPreferences(getActivity(), mCode);
//
//        Intent intent = new Intent(getActivity(), TrackingResultActivity.class);
//        intent.putExtra(Constants.PUT_TRACKING, trackingService);
//        intent.putExtra(Constants.PUT_TRACKING_STATUS_GERAL, trackingStatusGeral);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onTrackingServiceFailed(String responseFailed) {
//
//        mProgressDialog.dismiss();
//
//        ViewDialog alert = new ViewDialog();
//        alert.showDialog(getActivity(), responseFailed);
//
//    }

}
