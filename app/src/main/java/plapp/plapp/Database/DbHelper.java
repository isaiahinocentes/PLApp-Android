package plapp.plapp.Database;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Created by uCare on 27 Jan 2017.
 */
public class DbHelper extends SQLiteOpenHelper {




    //private DatabaseHelper mDbHelper;
    private String categId;
    private SQLiteDatabase mDb, read;
    ArrayList<String> newString = new ArrayList<>();
    //private final Context mCtx;
    private static final String DATABASE_NAME = "leaves_info.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY1="create table "+
            Contract.LeafEntries.TABLE_NAME1+ "("+Contract.LeafEntries.ID1+" text,"+
            Contract.LeafEntries.IMG1+" blob,"+
            Contract.LeafEntries.LNAME1+" text,"+
            Contract.LeafEntries.SNAME1+" text,"+
            Contract.LeafEntries.LOCATION1+" text,"+
            Contract.LeafEntries.USES1+" text,"+
            Contract.LeafEntries.CHARACTERISTICS1+" text,"+
            Contract.LeafEntries.SIMILAR1+" text,"+
            Contract.LeafEntries.HOWTOUSE1+" text,"+
            Contract.LeafEntries.CATEGORIES1+" );";



//    private static class DatabaseHelper extends SQLiteOpenHelper {
        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            Log.d("Database operations", "Database Created...");
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_QUERY1);
            Log.d("Database operations", "Table Created...");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Contract.LeafEntries.TABLE_NAME1);
            onCreate(db);
        }




    public boolean checkTable(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " +Contract.LeafEntries.TABLE_NAME1, null);

        if(cursor != null){
            cursor.moveToFirst();
            int count = cursor.getInt(0);
            if(count > 0){
                return true;
            }cursor.close();
        }

        return false;
    }
    public void insertLeaf(DataProvider dataprov) {

        ContentValues cv = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        cv.put(Contract.LeafEntries.ID1, dataprov.getLeaf_Id());
        cv.put(Contract.LeafEntries.IMG1, Utility.getBytes(dataprov.getLeaf_image()));
        cv.put(Contract.LeafEntries.LNAME1, dataprov.getLocal_name());
        cv.put(Contract.LeafEntries.SNAME1, dataprov.getScientific_name());
        cv.put(Contract.LeafEntries.LOCATION1, dataprov.getPlant_location());
        cv.put(Contract.LeafEntries.USES1, dataprov.getLeaf_use());
        cv.put(Contract.LeafEntries.CHARACTERISTICS1, dataprov.getLeaf_characteristics());
        cv.put(Contract.LeafEntries.SIMILAR1, dataprov.getLeaf_similarity());
        cv.put(Contract.LeafEntries.HOWTOUSE1, dataprov.getHow_to());
        cv.put(Contract.LeafEntries.CATEGORIES1, dataprov.getCategory());
        db.insert(Contract.LeafEntries.TABLE_NAME1, null, cv);
        Log.d("Database operations", "Information inserted");

    }



    public void deleteRow(){
        SQLiteDatabase db = this.getWritableDatabase();
        //return db.delete(Contract.LeafEntries.TABLE_NAME1, Contract.LeafEntries.ID1+"="+id,null)>0;
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0001'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0002'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0003'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0004'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0005'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0006'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0007'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0008'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0009'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0010'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0011'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0012'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0013'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0014'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0015'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0016'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0017'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0018'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0019'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0020'");
        db.execSQL("DELETE FROM plant_infoo WHERE leafID = '0021'");


        Log.d("Database operations", "Information deleted!!!!!!!!!!");

    }


    public DataProvider getleaves() throws SQLException {


        Cursor cursor = mDb.query(true, Contract.LeafEntries.TABLE_NAME1, new String[] { Contract.LeafEntries.ID1,
                Contract.LeafEntries.IMG1, Contract.LeafEntries.LNAME1, Contract.LeafEntries.SNAME1, Contract.LeafEntries.LOCATION1, Contract.LeafEntries.CHARACTERISTICS1, Contract.LeafEntries.USES1,
                Contract.LeafEntries.HOWTOUSE1, Contract.LeafEntries.SIMILAR1,Contract.LeafEntries.CATEGORIES1}, null, null, null, null, null, null);

        String leafid, leaflocal, leafscientific, leaflocation, leafuses, leafcharac, leafhow, leafcateg, leafsimilar;
        byte[] leafimg;
        if (cursor.moveToFirst()) {

            leafid = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.ID1));
            leafimg = cursor.getBlob(cursor.getColumnIndex(Contract.LeafEntries.IMG1));
            leaflocal = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.LNAME1));
            leafscientific = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.SNAME1));
            leaflocation = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.LOCATION1));
            leafuses = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.USES1));
            leafcharac = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.CHARACTERISTICS1));
            leafhow = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.HOWTOUSE1));
            leafsimilar = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.SIMILAR1));
            leafcateg = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.CATEGORIES1));

            cursor.close();
            return new DataProvider(leafid, Utility.getPhoto(leafimg), leaflocal, leafscientific, leaflocation, leafuses, leafcharac, leafhow, leafcateg, leafsimilar);
        }
        cursor.close();
        return null;
    }


    public Cursor getInformations(SQLiteDatabase db){
        String[] projections={Contract.LeafEntries.ID1,
                Contract.LeafEntries.IMG1, Contract.LeafEntries.LNAME1,
                Contract.LeafEntries.SNAME1,
                Contract.LeafEntries.LOCATION1,
                Contract.LeafEntries.CHARACTERISTICS1,
                Contract.LeafEntries.USES1,
                Contract.LeafEntries.HOWTOUSE1,
                Contract.LeafEntries.SIMILAR1,
                Contract.LeafEntries.CATEGORIES1};
        Cursor cursor = db.query(true,Contract.LeafEntries.TABLE_NAME1,projections, null,null,null,null,null,null);



        return cursor;
    }

    public String getScientific(String id){
        String scienceName;
        String query = "SELECT "+ Contract.LeafEntries.SNAME1 + " FROM " + Contract.LeafEntries.TABLE_NAME1 + " where leafID='"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        scienceName=cursor.getString(cursor.getColumnIndex("scientificName"));

        return scienceName;
    }

    public ArrayList<String> splitHowTos(String howto){



        StringTokenizer tokenizer = new StringTokenizer(howto,";");
        while (tokenizer.hasMoreTokens()){
            newString.add(tokenizer.nextToken());
        }

        return newString;

    }

    public String getHowToUse(String id){
        String howto;
        ArrayList<String> list= new ArrayList<>();
        String query = "SELECT "+ Contract.LeafEntries.HOWTOUSE1 + " FROM " + Contract.LeafEntries.TABLE_NAME1 + " where leafID='"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        howto=cursor.getString(cursor.getColumnIndex("howToUse"));


        return howto;
    }

    public String getLocation(String id){
        String locationName;
        String query = "SELECT "+ Contract.LeafEntries.LOCATION1 + " FROM " + Contract.LeafEntries.TABLE_NAME1 + " where leafID='"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        locationName=cursor.getString(cursor.getColumnIndex("location_"));

        return locationName;
    }
    public String getCharacteristics(String id){
        String locationName;
        String query = "SELECT "+ Contract.LeafEntries.CHARACTERISTICS1 + " FROM " + Contract.LeafEntries.TABLE_NAME1 + " where leafID='"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        locationName=cursor.getString(cursor.getColumnIndex("characteristicss"));

        return locationName;
    }
    public Bitmap getImage(String id){
        byte[] leafimg;
        String query = "SELECT "+ Contract.LeafEntries.IMG1 + " FROM " + Contract.LeafEntries.TABLE_NAME1 + " where leafID='"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        leafimg=cursor.getBlob(cursor.getColumnIndex(Contract.LeafEntries.IMG1));
        return Utility.getPhoto(leafimg);
    }
    public String getUses(String id){
        String uses;
        String query = "SELECT "+ Contract.LeafEntries.USES1 + " FROM " + Contract.LeafEntries.TABLE_NAME1 + " where leafID='"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        uses=cursor.getString(cursor.getColumnIndex("leafUse"));

        return uses;
    }

    public String getCatgories(String categorr){

        String categ;

        //rdb where name like '% LIM %' OR name like "LIM %" OR name like "% LIM" OR name like "LIM"
        String query = "SELECT "+ Contract.LeafEntries.ID1 + " FROM " +
                Contract.LeafEntries.TABLE_NAME1 + " where "+Contract.LeafEntries.CATEGORIES1+" like '%"+categorr+"%' or "
                +Contract.LeafEntries.CATEGORIES1+" like '% "+categorr+"' or "+Contract.LeafEntries.CATEGORIES1+" like '"+categorr+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            categ=cursor.getString(cursor.getColumnIndex("leafID"));
            categId= categ;
        }else {
            categId="nada";
        }

        /*if(cursor.getString(cursor.getColumnIndex("leafID")).equals(null)){

            categId = "nada";
        }else {
            categId = cursor.getString(cursor.getColumnIndex("leafID"));
        }*/

        return categId;
    }
    public String getName(String id){
        String local;
        String query = "SELECT "+ Contract.LeafEntries.LNAME1 + " FROM " + Contract.LeafEntries.TABLE_NAME1 + " where leafID='"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        local=cursor.getString(cursor.getColumnIndex("localName"));

        return local;

        /*String query = "SELECT " local_name FROM plant_info where local_name = '"+id+"'";
         SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        local=cursor.getString(cursor.getColumnIndex("local_name"));
        cursor.close();
        db.close();
        return local;
         */
    }


    public void insertandGetData(){
        String data;
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "INSERT INTO "+Contract.LeafEntries.TABLE_NAME1 +" (leafUse) VALUES ('pls') where leafID='0001'";
        db.execSQL(insertQuery);
        Log.d("insert","he");


    }


}
