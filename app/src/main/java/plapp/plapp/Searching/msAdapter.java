package plapp.plapp.Searching;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import plapp.plapp.Database.DataProvider;
import plapp.plapp.Viewing.ViewLeaf;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by uCare on 22 Jan 2017.
 */
public class msAdapter extends ArrayAdapter {

   private List list = new ArrayList();
    Context context;
    private ArrayList<DataProvider> dataProviders;
    private ArrayList<DataProvider> originalList;

    public msAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View result_row = convertView;
        LeafHolder leafHolder;
        DataProvider product = (DataProvider)getItem(position);

       if(result_row==null){
            LayoutInflater layoutInflater1 = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            result_row = layoutInflater1.inflate(R.layout.child_row,parent,false);
            leafHolder =new LeafHolder();
            leafHolder.ser_local=(TextView) result_row.findViewById(R.id.child_text1);
           leafHolder.img=(ImageView)result_row.findViewById(R.id.child_icon1);
            result_row.setTag(leafHolder);

            leafHolder.ser_local.setText(product.getLocal_name().toString());
            leafHolder.img.setImageBitmap(product.getLeaf_image());
            return result_row;

        }

        TextView searchem = (TextView) convertView.findViewById(R.id.child_text1);
        searchem.setText(product.getLocal_name().trim());
        ImageView immg = (ImageView) convertView.findViewById(R.id.child_icon1);
        immg.setImageBitmap(product.getLeaf_image());
        //leafHolder.ser_local.setText(product.getLocal_name().toString());

        final View finalConvertView = convertView;


        return result_row;
    }


    static class LeafHolder{
        TextView tx_id,  tx_local, tx_scientific, tx_location, tx_uses, tx_charac, tx_how, tx_categ, tx_similar;
        TextView ser_local;
        ImageView img;
        String name;

    }
}
