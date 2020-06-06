package abi.projectH.skullcandy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //create account for new members
    public void createAccount(View view) {
        // declare intent object
        Intent intent = new Intent(this,CreateAccount.class);

        // Start activity create account
        startActivity(intent);



    }

    public void loginAccount(View view) {

    //declare intent object
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);


    }
}
