package plapp.plapp.Database;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//import plapp.plapp.Searching.ManualSearchAdapter;
import plapp.plapp.Searching.ManualSearchAdapter;
import plapp.plapp.Searching.shapesAdapter;

import plapp.plapp.Viewing.UsesAdapter;
import plapp.plapp.Viewing.ViewLeaf;
import plapp.plapp.Searching.viewACategory;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by uCare on 27 Dec 2016.
 */
public class BackgroundTask extends AsyncTask<String,DataProvider,String>{
    Context ctx, context;


    UsesAdapter usesAdapter;
    //private SQLiteDatabase mDb;

    ManualSearchAdapter manualSearchAdapter;
    shapesAdapter shapesAdapter;
    RecyclerView recyclerView, recView, msRecView;
    ListView listView1;
    ArrayList<DataProvider> originalList =  new ArrayList<DataProvider>();
    ArrayList<DataProvider> mockList =  new ArrayList<DataProvider>();

    Activity activity;

    String method;
    GridView gridView;

    private ProgressDialog progress;
    TextView gs;

    //get them data
    String leafid, leaflocal, leafscientific, leaflocation, leafuses, leafcharac, leafhow, leafcateg, leafsimilar;
    public BackgroundTask(Context ctx){
        this.ctx=ctx;
        activity = (Activity)ctx;
        progress = new ProgressDialog(activity);
    }

    public Activity getActivity() {
        return activity;
    }

    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate = null;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progress.setMessage("Getting Results");
        this.progress.show();

    }

    @Override
    protected String doInBackground(String... params) {
        method = params[0];
        DBOperations dbOperations = new DBOperations(ctx);
        DbHelper dbHelper = new DbHelper(ctx);

         if (method.equals("get_search")) {

            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = dbHelper.getInformations(db);


            String leafid, leaflocal, leafscientific, leaflocation, leafuses, leafcharac, leafhow, leafcateg, leafsimilar;
            byte[] leafimg;
            while (cursor.moveToNext()) {
                leafid= cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.ID1));
                leaflocal = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.LNAME1));
                leafimg = cursor.getBlob(cursor.getColumnIndex(Contract.LeafEntries.IMG1));
                DataProvider leaves = new DataProvider(leafid, Utility.getPhoto(leafimg), leaflocal, null, null, null, null, null, null, null);
                publishProgress(leaves);
                mockList.add(leaves);

            }


            //searchAdapter = new MyExpandableListAdapter(ctx, originalList);
            return "get_search";

        } else if (method.equals("get_categories_result")) {
            recView = (RecyclerView) activity.findViewById(R.id.recViewForCateg);
            ArrayList<DataProvider> newlist;
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = dbHelper.getInformations(db);

             String leafid, leaflocal, leafcharac;
             byte[] leafimg;
             while (cursor.moveToNext()){
                 leafid = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.ID1));
                 leafimg = cursor.getBlob(cursor.getColumnIndex(Contract.LeafEntries.IMG1));
                 leaflocal = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.LNAME1));
                 leafcharac = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.CHARACTERISTICS1));
                 DataProvider leaves = new DataProvider(leafid, Utility.getPhoto(leafimg), leaflocal, null, null, null, leafcharac, null, null, null);
                 publishProgress(leaves);

                 originalList.add(leaves);
                Log.d("leaves add", leaflocal);

            }
            viewACategory viewACategory = (viewACategory) getActivity();
            shapesAdapter = new shapesAdapter(originalList, viewACategory.getIdinCateg());


            return "get_categories_result";


        } else if (method.equals("get_uses_result")) {
            recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView1);
            ArrayList<DataProvider> newlist;
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = dbHelper.getInformations(db);
            String leafid, leaflocal, leafscientific, leaflocation, leafuses, leafcharac, leafhow, leafcateg, leafsimilar;
            while (cursor.moveToNext()) {
                leafid = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.ID1));

                leaflocal = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.LNAME1));
                //leafuses = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.USES1));
                DataProvider leaves = new DataProvider(leafid, null, leaflocal, null, null, null, null, null, null, null);
                publishProgress(leaves);

                    originalList.add(leaves);
                Log.d("leaves add", leaflocal);

            }
            ViewLeaf viewLeaf = (ViewLeaf) getActivity();
            usesAdapter = new UsesAdapter(originalList, viewLeaf.getId());


            return "get_uses_result";

        }

        else if (method.equals("get_manualsearch")){

             Log.d("entered", "bgtask_MS");
             msRecView=(RecyclerView)activity.findViewById(R.id.msRecview);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor= dbHelper.getInformations(db);
            String leafid, leaflocal, leafcharac;
            byte[] leafimg;
            while (cursor.moveToNext()){
                leafid = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.ID1));
                leafimg = cursor.getBlob(cursor.getColumnIndex(Contract.LeafEntries.IMG1));
                leaflocal = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.LNAME1));
                leafcharac = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.CHARACTERISTICS1));
                DataProvider leaves = new DataProvider(leafid, Utility.getPhoto(leafimg), leaflocal, null, null, null, leafcharac, null, null, null);
                publishProgress(leaves);
                originalList.add(leaves);
                mockList.add(leaves);
                Log.d("ms added", leaflocal);
                Log.d("bgtask_MS", "success");
            }

          //  manualSearchAdapter = new ManualSearchAdapter(originalList);


            return "get_manualsearch";
        }

            return null;
        }


    @Override
    protected void onProgressUpdate(DataProvider... values) {
        //adds one item at a time


    }


    @Override
    protected void onPostExecute(String result) {
        if (progress.isShowing()) {
            progress.dismiss();
        }
 if (result.equals("get_search")){

        }else if(result.equals("get_manualsearch")){
            //msRecView.setAdapter(manualSearchAdapter);

         //   getArray();

            Log.d("you are in",result);
        } else if(result.equals("get_categories_result")){

            recView.setAdapter(shapesAdapter);



        } else if (result.equals("get_uses_result")){
            recyclerView.setAdapter(usesAdapter);



            //recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),VersionModel.data));

            //recyclerView.setAdapter(new HowToUseFragment.SimpleStringRecyclerViewAdapter(getActivity(),DataProvider.getLeaf_use()));

        }
    }
    private class ItemList implements AdapterView.OnItemClickListener {

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //ViewGroup viewg=(ViewGroup)view;
            //TextView textv=(TextView)viewg.findViewById(R.id.t_name);
          //Intent i = new Intent(BackgroundTask.this, ViewLeaf.class);
        //startActivity(i);

        }
    }
    public ListView getList(){
        return listView1;
    }
    public ArrayList<DataProvider> getArray(){return mockList;}
    public void getAdapter(){msRecView.setAdapter(manualSearchAdapter);}
}

/*
public class BackgroundTask extends AsyncTask<String, Void, String>{

    Context ctx;
    BackgroundTask(Context ctx){
        this.ctx=ctx;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        DBOperations dbOperations= new DBOperations(ctx);
        if(method.equals("add_info")){
            String Id = params[1];
            String local = params[2];
            String scientific = params[3];
            String location = params[4];
            String uses = params[5];
            String characteristics = params[6];
            String similar = params[7];
            String how = params[8];
            String category = params[9];
            SQLiteDatabase db = dbOperations.getWritableDatabase();
            dbOperations.addEntry(db, Id, local,location,uses, characteristics,scientific,how,category,similar);

            return "Information inserted...";


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
*/
