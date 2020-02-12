package com.example.win10.adsmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    int bussinessType;
    int[] bussinessLocations;
    String websiteUrl;
    int sessionID;
    String TAG = this.getClass().getSimpleName();

    //TODO: implement creating session id logic


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void nextButton(View view) {
        EditText websiteEditText = findViewById(R.id.website_id);
        websiteUrl = websiteEditText.getText().toString().trim().toLowerCase();
        if (isValidURL(websiteUrl)) {
            Spinner bussinessArray = findViewById(R.id.bussiness_type_id);
            bussinessType = bussinessArray.getSelectedItemPosition();
            //TODO: bussiness location logic to be implemented


            AdIntrestedPerson person = new AdIntrestedPerson();
            //TODO: make sure session id is set
            person.setStage1(sessionID, bussinessType, bussinessLocations, websiteUrl);
            try {
                Intent intent = new Intent(MainActivity.this, stage2_activity.class);
                intent.putExtra("stage1", person);
                startActivity(intent);
            } catch (Exception e) {
                Log.d(TAG, "Couldnt start intent");
                e.printStackTrace();
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid Website", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    private boolean isValidURL(String websiteUrl) {
        try {
            new URL(websiteUrl).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
