package locations.gps.appmobile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import locations.gps.appmobile.domain.Location;

public class SQLDatabase
{
    private static final String TAG = SQLDatabase.class.getSimpleName();
    private LocationDatabase m_locationDatabase;

    public SQLDatabase(Context f_context) 
    {
        m_locationDatabase = new LocationDatabase(f_context);
    }

    public void createLocation(Location f_location)
    {
        ContentValues l_contentValues = new ContentValues();
        l_contentValues.put(LocationTable.COLUMN_NAME, f_location.getName());
        l_contentValues.put(LocationTable.COLUMN_DESCRIPTION, f_location.getDescription());
        l_contentValues.put(LocationTable.COLUMN_TYPE, f_location.getType());
        
        createLocation(m_locationDatabase.getWritableDatabase(), l_contentValues);
    }
    
    private void createLocation(SQLiteDatabase f_database, ContentValues f_contentValues)
    {
        f_database.insert(LocationTable.TABLE, null, f_contentValues);
    }

    public void deleteLocation(int f_ID)
    {
        deleteLocation(m_locationDatabase.getWritableDatabase(), f_ID);
    }

    private void deleteLocation(SQLiteDatabase f_database, int f_ID)
    {
        String l_deleteSelection = LocationTable._ID + " = ?";
        String[] l_deleteArguments = {Integer.toString(f_ID)};
        f_database.delete(LocationTable.TABLE, l_deleteSelection, l_deleteArguments);
    }

    public void updateLocation(Location f_location)
    {
        ContentValues l_contentValues = new ContentValues();
        l_contentValues.put(LocationTable.COLUMN_TYPE, f_location.getType());
        l_contentValues.put(LocationTable.COLUMN_DESCRIPTION, f_location.getDescription());
        l_contentValues.put(LocationTable.COLUMN_NAME, f_location.getName());

        updateLocation(m_locationDatabase.getWritableDatabase(), l_contentValues, f_location.getID());
    }

    private void updateLocation(SQLiteDatabase f_database, ContentValues f_contentValues, int f_ID)
    {
        String l_updateSelection = LocationTable._ID + " = ?";
        String[] l_updateArguments = {Integer.toString(f_ID)};

        f_database.update(LocationTable.TABLE, f_contentValues, l_updateSelection, l_updateArguments);
    }
    
    public List<Location> getLocations()
    {
        String[] l_projections =
                {
                        LocationTable._ID,
                        LocationTable.COLUMN_NAME,
                        LocationTable.COLUMN_TYPE,
                        LocationTable.COLUMN_DESCRIPTION
                };

        List<Location> l_locations = new ArrayList<>();

        try (Cursor l_cursor = m_locationDatabase.getReadableDatabase().query(
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
}
