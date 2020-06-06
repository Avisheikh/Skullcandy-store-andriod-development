package abi.projectH.skullcandy;

import android.app.Activity;
import android.graphics.Bitmap;

public class StoreModelClass extends Activity {



    private String name;
    private String price;
    private Bitmap image;

    public StoreModelClass(String name, String price, Bitmap image) {

        this.name = name;
        this.price = price;
        this.image = image;
    }



    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Bitmap getImage() {
        return image;
    }
}
