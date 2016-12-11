package locations.gps.appmobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import locations.gps.appmobile.database.SQLDatabase;
import locations.gps.appmobile.domain.Location;

public class SubmitFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_form_activity);
    }

    public void sendRequest(View view)
    {
        EditText l_editTextLocationName=(EditText)findViewById(R.id.editTextLocationName);
        String l_locationName=l_editTextLocationName.getText().toString();

        EditText l_editTextDescription=(EditText)findViewById(R.id.editTextDescription);
        String l_description=l_editTextDescription.getText().toString();

        String l_subjectEmail = "New location request";
        String l_bodyEmail = "";

        l_bodyEmail += "Location name: " + l_locationName;
        l_bodyEmail += "\n";
        l_bodyEmail += "Description: " + l_description;

        String l_toEmail = "foloba.anca@gmail.com";

        Intent l_email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", l_toEmail, null
        ));
        l_email.putExtra(Intent.EXTRA_SUBJECT, l_subjectEmail);
        l_email.putExtra(Intent.EXTRA_TEXT, l_bodyEmail);

        SQLDatabase l_sqlDatabase = new SQLDatabase(this);
        l_sqlDatabase.createLocation(new Location("Pharmacy", "Farmacia CATENA", "Farmacie nonstop", 0, 0));

        startActivity(l_email);
        finish();

        Intent l_locationIntent = new Intent(this, OpenLocationActivity.class);
        startActivity(l_locationIntent);
    }
}
