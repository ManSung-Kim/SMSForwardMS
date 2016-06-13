package com.jactlab.smsforwardms;

import com.jactlab.smsforwardms.service.SMSReceiverMS;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends Activity {

	final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	
	private BroadcastReceiver pmSMSReceiver = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pmSMSReceiver = new SMSReceiverMS();
		IntentFilter lIFilter = new IntentFilter(SMS_RECEIVED);
		registerReceiver(pmSMSReceiver, lIFilter);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if( pmSMSReceiver != null ) {
			unregisterReceiver(pmSMSReceiver);
			pmSMSReceiver = null;
		}
	}
	
}
