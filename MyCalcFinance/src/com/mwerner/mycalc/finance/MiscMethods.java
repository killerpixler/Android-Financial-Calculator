package com.mwerner.mycalc.finance;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MiscMethods{
	public static void ErrorToast(int errorCode) {
		String errorString = null;
		switch (errorCode) {
		case 1:
			errorString = App.getContext().getString(R.string.error_tooManyFieldsEmpty);
			break;
		case 2:
			errorString = App.getContext().getString(R.string.error_featureComingSoon);
			break;
		case 3:
			errorString = App.getContext().getString(R.string.error_SwitchBreak);
			break;
		default:
			errorString="Wrong Error Code";
			break;
		}
		Toast errormsg = Toast.makeText(App.getContext(), errorString, Toast.LENGTH_SHORT);
		errormsg.setGravity(Gravity.CENTER, 0, 0);
		errormsg.show();
	}
		
	public static double rounder(double number, int decimals){
		int multiplier = (int) Math.pow(10, decimals);
		double roundednumber;
		roundednumber = Math.round(number*multiplier)/(double)multiplier;
		return roundednumber;		
	}
	
	public static boolean landscapeChecker(Activity activity){
		boolean mDualPane;
		View detailsFrame = activity.findViewById(R.id.content1);
		mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
		return mDualPane;
		
	}
}
