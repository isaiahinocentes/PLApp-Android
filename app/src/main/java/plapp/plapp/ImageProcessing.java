package plapp.plapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
  Created by PH PLApp:
    Inocentes,Isaiah
    Olila, Jam
    Salanguit, Mae
    Faustino, Mae
 */

public class ImageProcessing extends Thread{

    //Class Variables
    private static Bitmap bmp_original;
    private static Bitmap bmp_colorBlob;
    private static Bitmap bmp_otsu_original;
    private static Bitmap bmp_grayscale;
    private static Bitmap bmp_otsu;
    private static Bitmap bmp_edge;
    //
    private static Bitmap bmp_base;
    //
    private int pic_no;
    private String dest;
    //FEATURE COMPARISON RESULTS
    private int[][] results_id_percent;
    public int no_results;
    private Intent intent;
    private static String file_path;

    @Constructor
    public ImageProcessing(Bitmap Original, Resources resources, String cannyTHold, String dest, String file_path){
        this.resources = resources;
        //Set the Canny Edge Detection Threshold
        switch (cannyTHold){
            case max:
                cannyHigh = 255;
                cannyLow = cannyHigh/3;
                break;
            case med:
                cannyHigh = 200;
                cannyLow = cannyHigh/3;
                break;
            case min:
                cannyHigh = 150;
                cannyLow = cannyHigh/3;
                break;
        }
        //this.feature_id = feature_id;
        //Set the Objects
        this.bmp_original = Original;
        PIC_WIDTH   = Original.getWidth();
        PIC_HEIGHT  = Original.getHeight();
        this.no_results = no_results;
        //
        //appF = new AppFunctions(PIC_WIDTH, PIC_HEIGHT);
        //scoring = new ScoringSystem();
        results_id_percent = new int[10][2];
        this.dest = dest;
        this.file_path = file_path;
    }
    //ImageProcessing and compare two images only
    public ImageProcessing(Bitmap bmp_src, Bitmap bmp_base, int pic_no
            //,int feature_id
            //,int no_results
    ){
        this.bmp_original = bmp_src;
        this.bmp_base = bmp_base;
        this.pic_no = pic_no;
        //this.feature_id = feature_id;
        //this.no_results = no_results;
    }


    //RUN THREAD
    @Override
    public void run() {
        doImageProcessing(); //Proccess the Input Image
        //doImageComparison(feature_id);
        //histCompare(bmp_original, bmp_base, pic_no, feature_id);
    }

    //METHODS - Flow Controls
        //ImageProcessing Image output
    private void doImageProcessing(){
        //Convert the Original and then Assign to Bitmaps
        //bmp_colorBlob = bmp_colorBlob(bmp_original,file_path);
        bmp_grayscale = bmp_cvt2Gray(bmp_original);
        bmp_otsu = bmp_thresholding(bmp_grayscale, bmp_original);
        bmp_edge = bmp_cvt2Canny(bmp_original);

        //SAVE Input FEATURES
        appF.saveImage(bmp_colorBlob, "ColorBlob",dest);
        appF.saveImage(bmp_grayscale, "Grayscale",dest);
        appF.saveImage(bmp_otsu, "Binarized",dest);
        //appF.saveImage(bmp_otsu_original, "Original","img");
        appF.saveImage(bmp_edge, "Edge",dest);
        appF.saveImage(bmp_original, "Original",dest);
    }

