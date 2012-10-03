package com.mwerner.mycalc.finance;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetailsActivity2 extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.details2);

		Bundle starter = getIntent().getExtras();
		String launcher = (String) starter.get("infos");
		if(launcher.equals("pv")){setContentView(R.layout.pv_info);}
		if(launcher.equals("pvann")){setContentView(R.layout.pvann_info);}
		if(launcher.equals("pvanndue")){setContentView(R.layout.pvanndue_info);}
		if(launcher.equals("fvann")){setContentView(R.layout.fvann_info);}
		if(launcher.equals("fvanndue")){setContentView(R.layout.fvanndue_info);}
		if(launcher.equals("bonds")){setContentView(R.layout.bonds_info);}
		if(launcher.equals("growth")){setContentView(R.layout.growth_info);}
		
	}
}
