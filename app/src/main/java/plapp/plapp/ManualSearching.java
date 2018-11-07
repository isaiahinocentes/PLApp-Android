package plapp.plapp;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import plapp.plapp.Database.BackgroundTask;
import plapp.plapp.Database.DataProvider;
import plapp.plapp.Searching.CategoryMain;
import plapp.plapp.Searching.ManualSearchAdapter;
import viralandroid.com.androiduserinterfacetutorial.R;
//import viralandroid.com.androiduserinterfacetutorial.databinding.ManualSearchMainBinding;


/*** Created by uCare on 28 Jan 2017.*/

public class ManualSearching extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private SearchManager searchManager;
    private android.widget.SearchView searchView;
    private String[] bysearch = {"By Name", "By Category"};
    private MenuItem searchItem, spinnerItem;
    private RecyclerView recyclerView;
    private ManualSearchAdapter msList;
    private BackgroundTask backgroundTask;
    private List<DataProvider> listt;
    private List<DataProvider> filteredModelList = new ArrayList<>();
    private ProgressDialog progress;
    private ProgressBar progressBar;
    private ArrayList<DataProvider> dataProviders=new ArrayList<DataProvider>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ms_top);
        Toolbar toolbar = (Toolbar)findViewById(R.id.mstoolbar);
        setSupportActionBar(toolbar);
        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        recyclerView = (RecyclerView)findViewById(R.id.msRecview);


        setupRecyclerView(recyclerView);


    }
    /*
        public class MyCountDownTimer extends CountDownTimer {
            public MyCountDownTimer(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onTick(long millisUntilFinished) {

                int progress = (int) (millisUntilFinished/1000);

                progressBar.setProgress(progressBar.getMax()-progress);
            }

            @Override
            public void onFinish() {
                finish();
            }
        }*/
    private void setupRecyclerView(RecyclerView recyclerView){


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_manualsearch");
        recyclerView.setAdapter(new ManualSearchAdapter(backgroundTask.getArray()));
        msList = new ManualSearchAdapter(backgroundTask.getArray());
        listt=backgroundTask.getArray();
        //  recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),VersionModel.data));
    }


    private void displayCategories(){
        startActivity(new Intent(this, CategoryMain.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter(this, R.layout.spinner_title, bysearch);
        stringArrayAdapter.setDropDownViewResource(R.layout.spinner_drop);

        // create a spinner
        // add adapter to spinner
        spinner.setAdapter(stringArrayAdapter);
        // create listener and add to spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if((String.valueOf(position)).equals("1")){

                    displayCategories();
                }else {
                    setupRecyclerView(recyclerView);
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                setupRecyclerView(recyclerView);

                // This expands the list.
                //expandAll();

            }
        });

        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo
                (searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);



/*

  query = query.toLowerCase();
        final List<DataProvider> filteredModelList = new ArrayList<>();
        for (DataProvider model : listt) {

            final String text = model.getLocal_name().toLowerCase();
            if (text.contains(query)) {
                Log.d("entered equal",text);
                filteredModelList.add(model);
            }
        }

        msList.animateTo(filtefenterelList);
        recyclerView.scrollToPosition(0);
        msList.notifyDataSetChanged();








 query = query.toLowerCase();
 final List<ExampleModel> filteredModelList = new ArrayList<>();
 for (ExampleModel model : mModels) {
 final String text = model.getText().toLowerCase();
 if (text.contains(query)) {
 filteredModelList.add(model); } }
 mAdapter.animateTo(filteredModelList);
 mRecyclerView.scrollToPosition(0);
 return true;
 */


        //msList.filterList(newText);
        /*        msList.filterData(newText);
        msList.notifyDataSetChanged();
        Log.d("input",newText);
        return false;*/


        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search Here");

        searchView.requestFocus();


        return true;
    }



    @Override
    public boolean onQueryTextSubmit(String query) {

        Log.d("button clickedd",query);
        return false;
    }


    @Override
    public boolean onQueryTextChange(String query) {


        Log.d("executed", query);


        query = query.toLowerCase();

        filteredModelList.clear();

        // If there is no search value, then add all original list items to filter list
        if (TextUtils.isEmpty(query)) {

            filteredModelList.addAll(listt);

        } else {
            for (DataProvider model : listt) {

                String text = model.getLocal_name().toLowerCase();
                if (text.contains(query)) {
                    Log.d(query + " entered equal", text);
                    filteredModelList.add(model);
                }
            }
            msList.animateTo(filteredModelList);
            recyclerView.scrollToPosition(0);
            recyclerView.invalidate();
//                msList.notifyDataSetChanged();

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
     /*      case R.id.:
                newGame();
                return true;
            case R.id.help:
                showHelp();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}


































/*
public class ManualSearching extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ManualSearchAdapter mAdapter;
    private List<DataProvider> dataProviderList;
    private RecyclerView recyclerView;

    private ManualSearchMainBinding mBinding;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=DataBindingUtil.setContentView(this, R.layout.manual_search_main);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataProviderList = new ArrayList<>();
       // for (int i = 0, count = Contract.LeafEntries.length; i < count; i++) {
         //   dataProviderList.add(new DataProvider(i, MOVIES[i]));}

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_search");


        mAdapter.edit()
                .replaceAll(dataProviderList)
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        final List<DataProvider> filteredModelList = filter(dataProviderList, query);
        mAdapter.edit()
                .replaceAll(filteredModelList)
                .commit();
        recyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private static List<DataProvider> filter(List<DataProvider> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<DataProvider> filteredModelList = new ArrayList<>();
        for (DataProvider model : models) {
            final String text = model.getLocal_name().toLowerCase();
            if (text.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
*/