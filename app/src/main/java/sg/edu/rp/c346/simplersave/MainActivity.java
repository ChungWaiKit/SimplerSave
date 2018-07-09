package sg.edu.rp.c346.simplersave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // obtain an instance of sharedpreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // obtain an instance of the sharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
       // add the key-value pair
        prefEdit.putString("greetings", "Hello!");
        // call commit() method to save the changes into sharedpreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //obtain an instance of the sharedpreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString( "greetings", "no greeting!");
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}
