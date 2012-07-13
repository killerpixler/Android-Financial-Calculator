package com.mwerner.mycalc.finance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class DetailsActivity2 extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.details2);

		Bundle starter = getIntent().getExtras();
		String launcher = (String) starter.get("infos");

		if (launcher.equals("pv")) {
			Fragment fragPV = new F_PV_Info();
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details2, fragPV);
			ft.commit();
		}
		if (launcher.equals("pvann")) {
			Fragment fragPVAnn = new F_PVAnn_Info();
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details2, fragPVAnn);
			ft.commit();
		}
		if (launcher.equals("pvanndue")) {
			Fragment fragPVAnnDue = new F_PVAnnDue_Info();
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details2, fragPVAnnDue);
			ft.commit();
		}
		if(launcher.equals("fvann")){
			Fragment fragFVAnn = new F_FVAnn_Info();
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details2, fragFVAnn);
			ft.commit();
		}
		if(launcher.equals("fvanndue")){
			Fragment fragFVAnnDue = new F_FVAnnDue_Info();
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details2, fragFVAnnDue);
			ft.commit();
		}
		if(launcher.equals("bonds")){
			Fragment fragBonds = new F_Bonds_Info();
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details2, fragBonds);
			ft.commit();
		}
		if(launcher.equals("growth")){
			Fragment fragGrowth = new F_Growth_Info();
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details2, fragGrowth);
			ft.commit();
		}
	}
}
