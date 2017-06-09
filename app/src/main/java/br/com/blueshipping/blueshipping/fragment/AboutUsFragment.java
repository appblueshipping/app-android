package br.com.blueshipping.blueshipping.fragment;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.InputStream;
import java.net.URL;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.utils.Utils;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {

    //private final String urlVideo = "http://192.168.0.88:8888/video.mp4";
    private final String urlPhoto = "http://www.blueshipping.com.br/video2017/framevideo.jpg";
    private final String urlVideo = "https://www.blueshipping.com.br/video2017/videoinstitucional.mp4";

    // UI
    ImageView mPlayButton;
    ImageView mImageVideo;

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //mPlayButton.setVisibility(View.VISIBLE);

        TextView txtTitleAboutUs = (TextView) getView().findViewById(R.id.fragment_about_us_titleAboutUs);
        txtTitleAboutUs.setTypeface(Utils.customFont("CoreSansD25Light.otf"));

        TextView txtDescriptionAboutUs = (TextView) getView().findViewById(R.id.fragment_about_us_descriptionAboutUs);
        txtDescriptionAboutUs.setTypeface(Utils.customFont("CoreSansD25Light.otf"));

        openInitialframeOfVideoView();
        openVideoOnVideoView();
    }

    @Nullable
    public void openInitialframeOfVideoView() {


        //Initialize ImageView
        mImageVideo = (ImageView) getView().findViewById(R.id.fragment_about_us_image_video);

        //Loading image from below url into imageView

        Picasso.with(getActivity())
                .load(urlPhoto)
                .into(mImageVideo);


    }


    @Nullable
    public void openVideoOnVideoView() {

        // Setup a play button to start the video
        mPlayButton = (ImageView) getView().findViewById(R.id.fragment_abou_us_play_button);
        //mImageVideo = (ImageView) getView().findViewById(R.id.fragment_about_us_image_video);

        mPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                startActivity(new Intent(getActivity(), VideoViewActivity.class));

                Intent intent = new Intent(Intent.ACTION_VIEW );
                intent.setDataAndType(Uri.parse(urlVideo), "video/*");
                startActivity(intent);
            }
        });

    }

}
