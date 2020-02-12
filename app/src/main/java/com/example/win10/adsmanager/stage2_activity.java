package com.example.win10.adsmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class stage2_activity extends AppCompatActivity {
    private int gender;
    private int minAge;
    private int maxAge;
    private int[] strategiesTried; //TODO: Make sure it is assigned
    private int triedReferalCampaign;
    private double avgConversionRate;
    private AdIntrestedPerson person;
    private final String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2_activity);

        Intent i = getIntent();
        person = (AdIntrestedPerson) i.getSerializableExtra("stage1");
        Log.d(TAG,"MYLOG: "+person.getWebsite()+"\n");
    }

    public void nextButton(View view) {
        extractData();
        if(isAvgConversionRateValid(avgConversionRate)){
            setStage2Data();
            callStage3();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid Avg Conversion Rate", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void setStage2Data() {
        person.setStage2(gender,minAge,maxAge,strategiesTried,triedReferalCampaign,avgConversionRate);
    }

    private void callStage3() {
        try {
            Intent intent = new Intent(stage2_activity.this, Stage3.class);
            intent.putExtra("stage2", person);
            startActivity(intent);
        } catch (Exception e) {
            Log.d(TAG, "Couldnt start intent");
            e.printStackTrace();
        }
    }

    private boolean isAvgConversionRateValid(double avg) {
        if(avg>=0.0&&avg<=100.0){
            return true;
        }
        return false;
    }

    private void extractData(){
        Spinner genderSpinner = findViewById(R.id.gender_selected_id);
        gender = genderSpinner.getSelectedItemPosition();

        EditText minAgeEditText = findViewById(R.id.age_min_id);
        EditText maxAgeEditText = findViewById(R.id.age_max_id);
        minAge = Integer.parseInt(minAgeEditText.getText().toString());
        maxAge = Integer.parseInt(maxAgeEditText.getText().toString());

        //TODO: marketing strategies have u tried should be done

        Spinner triedRefCampSpinner = findViewById(R.id.ref_camp_id);
        triedReferalCampaign = triedRefCampSpinner.getSelectedItemPosition();

        EditText avgConversionRateEditText = findViewById(R.id.avg_conversion_rate_id);
        avgConversionRate = Integer.parseInt(avgConversionRateEditText.getText().toString());

    }
    public void backButton(View view) {
    }
}
