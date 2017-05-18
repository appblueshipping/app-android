package br.com.blueshipping.blueshipping.utils;

import android.graphics.Typeface;

import br.com.blueshipping.blueshipping.infrastructure.MyApplication;

/**
 * Created by aronuchoa on 17/05/17.
 */

public abstract class Utils {

    public static Typeface customFont(String font){

        String path = "fonts/" + font;
        return Typeface.createFromAsset(MyApplication.getContext().getAssets(),  path);
    }
}
