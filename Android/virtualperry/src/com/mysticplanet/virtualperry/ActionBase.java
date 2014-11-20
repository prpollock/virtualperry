package com.mysticplanet.virtualperry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class ActionBase extends Activity {
	
	Context _context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
	}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return super.onCreateOptionsMenu(menu);
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			int id = item.getItemId();
			if (id == R.id.action_settings) {
				Intent myIntent = new Intent(_context, com.mysticplanet.virtualperry.SettingsActivity.class);
				startActivity(myIntent);			
				return true;
			}
			if (id == R.id.tts) {
				Intent myIntent = new Intent(_context, com.mysticplanet.virtualperry.TTSActivity.class);
				startActivity(myIntent);				
				return true;
			}	
			if (id == R.id.cmd) {
				Intent myIntent = new Intent(_context, com.mysticplanet.virtualperry.CommandActivity.class);
				startActivity(myIntent);				
				return true;
			}	
			if (id == R.id.freeform) {
				Intent myIntent = new Intent(_context, com.mysticplanet.virtualperry.FreeformActivity.class);
				startActivity(myIntent);				
				return true;
			}			

			return super.onOptionsItemSelected(item);
		}
		

}
