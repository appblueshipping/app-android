package br.com.blueshipping.blueshipping.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.model.TrackingModel;
import br.com.blueshipping.blueshipping.utils.Utils;

/**
 * Created by aronuchoa on 17/05/17.
 */

public class TrackingListAdapter extends BaseAdapter {


    private Context mContext;
    private List<TrackingModel> mTrackingList;

    // Constructor

    public TrackingListAdapter(Context mContext, List<TrackingModel> mTrackingList) {
        this.mContext = mContext;
        this.mTrackingList = mTrackingList;
    }


    @Override
    public int getCount() {
        return mTrackingList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTrackingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.item_tracking_list, null);
        TextView txtDate = (TextView) v.findViewById(R.id.item_tracking_date);
        txtDate.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));
        TextView txtStatus = (TextView) v.findViewById(R.id.item_tracking_status);
        txtStatus.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));
        //ImageView iDocs = (ImageView) v.findViewById(R.id.item_tracking_docs);
        //TextView txtDocs = (TextView) v.findViewById(R.id.item_tracking_docs);

        //set text for TextView
        txtDate.setText(mTrackingList.get(position).getDate());
        txtStatus.setText(mTrackingList.get(position).getStatus());
        //txtDocs.setText(mTrackingList.get(position).getDoc());

        //save product id for tag
        v.setTag(mTrackingList.get(position));


        return v;
    }



}
