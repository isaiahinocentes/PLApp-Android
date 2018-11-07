package plapp.plapp.Searching;



import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import plapp.plapp.Database.DataProvider;
import plapp.plapp.Database.DbHelper;
import plapp.plapp.Viewing.ViewLeaf;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by uCare on 22 Jan 2017.
 */
public class shapesAdapter extends RecyclerView.Adapter<shapesAdapter.ViewHolder>  {
    ArrayList<String> list=new ArrayList<String>();
    private List<DataProvider> leaf;
    private String  leaf_id;
    private String[] values;
    private Context context;
    private String name, characteristics;
    private DbHelper dbHelper;
    private ProgressDialog progress;


    public shapesAdapter(ArrayList<DataProvider> leaf, String leaf_id) {
        this.leaf=leaf;
        this.leaf_id=leaf_id;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_child_row, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {


        //Holder leafholder = null;
//        DataProvider dataProvider =leaf.get(position);
if (leaf_id.equals(null)){
    Dialog d = new Dialog(context);
    d.setTitle("Error");
    TextView tv = new TextView(context);
    tv.setText("No leaf under the category");
    d.setContentView(tv);
    d.show();

    d.setOnDismissListener(new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialogInterface) {

        }
    });

}else {
    name = leaf.get(position).getLocal_name();

    if (leaf_id.equals(leaf.get(position).getLeaf_Id())) {
        holder.usesView.setText(name.trim());
        holder.charac.setText(leaf.get(position).getLeaf_characteristics().trim());
        holder.imageView.setImageBitmap(leaf.get(position).getLeaf_image());
        holder.usesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ViewLeaf.class);
                intent.putExtra("leafid", leaf_id);
                context.startActivity(intent);

            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ViewLeaf.class);
                intent.putExtra("leafid", leaf_id);
                context.startActivity(intent);
            }
        });

        holder.charac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ViewLeaf.class);
                intent.putExtra("leafid", leaf_id);
                context.startActivity(intent);

            }
        });

//            notifyDataSetChanged();
    } else {
        holder.relativeLayout.setVisibility(View.GONE);

    }

}
    }

    @Override
    public int getItemCount() {
        return leaf.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView usesView, charac;
        public View view;
        public ImageView imageView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            usesView = (TextView) itemView.findViewById(R.id.child_text);
            imageView=(ImageView)itemView.findViewById(R.id.child_icon);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.rel);
            charac=(TextView)itemView.findViewById(R.id.child_charac1);
        }
    }
    public String getValueAt(int position) {
        return values[position];
    }

}
