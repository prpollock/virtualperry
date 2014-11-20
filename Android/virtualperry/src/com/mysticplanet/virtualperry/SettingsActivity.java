package com.mysticplanet.virtualperry;

import android.os.Bundle;


public class SettingsActivity extends ActionBase {

	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_context = this.getApplicationContext();


        getFragmentManager().beginTransaction()
        .replace(android.R.id.content, new SettingsFragment())
        .commit();
	}	
	
}
