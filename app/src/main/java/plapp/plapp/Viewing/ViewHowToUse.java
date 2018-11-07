package plapp.plapp.Viewing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import plapp.plapp.Database.Contract;
import plapp.plapp.Database.DbHelper;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by uCare on 28 Jan 2017.
 */
public class ViewHowToUse extends AppCompatActivity {
    private String getUseleaf, newTitle="";
    private DbHelper dbHelper;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_use);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if(null !=intent){
            getUseleaf = intent.getStringExtra("useOfLeaf");
        }
        dbHelper= new DbHelper(getApplicationContext());
        setTitle(getUseleaf);
        textView = (TextView) findViewById(R.id.result_howto);
        textView.setText(dbHelper.getHowToUse(getUseleaf));
        /*
          leaf9name = dbHelper.getName(id1);
        setTitle(leaf9name);
        imageView = (ImageView) findViewById(R.id.imaglayout);
        imageView.setImageBitmap(dbHelper.getImage(id1));
         */


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (id){
            case android.R.id.home:

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
