package plapp.plapp.Searching;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import viralandroid.com.androiduserinterfacetutorial.R;

public class marginAdapter extends BaseAdapter {
    private Context ctx;

    // Keep all Images in array
    public Integer[] thumbnails = {
            R.drawable.ms_contour_margin_crenate,   R.drawable.ms_contour_margin_dentate,   R.drawable.ms_contour_margin_doubleserrate,
            R.drawable.ms_contour_margin_entire,    R.drawable.ms_contour_margin_incised,   R.drawable.ms_contour_margin_lobed,
            R.drawable.ms_contour_margin_serrate,   R.drawable.ms_contour_margin_serrulate, R.drawable.ms_contour_margin_sinuate,
            R.drawable.ms_contour_margin_undulate

    };

    public String[] label = {
            "crenate","dentate","double serrate","entire","incised","lobed","serrate",
            "serrate","serrulate","sinuate","undulate"};

    // Constructor
    public marginAdapter(Context c) {
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