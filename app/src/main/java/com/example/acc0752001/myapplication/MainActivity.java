package com.example.acc0752001.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button sayhello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sayhello = (Button)findViewById(R.id.button);
        sayhello.setOnClickListener(Hello);

    }
    private static final int ACTIVITY_SET_NAME = 1;
    private View.OnClickListener Hello = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =new Intent();
            intent.setClass(MainActivity.this,doitActivity.class);
            startActivityForResult(intent,ACTIVITY_SET_NAME);

        }
    };

    protected  void omActivityResult(int requestCode, int resultCode, Intent intent){
        String name;
    Toast t;
        super.onActivityResult(requestCode, resultCode, intent);
        switch(requestCode){
            case ACTIVITY_SET_NAME:
                name = intent.getStringExtra("name");
                t =Toast.makeText(MainActivity.this, "Hello " + name, Toast.LENGTH_SHORT);
                t.show();
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
        if (id == R.id.action_settings) {
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Web) {
            Uri uri = Uri.parse("http://www.google.com");
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(uri);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }
}
