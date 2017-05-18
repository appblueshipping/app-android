package br.com.blueshipping.blueshipping.model;

import android.widget.ImageView;

/**
 * Created by aronuchoa on 17/05/17.
 */

public class TrackingModel {


    private String date;
    private String status;
    //private ImageView doc;
    //private String doc;

    // Constructor


    public TrackingModel(String date, String status) {
        this.date = date;
        this.status = status;
    }

    // Setter, getter

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
