package plapp.plapp.Database;

import android.graphics.Bitmap;
import android.support.v7.util.SortedList;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

import java.util.ArrayList;

/**
 * Created by uCare on 4 Dec 2016.
 */
//provide data in form of an object
public class DataProvider implements SortedListAdapter.ViewModel {
    //private static String[] leaf_use;
    private String leaf_Id;
    private Bitmap leaf_image;
    private String local_name;
    private String scientific_name;
    private String plant_location;
    private String leaf_use;
    private String leaf_characteristics;
    private String leaf_similarity;
    private String how_to;
    private String category;

    public DataProvider(String id, Bitmap img, String local, String scientific,
                        String location, String uses, String charac,
                        String howto, String similar, String category){
        this.setLeaf_Id(id);
        this.setLeaf_image(img);
        this.setLocal_name(local);
        this.setScientific_name(scientific);
        this.setPlant_location(location);
        this.setLeaf_use(uses);
        this.setLeaf_characteristics(charac);
        this.setLeaf_similarity(similar);
        this.setHow_to(howto);
        this.setCategory(category);



    }

    public Bitmap getLeaf_image() {
        return leaf_image;
    }

    public void setLeaf_image(Bitmap leaf_image) {
        this.leaf_image = leaf_image;
    }

    public String getLeaf_Id() {
        return leaf_Id;
    }

    public void setLeaf_Id(String leaf_Id) {
        this.leaf_Id = leaf_Id;
    }

    public String getLocal_name() {
        return local_name;
    }

    public void setLocal_name(String local_name) {
        this.local_name = local_name;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    public String getPlant_location() {
        return plant_location;
    }

    public void setPlant_location(String plant_location) {
        this.plant_location = plant_location;
    }

    public final String getLeaf_use() {
        return leaf_use;
    }

    public void setLeaf_use(String leaf_use) {
        this.leaf_use = leaf_use;
    }

    public String getLeaf_characteristics() {
        return leaf_characteristics;
    }

    public void setLeaf_characteristics(String leaf_characteristics) {
        this.leaf_characteristics = leaf_characteristics;
    }

    public String getLeaf_similarity() {
        return leaf_similarity;
    }

    public void setLeaf_similarity(String leaf_similarity) {
        this.leaf_similarity = leaf_similarity;
    }

    public String getHow_to() {
        return how_to;
    }

    public void setHow_to(String how_to) {
        this.how_to = how_to;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public static final String[] data = {
            "cupcake", "donut", "eclair", "froyo", "gingerbread",
            "honeycomb", "ice cream sandwich", "jelly bean", "kit kat",
            "Lollipop", "marshmallow"
    };



    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataProvider model = (DataProvider) o;

        if (leaf_Id.equals(model.leaf_Id)) return false;
        return local_name != null ? local_name.equals(model.local_name) : model.local_name == null;

    }
}
