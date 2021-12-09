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
        setContentView(R.layout.activity_main);

        final Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        final Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);

        tv = findViewById(R.id.text);
        Integer nb = getResources().getInteger(R.integer.scount);

        fade.setAnimationListener(
                new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        int resId = getResources().getIdentifier("s" + verse++, "string", getPackageName());
                        text = getString(resId);
                        tv.setText(text);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        fade.cancel();
                        if (verse < nb+1) {
                            tv.startAnimation(fade);
                        }
                        else {
                            if (verse == nb+1) {
                                tv.startAnimation(fadein);
                            }
                        }
                    }
                }
        );
        tv.startAnimation(fade);
    }
}