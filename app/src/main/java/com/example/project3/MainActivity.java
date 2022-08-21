package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Button progressBarBtn;
    private ProgressBar progressBar;
    private ProgressBar customProgressBar;
    private Spinner planetSpinner; // spinner code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinnerCode();
        ProgressBarCode();

    }

    public void SpinnerCode(){
        // spinner code begins
        planetSpinner = findViewById(R.id.spinnerID);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_planets,
                android.R.layout.simple_spinner_item);

        planetSpinner.setOnItemSelectedListener(this);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "You selected " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    // spinner code ends

    // time picker code begins (also includes the TimePickerFragment class)
    public void TimePickerBtn(View view){
        DialogFragment fragment = new TimePickerFragment();
        fragment.show(getSupportFragmentManager(), "TimePicker");
    }
    //time picker code ends

    // date picker code begins (also includes the DatePickerFragment class)
    public void DatePickerBtn(View view){
        DialogFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "DatePicker");
    }


    public void ProgressBarCode(){

        // indeterminate progress bar begins
        progressBar = findViewById(R.id.progressBarID);
        progressBarBtn = findViewById(R.id.progressBarControlBtnID);
        progressBar.setVisibility(View.INVISIBLE);
        // indeterminate progress bar end

        // for the determinate progress bar begins
        customProgressBar = findViewById(R.id.customProgressBarID);
        // for the determinate progress bar ends

        progressBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // indeterminate progress bar begins
                progressBar.setVisibility(View.VISIBLE);
                // indeterminate progress bar ends

                // for the determinate progress bar begins
                customProgressBar.incrementProgressBy(10);
                // for the determinate progress bar ends

            }
        });
    }
}