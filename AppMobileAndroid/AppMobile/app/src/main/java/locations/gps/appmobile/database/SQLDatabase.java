package locations.gps.appmobile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import locations.gps.appmobile.domain.Location;

public class SQLDatabase
{
    private static final String TAG = SQLDatabase.class.getSimpleName();

    public SQLDatabase()
    {
    }

    public List<Location> demo(Context f_context)
    {
        LocationDatabase l_locationDatabase = new LocationDatabase(f_context);

        deleteEntry(l_locationDatabase.getWritableDatabase());

        return retreiveEntries(l_locationDatabase.getReadableDatabase());
    }

    private void createEntry(SQLiteDatabase f_database)
    {
        ContentValues l_contentValues = new ContentValues();
        l_contentValues.put(LocationTable.COLUMN_NAME, "Farmacia catena");
        l_contentValues.put(LocationTable.COLUMN_DESCRIPTION, "Farmacie nonstop.");
        l_contentValues.put(LocationTable.COLUMN_TYPE, "farmacie");

        f_database.insert(LocationTable.TABLE, null, l_contentValues);
    }

    private void deleteEntry(SQLiteDatabase f_database)
    {
        String l_deleteSelection = LocationTable.COLUMN_NAME + " = ?";
        String[] l_deleteArguments = {"Farmacia catena"};
        f_database.delete(LocationTable.TABLE, l_deleteSelection, l_deleteArguments);
    }

    private List<Location> retreiveEntries(SQLiteDatabase f_database)
    {
        String[] l_projections =
                {
                        LocationTable._ID,
                        LocationTable.COLUMN_NAME,
                        LocationTable.COLUMN_TYPE,
                        LocationTable.COLUMN_DESCRIPTION
                };

        String l_selection = LocationTable.COLUMN_NAME + " = ?";
        String[] l_selectionAguments = {"Farmacia catena"};

        List<Location> l_locations = new ArrayList<>();

        try (Cursor l_cursor = f_database.query(
                LocationTable.TABLE,
                l_projections,
                null,
                null,
                null,
                null,
                null
        ))
        {
            if (l_cursor.moveToFirst())
            {
                do
                {
                    long l_ID = l_cursor.getLong(l_cursor.getColumnIndex(LocationTable._ID));
                    String l_name = l_cursor.getString(l_cursor.getColumnIndex(LocationTable.COLUMN_NAME));
                    String l_type = l_cursor.getString(l_cursor.getColumnIndex(LocationTable.COLUMN_TYPE));
                    String l_description = l_cursor.getString(l_cursor.getColumnIndex(LocationTable.COLUMN_DESCRIPTION));
                    l_locations.add(new Location((int)l_ID, l_type, l_name, l_description, 0, 0));
                }
                while (l_cursor.moveToNext());
            }
        }

        return l_locations;
    }

    private void deleteDatabase(SQLiteDatabase f_database)
    {
        f_database.execSQL("DROP TABLE IF EXISTS location.db");
    }
}
