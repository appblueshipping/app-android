package br.com.blueshipping.blueshipping.model;

import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by aronuchoa on 18/05/17.
 */

public class Tracking implements Serializable {

    private String blawb;
    private String type;
    private String company;
    private String origin;
    private String finaldestination;
    private String exporter;
    private String datainicio;

    public Tracking(JSONObject jsonObject) {

        try {
            blawb = jsonObject.isNull("blawb") ? "" : jsonObject.getString("blawb");
            type = jsonObject.isNull("type") ? "" : jsonObject.getString("type");
            company = jsonObject.isNull("company") ? "" : jsonObject.getString("company");
            origin = jsonObject.isNull("origin") ? "" : jsonObject.getString("origin");
            finaldestination = jsonObject.isNull("finaldestination") ? "" : jsonObject.getString("finaldestination");
            exporter = jsonObject.isNull("exporter") ? "" : jsonObject.getString("exporter");
            datainicio = jsonObject.isNull("datainicio") ? "" : jsonObject.getString("datainicio");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getBlawb() {
        return blawb;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getOrigin() {
        return origin;
    }

    public String getFinaldestination() {
        return finaldestination;
    }

    public String getExporter() {
        return exporter;
    }

    public String getDatainicio() {
        return datainicio;
    }
}
