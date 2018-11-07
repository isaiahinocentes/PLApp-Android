package plapp.plapp.Searching;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import plapp.plapp.ManualSearching;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by uCare on 29 Jan 2017.
 */
public class CategoryMain extends AppCompatActivity {
    private LinearLayout l1, l2;
    private String[] bysearch = {"By Category","By Name"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_category);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar18);
        setSupportActionBar(toolbar);
        setTitle(null);
        l1= (LinearLayout)findViewById(R.id.leafshapes);
        l2= (LinearLayout)findViewById(R.id.leafmargins);
        l1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CategoryMain.this, GridSearch.class);
                intent.putExtra("chosen", "shapes");
                startActivity(intent);
            }
        });
        l2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CategoryMain.this, GridSearch.class);
                intent.putExtra("chosen", "margins");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.category, menu);

        MenuItem item = menu.findItem(R.id.spinner1);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter(this, R.layout.spinner_title, bysearch);
        stringArrayAdapter.setDropDownViewResource(R.layout.spinner_drop);
        spinner.setAdapter(stringArrayAdapter);
        // create listener and add to spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if((String.valueOf(position)).equals("1")){
                    displayNames();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void displayNames(){
        startActivity(new Intent(this, ManualSearching.class));

    }
}
