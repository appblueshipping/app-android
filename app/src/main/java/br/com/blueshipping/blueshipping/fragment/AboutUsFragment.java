package br.com.blueshipping.blueshipping.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    ImageButton mPlayButton;

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_about_us, container, false);

        // Inflate the layout for this fragment
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        TextView txtTitleAboutUs = (TextView) getView().findViewById(R.id.fragment_about_us_titleAboutUs);
//        txtTitleAboutUs.setTypeface(Utils.customFont("CoreSansD25Light"));
//
//        TextView txtDescriptionAboutUs = (TextView) getView().findViewById(R.id.fragment_about_us_descriptionAboutUs);
//        txtDescriptionAboutUs.setTypeface(Utils.customFont("CoreSansD25Light"));

        TextView txtTitleAboutUs = (TextView) getView().findViewById(R.id.fragment_about_us_titleAboutUs);
        txtTitleAboutUs.setTypeface(Utils.customFont("CoreSansD25Light.otf"));

        TextView txtDescriptionAboutUs = (TextView) getView().findViewById(R.id.fragment_about_us_descriptionAboutUs);
        txtDescriptionAboutUs.setTypeface(Utils.customFont("CoreSansD25Light.otf"));

        openVideoOnVideoView();
    }


    @Nullable
    public void openVideoOnVideoView() {

        // Setup a play button to start the video
        mPlayButton = (ImageButton) getView().findViewById(R.id.fragment_abou_us_play_button);

        mPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                VideoView video = (VideoView) getView().findViewById(R.id.fragment_about_us_videoView);

                video.setVideoURI(Uri.parse("http://www.blueshipping.com.br/video2017/videoinstitucional.mp4"));

                video.setMediaController(new MediaController(getActivity())); //sets MediaController in the video view

                // MediaController containing controls for a MediaPlayer

                v.requestFocus();//give focus to a specific view

                //v.start();//starts the video

                if (video.isPlaying()) {



                }
                else {

                    video.start();
                    // hide button once playback starts
                    mPlayButton.setVisibility(View.GONE);
                }

            }
        });

    }

}
