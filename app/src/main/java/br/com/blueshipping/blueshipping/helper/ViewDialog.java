package br.com.blueshipping.blueshipping.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.activity.TrackingResultActivity;
import br.com.blueshipping.blueshipping.rest.TrackingService;
import br.com.blueshipping.blueshipping.utils.Utils;
import cz.msebera.android.httpclient.Header;

/**
 * Created by aronuchoa on 17/05/17.
 */

public class ViewDialog {


    public void showDialog(final Activity activity, String msg){

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);


        TextView text = (TextView) dialog.findViewById(R.id.txt_dialog);
        text.setTypeface(Utils.customFont("CoreSansD15Thin.otf"));
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}