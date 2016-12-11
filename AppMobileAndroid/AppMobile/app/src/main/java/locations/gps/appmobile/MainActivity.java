package locations.gps.appmobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import locations.gps.appmobile.database.SQLDatabase;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void openLocation(View view)
    {
        Intent l_openLocationActivity=new Intent(this, OpenLocationActivity.class);
        startActivity(l_openLocationActivity);
    }
}