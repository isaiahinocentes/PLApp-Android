package plapp.plapp.Viewing;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import plapp.plapp.Database.BackgroundTask;
import plapp.plapp.Database.DBOperations;
import plapp.plapp.Database.DataProvider;
import plapp.plapp.Database.DbHelper;
import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by rufflez on 6/21/15.
 */
    public class HowToUseFragment extends Fragment {


    private String id;
    private DbHelper dbHelper;
    DBOperations db = new DBOperations(getContext());
    TextView uses;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.content_view_leaf, container, false);
        String a = "";


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dbHelper= new DbHelper(getActivity());
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        String leafName, scienceName, location, characteristics;
        uses = (TextView) getActivity().findViewById(R.id.result_uses);
        ViewLeaf viewLeaf = (ViewLeaf)getActivity();
        id=viewLeaf.getId();



        //    local.setText(dbHelper.getName(viewLeaf.getId().toString()));
        String useId = dbHelper.getHowToUse(viewLeaf.getId().toString());

        uses.setText(Html.fromHtml(useId));


        //return inflater.inflate(R.layout.fragment, container, false);


        //    Bundle bundle = this.getArguments();
        //    if (bundle != null) {
        //         i = bundle.getString("id");



        // }

    }
}
/*    RecyclerView recyclerView;
    UsesAdapter us;
     static String id;


    ArrayList<DataProvider> originalList =  new ArrayList<DataProvider>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.view_how_to, container, false);


        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView1);
        setupRecyclerView(recyclerView);
        return rootView;
    }

    private void setupRecyclerView(RecyclerView recyclerView){
        ViewLeaf viewLeaf = (ViewLeaf)getActivity();

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        BackgroundTask backgroundTask = new BackgroundTask(this.getActivity());
        backgroundTask.execute("get_uses_result");

      //  recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),VersionModel.data));
    }

 /*   public static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder>{
        private String[] mValues;
        private Context mContext;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public final View mView;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mTextView = (TextView) view.findViewById(android.R.id.text1);
            }

        }

        public String getValueAt(int position) {
            return mValues[position];
        }

        public SimpleStringRecyclerViewAdapter(Context context, String[] items) {
            mContext = context;
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {


            holder.mTextView.setText(mValues[position]);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, getValueAt(position), Snackbar.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.length;
        }
    }*/
