package com.example.eventbus_test;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.os.CountDownTimer;
import android.provider.Telephony.Mms.Addr;

public class Proxy {
	public static List <String> items  = new ArrayList <String> () {{ add("a");}};
	public static ProgressDialog progress;
	public static void load(){
		
		
		new CountDownTimer(3000, 1000) {

		     public void onTick(long millisUntilFinished) {
		         
		     }

		     public void onFinish() {
		    	 items.add("b");
		    	 Proxy.progress.dismiss();
		     }
		  }.start();
	}

}
