package plapp.plapp.Viewing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import plapp.plapp.Database.DataProvider;
import plapp.plapp.Database.DbHelper;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by uCare on 22 Jan 2017.
 */
public class UsesAdapter extends RecyclerView.Adapter<UsesAdapter.ViewHolder>  {
    ArrayList<String> list=new ArrayList<String>();
    private List<DataProvider> leaf;
    private String leafid;
    private String[] values;
    private Context context;
    private DbHelper dbHelper;
    private ViewLeaf viewLeaf;


    public UsesAdapter(ArrayList<DataProvider> leaf, String id) {
        this.leaf=leaf;
        this.leafid=id;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_item, parent, false);
        //leafHolder.tx_local.setText(product.getLocal_name().toString());
        ViewLeaf viewLeaf = (ViewLeaf)v.getContext();

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
       final String use=leaf.get(position).getLocal_name();
       list.add(use);
       Log.d("asd",use);
        if (leafid.equals(leaf.get(position).getLeaf_Id())) {
            holder.usesView.setText(use);
            holder.usesView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent=new Intent(context, ViewHowToUse.class);
                    intent.putExtra("useOfLeaf",use);
                    context.startActivity(intent);
                }
            });

       }else holder.usesView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return leaf.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView usesView;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            usesView = (TextView) itemView.findViewById(R.id.listitem_name);
        }
    }
    public String getValueAt(int position) {
        return values[position];
    }

}
