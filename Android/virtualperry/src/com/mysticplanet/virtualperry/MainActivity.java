package com.mysticplanet.virtualperry;


import org.ispeech.SpeechSynthesis;
import org.ispeech.SpeechSynthesisEvent;
import org.ispeech.error.BusyException;
import org.ispeech.error.InvalidApiKeyException;
import org.ispeech.error.NoNetworkException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


//public class MainActivity extends Activity {
public class MainActivity extends ActionBase{	

	private static final String TAG = "Virtual Perry";
	SpeechSynthesis synthesis;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_context = this.getApplicationContext();
		setContentView(R.layout.activity_main);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		PreferenceManager.setDefaultValues(this, R.xml.preference, false);
		
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String userName = sharedPref.getString("userName", "").replace(' ', '_');
		
		TextView t = (TextView) findViewById(R.id.text1);
		String displayHello = "Hello " + userName + ". What revolutionary idea can we discuss today?";
		
		t.setText(displayHello);
		
		prepareTTSEngine();
		
		synthesis.setStreamType(AudioManager.STREAM_MUSIC); 
		try{
		synthesis.speak(displayHello + " ");
		
		} catch (BusyException e) {
			Log.e(TAG, "SDK is busy");
			e.printStackTrace();
			Toast.makeText(_context, "ERROR: SDK is busy", Toast.LENGTH_LONG).show();
		} catch (NoNetworkException e) {
			Log.e(TAG, "Network is not available\n" + e.getStackTrace());
			Toast.makeText(_context, "ERROR: Network is not available", Toast.LENGTH_LONG).show();
		}
		
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
	private void prepareTTSEngine() {
		try {
			
			SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
			String voiceType = sharedPref.getString("vp_lang_resp_type", "").replace(' ', '_');
			
			
			synthesis = SpeechSynthesis.getInstance(this);
			synthesis.setVoiceType(voiceType);
			synthesis.addOptionalCommand("speed", sharedPref.getString("vp_voiceSpeed", ""));
			synthesis.addOptionalCommand("pitch", sharedPref.getString("vp_voicePitch", ""));
			synthesis.addOptionalCommand("bitrate", sharedPref.getString("vp_bitRate", ""));
			synthesis.addOptionalCommand("format","mp3");
			
			
			synthesis.setSpeechSynthesisEvent(new SpeechSynthesisEvent() {

				public void onPlaySuccessful() {
					Log.i(TAG, "onPlaySuccessful");
				}

				public void onPlayStopped() {
					Log.i(TAG, "onPlayStopped");
				}

				public void onPlayFailed(Exception e) {
					Log.e(TAG, "onPlayFailed");
					

					AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
					builder.setMessage("Error[TTSActivity]: " + e.toString())
					       .setCancelable(false)
					       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					           }
					       });
					AlertDialog alert = builder.create();
					alert.show();
				}

				public void onPlayStart() {
					Log.i(TAG, "onPlayStart");
				}

				@Override
				public void onPlayCanceled() {
					Log.i(TAG, "onPlayCanceled");
				}
				
				
			});


		} catch (InvalidApiKeyException e) {
			Log.e(TAG, "Invalid API key\n" + e.getStackTrace());
			Toast.makeText(_context, "ERROR: Invalid API key", Toast.LENGTH_LONG).show();
		}

	}



}
