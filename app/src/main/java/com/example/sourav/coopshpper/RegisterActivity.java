package com.example.sourav.coopshpper;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class RegisterActivity extends Activity{
    ActionBar action;
    Button signin_submit;
    boolean registered;
    String TAG = "SOURAV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        registered = getIntent().getBooleanExtra("registered", false);
        action = getActionBar();
        if(!registered) {
            setContentView(R.layout.register_page);
            if(action != null)
                action.setTitle("Register");
        }
        else {
            setContentView(R.layout.signin_page);
            signin_submit = (Button) findViewById(R.id.save);
            if(action != null)
                action.setTitle("Sign In");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(registered) {
            /* Sign in Page */
            signin_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "Submit email and password");
                }
            });
        }
    }
}
