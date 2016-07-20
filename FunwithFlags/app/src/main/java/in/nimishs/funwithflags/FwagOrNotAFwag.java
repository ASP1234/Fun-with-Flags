package in.nimishs.funwithflags;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FwagOrNotAFwag extends AppCompatActivity {

    ProgressBar barTimer;
    Drawable[] flags;
    int count = 0, score = 0, numFlags = 25;
    boolean[] key = new boolean[numFlags];
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_fwag_or_not_afwag);
        barTimer = (ProgressBar) findViewById(R.id.progressBarToday);
        getFlags();
        startTimer(count);

    }


    private void getFlags() {
        flags = new Drawable[numFlags];

        for (int j = 1; j <= numFlags; j++) {
            flags[j - 1] = ContextCompat.getDrawable(this, getResources().getIdentifier("flag" + j, "drawable", getPackageName()));
            key[j - 1] = true;
        }

        key[15] = false;
        key[16] = false;
        key[21] = false;
        key[23] = false;
        key[24] = false;

    }

    private void startTimer(final int i) {

        count = i;
        ImageView flagView = (ImageView) findViewById(R.id.flag_image);
        flagView.setImageDrawable(flags[i]);

        TextView flagCountView = (TextView) findViewById(R.id.flag_count);
        flagCountView.setText(String.format("%d", count + 1));

        countDownTimer = new CountDownTimer(10 * 1000, 1) {
            //1 means, onTick function will be called at every 1 milliseconds

            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = leftTimeInMilliseconds / 1000;
                barTimer.setProgress((int) seconds);

            }

            @Override
            public void onFinish() {
                barTimer.setProgress(30);
                disableAction();
            }
        }.start();

    }

    public void fwag(View v) {
        if (key[count]) {
            score += 100;
            updateScore();
        } else
            bazinga();


    }

    private void updateScore() {
        TextView scoreView = (TextView) findViewById(R.id.score_count);
        scoreView.setText(String.format("%d", score));
        countDownTimer.cancel();
        disableAction();
    }

    private void disableAction() {
        if (count + 1 < numFlags)
            startTimer(count + 1);
        else
            bazinga();
    }

    private void bazinga() {
        CardView cardView = (CardView) findViewById(R.id.card_view);
        cardView.setVisibility(View.GONE);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.fwag_or_not_a_fwag);
        layout.setBackgroundColor(Color.parseColor("#ED1C24"));

        ImageView imageView = (ImageView) findViewById(R.id.bazinga);
        imageView.setVisibility(View.VISIBLE);

        countDownTimer.cancel();
    }

    public void notAFwag(View v) {
        if (!key[count]) {
            score += 100;
            updateScore();
        } else
            bazinga();

    }
}
