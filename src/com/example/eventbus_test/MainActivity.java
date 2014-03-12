package com.example.eventbus_test;

import de.greenrobot.event.EventBus;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listView1;
	ArrayAdapter<String> x;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EventBus.getDefault().register(this);
		
		Proxy.progress = ProgressDialog.show(this, "Waiting 3 seconds before adding item",
			    "dialog message", true);
		
		
		listView1 = (ListView)findViewById(R.id.listView1);
		x = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Proxy.items);
		listView1.setAdapter(x);
		Proxy.load();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onEvent(AlphaListUpdateEvent event){ 
		Log.d("event", "list has been updated");
		x.notifyDataSetChanged();
	}

}
