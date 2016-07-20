package in.nimishs.funwithflags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayFlagOfTheWeek(View v) {
        Intent intent = new Intent(this, FlagOfTheWeek.class);
        startActivity(intent);
    }

    public void playFwagOrNotAFwag(View v) {
        Intent intent = new Intent(this, FwagOrNotAFwag.class);
        startActivity(intent);

    }

    public void learnVexillophile(View v) {
        Intent intent = new Intent(this, Vexillophile.class);
        startActivity(intent);
    }
}
