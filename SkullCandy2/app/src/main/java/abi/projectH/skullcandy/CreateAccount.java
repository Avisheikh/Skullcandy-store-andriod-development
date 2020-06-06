package abi.projectH.skullcandy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText FName;
    private EditText LName;
    private EditText Email;
    private EditText Pass1;
    private EditText Pass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mAuth = FirebaseAuth.getInstance();

        // get edit text values
        FName = (EditText) findViewById(R.id.fName);
        LName = (EditText) findViewById(R.id.lName);
        Email = (EditText) findViewById(R.id.email);
        Pass1 = (EditText) findViewById(R.id.pass1);
        Pass2 = (EditText) findViewById(R.id.pass2);



        // adding tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //adding the up button to go to parrent activity when clicked
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }




    public void createUserAccount(View view) {


        //storing values form edit text to string variables
        String firstName = FName.getText().toString().trim();
        String lastName = LName.getText().toString().trim();
        String email_address = Email.getText().toString().trim();
        String password1 = Pass1.getText().toString().trim();
        String password2 = Pass2.getText().toString().trim();


        //Checking if the edittext are empty or not.
        if (firstName.isEmpty()) {
            Toast.makeText(CreateAccount.this, "Please Enter The First Name Correctly", Toast.LENGTH_SHORT).show();
        }

        else if (lastName.isEmpty()) {
            Toast.makeText(CreateAccount.this, "Please Enter The Last Name Correctly", Toast.LENGTH_SHORT).show();
        }


        else if (email_address.isEmpty()) {
            Toast.makeText(CreateAccount.this, "Please Enter The Email Address Correctly", Toast.LENGTH_SHORT).show();
        }

        else if(password1.isEmpty()){
            Toast.makeText(CreateAccount.this,"Please Enter The Password Address Correctly",Toast.LENGTH_SHORT).show();
        }

        else if(password2.isEmpty() ){
            Toast.makeText(CreateAccount.this,"Please Enter The Re Password Address Correctly",Toast.LENGTH_SHORT).show();
        }

        else if(password1.length() < 7 ){
            Toast.makeText(CreateAccount.this,"Password Length Should Be Greater Than Seven",Toast.LENGTH_SHORT).show();

        }
        //check if password1 and password 2 are correct
        else if (!password1.equals(password2))
        {
            Toast.makeText(CreateAccount.this,"Password did not match",Toast.LENGTH_SHORT).show();
        }

        else{userLogin(email_address,password1);}
    }


    private void userLogin(String email_address, String password1)

    {
        mAuth.createUserWithEmailAndPassword(email_address, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(CreateAccount.this,LoginActivity.class));
                            Toast.makeText(CreateAccount.this,"Account Created Successfully",Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(CreateAccount.this,"Create Account Failed",Toast.LENGTH_SHORT)
                                    .show();
                        }

                        // ...
                    }
                });



    }


}

