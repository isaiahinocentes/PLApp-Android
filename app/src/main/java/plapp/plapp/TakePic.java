package plapp.plapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by uCare on 19 Oct 2016.
 */
public class TakePic extends AppCompatActivity{

    static final int REQUEST_IMAGE_CAPTURE = 1,SELECT_PICTURE = 1,PICK_IMAGE_REQUEST = 1;
    static boolean hasPicture = false;
    static String method = null;

    Bitmap taken;
    ImageView chosen;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    protected void takePic(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            hasPicture = true;
            method = "pic";
            //
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}
