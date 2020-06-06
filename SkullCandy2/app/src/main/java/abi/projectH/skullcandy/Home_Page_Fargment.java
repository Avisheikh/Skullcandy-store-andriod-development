package abi.projectH.skullcandy;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;

import java.util.Locale;


public class Home_Page_Fargment extends Fragment {

    ViewFlipper v_flipper;
    private TextView textView;

    private CountDownTimer countDownTimer;
    private final long startTime = 160000000;
    private long timeLeft = startTime;


    //Referencing images for viewflipper
    int images[] = {R.drawable.slidea,R.drawable.slideb, R.drawable.slidec};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home__page, container, false);

        textView = (TextView)  rootView.findViewById(R.id.timer);

        startTimer();

        //Simple View Animator that will animate between two or more views that have been added to it.
        v_flipper = (ViewFlipper) rootView.findViewById(R.id.flipper);


        // for loop to get images to slide
        for(int i=0; i < images.length; i++){
            // This will create dynamic image views and add them to the ViewFlipper.
            flipperImages(images[i]);
        }









        return rootView;
    }


    public void flipperImages(int image)
    {
        Log.i("Set Filpper Called", image+"");
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        //set animation
        v_flipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);


    }

    private void startTimer()
    {
        countDownTimer = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

            }
        }.start();


    }

    private void updateCountDownText()
    {
        int hour = (int) (timeLeft/1000) / 36000;
        int min = (int) ((timeLeft/1000) % 3600) / 60;
        int sec = (int) (timeLeft/1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%d:%02d:%02d",hour,min,sec);
        textView.setText(timeLeftFormatted);



    }


}
