package sample.android.com.autocompletetextviewexample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView searchView;
    // String[] country = {"Bangladesh" , "Canada", "Denmark", "Japan", "Jordan", "Pakistan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        searchView = findViewById(R.id.aucompleteTxtViewId);

        String[] country = getResources().getStringArray(R.array.country);

        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.sample_layout, R.id.txtViewId, country);

        searchView.setAdapter(adapter);
    }


    public void showAlert(View view) {
        showDialog();
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setTitle("Exit ?");
        builder.setCancelable(false);
        builder.setMessage("Are you sure to exit ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("NO", null);

        builder.show();
    }
}
