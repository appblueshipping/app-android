package br.com.blueshipping.blueshipping.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.model.Tracking;
import br.com.blueshipping.blueshipping.model.TrackingStatusGeral;
import br.com.blueshipping.blueshipping.utils.Constants;
import br.com.blueshipping.blueshipping.utils.Utils;

public class TrackingResultActivity extends Activity {

    private TrackingStatusGeral mTrackingListObject;

    private Tracking mTracking;

    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_result);

        mTracking = (Tracking) getIntent().getSerializableExtra(Constants.PUT_TRACKING);
        mTrackingListObject = (TrackingStatusGeral) getIntent().getSerializableExtra(Constants.PUT_TRACKING_STATUS_GERAL);

        // UI
        btnBack = (ImageView) findViewById(R.id.item_custom_navigation_btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        populateTrackingTexts(mTracking);
        populateTrackingList(mTrackingListObject.getMtesteArray());

    }

    public void populateTrackingTexts(Tracking mTracking) {

        //Change Fonts
        TextView txtTitleResult = (TextView) findViewById(R.id.activity_tracking_result_titleResult);
        txtTitleResult.setTypeface(Utils.customFont("CoreSansD35Regular.otf"));

        TextView txtTitleBL = (TextView) findViewById(R.id.activity_tracking_result_titleBL);
        txtTitleBL.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtResultBL = (TextView) findViewById(R.id.activity_tracking_result_resultBL);
        txtResultBL.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtTitleType = (TextView) findViewById(R.id.activity_tracking_result_titleType);
        txtTitleType.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtResultType = (TextView) findViewById(R.id.activity_tracking_result_resultType);
        txtResultType.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtTitleCompany = (TextView) findViewById(R.id.activity_tracking_result_titleCompany);
        txtTitleCompany.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtResultCompany = (TextView) findViewById(R.id.activity_tracking_result_resultCompany);
        txtResultCompany.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtTitleOrigin = (TextView) findViewById(R.id.activity_tracking_result_titleOrigin);
        txtTitleOrigin.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtResultOrigin = (TextView) findViewById(R.id.activity_tracking_result_resultOrigin);
        txtResultOrigin.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtTitleFinalDestination = (TextView) findViewById(R.id.activity_tracking_result_titleFinalDestination);
        txtTitleFinalDestination.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtResultFinalDestination = (TextView) findViewById(R.id.activity_tracking_result_resultFinalDestination);
        txtResultFinalDestination.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtTitleExOrIm = (TextView) findViewById(R.id.activity_tracking_result_titleExOrIm);
        txtTitleExOrIm.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtResultExOrIm = (TextView) findViewById(R.id.activity_tracking_result_resultExOrIm);
        txtResultExOrIm.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtTitleDate = (TextView) findViewById(R.id.activity_tracking_result_titleDate);
        txtTitleDate.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtResultDate = (TextView) findViewById(R.id.activity_tracking_result_resultDate);
        txtResultDate.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtTitleStatus = (TextView) findViewById(R.id.activity_tracking_result_titleStatus) ;
        txtTitleStatus.setTypeface(Utils.customFont("CoreSansD35Regular.otf"));

        // Set texts
        txtResultBL.setText(mTracking.getBlawb());
        txtResultType.setText(mTracking.getType());
        txtResultCompany.setText(mTracking.getCompany());
        txtResultOrigin.setText(mTracking.getOrigin());
        txtResultFinalDestination.setText(mTracking.getFinaldestination());
        txtResultExOrIm.setText(mTracking.getExporter());
        txtResultDate.setText(mTracking.getDatainicio());

    }

    public void populateTrackingList(List<TrackingStatusGeral> mTrackingStatusGeral){


        // add sample data for list
        // we can get data from webservice here
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_tracking_listView_resultTracking);


        View vHeader =  getLayoutInflater().inflate(R.layout.header_tracking_list, null);
        TextView txtHeaderSDate = (TextView) vHeader.findViewById(R.id.header_tracking_txtTitleDate);
        txtHeaderSDate.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));
        TextView txtHeaderStatus = (TextView) vHeader.findViewById(R.id.header_tracking_txtTitleStatus);
        txtHeaderStatus.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));
        TextView txtHeaderDocs = (TextView) vHeader.findViewById(R.id.header_tracking_txtTitleDocs);
        txtHeaderDocs.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        linearLayout.addView(vHeader);


        for (final TrackingStatusGeral trackingStatusGeral : mTrackingStatusGeral) {
            View v = getLayoutInflater().inflate(R.layout.item_tracking_list, null);

            TextView txtDate = (TextView) v.findViewById(R.id.item_tracking_date);
            txtDate.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));
            TextView txtStatus = (TextView) v.findViewById(R.id.item_tracking_status);
            txtStatus.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));
            ImageView imgDocs = (ImageView) v.findViewById(R.id.item_tracking_docs);


            if (trackingStatusGeral.getDocumento().equals("false")) {

                imgDocs.setImageResource(R.drawable.ic_remove_white_24dp);
            }
            else {

                imgDocs.setImageResource(R.drawable.ic_link_white_24dp);

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        String url = trackingStatusGeral.getDocumento();
//                        Intent i = new Intent(Intent.ACTION_VIEW);
//                        i.setData(Uri.parse(url));
//                        startActivity(i);

                        Intent intent;
                        intent = new Intent(getApplicationContext(), WebViewActivity.class);
                        intent.putExtra(Constants.PUT_LINK_STATUS_GERAL, trackingStatusGeral.getDocumento());
                        startActivity(intent);
                    }
                });
            }

            txtDate.setText(trackingStatusGeral.getData());
            txtStatus.setText(trackingStatusGeral.getStatus());

            // set item content in view
            linearLayout.addView(v);
        }

    }

}
