package org.wadael.fearlitany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation fade = null;
    TextView tv = null;

    String text = null;
    int verse = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        fade = AnimationUtils.loadAnimation(this, R.anim.fade);

        /*
        final Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        final Animation fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        */

        //  LinearLayout whole = findViewById(R.id.whole);
        tv = findViewById(R.id.text);
        Integer nb = getResources().getInteger(R.integer.scount);

        fade.setAnimationListener(
                new Animation.AnimationListener(){
                    @Override
                    public void onAnimationStart(Animation animation) {
                        int resId = getResources().getIdentifier("s" + verse, "string", getPackageName());
                        String s = getString(resId);
                        tv.setText(s);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        verse++;
                        fade.reset();

                        if(verse<=nb) tv.startAnimation(fade);
                    }

                }
        );

        tv.startAnimation(fade);

        }
    }