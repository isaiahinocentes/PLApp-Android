package plapp.plapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.util.Log;


import java.io.ByteArrayOutputStream;
import java.sql.SQLData;
import java.sql.SQLException;


/**
 * Created by uCare on 27 Dec 2016.
 */
public class DBOperations extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="product_info.db";
    private static final String CREATE_QUERY="create table "+ Contract.LeafEntries.TABLE_NAME+
            "("+Contract.LeafEntries.ID+" text,"+
            Contract.LeafEntries.IMG+" blob,"+
            Contract.LeafEntries.LNAME+" text,"+
            Contract.LeafEntries.SNAME+" text,"+
            Contract.LeafEntries.LOCATION+" text,"+
            Contract.LeafEntries.USES+" text,"+
            Contract.LeafEntries.CHARACTERISTICS+" text,"+
            Contract.LeafEntries.SIMILAR+" text,"+
            Contract.LeafEntries.HOWTOUSE+" text,"+
            Contract.LeafEntries.CATEGORIES+" );";
    private static final String alter = "alter table "+ Contract.LeafEntries.TABLE_NAME+
            " add column "+Contract.LeafEntries.IMG+ " blob";
    private android.database.sqlite.SQLiteDatabase db;

    private DBOperations mDbHelper;
    private SQLiteDatabase mDb;

    public DBOperations(Context ctx){
        super(ctx, DB_NAME, null,DB_VERSION);
         Log.d("Database operations", "Database Created...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table Created...");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion, int newVersion) {
        // If you need to add a column
        if (newVersion > oldVersion) {
            sqLiteDatabase.execSQL(alter);
        }
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.LeafEntries.TABLE_NAME);
    }

    public String getData(String id){
        String local, scien, charac, location;
        String query = "SELECT local_name FROM plant_info where local_name = '"+id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        local=cursor.getString(cursor.getColumnIndex("local_name"));
        cursor.close();
        db.close();
        return local;
    }


    public void addEntry (String id, String local, Bitmap image, String scientific, String location, String uses, String charac, String howto, String similar, String category){
        ContentValues contentValues = new ContentValues();

        SQLiteDatabase db = this.getWritableDatabase();
        contentValues.put(Contract.LeafEntries.ID, id);
        contentValues.put(Contract.LeafEntries.IMG, Utility.getBytes(image));
        contentValues.put(Contract.LeafEntries.LNAME, local);
        contentValues.put(Contract.LeafEntries.SNAME, scientific);
        contentValues.put(Contract.LeafEntries.LOCATION, scientific);
        contentValues.put(Contract.LeafEntries.USES, uses);
        contentValues.put(Contract.LeafEntries.CHARACTERISTICS, charac);
        contentValues.put(Contract.LeafEntries.SIMILAR, howto);
        contentValues.put(Contract.LeafEntries.HOWTOUSE, similar);
        contentValues.put(Contract.LeafEntries.CATEGORIES, category);


        db.insert(Contract.LeafEntries.TABLE_NAME,null,contentValues);
        Log.d("Database operations", "Information inserted");

    }

    public void dropTable(){
        db.execSQL("DROP TABLE "+Contract.LeafEntries.TABLE_NAME+" _old");
        Log.d("Dbase oper", "dropped");
    }

    public String addcol(){
        db.execSQL(alter);
        return "added column";

    }
    public void insertEntry(DataProvider dataprov){
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        cv.put(Contract.LeafEntries.ID, dataprov.getLeaf_Id());
        cv.put(Contract.LeafEntries.IMG, Utility.getBytes(dataprov.getLeaf_image()));
        cv.put(Contract.LeafEntries.LNAME, dataprov.getLocal_name());
        cv.put(Contract.LeafEntries.SNAME, dataprov.getScientific_name());
        cv.put(Contract.LeafEntries.LOCATION, dataprov.getPlant_location());
        cv.put(Contract.LeafEntries.USES, dataprov.getLeaf_use());
        cv.put(Contract.LeafEntries.CHARACTERISTICS, dataprov.getLeaf_characteristics());
        cv.put(Contract.LeafEntries.SIMILAR, dataprov.getLeaf_similarity());
        cv.put(Contract.LeafEntries.HOWTOUSE, dataprov.getHow_to());
        cv.put(Contract.LeafEntries.CATEGORIES, dataprov.getCategory());
        db.insert(Contract.LeafEntries.TABLE_NAME,null,cv);
    }


    public Cursor getInformations(SQLiteDatabase db){
        String[] projections={Contract.LeafEntries.ID1,
                Contract.LeafEntries.IMG1,
                Contract.LeafEntries.LNAME1,
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



    public DataProvider retriveEmpDetails() throws SQLException {
        Cursor cursor = mDb.query(true, Contract.LeafEntries.TABLE_NAME, new String[] { Contract.LeafEntries.ID,

                Contract.LeafEntries.IMG,
                Contract.LeafEntries.LNAME,
                Contract.LeafEntries.SNAME,
                Contract.LeafEntries.LOCATION,
                Contract.LeafEntries.CHARACTERISTICS,
                Contract.LeafEntries.USES,
                Contract.LeafEntries.HOWTOUSE,
                Contract.LeafEntries.SIMILAR,
                Contract.LeafEntries.CATEGORIES}, null, null, null, null, null, null);
        String leafid, leaflocal, leafscientific, leaflocation, leafuses, leafcharac, leafhow, leafcateg, leafsimilar;
        byte[] leafimg;
        if (cursor.moveToFirst()) {
            leafid = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.ID));
            leafimg = cursor.getBlob(cursor.getColumnIndex(Contract.LeafEntries.IMG));
            leaflocal = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.LNAME));
            leafscientific = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.SNAME));
            leaflocation = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.LOCATION));
            leafuses = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.USES));
            leafcharac = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.CHARACTERISTICS));
            leafhow = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.HOWTOUSE));
            leafcateg = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.CATEGORIES));
            leafsimilar = cursor.getString(cursor.getColumnIndex(Contract.LeafEntries.SIMILAR));
            cursor.close();
            return new DataProvider(leafid, Utility.getPhoto(leafimg), leaflocal, leafscientific, leaflocation, leafuses, leafcharac, leafhow, leafcateg, leafsimilar);
        }
        cursor.close();
        return null;
    }




    public void Reset() {
        mDbHelper.onUpgrade(this.mDb, 1, 1);
    }

    public void close() {
        mDbHelper.close();
    }


}

