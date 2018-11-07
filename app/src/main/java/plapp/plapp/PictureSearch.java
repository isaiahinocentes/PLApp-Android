package plapp.plapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

import plapp.plapp.Database.DbHelper;
import plapp.plapp.Viewing.ViewLeaf;
import viralandroid.com.androiduserinterfacetutorial.R;

public class PictureSearch extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_search);
        startProcessThreads();
    }

    void FlowController(){
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //Start Processing Thread
        controller_process = new Thread(new Runnable() {
            @Override
            public void run() {
                startProcessThreads();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(mProgressStatus < 100){
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(mProgressStatus);
                                }
                            });
                        }
                    }
                }).run();
            }
        }); controller_process.start();
        controller_results = new Thread(new Runnable() {
            @Override
            public void run() {
                showSearchResults();
            }
        }); //controller_results.start();
        Log.i("PLAPP_PS_Controllers",
                "Proc: "+controller_process.isAlive()+" - " +
                        "Res: "+controller_results.isAlive());
    }

    //Get the image from previous intent and Start Image Processing and Compare threads
    void startProcessThreads(){
        //Initialize Bitmaps
        WorkingBitmap = Bitmap.createBitmap(1200, 1600, Bitmap.Config.ARGB_8888);
        bmp_org = Bitmap.createBitmap(1200, 1600, Bitmap.Config.ARGB_8888);

        //Get extras from previous intent
        Bundle extras = getIntent().getExtras();

        //If Gallery method is true
        if(extras.getBoolean("gallery")){
            try {
                //Get Filepath
                file_path = extras.getString("file_path");
                String file_path = extras.getString("file_path");
                Log.i("PLAPP_PS_GAL_FILEPATH",file_path);
                //Decode File using filepath
                WorkingBitmap = BitmapFactory.decodeFile(file_path);
                //Null Check
                Log.d("PLAPP_PS_GL_NULL CHECK", String.valueOf(WorkingBitmap));

                //To make sure if the Method Above didn't work
                if(String.valueOf(WorkingBitmap).equals(null)){
                    Uri selectedImageUri = Uri.parse(file_path);
                    Log.i("PLAPP_PS_GAL_IMAGE", String.valueOf(selectedImageUri));
                    WorkingBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImageUri);
                    if(String.valueOf(WorkingBitmap).equals(null)) {
                        Log.e("PLAPP_PS_GAL_Image Path", "Error on Image File");
                    }
                }
                //((ImageView)findViewById(R.id.imgRes1)).setImageBitmap(WorkingBitmap);
            } catch (Exception e) {
                Log.i("ERROR",e.getLocalizedMessage()+" "+e.getMessage()+" - ERROR ON URI");
//                if(e.getCause().equals(new NullPointerException()))
//                    Toast.makeText(this, "Image Address Errors", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        //Else, Picture search
        } else{
            byte[] byteArray = extras.getByteArray("picture");
            WorkingBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }

        try{
            bmp_org = WorkingBitmap.copy(Bitmap.Config.ARGB_8888, true); //creates an accessible bitmap
            Log.d("PLAPP_PS_NULL CHECK", String.valueOf(bmp_org));
            if(bmp_org.equals(null)){
                bmp_org = Bitmap.createBitmap(WorkingBitmap);
                Log.d("PLAPP_PS_NULL CHECK", String.valueOf(bmp_org));
            }
        } catch (NullPointerException e){
            Log.e("PLAPP_PS_NULL","Error on Picture Input");
        }

        //Compare all threads
        /*int first = R.drawable.pic1;
        int lasQ    12t = R.drawable.pic6;
        Thread process[] = new Thread[10];
        for(int i = first, pic_no = 1000, c = 0; i <= last; i++, pic_no++, c++){
            Bitmap bmp_src = BitmapFactory.decodeResource(getResources(), i);
            process[c] = new Thread(new Process(bmp_org, bmp_src, pic_no, FEATURE_GRAYSCALE, no_results+2));
            process[c].start();
        }*/

        //Process the Image input
        //new ImageProcessing(bmp_org, getResources(), ImageProcessing.max, "img").run();

        mProgressStatus = 30;
        //Empty ID and Score every input processing and comparing
            //ScoringSystem.ID.clear();
            //ScoringSystem.SCORE.clear();
        new ScoringSystem().ShowValues();

        //Get drawables 1-6 and compare input to them
        int first = R.drawable.ps_pic1;
        int last = R.drawable.ps_pic6;
        for (int pic_id = first; pic_id <= last; pic_id++){
            //if(pic_id == R.drawable.pic5)
                //continue;

                //Decode Drawable ID
            Bitmap bmp_base = BitmapFactory.decodeResource(getResources(), pic_id);
            //new ImageProcessing(bmp_base, getResources(), ImageProcessing.max, "db"+pic_id).run();
            //bmp_base = ImageProcessing.getSpecificFeature(bmp_base,ImageProcessing.FEATURE_GRAYSCALE);
            //imgComp = new ImageCompare(bmp_org, bmp_base, pic_id, ImageProcessing.FEATURE_GRAYSCALE);
            //imgComp.run();
            //imgComp = new ImageCompare(bmp_org, bmp_base, pic_id, ImageProcessing.FEATURE_COLOR_BLOB);
            //imgComp.run();

            //Add unique drawable IDs to ID
            ScoringSystem.ID.add(pic_id);

            //Start image comparison
            //Log.i("PLAPP_PS_Method",""+getIntent().getExtras().getBoolean("gallery"));
            if(getIntent().getExtras().getBoolean("gallery")){
                ImageCompare.doImageComparison(file_path,bmp_base, pic_id, ImageProcessing.FEATURE_COLOR_BLOB);
            } else {
                ImageCompare.doImageComparison(bmp_org, bmp_base, pic_id, ImageProcessing.FEATURE_COLOR_BLOB);
            }
            //ImageCompare.doImageComparison(bmp_org, bmp_base, pic_id, ImageProcessing.FEATURE_COLOR_BLOB);
//            imgComp = new ImageCompare(bmp_org, bmp_base, pic_id, ImageProcessing.FEATURE_CANNY_EDGE);
//            imgComp.run();
            mProgressStatus+=10;
        }
        mProgressStatus = 100;
        showSearchResults();
    }


    void showSearchResults() {

        try{
            while(controller_process.isAlive()){
                Log.i("PLAPP_PS_THREAD Check",controller_process.isAlive()+"");
            }
        } catch (Exception e){
            Log.e("PLAPP_ERR_PS", "Thread is null");
        }

        //int[][] results;// = ScoringSystem.getResults(3);
        int[][] results = new int[6][2];
        ScoringSystem.computeScore();
        for(int i = 0; i < ScoringSystem.ID.size(); i++){
            results[i][0] = ScoringSystem.ID.get(i);
            results[i][1] = ScoringSystem.SCORE.get(i);
        }

        //Set the Elements to Java
        for (int i = 0; i < 3; i++) {
            //Set UI variable connections
            final DbHelper dbHelper = new DbHelper(this);
            ImageView imgView = (ImageView) findViewById(r_id[i]);
            TextView nameView = (TextView) findViewById(r_names[i]);
            TextView characView = (TextView) findViewById(r_characs[i]);
            RelativeLayout rcView = (RelativeLayout) findViewById(r_relative[i]);
            TextView matchView = (TextView) findViewById(r_match[i]);

            //Set UI Results
            idMock = results[i][0]; //idMock is yung drawable image mo na original yung galing sa phone m
                Log.i("LEAF",AppFunctions.translateDrawableId(idMock));
            final String leaf_id = AppFunctions.translateId(idMock);
                Log.i("OUTPUT" + (i + 1), " results[" + i + "] = " + leaf_id + " = " + dbHelper.getName(leaf_id));
            imgView.setImageBitmap(dbHelper.getImage(leaf_id));
            Bitmap tmp = BitmapFactory.decodeResource(getResources(), idMock);
            tmp = Bitmap.createScaledBitmap(tmp, 250, 400, false);
            imgView.setImageBitmap(tmp);
            nameView.setText(dbHelper.getName(leaf_id));
            characView.setText(dbHelper.getCharacteristics(leaf_id));
            //matchView.setText(""+(results[i][1]));
            String txt = String.valueOf((1-ScoringSystem.binary_match.get(i))*100).substring(0,5) + "%";
            matchView.setText(txt); //0-1

            //SwitchCase put the ID to the next intent and add onClick Listener
            final Intent intent = new Intent(this, ViewLeaf.class);
            intent.putExtra("leafid", leaf_id);
            //final Intent intent = new Intent(this, PictureSearchResult.class);
            intent.putExtra("id", idMock);
            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.close();
                    startActivity(intent);
                }
            }); rcView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.close();
                    startActivity(intent);
                }
            }); nameView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.close();
                    startActivity(intent);
                }
            }); characView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.close();
                    startActivity(intent);
                }
            });
        } //End For Loop
        AppFunctions.showAlert(this,"Alert","The next 2 outputs are additional results");
    }

    //Arrays to point to XML UI Elements
    int r_id[] = { R.id.imgRes1, R.id.imgRes2, R.id.imgRes3 };
    int r_names[] = { R.id.txtRes1, R.id.txtRes2, R.id.txtRes3 };
    int r_characs[] = { R.id.charRes1, R.id.charRes2, R.id.charRes3 };
    int r_match[] = { R.id.matchRes1, R.id.matchRes2, R.id.matchRes3 };
    int r_relative[] = { R.id.rel1, R.id.rel2, R.id.rel3 };
    int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    private Bitmap WorkingBitmap;
    private Bitmap bmp_org;
    int idMock;
    private String file_path;

    Thread controller_process,
            controller_results;

    //OPENCV LOADER
    static{
        if(OpenCVLoader.initDebug())
            Log.d("MAINMENU","OpenCV 3.1.0 Successfully Loaded");
        else
            Log.d("MAINMENU","Failed to Load: OpenCV Library");
    }
    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i("OpenCV", "OpenCV loaded successfully");

                } break;
                default:
                {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };
}