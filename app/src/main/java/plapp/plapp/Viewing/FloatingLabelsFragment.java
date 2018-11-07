package plapp.plapp.Viewing;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import plapp.plapp.Database.DBOperations;
import plapp.plapp.Database.DbHelper;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by rufflez on 6/20/15.
 */
public class FloatingLabelsFragment extends Fragment{
    private String id;
    private DbHelper dbHelper;
DBOperations db = new DBOperations(getContext());
    TextView local, science, charac, loc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.floating_labels, container, false);
        String a = "";


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dbHelper= new DbHelper(getActivity());
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        String leafName, scienceName, location, characteristics;
        local = (TextView) getActivity().findViewById(R.id.result_local_names);
        science = (TextView) getActivity().findViewById(R.id.result_scientific);
        loc = (TextView) getActivity().findViewById(R.id.result_location);
        charac = (TextView) getActivity().findViewById(R.id.result_characteristics);
        ViewLeaf viewLeaf = (ViewLeaf)getActivity();
         id=viewLeaf.getId();



    //    local.setText(dbHelper.getName(viewLeaf.getId().toString()));
        local.setText(dbHelper.getName(viewLeaf.getId().toString()));
        science.setText(dbHelper.getScientific(viewLeaf.getId().toString()));
        loc.setText(dbHelper.getLocation(viewLeaf.getId().toString()));
        charac.setText(dbHelper.getCharacteristics(viewLeaf.getId().toString()));

        //return inflater.inflate(R.layout.fragment, container, false);


    //    Bundle bundle = this.getArguments();
    //    if (bundle != null) {
   //         i = bundle.getString("id");



       // }

    }
}
