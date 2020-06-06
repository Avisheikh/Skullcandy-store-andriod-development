package abi.projectH.skullcandy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Store_page_Fargment extends Fragment {

    private SkullcandyDatabaseHelper objDB;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView storeRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_store, container, false);


        try {

            storeRecycler= storeRecycler.findViewById(R.id.store_recycler);
                objDB = new SkullcandyDatabaseHelper(getActivity());

                CaptionedImagesAdapter  objAdapter = new CaptionedImagesAdapter(objDB.getAllProductData());
            storeRecycler.setHasFixedSize(true);
            storeRecycler.setAdapter(objAdapter);
            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            storeRecycler.setLayoutManager(layoutManager);

        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }









        return storeRecycler;

    }




}
