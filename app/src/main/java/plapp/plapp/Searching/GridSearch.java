package plapp.plapp.Searching;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import plapp.plapp.Database.DbHelper;
import plapp.plapp.ManualSearching;
import viralandroid.com.androiduserinterfacetutorial.R;

public class GridSearch extends AppCompatActivity {
    Context ctx;
    private String[] bysearch = {"By Category", "By Name"};
    private ActionBar actionBar;
    private String spin;
    private String result="";
    private MenuItem searchItem, spinnerItem;
    private android.widget.SearchView searchView;
    private SearchManager searchManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_manual_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);



        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        displayCategories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.category, menu);

        MenuItem item = menu.findItem(R.id.spinner1);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter(this, R.layout.spinner_title, bysearch);
        stringArrayAdapter.setDropDownViewResource(R.layout.spinner_drop);
        spinner.setAdapter(stringArrayAdapter);

//        MenuItem item = menu.findItem(R.id.spinnercateg);
        //      Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        //    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, bysearch);
        // create a spinner
        // add adapter to spinner
        //  spinner.setAdapter(stringArrayAdapter);
        // create listener and add to spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if((String.valueOf(position)).equals("0")){
                    displayCategories();
                }else {
                    displayList();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                displayCategories();
            }
        });


        return true;
    }

    private void displayList() {

        Intent i = new Intent(this, ManualSearching.class);
        startActivity(i);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.leafmargins:
                displayCategories();
                break;
            case R.id.leafshapes:

                displayCategories();
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    public void split(){

    }

    private void displayCategories(){

        Intent intent = getIntent();
        if(null !=intent){
            result = intent.getStringExtra("chosen");
        }


        final GridView gridView = (GridView) findViewById(R.id.GridViewsearch);
        final DbHelper dbHelper= new DbHelper(getApplicationContext());
        if (result.equals("shapes")) {
            gridView.setAdapter(new ImageAdapter(this));
        }else {
            gridView.setAdapter(new marginAdapter(this));

        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //DataProvider provider = (DataProvider)gridView.getItemAtPosition(position);
                Intent intent= new Intent(GridSearch.this, viewACategory.class);
                Log.d("wasabi",gridView.getItemAtPosition(position).toString());
                intent.putExtra("category", gridView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });

        /*gridView = (GridView)findViewById(R.id.GridViewsearch);
        imageAdapter = new ImageAdapter(ctx);
        gridView.setAdapter(imageAdapter);*/
    }
}