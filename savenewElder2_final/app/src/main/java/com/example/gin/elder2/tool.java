package com.example.gin.elder2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class tool extends AppCompatActivity {

    int flag=0;
    String choice="1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = this.getIntent();
        choice = intent.getStringExtra("choice");

        ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);
        stub.setLayoutResource(R.layout.accessment);
        View inflated = stub.inflate();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("簡易心智量表");
        if(choice.equals("2")) {
            ImageView content = (ImageView) findViewById(R.id.imageView500);
            content.setImageResource(R.drawable.tool2);
            getSupportActionBar().setTitle("簡易心智狀態問卷");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_menu_send);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag++;
                flag%=3;
                if(choice.equals("1")){
                    ImageView content = (ImageView) findViewById(R.id.imageView500);
                    content.setImageResource(R.drawable.tool11);
                    if(flag==2) {
                        flag++;
                        content.setImageResource(R.drawable.tool12);
                    }
                } else {
                    ImageView content = (ImageView) findViewById(R.id.imageView500);
                    content.setImageResource(R.drawable.tool22);
                }


            }
        });










    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
