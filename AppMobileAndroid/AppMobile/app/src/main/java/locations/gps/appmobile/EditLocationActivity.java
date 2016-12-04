package locations.gps.appmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditLocationActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_location);
    }

    public void update(View view)
    {
        finish();
    }
}
