package abi.projectH.skullcandy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class SkullcandyDatabaseHelper extends SQLiteOpenHelper {

    Context context;

    private static final String DB_NAME = "SkullCandyProduct.db"; // name of database
    private static final int DB_VERSION = 1; // the version of the database

    private static String sql ="CREATE TABLE PRODUCTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PRICE TEXT, IMAGE_RESOURCE BLOB)";

    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInByte;





    SkullcandyDatabaseHelper (Context context)
    {
    super(context, DB_NAME, null, DB_VERSION);
    this.context = context;
    }

    //onCreate gets called when the db first gets created, so we
    // are using it to create the table and ise3rt data.
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try{
        db.execSQL(sql);
        Toast.makeText(context,"Table created successfully",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void insertProduct(StoreModelClass objModelClass) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();

            Bitmap imageToStoreBitmap = objModelClass.getImage();

            objectByteArrayOutputStream = new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100,objectByteArrayOutputStream);

            imageInByte = objectByteArrayOutputStream.toByteArray();

//            String bytesImage = Base64.encodeToString(imageInByte, Base64.DEFAULT);

            ContentValues productValues = new ContentValues();
            productValues.put("NAME", objModelClass.getName());
            productValues.put("PRICE", objModelClass.getPrice());
            productValues.put("IMAGE_RESOURCE", imageInByte);
            long checkIfQueryRuns = db.insert("Products", null, productValues);

            if (checkIfQueryRuns != -1) {
                Toast.makeText(context, "Data Added Into Table", Toast.LENGTH_SHORT).show();
                db.close();
            }
            else {
                Toast.makeText(context, "Fail To Add Into Table", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public ArrayList<StoreModelClass> getAllProductData()
    {

        try
        {
            SQLiteDatabase objSQL = this.getReadableDatabase();

            ArrayList<StoreModelClass> storeModelClassArrayList = new ArrayList<>();

            Cursor objCursor = objSQL.rawQuery("select * from products",null);

            if(objCursor.getCount() != 0 )
            {

                while (objCursor.moveToNext())
                {
                    String nameOfProduct = objCursor.getString(1);
                    String priceOfProduct = objCursor.getString(2);
                    byte [] imageBytes = objCursor.getBlob(3);

                    Bitmap objBitmap = BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                    storeModelClassArrayList.add(new StoreModelClass(nameOfProduct,priceOfProduct,objBitmap));
                }

                return storeModelClassArrayList;

            }
            else
            {
                Toast.makeText(context, "No values exist in database",Toast.LENGTH_SHORT).show();
                return null;
            }

        }
        catch (Exception e)
        {
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
            return null;
        }


    }




}
