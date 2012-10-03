package com.mwerner.mycalc.finance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class F_Bonds extends Fragment {
	String answer_bonds;
	Button calc,info;
	EditText cp,fv,r,n,t;
	TextView answer;
	int emptyfields = 0;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.bonds, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//hide the keyboard initially
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//get Strings ...
		calc = (Button) getActivity().findViewById(R.id.bonds_calc);
		info = (Button) getActivity().findViewById(R.id.bonds_infobutton);
		answer_bonds = (String) getActivity().getResources().getString(R.string.answer_bonds);

		buttonCalc();
		boolean mDualPane=MiscMethods.landscapeChecker(getActivity());
		if(mDualPane == false){buttonInfo();}
	}// onActivityCreated ends

	public void buttonInfo() {
		info.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
			Intent info = new  Intent();
			info.setClass(getActivity(), DetailsActivity2.class);
			info.putExtra("infos", "bonds");
			startActivity(info);
			}
		});
	}

	public void buttonCalc() {
		calc.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				cp = (EditText) getActivity().findViewById(R.id.bonds_cp);
				fv = (EditText) getActivity().findViewById(R.id.bonds_fv);
				r = (EditText) getActivity().findViewById(R.id.bonds_r);
				n = (EditText) getActivity().findViewById(R.id.bonds_n);
				t = (EditText) getActivity().findViewById(R.id.bonds_t);
				answer = (TextView) getActivity().findViewById(R.id.bonds_answer);
				if (cp.getText().toString().equals("")) {emptyfields++;}
				if (fv.getText().toString().equals("")) {emptyfields++;}
				if (r.getText().toString().equals("")) {emptyfields++;}
				if (n.getText().toString().equals("")) {emptyfields++;}
				if (t.getText().toString().equals("")) {emptyfields++;}
				if (emptyfields > 1) {MiscMethods.ErrorToast(1);}
				else {
					double cp1 = Double.parseDouble(cp.getText().toString());
					double fv1 = Double.parseDouble(fv.getText().toString());
					double r1 = Double.parseDouble(r.getText().toString());
					double n1 = Double.parseDouble(n.getText().toString());
					double t1 = Double.parseDouble(t.getText().toString());
					double result1 = (cp1/r1)*(1-Math.pow(1+(r1/n1),-n1*t1))+(fv1/Math.pow(1+(r1/n1),n1*t1));
					result1 = MiscMethods.rounder(result1, 2);
					answer.setText(answer_bonds+ result1);

				}// else ends

			}
		});
	}

}
