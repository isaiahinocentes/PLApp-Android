package plapp.plapp.Searching;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import viralandroid.com.androiduserinterfacetutorial.R;

public class ImageAdapter extends BaseAdapter {
    private Context ctx;

    // Keep all Images in array
    public Integer[] thumbnails = {
        R.drawable.ms_shape_cordate, R.drawable.ms_shape_deltoid, R.drawable.ms_shape_elliptic,
        R.drawable.ms_shape_falcate, R.drawable.ms_shape_flabellate, R.drawable.ms_shape_gladiate,
        R.drawable.ms_shape_hastate, R.drawable.ms_shape_lanceolate, R.drawable.ms_shape_obcordate,
        R.drawable.ms_shape_oblanceolate, R.drawable.ms_shape_oblong, R.drawable.ms_shape_obovate,
        R.drawable.ms_shape_oval, R.drawable.ms_shape_ovate, R.drawable.ms_shape_reinform, R.drawable.ms_shape_rhomboid,
        R.drawable.ms_shape_sagittate, R.drawable.ms_shape_spatulate

    };

    public String[] label = {
            "cordate","deltoid","elliptic","falcate","flabellate","gladiate","hastate",
            "lanceonlate","obcordate","oblanceolate","oblong", "obovate","oval","ovate",
            "reinform","rhomboid","sagittate","spatulate"};




    // Constructor
    public ImageAdapter(Context c) {
        ctx = c;
    }

    @Override
    public int getCount() {
        return label.length;
    }

    @Override
    public String getItem(int position) {
        return label[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holderr holder;
        if(row==null) {
            LayoutInflater layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.shape_row, parent, false);
            holder=new Holderr();
            holder.imageView=(ImageView)row.findViewById(R.id.iconshapes);
            holder.textView=(TextView)row.findViewById(R.id.iconshapelbl);
            row.setTag(holder);
            holder.textView.setText(label[position]);
            holder.imageView.setImageResource(thumbnails[position]);

            /*ImageView imageView = new ImageView(ctx);
            imageView.setImageResource(thumbnails[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setPadding(20, 20, 20, 20);
            return imageView;**/
        }
        return row;

    }

    static class Holderr{
        TextView textView;
        ImageView imageView;


    }

}