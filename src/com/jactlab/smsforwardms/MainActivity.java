package com.jactlab.smsforwardms;

import com.jactlab.smsforwardms.service.SMSReceiverMS;
import com.jactlab.smsforwardms.service.SMSServiceMS;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends Activity {

	private Intent pmIntentSMSService = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pmIntentSMSService = new Intent(this, SMSServiceMS.class);
		
		startService(pmIntentSMSService);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		// btn 만들어서 stopservice 가능하게 만들기
	}
	
}
