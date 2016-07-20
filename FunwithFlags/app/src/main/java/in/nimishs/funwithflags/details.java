package in.nimishs.funwithflags;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        int resourceId = extras.getInt("RESOURCE_ID");
        checkID(resourceId);
    }

    private void checkID(int id) {
        switch (id) {
            case R.drawable.type_bend_sinister:
                updateData(R.drawable.bend_sinister, R.string.bend_sinister, R.string.bend_sinister_details);
                break;
            case R.drawable.type_border:
                updateData(R.drawable.border, R.string.border, R.string.border_details);
                break;
            case R.drawable.type_canton:
                updateData(R.drawable.canton, R.string.canton, R.string.canton_details);
                break;
            case R.drawable.type_chevron:
                updateData(R.drawable.chevron, R.string.chevron, R.string.chevron_details);
                break;
            case R.drawable.type_fess:
                updateData(R.drawable.fess, R.string.fess, R.string.fess_details);
                break;
            case R.drawable.type_greek_cross:
                updateData(R.drawable.greek_cross, R.string.greek_cross, R.string.greek_cross_details);
                break;
            case R.drawable.type_nordic_cross:
                updateData(R.drawable.nordic_cross, R.string.nordic_cross, R.string.nordic_cross_details);
                break;
            case R.drawable.type_pale:
                updateData(R.drawable.pale, R.string.pale, R.string.pale_details);
                break;
            case R.drawable.type_pall:
                updateData(R.drawable.pall, R.string.pall, R.string.pall_details);
                break;
            case R.drawable.type_quadrisection:
                updateData(R.drawable.quadrisection, R.string.quadrisection, R.string.quadrisection_details);
                break;
            case R.drawable.type_saltire:
                updateData(R.drawable.saltire, R.string.saltire, R.string.saltire_details);
                break;
            case R.drawable.type_symmetric_cross:
                updateData(R.drawable.symmetric_cross, R.string.symmetric_cross, R.string.symmetric_cross_details);
                break;
        }
    }

    private void updateData(int flagID, int titleID, int detailId) {
        ImageView flagView = (ImageView) findViewById(R.id.detail_flag);
        flagView.setImageResource(flagID);

        TextView titleView = (TextView) findViewById(R.id.detail_title);
        titleView.setText(getResources().getString(titleID));

        TextView detailView = (TextView) findViewById(R.id.detail_text);
        detailView.setText(getResources().getString(detailId));
    }
}
