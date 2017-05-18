package br.com.blueshipping.blueshipping.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {

    Button sendEmailButton;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_us, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView txtTitleContactUs = (TextView) getView().findViewById(R.id.fragment_contact_us_titleContactUs);
        txtTitleContactUs.setTypeface(Utils.customFont("CoreSansD25Light.otf"));

        TextView txtNumberPhone = (TextView) getView().findViewById(R.id.fragment_contact_us_numberPhone);
        txtNumberPhone.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtEmail = (TextView) getView().findViewById(R.id.fragment_contact_us_email);
        txtEmail.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        TextView txtSite = (TextView) getView().findViewById(R.id.fragment_contact_us_site);
        txtSite.setTypeface(Utils.customFont("CoreSansD45Medium.otf"));

        sendEmailButton = (Button) getView().findViewById(R.id.fragment_contact_us_btnContactUs);
        sendEmailButton.setTypeface(Utils.customFont("CoreSansD55Bold.otf"));

        sendEmailButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                sendEmail();
            }
        });
    }

    public void sendEmail() {

        Intent intent=new Intent(Intent.ACTION_SEND);
        String[] recipients={"sistemas@teste.com.br"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"FaleConosco[Enviado pelo aplicativo]");
        intent.putExtra(Intent.EXTRA_TEXT,"Escreva aqui sua mensagem");
        intent.setType("text/html");
        startActivity(Intent.createChooser(intent, "Enviar e-mail"));
    }

}
