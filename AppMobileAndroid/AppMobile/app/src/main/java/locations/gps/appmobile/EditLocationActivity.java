package locations.gps.appmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import locations.gps.appmobile.database.SQLDatabase;
import locations.gps.appmobile.domain.Location;

public class EditLocationActivity extends AppCompatActivity
{
    static private int m_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_location);
    }

    public void update(View view)
    {
        Spinner l_spinnerLocationType = (Spinner)findViewById(R.id.spinnerLocationType);
        String l_locationType = l_spinnerLocationType.getSelectedItem().toString();

        EditText l_editTextLocationName = (EditText)findViewById(R.id.textLocationName);
        String l_locationName = l_editTextLocationName.getText().toString();

        EditText l_editTextLocationDescription = (EditText)findViewById(R.id.textDescription);
        String l_locationDescription = l_editTextLocationDescription.getText().toString();

        Location l_location = new Location(m_ID, l_locationType, l_locationName, l_locationDescription, 0, 0);
        SQLDatabase l_database = new SQLDatabase(this);

        l_database.updateLocation(l_location);
        finish();

        Intent l_locationIntent = new Intent(this, OpenLocationActivity.class);
        startActivity(l_locationIntent);
    }

    static public void setID(int f_ID)
    {
        m_ID = f_ID;
    }
}
