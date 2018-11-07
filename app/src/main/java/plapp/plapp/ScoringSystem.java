package plapp.plapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

import static plapp.plapp.ImageProcessing.FEATURE_BINARY;
import static plapp.plapp.ImageProcessing.FEATURE_CANNY_EDGE;
import static plapp.plapp.ImageProcessing.FEATURE_COLOR_BLOB;
import static plapp.plapp.ImageProcessing.FEATURE_GRAYSCALE;

/**
 *Created by PH PLApp:
 Inocentes,Isaiah
 Olila, Jam
 Salanguit, Mae
 Faustino, Mae
 <html>
    <head><title>PH PlApp</title>
    </head>

    <boody>
        Game
    </boody>
 </html>
*/

public class ScoringSystem {

    //Final Score
    public static ArrayList<Integer> ID = new ArrayList<>();
    public static ArrayList<Integer> SCORE = new ArrayList<>();
    public static int res[][];

    /*public static int                 score_id[];
    public static  ArrayList<Integer>  score_point;*/
    static ArrayList<Integer> gray_id = new ArrayList<>();
    static ArrayList<Double> gray_match = new ArrayList<>();

    static ArrayList<Integer> binary_id = new ArrayList<>();
    static ArrayList<Double> binary_match = new ArrayList<>();

    static ArrayList<Integer> contour_id = new ArrayList<>();
    static ArrayList<Double> contour_match = new ArrayList<>();

    //static final ArrayList ids[] = {gray_id, binary_id, contour_id};
    //static final ArrayList matches[] = {gray_match, binary_match, contour_match};

    static ArrayList ids[] = {gray_id
            ,binary_id
            ,contour_id
    };
    //
    static ArrayList matches[] = {gray_match
            ,binary_match
            ,contour_match
    };

    public static Thread thread = null;

    public ScoringSystem(){
//        for(int i = 0; i < 10; i++){
//            SCORE.add(0);
//        }
        //Final Score
        ID = new ArrayList<>();
        SCORE = new ArrayList<>();

        gray_id = new ArrayList<>();
        gray_match = new ArrayList<>();

        binary_id = new ArrayList<>();
        binary_match = new ArrayList<>();

        contour_id = new ArrayList<>();
        contour_match = new ArrayList<>();
    }
    public static void addScore(int key, double value, int feature_id){
        switch(feature_id){
            case FEATURE_GRAYSCALE:
                gray_id.add(key);
                gray_match.add(value);
                break;
            case FEATURE_COLOR_BLOB | FEATURE_BINARY:
                binary_id.add(key);
                binary_match.add(value);
                break;
            case FEATURE_CANNY_EDGE:
                contour_id.add(key);
                contour_match.add(value);
                break;
        }
        Log.i("AD_BINARY",binary_id+"" +
                binary_match);
        //ShowValues();
//        System.out.println("Added "+key+" - "+value);
    }

    public static void computeScore(){

        ShowValues();
        //

//        sortArrays(ids[1], matches[1], 1);
//        addScores(ids[1], matches[1]);

        sortArrays(binary_id,binary_match, 1);
        addScores(binary_id);

//        for(int ii = 0; ii < 3; ii++){
//            final int i = ii;
////            Log.d("IDS",""+ids[i]);
////            Log.d("MATCH",""+matches[i]);
//            sortArrays(ids[i], matches[i], ii);
////            thread = new Thread(new Runnable() {
////                @Override
////                public void run() {
////                    sortArrays(ids[i], matches[i]);
////                }
////            });
////            thread.start();
//            //System.out.println("ID: "+ids[ii]);
//            //System.out.println("Val:"+matches[ii])
//        }
//        //while(thread.isAlive()){};
//        for(int ii = 0; ii < 3; ii++){
//            addScores(ids[ii], matches[ii]);
//        }
    }

