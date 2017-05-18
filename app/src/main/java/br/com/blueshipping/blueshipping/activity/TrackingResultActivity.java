package br.com.blueshipping.blueshipping.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.adapter.TrackingListAdapter;
import br.com.blueshipping.blueshipping.model.TrackingModel;
import br.com.blueshipping.blueshipping.utils.Utils;

public class TrackingResultActivity extends Activity {

    private ListView lvTracking;
    private TrackingListAdapter adapter;
    private List<TrackingModel> mTrackingList;

    ImageView btnBack;
    ImageView btnLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_result);

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


        btnBack = (ImageView) findViewById(R.id.activity_tracking_result_btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

//        btnLink = (ImageView) findViewById(R.id.item_tracking_docs);
//        btnLink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent;
//                intent = new Intent(getApplicationContext(), WebViewActivity.class);
//                startActivity(intent);
//            }
//        });

        // TODO - falta alterar a font da listView e header

        lvTracking = (ListView) findViewById(R.id.activity_tracking_listView_resultTracking);

        mTrackingList = new ArrayList<>();

        // add header

        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.header_tracking_list, null, false);

        lvTracking.addHeaderView(header);

        // add sample data for list
        // we can get data from webservice here
        mTrackingList.add(new TrackingModel("12/06","Description 1"));
        mTrackingList.add(new TrackingModel("14/06","Description 2 Description 2 Description 2 Description 2 Description 2"));
        mTrackingList.add(new TrackingModel("20/06","Description 3"));
        mTrackingList.add(new TrackingModel("22/06","Description 4 Description 4 Description 4 Description 4"));
        mTrackingList.add(new TrackingModel("24/06","Description 5"));
        mTrackingList.add(new TrackingModel("26/06","Description 6"));
        mTrackingList.add(new TrackingModel("30/06","Description 7"));


        //init adapter
        adapter = new TrackingListAdapter(getApplicationContext(), mTrackingList);
        lvTracking.setAdapter(adapter);



        lvTracking.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                // Do something
//                Toast.makeText(getApplicationContext(),"Clicked product id =" + position, Toast.LENGTH_SHORT).show();
                Intent intent;
                intent = new Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(intent);
            }
        });


    }
}
