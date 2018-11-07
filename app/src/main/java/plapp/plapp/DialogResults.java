package plapp.plapp;

/**
 * Created by uCare on 12 Feb 2017.
 */


import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import plapp.plapp.Database.BackgroundTask;
import plapp.plapp.Database.DataProvider;
import viralandroid.com.androiduserinterfacetutorial.R;

public class DialogResults extends ListActivity {

    public static String RESULT_CONTRYCODE = "countrycode";
    public String[] countrynames, countrycodes;
    private TypedArray imgs;
    private List<DataProvider> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_search");
        //populateCountryList();
        //ArrayAdapter<DataProvider> adapter = new CountryListArrayAdapter(this, countryList);
        //setListAdapter(adapter);

    }

  /*  private void populateCountryList() {
        countryList = new ArrayList<DataProvider>();
        countrynames = getResources().getStringArray(R.array.country_names);
        countrycodes = getResources().getStringArray(R.array.country_codes);
        imgs = getResources().obtainTypedArray(R.array.country_flags);
        for(int i = 0; i < countrycodes.length; i++){
            countryList.add(new Country(countrynames[i], countrycodes[i], imgs.getDrawable(i)));
        }
    }*/


}