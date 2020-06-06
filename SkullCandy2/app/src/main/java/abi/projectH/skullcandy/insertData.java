package abi.projectH.skullcandy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class insertData extends AppCompatActivity {

    private EditText e,e1,pId;
    private ImageView objImageView;
    private static final int PICK_IMAGE_REQUEST = 100;
    private Uri imageFilePath;
    private Bitmap imageToStore;
    SkullcandyDatabaseHelper objDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        e = (EditText) findViewById(R.id.e);
        e1 = (EditText) findViewById(R.id.e1);

        objImageView = (ImageView) findViewById(R.id.storeImg);
        objDbHandler = new SkullcandyDatabaseHelper(this);





    }

    public void chooseImage(View objView){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                imageFilePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageFilePath);

                objImageView.setImageBitmap(imageToStore);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }


    public void addRecord(View view) {

        try {
          if(!e.getText().toString().isEmpty() && !e1.getText().toString().isEmpty() && objImageView.getDrawable() != null && imageToStore != null)
          {
                objDbHandler.insertProduct(new StoreModelClass(
                        e.getText().toString(), e1.getText().toString(), imageToStore));
          }
          else
          {
              Toast.makeText(insertData.this, "Please Enter The Field Correctly or Please Select Image",Toast.LENGTH_SHORT).show();
          }
        }
        catch (Exception e)
        {
            Toast.makeText(insertData.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }
}
