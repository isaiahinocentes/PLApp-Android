package plapp.plapp.Searching;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import plapp.plapp.Database.BackgroundTask;
import plapp.plapp.Database.DbHelper;
import plapp.plapp.Viewing.ViewLeaf;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by uCare on 22 Jan 2017.
 */
public class viewACategory extends AppCompatActivity {
    private TextView textView, characView;
    private ImageView imageView;
    private String categ, leafid;
    private RecyclerView recyclerView;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_view_list);
        DbHelper dbHelper = new DbHelper(getApplicationContext());

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        imageView=(ImageView)findViewById(R.id.child_icon);
        textView = (TextView)findViewById(R.id.child_text);
        characView = (TextView)findViewById(R.id.child_charac1);
        Intent intent = getIntent();
        if(null !=intent){
            categ = intent.getStringExtra("category");
        }
        setTitle("RESULTS FOR "+categ.toUpperCase());

        if (dbHelper.getCatgories(categ).equals("nada")){
            Dialog d = new Dialog(this);
            d.setTitle("Error");
            TextView tv = new TextView(this);
            tv.setText("No leaf under the category");
            d.setContentView(tv);
            d.show();
        }else {
        leafid=dbHelper.getCatgories(categ);
        Log.d("wasabi",dbHelper.getCatgories(categ));

        recyclerView = (RecyclerView)findViewById(R.id.recViewForCateg);
        setupRecyclerView(recyclerView);
        }
   //     progress=new ProgressDialog(this);
     //   progress.setMessage("Getting results");
        //ogress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       // progress.setIndeterminate(true);
        //progress.setMax(4);
        //backgroundTask = new BackgroundTask(this);

        //progress.show();




    }
    private void setupRecyclerView(RecyclerView recyclerView){


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_categories_result");

        //  recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),VersionModel.data));
    }
    public String getIdinCateg(){
        return leafid;
    }
}
