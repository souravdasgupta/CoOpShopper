package com.example.sourav.coopshpper;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    boolean isUserSignedin = false;
    Button signIn, register ;
    String TAG = "SOURAV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(isUserSignedin) {
            /* If user is signed in already, directly go to his homepage */
        } else {
            setContentView(R.layout.activity_main);
            signIn = (Button) findViewById(R.id.sign);
            register = (Button) findViewById(R.id.register);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!isUserSignedin) {
            signIn.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View view) {
                    Log.d("TAG", "Sign in button clicked" );
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    intent.putExtra("registered",true);
                    startActivity(intent);
                 }
             });

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TAG", "Register button clicked");
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    intent.putExtra("registered",false);
                    startActivity(intent);
                }
            });
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
