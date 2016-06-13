package com.jactlab.smsforwardms.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.RawContacts.Data;
import android.telephony.gsm.SmsMessage;

import com.jactlab.smsforwardms.utils.MSLog;

public class SMSReceiverMS extends BroadcastReceiver{

	final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String lAction = intent.getAction();
		if( lAction.equals(SMS_RECEIVED) ) {
			MSLog.log("rcvd");
			
			Bundle bundle = intent.getExtras();
			Object[] msg = (Object[]) bundle.get("pdus");
			SmsMessage[] smsMsg = new SmsMessage[msg.length];
			
			for(int i=0; i< msg.length; i++) {
				smsMsg[i] = SmsMessage.createFromPdu((byte[])msg[i]);
			}
			
			//Data curDate = new Data(smsMsg[0].getTimestampMillis());
			
			String msgContent = smsMsg[0].getMessageBody().toString();
			MSLog.log(msgContent);
		}
	}

}
