package br.com.blueshipping.blueshipping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.utils.Utils;

public class SettingActivity extends Activity {

    ImageView btnBack;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        TextView txtTilteProfile = (TextView) findViewById(R.id.activity_setting_titleProfile);
        txtTilteProfile.setTypeface(Utils.customFont("CoreSansD25Light.otf"));

        EditText edtName = (EditText) findViewById(R.id.activity_setting_edtName);
        edtName.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        EditText edtEmail = (EditText) findViewById(R.id.activity_setting_edtEamil);
        edtEmail.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        EditText edtPhone = (EditText) findViewById(R.id.activity_setting_edtPhone);
        edtPhone.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        EditText edtUserName = (EditText) findViewById(R.id.activity_setting_edtUsername);
        edtUserName.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        btnBack = (ImageView) findViewById(R.id.activity_setting_btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnLogout = (Button) findViewById(R.id.activity_setting_btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //finish();
            }
        });

    }
}
