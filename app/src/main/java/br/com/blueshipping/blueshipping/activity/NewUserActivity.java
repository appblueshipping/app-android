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

public class NewUserActivity extends Activity {

    Button btnCancelar;
    Button btnRegister;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);


        TextView txtTitleNewUser = (TextView) findViewById(R.id.activity_new_user_titleNewUser);
        txtTitleNewUser.setTypeface(Utils.customFont("CoreSansD25Light.otf"));

        EditText edtName = (EditText) findViewById(R.id.activity_new_user_edtName);
        edtName.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        EditText edtEmail = (EditText) findViewById(R.id.activity_new_user_edtEmail);
        edtEmail.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        EditText edtPhone = (EditText) findViewById(R.id.activity_new_user_edtPhone);
        edtPhone.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        EditText edtUserName = (EditText) findViewById(R.id.activity_new_user_edtUsername);
        edtUserName.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));


        btnBack = (ImageView) findViewById(R.id.activity_setting_btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnRegister = (Button) findViewById(R.id.activity_new_user_btnRegister);
        btnRegister.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));

        btnCancelar = (Button) findViewById(R.id.activity_new_user_btnCancelar);
        btnCancelar.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}
