package plapp.plapp;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FileOutputStream;

import viralandroid.com.androiduserinterfacetutorial.R;

/**
 * Created by Isaiah on 2/8/2017.
 */

public class AppFunctions {

    private static int PIC_WIDTH;
    private static int PIC_HEIGHT;

    public AppFunctions(int width, int height){
        PIC_WIDTH = width;
        PIC_HEIGHT = height;
    }

    public static void showAlert(Context context){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Sorry :( ");
        alertDialog.setMessage("Feature Still in Development");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    public static void showAlert(Context context,String title, String dialog){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(dialog);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    //FUNCTIONALITIES
    public static boolean saveImage(Bitmap bitmap, String imgname, String loc){
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir;
        myDir = new File(root + "/plapp/"+loc);
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
//    public static void boolean getImageChosenImage(){
//        return false;
//    }
    public static boolean saveImage(Mat mat, String imgname, String loc){
        Mat newMat = new Mat();
        Imgproc.cvtColor(mat, newMat, Imgproc.COLOR_GRAY2BGR);
        Bitmap bitmap = Bitmap.createBitmap(newMat.width(), newMat.height(),
                Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(newMat, bitmap);

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

    ///////////////////////////////////////////////////////////
    public static String translateId(int r_id) {
        /*1-akapulko
        2-ampalaya
        3-atis
        4-bawang
        5-bayabas
        6-kangkong
        7-lagundi
        8-manga
        9-niyong
        10-oregano
        11-pandan
        12-pansit
        13-pechay
        14-repolyo
        15-sambong
        16-tsaang gubat
        17-tuba
        18-uray
        19-yerba*/
        switch (r_id) {
            case R.drawable.ps_pic1:
                return "0005";
            case R.drawable.ps_pic2:
                return "0003";
            case R.drawable.ps_pic3:
                return "0008";
            case R.drawable.ps_pic4:
                return "0010";
            case R.drawable.ps_pic5:
                return "0010";
            case R.drawable.ps_pic6:
                return "0011";
        }
        return "";
    }
    public static String translateDrawableId(int id){
        /*
        1-akapulko
        2-ampalaya
        3-atis
        4-bawang
        5-bayabas
        6-kangkong
        7- lagundi
        8-manga
        9-niyong
        10-oregano
        11-pandan
        12-pansit
        13-pechay
        14-repolyo
        15-sambong
        16- tsaang gubat
        17-tuba
        18-uray
        19-yerba
         */
        switch (id){
            case R.drawable.ps_pic1:
                return "Bayabas";
            case R.drawable.ps_pic2:
                return "Atis";
            //case R.drawable.pic3: return "0005";
            case R.drawable.ps_pic3:
                return "Mangga";
            case R.drawable.ps_pic4:
                return "Oregano";
            case R.drawable.ps_pic5:
                return "Oregano";
            case R.drawable.ps_pic6:
                return "Pandan";
            //if there's a proper image, pls change it
        }
        return null;
    }
    public static String translateFeatureId(int id){
        switch (id){
            case ImageProcessing.FEATURE_GRAYSCALE:
                return "GS";
            case ImageProcessing.FEATURE_COLOR_BLOB:
                return "CB/BIN";
            case ImageProcessing.FEATURE_CANNY_EDGE:
                return "CE";
        }
        return null;
    }
    public static void makeToast(Context context, String title,int duration){
        Toast.makeText(context, title, duration).show();
    }
}
