package plapp.plapp.Searching;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import plapp.plapp.Database.DataProvider;

/**
 * Created by uCare on 30 Jan 2017.
 */
public class FilterClass extends Filter {

    private List<DataProvider> leaves;
    private List<DataProvider> filteredleaves;
    private ManualSearchAdapter adapter;

    public FilterClass(List<DataProvider> leaves, ManualSearchAdapter adapter) {
        this.adapter = adapter;
        this.leaves = leaves;
        this.filteredleaves = new ArrayList();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        filteredleaves.clear();
        final FilterResults results = new FilterResults();

        //here you need to add proper items do filteredleaves
        for (final DataProvider item : leaves) {
            if (item.getLocal_name().toLowerCase().trim().contains("pattern")) {
                filteredleaves.add(item);
            }
        }

        results.values = filteredleaves;
        results.count = filteredleaves.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        //adapter.setList(filteredleaves);
        adapter.notifyDataSetChanged();
    }
}