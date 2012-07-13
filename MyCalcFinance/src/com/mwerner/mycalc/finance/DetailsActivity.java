package com.mwerner.mycalc.finance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class DetailsActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.details);

		// here the intent that gets send from the listfragment F_List.java gets
		// the data
		Bundle starter = getIntent().getExtras();
		int launcher = (Integer) starter.get("passedID");

		switch (launcher) {
		case 0:
			// Present Value
			Fragment frag0 = new F_PV();
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.replace(R.id.details1, frag0);
			ft.commit();
			break;

		case 1:
			// Present Value of Annuity
			Fragment frag1 = new F_PVAnn();
			FragmentTransaction ft1 = getSupportFragmentManager()
					.beginTransaction();
			ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft1.replace(R.id.details1, frag1);
			ft1.commit();
			break;
		case 2:
			// Present Value of Annuity Due
			Fragment frag2 = new F_PVAnnDue();
			FragmentTransaction ft2 = getSupportFragmentManager()
					.beginTransaction();
			ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft2.replace(R.id.details1, frag2);
			ft2.commit();
			break;
		case 3:
			Fragment frag3 = new F_FVAnn();
			FragmentTransaction ft3 = getSupportFragmentManager()
					.beginTransaction();
			ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft3.replace(R.id.details1, frag3);
			ft3.commit();
			break;
		case 4:
			Fragment frag4 = new F_FVAnnDue();
			FragmentTransaction ft4 = getSupportFragmentManager()
					.beginTransaction();
			ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft4.replace(R.id.details1, frag4);
			ft4.commit();
			break;
		case 5:
			Fragment frag5 = new F_Bonds();
			FragmentTransaction ft5 = getSupportFragmentManager()
					.beginTransaction();
			ft5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft5.replace(R.id.details1, frag5);
			ft5.commit();
			break;
		case 6:
			Fragment frag6 = new F_Growth();
			FragmentTransaction ft6 = getSupportFragmentManager()
					.beginTransaction();
			ft6.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft6.replace(R.id.details1, frag6);
			ft6.commit();
			break;
		case 7:
			Fragment frag7 = new F_NPV();
			FragmentTransaction ft7 = getSupportFragmentManager()
					.beginTransaction();
			ft7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft7.replace(R.id.details1, frag7);
			ft7.commit();
			break;
		default:
			break;
		}

	}

}
