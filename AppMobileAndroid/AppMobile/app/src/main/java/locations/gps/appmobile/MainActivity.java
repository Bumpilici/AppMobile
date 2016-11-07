package locations.gps.appmobile;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void sendRequest(View view)
    {
        EditText l_editTextLocationName=(EditText)findViewById(R.id.editTextLocationName);
        String l_locationName=l_editTextLocationName.getText().toString();

        Log.w("myTag", l_locationName);

        AlertDialog l_alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        l_alertDialog.setTitle("Submit");
        l_alertDialog.setMessage("Request submitted!");
        l_alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface f_dialog, int f_which)
                    {
                        f_dialog.dismiss();

                        finish();
                        startActivity(getIntent());
                    }
                });
        l_alertDialog.show();

        String l_subjectEmail = "New location request";
        String l_bodyEmail = "";
    }
}