package plapp.plapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import viralandroid.com.androiduserinterfacetutorial.R;

public class MainActivity extends AppCompatActivity{

    private static final int IMAGE_CAPTURE = 100;
    private static final int IMAGE_SELECT = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Camera(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, IMAGE_CAPTURE);
        //if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
          //  startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        //}
    }

    public void Gallery(View v){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Leaf Picture"),IMAGE_SELECT);

        //Intent intent = new Intent(this, Main_Gallery.class);
        //startActivity(intent);
    }


    /////////////////////////////
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bmp;
        Intent intent = new Intent(this, PictureSearch.class);
        //If result ok and Request code is Image Capture
        if (resultCode == RESULT_OK && requestCode == IMAGE_CAPTURE) {
            //Get data
            Bundle extras = data.getExtras();

            //RESCALE BITMAP to 1200x1600
            bmp = Bitmap.createScaledBitmap((Bitmap)extras.get("data"), 1200, 1600, true);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, stream);
                        Log.i("PLAPP_MA_BITMAP SIZE",bmp.getWidth()+" x "+bmp.getHeight());
            byte[] byteArray = stream.toByteArray();

            //intent.putExtra("file_path",new String());
            intent.putExtra("picture", byteArray);
            intent.putExtra("gallery", false);

            Log.i("PLAPP_MA_Succes","Going to next Intent");
            startActivity(intent);

        //If result of and Request Code is Request Image from Gallery
        } else if(resultCode == RESULT_OK  && requestCode == IMAGE_SELECT){
            //Get URL
            Uri selectedImageUri = data.getData();
            String file_path = getRealPathFromURI(selectedImageUri);
            int width; int height;
            //Get image from gallery > set to Bitmap
            try {
                //RESCALE BITMAP TO 1200x1600
                width = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri).getWidth();
                height = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri).getHeight();
                Log.i("PLAPP_MA_BITMAP SIZE",width+" x "+height);
                //bmp = Bitmap.createScaledBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri), 1200, 1600, true);

                //Save image to SD\plapp\img
                //Log.i("PLAPP_MA_NEW BITMAP SIZE",bmp.getWidth()+" x "+bmp.getHeight());
                //AppFunctions.saveImage(bmp, "Chosen_Img", "img");
                Log.i("PLAPP_MA_PICTURE PATH",file_path);

            } catch (IOException e) {
                Log.e("PLAPP_MA_ERROR", e.getMessage());
                e.printStackTrace();
            }

            intent.putExtra("file_path", file_path);
            intent.putExtra("gallery",true);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Operation Cancelled", Toast.LENGTH_LONG).show();
        }
    }

    public String getRealPathFromURI(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public void ManualSearch(View v){
        startActivity(new Intent(this, ManualSearching.class));
    }
}
