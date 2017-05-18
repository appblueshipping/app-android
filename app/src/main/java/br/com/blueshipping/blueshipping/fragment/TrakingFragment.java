package br.com.blueshipping.blueshipping.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.activity.TrackingResultActivity;
import br.com.blueshipping.blueshipping.helper.ViewDialog;
import br.com.blueshipping.blueshipping.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrakingFragment extends Fragment {


    Button searchButton;

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
        EditText edtTextEnterCode = (EditText) getView().findViewById(R.id.fragment_tracking_edtCode);
        edtTextEnterCode.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        searchButton = (Button) getView().findViewById(R.id.fragment_tracking_btnTracking);
        searchButton.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));
        searchButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity(), "TRACKING NUMBER NOT FOUND");

//                Intent intent;
//                intent = new Intent(getActivity(), TrackingResultActivity.class);
//                startActivity(intent);
            }

        });



    }
}