    public static void sortFinalScore(ArrayList<Integer> id, ArrayList<Integer> match){
        ArrayList<Integer> l_id = new ArrayList<>();
        ArrayList<Integer> l_perc = new ArrayList<>();
        //
        Log.i("SORT-ARRAYS-SCORE",""+id+"\n   "+match);
        //i to length of ArrayList
        for(int i = 0; i < ID.size(); i++){
            //Get the max value
            int val = Collections.max(match);
            //Get the index of max value
            int c = indexOf(match, val);
            Log.i(i+"_FS_MAX",""+val+" - INDX = "+c);
            //Put the max values and it's ID to new List
            l_id.add(id.get(c));
            l_perc.add(match.get(c));
            //Log.i("SA_Contains",""+!ID.contains(id.get(c)));
            Log.i(i+"_FS_VAR",""+l_id+"\n  " +
                    l_perc);
            //if(!ID.contains(id.get(c)))
            //    ID.add(id.get(c));
            //Remove the index
            id.remove(c);
            match.remove(c);
        }
        //ids[idx].clear();
        //Collections.copy(ids[idx], l_id);
        ////
        //matches[idx].clear();
        //Collections.copy(matches[idx], l_perc);

        //binary_id.clear();
        //Collections.copy(binary_id, l_id);
        ////
        //binary_match.clear();
        //Collections.copy(binary_match, l_perc);

        ID.clear();
        ID = new ArrayList<>(l_id);
        //
        SCORE.clear();
        SCORE = new ArrayList<>(l_perc);

        //ShowValues();
        Log.i("FS_VALS",""+ID+"\n"+
            SCORE);
//        id = l_id;
//        match = l_perc;
    }
    public static void sortArrays(ArrayList<Integer> id, ArrayList<Double> match, int idx){
        ArrayList<Integer> l_id = new ArrayList<>();
        ArrayList<Double> l_perc = new ArrayList<>();
        //
        Log.i("SORT-ARRAYS",""+id+"\n   "+match);
        //i to length of ArrayList
        for(int i = 0; i < ID.size(); i++){
            //Get the max value
            double val = Collections.min(match);
            //Get the index of max value
            int c = indexOf(match, val);
            Log.i(i+"_SA_Min",""+val+" - INDX = "+c);
            //Put the max values and it's ID to new List
            l_id.add(id.get(c));
            l_perc.add(match.get(c));
            //Log.i("SA_Contains",""+!ID.contains(id.get(c)));
            Log.i(i+"_SA_Vars",""+l_id+"\n  " +
                    l_perc);
            //if(!ID.contains(id.get(c)))
            //    ID.add(id.get(c));
            //Remove the index
            id.remove(c);
            match.remove(c);
        }
        //ids[idx].clear();
        //Collections.copy(ids[idx], l_id);
        ////
        //matches[idx].clear();
        //Collections.copy(matches[idx], l_perc);

        //binary_id.clear();
        //Collections.copy(binary_id, l_id);
        ////
        //binary_match.clear();
        //Collections.copy(binary_match, l_perc);

        binary_id.clear();
        binary_id = new ArrayList<>(l_id);
        //
        binary_match.clear();
        binary_match = new ArrayList<>(l_perc);

        ShowValues();
//        id = l_id;
//        match = l_perc;
    }



    public static void addScores(ArrayList<Integer> id){
//        SCORE.clear();
//        //Set the initial Scores
//        for(int i = 0; i < ID.size(); i++){
//            SCORE.add(0);
//        }
        SCORE.clear();
        ArrayList<Integer> tmp_SCORE = new ArrayList<>();
        for(int i = 0; i < id.size(); i++){
            tmp_SCORE.add(0);
            SCORE.add(0);
        }

        for(int i = 0, Score = 100; i < ID.size(); i++, Score-=10){

            Log.i(i+" AS",""+id);
            //
            int key = id.get(i);
            Log.i("AS_K",""+key);
            //double value = (double)match.get(i);
            //
            //int ID_index = ID.indexOf(key);
            //
            //Integer[] array = new Integer[ID.size()];
            //for(int c = 0; c < ID.size(); c++){
            //    array[c] = ID.get(c);
            //}
            //List<Integer> list = Arrays.asList(array);
            //int ID_index = list.indexOf(key);
            int ID_index = indexOf(ID, key);
            Log.i("AS_KI",""+ID_index);
            //
            int newScore = tmp_SCORE.get(ID_index)+Score;
            SCORE.remove(ID_index);
            SCORE.add(ID_index, newScore);
            Log.i("AS_S",""+SCORE);
            //System.out.println("Score: "+ID.get(key)+" = "+newScore);
        }
        sortFinalScore(ID, SCORE);
    }

    private static int indexOf(ArrayList<Integer> list, int key){
        for(int i = 0; i < list.size(); i++){
            Log.i(i+" Index",""+list.get(i)+" == "+key);
            if(list.get(i) == key)
                return i;
        }
        return 0;
    }
    private static int indexOf(ArrayList<Double> list, double key) {
        for(int i = 0; i < list.size(); i++){
            Log.i(i+" Index",""+list.get(i)+" == "+key);
            if(list.get(i) == key)
                return i;
        }
        return 0;
    }

