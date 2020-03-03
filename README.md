Yellow Messenger WebView SDK
=======================

### Configuration


App level gradle file
```gradle
allprojects {
    repositories {
        jcenter()
        // Add these two lines 
        maven { url "https://jitpack.io" }
        maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
    }
}

...
...
...

dependencies {
    ...
    ...
	   implementation 'com.github.yellowmessenger:webviewsdk:0.0.6'


}
```
Android Application class Example
```java
import com.example.ymwebview.BotEventListener;
import com.example.ymwebview.YMBotPlugin;
import com.example.ymwebview.models.BotEventsModel;

public class MainActivity extends AppCompatActivity {
    
    @Override
    public void onCreate() {
        super.onCreate();
        //Configuration data
        String configData = "{" +
            "\"botName\": \"Bot-Name\"," +
            "\"botID\": \"<REPLACE-WITH-BOT-ID>\"," +
	        "\"enableHistory\": \"<true/false>\"" +
            "}";
        //Payload attributes
        HashMap<String, Object> payloadData = new HashMap<>();
        //Important
        payloadData.put("platform","Android-App");
     
        //You can add other payload attributes in the same format.
        
        //Initialize the bot
        YMBotPlugin pluginYM =  YMBotPlugin.getInstance();
        pluginYM.init(configData, new BotEventListener() {
            @Override
            public void onSuccess(BotEventsModel botEvent) {
                Log.d("EventListener", "Event Recieved: "+ botEvent.getCode());
                switch (botEvent.getCode()){
                    case "even-name-1" : break;
                    case "even-name-2" : break;
                    case "even-name-3" : break;
                }
            }

            @Override
            public void onFailure(String error) {
            }
        });
        //Send Payload Data
        pluginYM.setPayload(this, payloadData);
        
        //To start chabot call the pluginYm.startChatBot() method.
         FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
           //Starting the bot activity
           pluginYM.startChatBot();
        });
    }
    

}
```


