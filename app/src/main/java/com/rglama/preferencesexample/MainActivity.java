package com.rglama.preferencesexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    String tag="tagger";
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onPause() {

        edit= (EditText) findViewById(R.id.textView);


        super.onPause();
        Context context= this;
        SharedPreferences sharedPref= context.getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putInt(getString(R.string.level),0);
        editor.commit();
    //bob saved here
        SharedPreferences.Editor stringeditor= sharedPref.edit();
        editor.putString(getString(R.string.preference_file_name),edit.getText().toString());
        editor.commit();

    }


    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharePref= this.getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE);

        try {
            sharePref.contains(getString(R.string.level));
            Log.d(tag, "its here");
            int level=sharePref.getInt(getString(R.string.level),0);
            Log.d(tag,"level" +level);
        }
        catch (Exception e){
            Log.d(tag,e.toString());
        }


        //get a edit text
        try{
        sharePref.contains(getString(R.string.preference_file_name));
            Log.d(tag,"File found");
            String name= sharePref.getString(getString(R.string.preference_file_name),"not found");
            Log.d(tag,name);


        }catch (Exception e){
           Log.d(tag,e.toString());

        }


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