    //METHODS - Image Processing
        //Color Blob Detection
    public static Bitmap bmp_colorBlob(Bitmap img_src){
    //public static void bmp_colorBlob(Bitmap img_src){
        /*//Compress the Image Input
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        img_src.compress(Bitmap.CompressFormat.PNG, 60, stream);
        byte[] byteArray = stream.toByteArray();
        //Put the compressed Image to newSrc*/
        //
        Log.i("IP_CB_Size",""+img_src.getWidth()+" x "+img_src.getWidth());
        //
        Mat tmp = new Mat();
        Mat hsv = new Mat();
        Mat result = new Mat();
        Mat mFilteredFrame = new Mat();

        Utils.bitmapToMat(img_src, tmp);
        Scalar lower = new Scalar(0, 15, 0);
        Scalar upper = new Scalar(75, 255, 255);

        //colr detector HSV-based
        Imgproc.cvtColor(tmp, hsv, Imgproc.COLOR_RGB2HSV);
        Core.inRange(hsv, lower, upper, result);
        mFilteredFrame.setTo(new Scalar(0, 0, 0));
        tmp.copyTo(mFilteredFrame, result);

        // Output changing back to rgb
        Imgproc.cvtColor(result, result, Imgproc.COLOR_GRAY2RGB,0);
        Imgproc.cvtColor(result, result, Imgproc.COLOR_RGB2RGBA);

        Bitmap result_bmp = Bitmap.createBitmap(img_src);
        Utils.matToBitmap(result, result_bmp);
        //AppFunctions.saveImage(       result_bmp,"Color Blob");
        return result_bmp;
    }
    public static Bitmap bmp_colorBlob(String file_path){
        //public static void bmp_colorBlob(Bitmap img_src){
        /*//Compress the Image Input
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        img_src.compress(Bitmap.CompressFormat.PNG, 60, stream);
        byte[] byteArray = stream.toByteArray();
        //Put the compressed Image to newSrc*/

        Bitmap newSrc;
        newSrc = BitmapFactory.decodeFile(file_path);

        //
        Mat tmp = new Mat();
        Mat hsv = new Mat();
        Mat result = new Mat();
        Mat mFilteredFrame = new Mat();

        Utils.bitmapToMat(newSrc, tmp);
        Scalar lower = new Scalar(0, 15, 0);
        Scalar upper = new Scalar(75, 255, 255);

        //colr detector HSV-based
        Imgproc.cvtColor(tmp, hsv, Imgproc.COLOR_RGB2HSV);
        Core.inRange(hsv, lower, upper, result);
        mFilteredFrame.setTo(new Scalar(0, 0, 0));
        tmp.copyTo(mFilteredFrame, result);

        // Output changing back to rgb
        Imgproc.cvtColor(result, result, Imgproc.COLOR_GRAY2RGB,0);
        Imgproc.cvtColor(result, result, Imgproc.COLOR_RGB2RGBA);

        Bitmap result_bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(file_path), 1200, 1600, true);
        try{
            Utils.matToBitmap(result, result_bmp);
        } finally {
            Log.e("Error on App", "Error");
        }
        //AppFunctions.saveImage(result_bmp,"Color Blob");
        return result_bmp;
    }
        //Returns Grayscaled Bitmap
    private static Bitmap bmp_cvt2Gray(Bitmap img_src){
        img_src = img_src.copy(Bitmap.Config.ARGB_8888, true);
        //MANUAL GRAYSCALING
        for (int x = 0; x < PIC_WIDTH; ++x){
            for (int y = 0; y < PIC_HEIGHT; ++y)
            {
                int rgb = img_src.getPixel(x,y); //Returns Int values for ARGB
                int r = (int)(0.299 * Color.red(rgb));
                int g = (int)(0.587 * Color.green(rgb));
                int b = (int)(0.114 * Color.blue(rgb));
                rgb = Color.rgb(r+g+b,r+g+b,r+g+b);
                img_src.setPixel(x,y,rgb);

                //FOR BINARIZATION
                /*vals.add(Color.red(rgb));
                //If array do not contain the said key already the pixel category
                if(!pix.containsKey(vals.get(i))){
                    pix.put(vals.get(i),1);
                    keys.add(vals.get(i));
                } else {
                    //If not, get the current value add 1 and put again
                    pix.put(vals.get(i),pix.get(vals.get(i))+1);
                }*/
            }
        }
        return img_src;
    }
        //Returns the Binarized Bitmap and Edits otsu threshold original Image
    private static Bitmap bmp_thresholding(Bitmap img_gray, Bitmap img_src) {

        //Thresholding
        Map<Double, Double> otsu_WCV = new TreeMap<>();
        ArrayList<Double> otsu_WCVkeys = new ArrayList<>();
        ArrayList<Integer> vals = new ArrayList<>(); //Contains 0-255 values for pixel
        ArrayList<Integer> keys = new ArrayList<>();
        Map<Integer, Integer> pix = new TreeMap<>();
        int THRESHOLD;
        double FinalTHRESHOLD;

        img_gray = img_gray.copy(Bitmap.Config.ARGB_8888, true);
        Bitmap bmp_otsu = Bitmap.createBitmap(PIC_WIDTH, PIC_HEIGHT, Bitmap.Config.ARGB_8888);
        bmp_otsu_original = img_src.copy(Bitmap.Config.ARGB_8888, true);

        //MANUAL GRAYSCALING
        for (int x = 0, i = 0; x < PIC_WIDTH; ++x) {
            for (int y = 0; y < PIC_HEIGHT; ++y) {
                int rgb = img_gray.getPixel(x, y);
                //FOR BINARIZATION
                vals.add(Color.green(rgb));
                //If array do not contain the said key already the pixel category
                if (!pix.containsKey(vals.get(i))) {
                    pix.put(vals.get(i), 1);
                    keys.add(vals.get(i));
                } else {
                    //If not, get the current value add 1 and put again
                    pix.put(vals.get(i), pix.get(vals.get(i)) + 1);
                }
            }
        }

        //Sort unique values and pixel-values
        Collections.sort(vals);
        Collections.sort(keys);

        //Suitable Thresholding
        {
            for (int tLevel = 0; tLevel < keys.size(); tLevel++) {
                double WEIGHTb, SUMb = 0,
                        MEANb, PIXSUMb = 0,
                        VARIANCEb, VARSUMb = 0; //For the pixels from the left to threshold
                double WEIGHTf, SUMf = 0,
                        MEANf, PIXSUMf = 0,
                        VARIANCEf, VARSUMf = 0; //For the pixels from the threshold to end
                double SIZE = PIC_HEIGHT * PIC_WIDTH,
                        WCV;
                THRESHOLD = keys.get(tLevel); //Would depend on the distinct elements of keys/pixel colors

                //BACKGROUND
                //Get the Weight
                //sum of values from left to theshold / SIZE
                for (int i = 0; vals.get(i) < THRESHOLD; i++) {
                    SUMb += 1;
                }
                WEIGHTb = SUMb / SIZE;

                //Get MEAN
                //0-threshold
                //Suma(Key * value)/SUM;
                for (int i = 0; keys.get(i) < THRESHOLD; i++) {
                    PIXSUMb += keys.get(i) * pix.get(keys.get(i));
                }
                //NaN Check
                if (Double.isNaN(PIXSUMb / SUMb))
                    MEANb = 0;
                else MEANb = PIXSUMb / SUMb;

                //Variance - 0 < threshold
                //(SUMA[ {KEY-MEAN}^2 * VALUE] )/SUM
                for (int i = 0; i < THRESHOLD && i < keys.size(); i++) {
                    VARSUMb += (keys.get(i) - MEANb) * (keys.get(i) - MEANb) * pix.get(keys.get(i));
                }
                //NaN Check
                if (Double.isNaN(VARSUMb / SUMb) || WEIGHTb == 0)
                    VARIANCEb = 0;
                else VARIANCEb = VARSUMb / SUMb;

                //FOREGROUND
                //Get the Weight
                //sum of values from threshold to end / SIZE
                for (int i = vals.indexOf(THRESHOLD); i < vals.size(); i++) {
                    SUMf += 1;
                }
                WEIGHTf = SUMf / SIZE;

                //Get MEAN
                //threshold-end
                //Suma(Key * value)/SUM;
                for (int i = THRESHOLD; i < keys.size(); i++) {
                    PIXSUMf += keys.get(i) * pix.get(keys.get(i));
                }
                if (Double.isNaN(PIXSUMf / SUMf))
                    MEANf = 0;
                else MEANf = PIXSUMf / SUMf;

                //Variance - threshold < end
                //(SUMA[ {KEY-MEAN}^2 * VALUE] )/SUM
                for (int i = THRESHOLD; i < pix.size(); i++) {
                    VARSUMf += (keys.get(i) - MEANf) * (keys.get(i) - MEANf) * pix.get(keys.get(i));
                }

                if (Double.isNaN(VARSUMf / SUMf))
                    VARIANCEf = 0;
                else VARIANCEf = VARSUMf / SUMf;

                //FINAL
                //Within Class Variance
                //WCV = Wb*Vb + Wf*Vf
                WCV = (WEIGHTb * VARIANCEb) + (WEIGHTf * VARIANCEf);

                //Save the sum of classes to Map
                otsu_WCV.put(WCV, (double) THRESHOLD);
                otsu_WCVkeys.add(WCV);
            }

            //Sort Keys
            Collections.sort(otsu_WCVkeys);
            //The computed suitable pixel THRESHOLD
            FinalTHRESHOLD = otsu_WCV.get(otsu_WCVkeys.get(0));
        }

        //BINARIZATION
        for (int x = 0; x < PIC_WIDTH; ++x){
            for (int y = 0; y < PIC_HEIGHT; ++y){
                int rgb = img_gray.getPixel(x, y); //Get the pixel color in RGB from img_gray
                int rgb_move;
                if(Color.red(rgb) < FinalTHRESHOLD){
                    rgb = Color.BLACK; //Set to as Foreground Pixel
                    rgb_move = img_src.getPixel(x,y); //set the Pixel to the color of the original image
                } else {
                    rgb = Color.WHITE; //Set to as Background Pixel
                    rgb_move = rgb;
                }
                bmp_otsu.setPixel(x,y,rgb); //Change the color of the said pixel(x,y)
                bmp_otsu_original.setPixel(x,y,rgb_move); //Change the background pixels as white
            }
        }
        return bmp_otsu;
    }
        //Returns the edges of an grayscale image
    private static Bitmap bmp_cvt2Canny(Bitmap bmp_org_non_otsu){
        //bmp_org = bmp_org.copy(Bitmap.Config.ARGB_8888, true);
        Mat mRgba = new Mat(PIC_HEIGHT, PIC_WIDTH, CvType.CV_8UC4); // Create a Mat with 4 Color Channel Only
        Mat imgGray = new Mat(PIC_HEIGHT, PIC_WIDTH, CvType.CV_8UC1); // Create a Mat with 1 Color Channel Only
        Mat imgCanny = new Mat(PIC_HEIGHT, PIC_WIDTH, CvType.CV_8UC1); // Create a Mat with 1 Color Channel Only
        Utils.bitmapToMat(bmp_org_non_otsu, mRgba);

        Imgproc.cvtColor(mRgba, imgGray, Imgproc.COLOR_RGB2GRAY);
        //Imgproc.Canny(imgGray, imgCanny, cannyLow, cannyHigh);
        Imgproc.Canny(imgGray, imgCanny, cannyLow, cannyHigh, 3, true);
        Utils.matToBitmap(imgCanny, bmp_org_non_otsu);

        //Log.i("DIRECTORY",Environment.DIRECTORY_PICTURES);
        //appF.saveImage(bmp_org,"CannyEdge");
        return bmp_org_non_otsu;
    }
        //Get specific feature of a picture (Gray, Binary, Edge, Blob)
    public static Bitmap getSpecificFeature(int feature_id){
        switch (feature_id){
            case FEATURE_GRAYSCALE:
                return bmp_grayscale;
            case FEATURE_BINARY:
                return bmp_otsu;
            case FEATURE_CANNY_EDGE:
                return bmp_edge;
            case FEATURE_COLOR_BLOB:
                return bmp_colorBlob;
        }
        return bmp_original;
    }
    public static Bitmap getSpecificFeature(Bitmap img, int feature_id){
        //Bitmap bmp = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);
        Bitmap bmp = null;
        switch (feature_id){
            case FEATURE_GRAYSCALE:
                bmp = bmp_cvt2Gray(img); break;
            case FEATURE_BINARY:
                bmp = bmp_thresholding(bmp_cvt2Gray(img), img); break;
            case FEATURE_CANNY_EDGE:
                bmp = bmp_cvt2Canny(img); break;
            case FEATURE_COLOR_BLOB:
                //Log.i("IMGPROC","Color_blob");
                bmp = bmp_colorBlob(img); break;
        }
        return bmp;
    }
    public static Bitmap getSpecificFeature(String file_path, int feature_id){
        Bitmap bmp = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(file_path),1200,1600,true);
        switch (feature_id){
            case FEATURE_GRAYSCALE:
                bmp = bmp_cvt2Gray(bmp); break;
            case FEATURE_BINARY:
                bmp = bmp_thresholding(bmp_cvt2Gray(bmp), bmp); break;
            case FEATURE_CANNY_EDGE:
                bmp = bmp_cvt2Canny(bmp); break;
            case FEATURE_COLOR_BLOB:
                //Log.i("IMGPROC","Color_blob");
                bmp = bmp_colorBlob(file_path); break;
        }
        return bmp;
    }

    //METHODS - Getter
    public int[][] getResults_id_percent(){
        return results_id_percent;
    }

    //REQUIRED
    public Resources getResources() {
        return resources;
    }
    //Values
    public static int PIC_WIDTH;
    public static int PIC_HEIGHT;
    //public static int feature_id;
    public static final String max = "MAX";
    public static final String med = "MED";
    public static final String min = "MIN";
    private static int cannyLow;
    private static int cannyHigh;
    public static final int FEATURE_GRAYSCALE = 0;
    public final static int FEATURE_BINARY = 1;
    public final static int FEATURE_CANNY_EDGE = 2;
    public final static int FEATURE_COLOR_BLOB = 3;
    public static final int NO_RESULTS_1 = 1;
    public static final int NO_RESULTS_2 = 2;
    public static final int NO_RESULTS_3 = 3;
    //App Functions and Needed
    private AppFunctions appF;
    private static ScoringSystem scoring;
    private Resources resources;
}
