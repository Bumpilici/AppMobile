package locations.gps.appmobile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LocationDatabase extends SQLiteOpenHelper
{
    public static final int DATABSE_VERSION = 3;
    public static final String DATABASE_NAME = "Location.db";
    private static final String TAG = LocationDatabase.class.getSimpleName();
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEPARATOR = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + LocationTable.TABLE + " (" +
                    LocationTable._ID + " INTEGER PRIMARY KEY," +
                    LocationTable.COLUMN_NAME + TEXT_TYPE + COMMA_SEPARATOR +
                    LocationTable.COLUMN_TYPE + TEXT_TYPE + COMMA_SEPARATOR +
                    LocationTable.COLUMN_DESCRIPTION + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + LocationTable.TABLE;

    public LocationDatabase(Context f_context)
    {
        super(f_context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase f_database)
    {
        f_database.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase f_database,
                         int f_oldVersion,
                         int f_newVersion)
    {
        f_database.execSQL(SQL_DELETE_ENTRIES);
        onCreate(f_database);
        Log.v(TAG, "onUpgrade");
    }

    @Override
    public void onDowngrade(SQLiteDatabase f_database,
                            int f_oldVersion,
                            int f_newVersion)
    {
        onUpgrade(f_database, f_oldVersion, f_newVersion);
        Log.v(TAG, "onDowngrade");
    }
}
