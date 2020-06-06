package abi.projectH.skullcandy;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    Button log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Attach the sectionpagerAdapter to the viewPager and using support fragments manager,
        //so we can pass our adapter a reference to the support fragment manager.
        SectionnsPagerAdapter pagerAdapter = new SectionnsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        //This attaches the fragment pager adapter we created to the view Pager
        pager.setAdapter(pagerAdapter);

        //Attach the viewPager to the tab layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        //link the viewpager to the tablayout
        tabLayout.setupWithViewPager(pager);

    }


    //To get view pager to diplay a fragment on each of it pages, we are using fragment pager adapter
    private class SectionnsPagerAdapter extends FragmentPagerAdapter
    {
        //creating a constructor that takes a fragmentmanager parameter
        public SectionnsPagerAdapter(FragmentManager fm)
        {super (fm);}

        //Override the getCount() method to specify the number of pages in the view pager
        @Override
        public int getCount()
        {
            //the number of pages in the viewpager
            return 4;

        }

        //Override getItem to say which fragment should appear on each page.The position gives the number, starting at 0.
        @Override
        public Fragment getItem(int position)
        {
            //The fragment to be displayed on each page

            switch (position)
            {
                case 0:
                    return new Home_Page_Fargment();


                case 1:
                    return new Store_page_Fargment();

                case 2:
                    return new cart_Page_Fargment();

                case 3:
                    return new Account_Page_Fargment();
            }

            return null;

        }

        //This method adds the text to the tabs
        @Override
        public CharSequence getPageTitle(int position)
        {

            switch (position)
            {
                case 0:
                    return getResources().getText(R.string.home_page);

                case 1:
                    return getResources().getText(R.string.store_page);

                case 2:
                    return getResources().getText(R.string.cart_page);

                case 3:
                    return getResources().getText(R.string.account_page);


            }
            return null;

        }

    }


}
