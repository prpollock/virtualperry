package com.mysticplanet.virtualperry;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;


//public class MainActivity extends Activity {
public class MainActivity extends ActionBase{	

	private static final String TAG = "iSpeech SDK Sample";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_context = this.getApplicationContext();
		setContentView(R.layout.activity_main);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		PreferenceManager.setDefaultValues(this, R.xml.preference, false);
		
		/**		findViewById(R.id.tts).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent myIntent = new Intent(_context, com.mysticplanet.virtualperry.TTSActivity.class);
				startActivity(myIntent);
			}
		});


		findViewById(R.id.freeform).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent myIntent = new Intent(_context, com.mysticplanet.virtualperry.FreeformActivity.class);
				startActivity(myIntent);
			}
		});


		findViewById(R.id.cmd).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent myIntent = new Intent(_context, com.mysticplanet.virtualperry.CommandActivity.class);
				startActivity(myIntent);
			}
		});		
		**/
	}


}
