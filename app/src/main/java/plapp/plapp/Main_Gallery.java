package plapp.plapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import viralandroid.com.androiduserinterfacetutorial.R;

public class Main_Gallery extends AppCompatActivity {

    Bitmap bmp;
    String file_path;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_gallery);
        intent = new Intent(this, PictureSearch.class);
    }

    //Start gallery Intent and put to view_leaf
    public void choosePicture(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Leaf Picture"),SELECT_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
//            Log.i("GALLERY","PICTURE CHOSEN");
//            Uri uri = data.getData();
//            try {
//                //Get image from gallery > set to Bitmap
//                bmp = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                //Save image to SD\plapp\img
//                ((ImageView)findViewById(R.id.view_leaf)).setImageBitmap(bmp); //Set to ImageView
//                bmp = scaleDownBitmap(bmp, 100, this);
//                AppFunctions.saveImage(bmp, "Chosen_Img", "img");
//            } catch (IOException e) {
//                e.printStackTrace();
//                Log.e("ERROR"," ON GALLERY IMAGE "+e.getMessage());
//            }
//        }
        if (resultCode == RESULT_OK) {
            Log.i("GALLERY","TRUE");
            try {
                Uri selectedImageUri = data.getData();
                file_path = getRealPathFromURI(selectedImageUri);
                AppFunctions.makeToast(this, "Chosen - \""+file_path+"\"", Toast.LENGTH_LONG);
                //Get image from gallery > set to Bitmap
                Log.i("BITMAP SIZE",MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri).getWidth()+" x "+MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri).getHeight());
                int width = 1200;
                int height = 1600;
                if(MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri).getWidth() < 1200){
                    width = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri).getWidth();
                } if(MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri).getHeight() < 1600){
                    height = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri).getHeight();
                }

                bmp = Bitmap.createScaledBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri),
                        width,
                        height,
                        true);
                Log.i("NEW BITMAP SIZE",bmp.getWidth()+" x "+bmp.getHeight());

                //Save image to SD\plapp\img
                ((ImageView)findViewById(R.id.view_leaf)).setImageBitmap(bmp); //Set to ImageView

                //bmp = scaleDownBitmap(bmp, 100, this);
                AppFunctions.saveImage(bmp, "Chosen_Img", "img");
                Log.i("PICTURE PATH",file_path);
                intent.putExtra("file_path", file_path);
                intent.putExtra("gallery",true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Choosing Picture - Cancelled", Toast.LENGTH_LONG).show();
        }
    }

    //Put to next intent and start searching
    public void imageSearch(View view){
        startActivity(intent);
    }

    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, Context context) {
        final float densityMultiplier = context.getResources().getDisplayMetrics().density;
        int height= (int) (newHeight*densityMultiplier);
        int width= (int) (height * photo.getWidth()/((double) photo.getHeight()));
        photo=Bitmap.createScaledBitmap(photo, width, height, true);
        return photo;
    }
    public String getRealPathFromURI(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    final static int SELECT_PICTURE = 1;
}
