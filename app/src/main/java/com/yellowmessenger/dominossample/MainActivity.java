package com.yellowmessenger.dominossample;

import android.os.Bundle;

import com.example.ymwebview.BotEventListener;
import com.example.ymwebview.YMBotPlugin;
import com.example.ymwebview.models.BotEventsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String configData = "{" +
            "\"botName\": \"Dominos\"," +
            "\"botID\": \"x1572447766397\"" +
            "}";
    String configDataSandbox = "{" +
            "\"botName\": \"Dominos\"," +
            "\"botID\": \"x1569558732722\"" +
            "}";
    HashMap<String, Object> payloadData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        YMBotPlugin pluginYM =  YMBotPlugin.getInstance();
        pluginYM.init(this ,configDataSandbox, new BotEventListener() {

            @Override
            public void onSuccess(BotEventsModel botEvent) {
                Log.d("EventListener", "Event Recieved: "+ botEvent.getCode());
                switch (botEvent.getCode()){
                    case "test" : break;
                    case "track-order" : break;
                    case "combos-and-offers" :  break;
                    case "token-expire" : break;
                    case "login-user" : break;
                    case "stores-near-me" :  break;
                }
            }

            @Override
            public void onFailure(String error) {
            }
        });

        payloadData.put("Platform", "Android-App");
        pluginYM.setPayload(payloadData);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
           pluginYM.startChatBot();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

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