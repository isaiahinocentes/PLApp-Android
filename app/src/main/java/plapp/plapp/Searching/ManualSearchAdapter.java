package plapp.plapp.Searching;



import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
public class ManualSearchAdapter extends RecyclerView.Adapter<ManualSearchAdapter.ViewHolder>  {
    //private final LayoutInflater mInflater;
    private List<DataProvider> mModels;

    List list = new ArrayList();
    private ArrayList<DataProvider> leaf;

    private String  leaf_id;
    private String[] values;
    private Context context;
    private DbHelper dbHelper;
    private FilterClass filter;

    private ArrayList<DataProvider> origList;



    public ManualSearchAdapter(ArrayList<DataProvider> leaf) {
        this.leaf = new ArrayList<>();
        this.leaf=leaf; //filter
        //this.leaf.addAll(origList);
        this.origList = new ArrayList<>();
        this.origList=leaf;
        mModels=leaf;
        //  this.origList.addAll(origList);



        //this.leaf.addAll(origList);
        //   this.originalList = new ArrayList<>();
        //this.origList.addAll(origList);
        //      filter = new FilterClass(leafsht, this);
        //this.leaf_id=leaf_id;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_row, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {


        holder.nameView.setText(leaf.get(position).getLocal_name().trim());
        //holder.nameView.setTypeface(light);
        holder.imageView.setImageBitmap(leaf.get(position).getLeaf_image());
        holder.characView.setText(leaf.get(position).getLeaf_characteristics().trim());
        //    holder.characView.setTypeface(lightItc);
        holder.relativeLayout.setFocusableInTouchMode(true);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent=new Intent(context, ViewLeaf.class);
                intent.putExtra("leafid", leaf.get(position).getLeaf_Id());
                context.startActivity(intent);


            }
        });

        //     holder.imageView.setFocusableInTouchMode(true);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent=new Intent(context, ViewLeaf.class);
                intent.putExtra("leafid", leaf.get(position).getLeaf_Id());
                context.startActivity(intent);


            }
        });

        //      holder.nameView.setFocusableInTouchMode(true);
        holder.nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent=new Intent(context, ViewLeaf.class);
                intent.putExtra("leafid", leaf.get(position).getLeaf_Id());
                context.startActivity(intent);
            }
        });

        //    holder.characView.setFocusableInTouchMode(true);
        holder.characView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent=new Intent(context, ViewLeaf.class);
                intent.putExtra("leafid", leaf.get(position).getLeaf_Id());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return leaf.size();
    }
    public void setModels(List<DataProvider> models) { mModels = new ArrayList<>(models); }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameView, characView;
        public View view;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        public Typeface light, lightItc;
        public AssetManager am;



        public ViewHolder(View itemView) {

            super(itemView);
//            Context context = view.getContext();
            nameView = (TextView) itemView.findViewById(R.id.child_text1);
            imageView=(ImageView)itemView.findViewById(R.id.child_icon1);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativesht);
            characView = (TextView) itemView.findViewById(R.id.child_charac);
            light = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/Roboto-Light.ttf");
            lightItc = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/Roboto-LightItalic.ttf");
            nameView.setTypeface(light);
            characView.setTypeface(lightItc);



        }
    }
    // set adapter filtered list
    public void setList(ArrayList<DataProvider> list) {
        this.leaf=list;
    }
    //call when you want to filter
    public void filterList(String text) {
        filter.filter(text);
    }


    public void filterData(String query) {
        query = query.toLowerCase();
        //leaf.clear();
        Log.d("clearthem", "list");
        if (query.isEmpty()) {
            leaf=origList;
            Log.d("empty","list");
        }
        else {

            final List<DataProvider> filteredModelList = new ArrayList<>();
            for (DataProvider model : origList) {

                final String text = model.getLocal_name().toLowerCase();
                if (text.contains(query)) {
                    Log.d("entered equal", text);
                    filteredModelList.add(model);
                }
            }
            notifyDataSetChanged();
            animateTo(filteredModelList);

        }
           /* for (DataProvider leafv : origList) {
           //    ArrayList<ChildRow> childList = parentRow.getL;
              ArrayList<DataProvider> newList = new ArrayList<DataProvider>();


                Log.d("whoooho","list");
                if(leafv.getLocal_name().toLowerCase().contains(query)){
                    leaf.add(leafv);
                    Log.d("equal",leafv.getLocal_name().toLowerCase());
*/

        //   } // end or (com.example.user.searchviewexpandablelistview.ParentRow parentRow : originalList)
        // end else


        // notifyDataSetChanged();
    }

    public String getValueAt(int position) {
        return values[position];
    }

    public DataProvider removeItem(int position) {
        final DataProvider model = mModels.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, DataProvider model) {
        mModels.add(position, model); notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final DataProvider model = mModels.remove(fromPosition);
        mModels.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
    public void animateTo(List<DataProvider> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<DataProvider> newModels) {
        for (int i = mModels.size() - 1; i >= 0; i--) {
            final DataProvider model = mModels.get(i);
            if (!newModels.contains(model))
            { removeItem(i); }
        }
    }

    private void applyAndAnimateAdditions(List<DataProvider> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final DataProvider model = newModels.get(i);
            if (!mModels.contains(model)) { addItem(i, model); }
        }
    }
    private void applyAndAnimateMovedItems(List<DataProvider> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final DataProvider model = newModels.get(toPosition);
            final int fromPosition = mModels.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition)
            { moveItem(fromPosition, toPosition); }
        }
    }
}
