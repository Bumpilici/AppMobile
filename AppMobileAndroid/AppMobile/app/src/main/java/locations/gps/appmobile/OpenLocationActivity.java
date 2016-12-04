package locations.gps.appmobile;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import locations.gps.appmobile.database.SQLDatabase;
import locations.gps.appmobile.domain.Location;

public class OpenLocationActivity extends AppCompatActivity
{
    /*private Location[] l_locations = {
            new Location(0, "Farmacie", "Farmacia CATENA", "Farmacie de cartier.", 0, 0),
            new Location(1, "Farmacie", "Farmacia RICHTER", "Farmacie de cartier.", 0, 0),
            new Location(2, "Supermarket", "Market", "Magazin de cartier.", 0, 0)
    };*/

    private void createLayout()
    {
        LinearLayout l_linearLayout = (LinearLayout)findViewById(R.id.mainLocationList);
        List<LinearLayout> l_linearLayoutLocations = new ArrayList<>();
        List<Location> l_locations = new SQLDatabase().demo(this);

        for (int i=0;i<l_locations.size();i++)
        {
            l_linearLayoutLocations.add(new LinearLayout(this));
            l_linearLayoutLocations.get(l_linearLayoutLocations.size() - 1).setOrientation(LinearLayout.VERTICAL);
            l_linearLayoutLocations.get(l_linearLayoutLocations.size() - 1).setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            /*TextView l_idTextView = new TextView(this);
            l_idTextView.setEnabled(false);
            l_idTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            l_idTextView.setTextSize(20);
            l_idTextView.setText(Integer.toString(l_locations[i].getID()));
            l_linearLayoutLocations.get(l_linearLayoutLocations.size() - 1).addView(l_idTextView);*/

            EditText l_typeTextView = new EditText(this);
            l_typeTextView.setId(l_locations.get(i).getID());
            l_typeTextView.setEnabled(true);
            l_typeTextView.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            l_typeTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            l_typeTextView.setTextSize(20);
            l_typeTextView.setText(l_locations.get(i).getType());
            l_linearLayoutLocations.get(l_linearLayoutLocations.size() - 1).addView(l_typeTextView);

            EditText l_nameTextView = new EditText(this);
            l_nameTextView.setId(l_locations.get(i).getID());
            l_nameTextView.setEnabled(true);
            l_nameTextView.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            l_nameTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            l_nameTextView.setTextSize(20);
            l_nameTextView.setText(l_locations.get(i).getName());
            l_linearLayoutLocations.get(l_linearLayoutLocations.size() - 1).addView(l_nameTextView);

            EditText l_descriptionTextView = new EditText(this);
            l_descriptionTextView.setId(l_locations.get(i).getID());
            l_descriptionTextView.setEnabled(true);
            l_descriptionTextView.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            l_descriptionTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            l_descriptionTextView.setTextSize(20);
            l_descriptionTextView.setText(l_locations.get(i).getDescription());
            l_linearLayoutLocations.get(l_linearLayoutLocations.size() - 1).addView(l_descriptionTextView);

            LinearLayout l_buttonLinearLayout = new LinearLayout(this);
            l_buttonLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            l_buttonLinearLayout.setOrientation(LinearLayout.VERTICAL);
            l_buttonLinearLayout.setGravity(Gravity.CENTER);
            Button l_editButton = new Button(this);
            l_editButton.setId(l_locations.get(i).getID());
            l_editButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            l_editButton.setText("EDIT");
            l_editButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    edit(v);
                }
            });
            l_buttonLinearLayout.addView(l_editButton);
            l_linearLayoutLocations.get(l_linearLayoutLocations.size() - 1).addView(l_buttonLinearLayout);

            l_linearLayout.addView(l_linearLayoutLocations.get(l_linearLayoutLocations.size() - 1));
        }
    }

    public void setLocation(int f_ID, Location f_location)
    {
        List<Location> l_locations = new SQLDatabase().demo(this);
        for (Location l_location: l_locations)
        {
            if(l_location.getID()==f_ID)
            {
                l_location.setName(f_location.getName());
                l_location.setType(f_location.getType());
                l_location.setDescription(f_location.getDescription());

                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_location_list);

        createLayout();
    }

    public void edit(View v)
    {
        int l_ID=v.getId();

        Location l_location;

        //Intent l_editIntent=new Intent(this, EditLocationActivity.class);
        //startActivity(l_editIntent);
    }

    public void update(View view)
    {
        finish();
    }
}
