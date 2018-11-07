package plapp.plapp;
/*
  Created by PH PLApp:
    Inocentes,Isaiah
    Olila, Jam
    Salanguit, Mae
    Faustino, Mae
 */

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;

public class ImageCompare implements Runnable{
//public class ImageCompare{
    static ScoringSystem score;
    Bitmap src, base;
    int pic_no;
    String file_path;

    @Constructor
    public ImageCompare(Bitmap src, Bitmap base, int pic_no, int feature_id, String file_path){
        this.src = src;
        this.base = base;
        this.pic_no = pic_no;
        this.feature_id = feature_id;
        this.file_path = file_path;
        score = new ScoringSystem();

    }

    @Override
    public void run() { //Start comparing input to different images
        //doImageComparison(feature_id);
        //doImageComparison(src, base, pic_no, feature_id, file_path);
    }

    //Compare 1 - 1 leaf feature image histogram
    public static void doImageComparison(String file_path, Bitmap base, int pic_no, int feature_id){

        //Mat
        Mat src_img = new Mat(),            //Contains the Original Image
                gray_img = new Mat(),       //Contains the grayscale
                hist_img = new Mat();       //The histogram of the grayscale
        Mat src_base = new Mat(),           //Contains the Original Image
                gray_base = new Mat(),      //Contains the grayscale
                hist_base = new Mat();      //The histogram of the grayscale

        //1st Image
        //Conver the Image
        Bitmap src = ImageProcessing.getSpecificFeature(file_path, feature_id); //Get specific feature for the histogram comparison
        //Save Image to IMG
        //ImagePath = MediaStore.Images.Media.insertImage(getContentResolver(),)
        //Log.i("PICTURE SAVED",""+AppFunctions.saveImage(src, "Input_"+AppFunctions.translateFeatureId(feature_id), "img"));
        Log.i("PICTURE SAVED",""+saveImage(src, "Src_input", "db")+", Src_input");
        //Get and proccess First Image
        Utils.bitmapToMat(src, src_img);
        Imgproc.cvtColor(src_img, gray_img, Imgproc.COLOR_BGR2GRAY);
        //IMG1 - Calculate histogram and normalize
        Imgproc.calcHist(Collections.singletonList(gray_img), new MatOfInt(0), new Mat(), hist_img, new MatOfInt(25), new MatOfFloat(0f, 256f));
        Core.normalize(gray_img, gray_img, 0, 1, Core.NORM_MINMAX);

        //Get 2nd Image
        base = ImageProcessing.getSpecificFeature(base, feature_id); //Get specific feature for the histogram comparison
        //Save Base Image to DB
        //Log.i("PICTURE SAVED",""+AppFunctions.saveImage(base, "Base_"+AppFunctions.translateDrawableId(pic_no)+"-"+AppFunctions.translateFeatureId(feature_id), "db"));
        Log.i("PICTURE SAVED",""+saveImage(base, "Base_"+pic_no, "db"));
        Utils.bitmapToMat(base, src_base);
        //Convert Colors to Grayscale
        Imgproc.cvtColor(src_base, gray_base, Imgproc.COLOR_BGR2GRAY);
        //IMG2 - Calculate histogram and normalize
        Imgproc.calcHist(Collections.singletonList(gray_base), new MatOfInt(0), new Mat(), hist_base, new MatOfInt(25), new MatOfFloat(0f, 256f));
        Core.normalize(gray_base, gray_base, 0, 1, Core.NORM_MINMAX);

        //Compare histograms depending on the given Feature
        double match_percent = Imgproc.compareHist(hist_img, hist_base, Imgproc.CV_COMP_BHATTACHARYYA); //PPD - Lowest
        Log.i("RESULTS-"+AppFunctions.translateFeatureId(feature_id), AppFunctions.translateDrawableId(pic_no)+" = "+match_percent);
        score.addScore(pic_no, match_percent, feature_id);
        //double img_base_correl = Imgproc.compareHist(hist_img, hist_base, CV_COMP_CORREL);    //Highest
        //double img_base_inter = Imgproc.compareHist(hist_img, hist_base, CV_COMP_INTERSECT);  //Highest
        //double img_base_chi = Imgproc.compareHist(hist_img, hist_base, CV_COMP_CHISQR);       //Lowest
        //double img_base_bhat = Imgproc.compareHist(hist_img, hist_base, Imgproc.CV_COMP_BHATTACHARYYA); //Lowest

        //String result
        //comparing += "\nPic" + pic_no + ": " + match_percent;

        //Add the pic id and the percentage of compare
        //results_id_percent = scoring.getResults(no_results);
    }
    public static void doImageComparison(Bitmap src, Bitmap base, int pic_no, int feature_id){
        //Mat
        Mat src_img = new Mat(),            //Contains the Original Image
                gray_img = new Mat(),       //Contains the grayscale
                hist_img = new Mat();       //The histogram of the grayscale
        Mat src_base = new Mat(),           //Contains the Original Image
                gray_base = new Mat(),      //Contains the grayscale
                hist_base = new Mat();      //The histogram of the grayscale
        Log.i("IC_BS_BS",base.getWidth()+" x "+base.getHeight());
        int width = base.getWidth();
        int height = base.getWidth();
        if(src.getWidth() < base.getWidth()){
            width = src.getWidth();
        }
        if(src.getHeight() < base.getWidth()){
            height = src.getHeight();
        }
        src = Bitmap.createScaledBitmap(src,
                width,
                height,
                true);
        Log.i("IC_SRC_BS",src.getWidth()+" x "+src.getHeight());

        //1st Image
        //Conver the +Image
        src = ImageProcessing.getSpecificFeature(src, feature_id); //Get specific feature for the histogram comparison
        //Save Image to IMG
        //ImagePath = MediaStore.Images.Media.insertImage(getContentResolver(),)
        //Log.i("PICTURE SAVED",""+AppFunctions.saveImage(src, "Input_"+AppFunctions.translateFeatureId(feature_id), "img"));
        Log.i("PICTURE SAVED",""+saveImage(src, "Src_input", "db"));
        //Get and proccess First Image
        Utils.bitmapToMat(src, src_img);
        Imgproc.cvtColor(src_img, gray_img, Imgproc.COLOR_BGR2GRAY);
        //IMG1 - Calculate histogram and normalize
        Imgproc.calcHist(Collections.singletonList(gray_img), new MatOfInt(0), new Mat(), hist_img, new MatOfInt(25), new MatOfFloat(0f, 256f));
        Core.normalize(gray_img, gray_img, 0, 1, Core.NORM_MINMAX);

        //Get 2nd Image
        base = ImageProcessing.getSpecificFeature(base, feature_id); //Get specific feature for the histogram comparison
        //Save Base Image to DB
        //Log.i("PICTURE SAVED",""+AppFunctions.saveImage(base, "Base_"+AppFunctions.translateDrawableId(pic_no)+"-"+AppFunctions.translateFeatureId(feature_id), "db"));
        Log.i("PICTURE SAVED",""+saveImage(base, "Base_"+pic_no, "db"));
        Utils.bitmapToMat(base, src_base);
        //Convert Colors to Grayscale
        Imgproc.cvtColor(src_base, gray_base, Imgproc.COLOR_BGR2GRAY);
        //IMG2 - Calculate histogram and normalize
        Imgproc.calcHist(Collections.singletonList(gray_base), new MatOfInt(0), new Mat(), hist_base, new MatOfInt(25), new MatOfFloat(0f, 256f));
        Core.normalize(gray_base, gray_base, 0, 1, Core.NORM_MINMAX);

        //Compare histograms depending on the given Feature
        double match_percent = Imgproc.compareHist(hist_img, hist_base, Imgproc.CV_COMP_BHATTACHARYYA); //PPD - Lowest
        Log.i("RESULTS-"+AppFunctions.translateFeatureId(feature_id), AppFunctions.translateDrawableId(pic_no)+" = "+match_percent);
        score.addScore(pic_no, match_percent, feature_id);
        //double img_base_correl = Imgproc.compareHist(hist_img, hist_base, CV_COMP_CORREL);    //Highest
        //double img_base_inter = Imgproc.compareHist(hist_img, hist_base, CV_COMP_INTERSECT);  //Highest
        //double img_base_chi = Imgproc.compareHist(hist_img, hist_base, CV_COMP_CHISQR);       //Lowest
        //double img_base_bhat = Imgproc.compareHist(hist_img, hist_base, Imgproc.CV_COMP_BHATTACHARYYA); //Lowest

        //String result
        //comparing += "\nPic" + pic_no + ": " + match_percent;

        //Add the pic id and the percentage of compare
        //results_id_percent = scoring.getResults(no_results);
    }





    public static boolean saveImage(Bitmap bitmap, String imgname, String loc){
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir;
        if(loc.equals("db"))
            myDir = new File(root + "/plapp/db");
        else
            myDir = new File(root + "/plapp/img");
        myDir.mkdirs();
        String fname = imgname +".jpg";
        File file = new File (myDir, fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    //REQUIRED
    private Resources resources;
    public Resources getResources() {
        return resources;
    }
    public static int feature_id;
}
