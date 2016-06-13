package com.jactlab.smsforwardms.utils;

import android.util.Log;


public class MSLog {
	private static final boolean DBG = true;
	private static String psmTitle = "mstag";
	
	static public <T extends Object> void log(T msg) {
		if(DBG) Log.d(psmTitle, msg+"");
	}
}