/*
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBOperations extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME = "leaf_info.db";
    private static final String CREATE_QUERY =
            "create table "+ Contract.LeafEntries.TABLE_NAME+
                    "("+Contract.LeafEntries.ID+" INTEGER PRIMARY KEY,"+
                    Contract.LeafEntries.LNAME+" VARCHAR,"+
                    Contract.LeafEntries.SNAME+" VARCHAR,"+
                    Contract.LeafEntries.LOCATION+" VARCHAR,"+
                    Contract.LeafEntries.USES+" VARCHAR,"+
                    Contract.LeafEntries.CHARACTERISTICS+" VARCHAR,"+
                    Contract.LeafEntries.SIMILAR+" VARCHAR,"+
                    Contract.LeafEntries.HOWTOUSE+" VARCHAR,"+
                    Contract.LeafEntries.CATEGORIES+" )";



    DBOperations(Context ctx){
        super(ctx,DB_NAME,null,DB_VERSION);
        Log.d("Database operations", "Database created...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created...");

    }

    public void addEntry (SQLiteDatabase db, String id, String local, String scientific, String location, String uses, String charac, String howto, String similar, String category){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.LeafEntries.ID, id);
        contentValues.put(Contract.LeafEntries.LNAME, local);
        contentValues.put(Contract.LeafEntries.SNAME, scientific);
        contentValues.put(Contract.LeafEntries.LOCATION, scientific);
        contentValues.put(Contract.LeafEntries.USES, uses);
        contentValues.put(Contract.LeafEntries.CHARACTERISTICS, charac);
        contentValues.put(Contract.LeafEntries.SIMILAR, howto);
        contentValues.put(Contract.LeafEntries.HOWTOUSE, similar);
        contentValues.put(Contract.LeafEntries.CATEGORIES, category);


        db.insert(Contract.LeafEntries.TABLE_NAME,null,contentValues);
        Log.d("Database operations", "Information inserted");

    }

    public Cursor getInformation(SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {Contract.LeafEntries.ID, Contract.LeafEntries.CHARACTERISTICS,
                Contract.LeafEntries.LNAME,
                Contract.LeafEntries.SNAME,
                Contract.LeafEntries.LOCATION,
                Contract.LeafEntries.USES,
                Contract.LeafEntries.HOWTOUSE,
                Contract.LeafEntries.SIMILAR,
                Contract.LeafEntries.CATEGORIES,
                };

        cursor =db.query(Contract.LeafEntries.TABLE_NAME, projections,null,null,null,null,null);
        return cursor;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
*/