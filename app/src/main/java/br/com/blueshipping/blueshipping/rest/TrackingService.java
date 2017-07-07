package br.com.blueshipping.blueshipping.rest;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import br.com.blueshipping.blueshipping.model.Tracking;
import br.com.blueshipping.blueshipping.model.TrackingStatusGeral;
import cz.msebera.android.httpclient.Header;

/**
 * Created by aronuchoa on 18/05/17.
 */

public class TrackingService {

    private final String URL_JSON = "https://www.blueshipping.com.br/index.php/wp-json/wp/v2/";
    private final String service = "rastreamento?search="; //RW12344

    private TrackingServiceListener listener;

    public TrackingService(TrackingServiceListener listener) {

        this.listener = listener;
    }

    public void requestJsonResponse(String code) throws NoSuchAlgorithmException {

        AsyncHttpClient client = new AsyncHttpClient();

        String urlService = URL_JSON + service + code;

        client.get (urlService, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if (responseBody != null) {

                    String response = new String(responseBody);
                    Log.d(TrackingService.class.getSimpleName(), "response");

                    ArrayList<TrackingStatusGeral> statusGeralList = new ArrayList<>();

                    try {

                        JSONArray jsonArray = new JSONArray(response);

                        if (jsonArray.length() != 0) {

                            JSONObject acf = ((JSONObject) jsonArray.get(0)).getJSONObject("acf");

                            JSONArray jsonStatus = acf.getJSONArray("statusgeral");

                            for (int j = 0; j < jsonStatus.length(); j++) {

                                JSONObject jsonStatu = ((JSONObject) jsonStatus.get(j));
                                TrackingStatusGeral statusGeral = new TrackingStatusGeral(jsonStatu);
                                statusGeralList.add(statusGeral);

                            }
                            TrackingStatusGeral mtrack = new TrackingStatusGeral(statusGeralList);
                            Tracking tracking = new Tracking(acf);

                            listener.onTrackingServiceSuccessfully(tracking, mtrack);
                        }

                        else {

                            listener.onTrackingServiceFailed("TRACKING NUMBER NOT FOUND");
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                String response = "ERROR TRYING TRACKING NUMBER";
                if (responseBody != null) response = new String(responseBody);

                listener.onTrackingServiceFailed(response);

            }
        });


    }

    public interface TrackingServiceListener{

        void onTrackingServiceSuccessfully(Tracking trackingService, TrackingStatusGeral statusGeral);
        void onTrackingServiceFailed(String responseFailed);
    }

}
