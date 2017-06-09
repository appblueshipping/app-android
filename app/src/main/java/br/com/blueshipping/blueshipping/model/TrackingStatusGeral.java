package br.com.blueshipping.blueshipping.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by aronuchoa on 18/05/17.
 */

public class TrackingStatusGeral implements Serializable {

    public String data;
    public String status;
    public String documento;

    private ArrayList<TrackingStatusGeral> mtesteArray = new ArrayList<>();

    public TrackingStatusGeral(ArrayList<TrackingStatusGeral> mtesteArray) {
        this.mtesteArray = mtesteArray;
    }

    public TrackingStatusGeral(JSONObject jsonObject) {

        try {

            data = jsonObject.isNull("data") ? "" : jsonObject.getString("data");
            status = jsonObject.isNull("status") ? "" : jsonObject.getString("status");
            documento = jsonObject.isNull("documento") ? "" : jsonObject.getString("documento");

        } catch (JSONException e) {

            e.printStackTrace();

        }
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getDocumento() {
        return documento;
    }

    public ArrayList<TrackingStatusGeral> getMtesteArray() {
        return mtesteArray;
    }
}