    public static void ShowValues(){
        //Log.i("GRAY",gray_id        +"\n"+gray_match);
        Log.i("SV_BINARY",binary_id    +"\n"+binary_match);
        //Log.i("CONTOUR",contour_id  +"\n"+contour_match);
    }

//    public static final int FEATURE_GRAYSCALE = 0;
//    public static final int FEATURE_BINARY = 1;
//    public static final int FEATURE_CONTOUR = 2;

//    private static ArrayList<Integer> leaf_id = new ArrayList<>();
//    private static ArrayList<Double> leaf_percent = new ArrayList<>();
//
//    //Add the Key and Value to the Lists
//    public static void addScore(int key, double value){
//        //Add the leaf ID to list
//        leaf_id.add(key);
//
//        //Add the current value to the list
//        leaf_percent.add(value);
//
//        //Log.i("KEY: "+key, "VALUE: "+value);
//        //add the leaf to MAP1
//        //percent_id.put(value, key);
//    }
//
//    //Get the results
//    public static int[][] getResults(int numOfResults){
//        ///Log.i("Results", "Start");
//        //Local Variables
//        /*ArrayList<Integer> id = new ArrayList<>();
//        ArrayList<Double> percent = new ArrayList<>();
//        Collections.copy(id, IDs);
//        Collections.copy(percent, values);*/
//
//        //Collections.sort(leaf_percent);
//        ArrayList<Integer> id = new ArrayList<>();
//        ArrayList<Double> perc = new ArrayList<>();
//
//        for(int i = 0; i < 3; i++){
//            //Log.i("Leaf Id",""+leaf_id);
//            //Log.i("Leaf Percent", ""+leaf_percent);
//            //Get the index of first highest value
//            /*double max_match = Collections.max(leaf_percent);
//            int c = leaf_percent.indexOf(max_match);
//            //Put the values to new List
//            id.add(leaf_id.get(c));
//            perc.add(leaf_percent.get(c));
//            //Remove the index
//            leaf_id.remove(c);
//            leaf_percent.remove(c);
//
//            //If still present, put again
//            if(leaf_percent.contains(max_match)){
//                c = leaf_percent.indexOf(max_match);
//                id.add(leaf_id.get(c));
//                perc.add(leaf_percent.get(c));
//
//                //Remove the index
//                leaf_id.remove(c);
//                leaf_percent.remove(c);
//
//            }*/
//
//            //Get the index of first highest value
//            String percents = "";
//            for (double db: leaf_percent) {
//                percents += db+" "; }
//            //Log.i("PERCENT ",percents);
//            double min_match = Collections.min(leaf_percent);
//            int c = leaf_percent.indexOf(min_match);
//            //Put the values to new List
//            id.add(leaf_id.get(c));
//            perc.add(leaf_percent.get(c));
//            //Log.i("RESULT "+c, AppFunctions.translateDrawableId(leaf_id.get(c))+" = "+leaf_percent.get(c));
//            //Remove the index
//            leaf_id.remove(c);
//            leaf_percent.remove(c);
//
//            //If still present, put again
//            /*if(leaf_percent.contains(min_match)){
//                c = leaf_percent.indexOf(min_match);
//                id.add(leaf_id.get(c));
//                perc.add(leaf_percent.get(c));
//
//                //Remove the index
//                leaf_id.remove(c);
//                leaf_percent.remove(c);
//            }*/
//        }
//
//        //Put the ID and percentage on a 2dArray
//        //Log.i("PERCENT SIZE",""+leaf_percent.size());
//        int[][] results = new int[5][2];
//        for(int i=0; i < numOfResults; i++){
//            results[i][0]= id.get(i);
//            results[i][1]= (int)(perc.get(i) * 100);
//            Log.i("RESULT "+(i+1), AppFunctions.translateDrawableId(results[i][0])+" - "+results[i][1]);
//        }
//        //Log.i("Results", "End");
//        //showValues();
//        return results;
//    }
//
//    //For log
//    public static void showValues(){
//        String values = "";
//        for (int i = 0; i < leaf_id.size(); i++) {
//            values += leaf_id.get(i) + " - " + leaf_percent.get(i) + "\n";
//        }
//        Log.i("VALUES"," "+values);
////        values = "";
////        for (int i = 0; i < ; i++) {
////            values += leaf_id.get(i) + " - " + leaf_percent.get(i) + "\n";
////        }
//    }
}
