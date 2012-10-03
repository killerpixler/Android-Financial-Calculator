package com.mwerner.mycalc.finance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class F_List extends ListFragment {

	boolean mDualPane;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// populate the list from strings.xml

		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, getResources()
						.getStringArray(R.array.menuchoices)));

		// check to see if there are the frame layouts (i.e. is the device in
		// landscape?
		View detailsFrame = getActivity().findViewById(R.id.content1);
		mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		/*
		 * here the long ID is converted into a int for switch statements here
		 * and in the DetailsActivity
		 */
		Integer id2 = (int) id;

		if (mDualPane) {
			/*
			 * if the device is in landscape mode on tablets the switch
			 * statement handles the fragment Transactions. If not, then an
			 * intent is passed to the new DetailsActivity that is started
			 * The IDs that are used in the switch statements are pulled
			 * straight from the strings.xml where the list is populated.
			 */

			switch (id2) {
			case 0:
				Fragment frag0 = new F_PV();
				Fragment frag01 = new F_PV_Info();
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.replace(R.id.content1, frag0);
				ft.replace(R.id.content2, frag01);
				ft.commit();
				break;
			case 1:
				Fragment frag1 = new F_PVAnn();
				Fragment frag11 = new F_PVAnn_Info();
				FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
				ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft1.replace(R.id.content1, frag1);
				ft1.replace(R.id.content2, frag11);
				ft1.commit();
				break;
			case 2:
				Fragment frag2 = new F_PVAnnDue();
				Fragment frag21 = new F_PVAnnDue_Info();
				FragmentTransaction ft2 = getActivity().getSupportFragmentManager().beginTransaction();
				ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft2.replace(R.id.content1, frag2);
				ft2.replace(R.id.content2, frag21);
				ft2.commit();
				break;
			case 3:
				Fragment frag3 = new F_FVAnn();
				Fragment frag31 = new F_FVAnn_Info();
				FragmentTransaction ft3 = getActivity().getSupportFragmentManager().beginTransaction();
				ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft3.replace(R.id.content1, frag3);
				ft3.replace(R.id.content2, frag31);
				ft3.commit();
				break;
			case 4:
				Fragment frag4 = new F_FVAnnDue();
				Fragment frag41 = new F_FVAnnDue_Info();
				FragmentTransaction ft4 = getActivity().getSupportFragmentManager().beginTransaction();
				ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft4.replace(R.id.content1, frag4);
				ft4.replace(R.id.content2, frag41);
				ft4.commit();
				break;
			case 5:
				Fragment frag5 = new F_Bonds();
				Fragment frag51 = new F_Bonds_Info();
				FragmentTransaction ft5 = getActivity().getSupportFragmentManager().beginTransaction();
				ft5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft5.replace(R.id.content1, frag5);
				ft5.replace(R.id.content2, frag51);
				ft5.commit();
				break;
			case 6:
				Fragment frag6 = new F_Growth();
				Fragment frag61 = new F_Growth_Info();
				FragmentTransaction ft6 = getActivity().getSupportFragmentManager().beginTransaction();
				ft6.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft6.replace(R.id.content1, frag6);
				ft6.replace(R.id.content2, frag61);
				ft6.commit();
				break;
			case 7:
				Fragment frag7 = new F_NPV();
				Fragment frag71 = new F_NPV_Info();
				FragmentTransaction ft7 = getActivity().getSupportFragmentManager().beginTransaction();
				ft7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft7.replace(R.id.content1, frag7);
				ft7.replace(R.id.content2, frag71);
				ft7.commit();
				break;
			default:
				break;
			}// end switch

		}// end if
		/*
		 * If the device is in portrait mode on phones, the content1 view is not visible
		 * and therefore mDualPane is false and so the phone version just has to start a
		 * new activity where the intent is passed.
		 */
		if (mDualPane == false) {
			Intent intent = new Intent(getActivity(), DetailsActivity.class);
			intent.putExtra("passedID", id2);
			startActivity(intent);
		}//end if

	}//end onclicklistener

}
