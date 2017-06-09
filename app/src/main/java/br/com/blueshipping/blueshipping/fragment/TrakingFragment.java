package br.com.blueshipping.blueshipping.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.Serializable;
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
public class TrakingFragment extends Fragment implements TrackingService.TrackingServiceListener {

    private TrackingService mTrackingService;
    private ProgressDialog mProgressDialog;

    Button searchButton;
    String mCode;

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

                    // Service
                    mTrackingService = new TrackingService(TrakingFragment.this);
                    mTrackingService.requestJsonResponse(mCode);

                }
                else {

                    ViewDialog alert = new ViewDialog();
                    alert.showDialog(getActivity(), "DIGITE O CÓDIGO DE RASTREIO");
                }

            }

        });

    }

    @Override
    public void onTrackingServiceSuccessfully(Tracking trackingService, TrackingStatusGeral trackingStatusGeral) {

        mProgressDialog.dismiss();

        Utils.saveCodeSharedPreferences(getActivity(), mCode);

        Intent intent = new Intent(getActivity(), TrackingResultActivity.class);
        intent.putExtra(Constants.PUT_TRACKING, trackingService);
        intent.putExtra(Constants.PUT_TRACKING_STATUS_GERAL, trackingStatusGeral);
        startActivity(intent);
    }

    @Override
    public void onTrackingServiceFailed(String responseFailed) {

        mProgressDialog.dismiss();

        ViewDialog alert = new ViewDialog();
        alert.showDialog(getActivity(), responseFailed);

    }
}
