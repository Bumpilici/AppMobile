package locations.gps.appmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import locations.gps.appmobile.domain.Location;

public class OpenLocationActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_location_list);

        Location[] l_locations={
                new Location("Farmacie", "Farmacia CATENA", "Farmacie de cartier.", 0, 0),
                new Location("Farmacie", "Farmacia RICHTER", "Farmacie de cartier.", 0, 0),
                new Location("Supermarket", "Market", "Magazin de cartier.", 0, 0)
        };

        String[] l_locationsString=new String[3];
        for (int i=0;i<3;i++)
        {
            l_locationsString[i]=l_locations[i].toString();
        }

        ArrayAdapter l_adapter=new ArrayAdapter<String>(this,R.layout.location_list,l_locationsString);

        ListView l_listView=(ListView) findViewById(R.id.location_list);
        l_listView.setAdapter(l_adapter);
    }

    public void edit(View view)
    {
        Intent l_editIntent=new Intent(this, EditLocationActivity.class);
        startActivity(l_editIntent);
    }

    public void update(View view)
    {
        finish();
    }
}
