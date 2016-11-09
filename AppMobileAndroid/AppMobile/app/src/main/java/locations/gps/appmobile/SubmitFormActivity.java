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

        try
        {
            startActivity(l_email);
            AlertDialog l_alertDialog = new AlertDialog.Builder(SubmitFormActivity.this).create();
            l_alertDialog.setTitle("Submit");
            l_alertDialog.setMessage("Request submitted!");
            l_alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface f_dialog, int f_which)
                        {
                            f_dialog.dismiss();

                            finish();
                        }
                    });
            l_alertDialog.show();
        }
        catch (android.content.ActivityNotFoundException f_exception)
        {
            Toast.makeText(SubmitFormActivity.this, "The email is invalid!", Toast.LENGTH_SHORT).show();
        }
    }
}
