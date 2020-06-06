package abi.projectH.skullcandy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;



public class Account_Page_Fargment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_account__page, container, false);

        Button btn = rootView.findViewById(R.id.CRUD);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SkullcandyDatabaseHelper(getActivity());
                startActivity(new Intent(getActivity(),insertData.class));
            }
        });


        return rootView;


    }
}
