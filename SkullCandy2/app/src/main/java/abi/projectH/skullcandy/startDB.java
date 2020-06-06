package abi.projectH.skullcandy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class startDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_d_b);
    }

    public void startDB(View view) {

        new SkullcandyDatabaseHelper(this);
        startActivity(new Intent(this,insertData.class));


    }
}
