package br.com.blueshipping.blueshipping.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.icu.util.Currency;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.utils.Utils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    Button loginButton;
    Button registerButton;
    Button forgotPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Change Fonts
        TextView txtUsername = (TextView)findViewById(R.id.activity_login_txt_userName);
        txtUsername.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));

        TextView txtPassword = (TextView)findViewById(R.id.activity_login_txt_password);
        txtPassword.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));


        //Set Buttons
        loginButton = (Button) findViewById(R.id.activity_login_btnAuthentication);
        loginButton.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));
        loginButton.setOnClickListener(this);

        registerButton = (Button) findViewById(R.id.activity_login_btnGoSignup);
        registerButton.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));
        registerButton.setOnClickListener(this);

        forgotPasswordButton = (Button) findViewById(R.id.activity_login_btnForgotPassword);
        forgotPasswordButton.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));
        forgotPasswordButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()){

            case R.id.activity_login_btnAuthentication:

                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                //checksAllFields();
                break;

            case R.id.activity_login_btnForgotPassword:

                intent = new Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(intent);
                break;

            case R.id.activity_login_btnGoSignup:

                intent = new Intent(getApplicationContext(), NewUserActivity.class);
                startActivity(intent);
                break;
        }
    }


//    private void checksAllFields(){
//
//        String email = edtEmail.getText().toString();
//        String password = edtPass.getText().toString();
//
//        if (email.isEmpty() || password.isEmpty()){
//            Utils.showToast(this, getString(R.string.dlg_invalid_fields));
//            return;
//        }
//
//        if (!Utils.isValidEmail(email)){
//            Utils.showToast(this, getString(R.string.dlg_invalid_email_message));
//            return;
//        }
//
//        Utils.disableButton(btnAuthentication, pbAuthentication);
//        if (!mAuthenticationService.requestAuthentication(this, email, password)){
//            Utils.enableButton(btnAuthentication, pbAuthentication);
//        }
//    }



}
