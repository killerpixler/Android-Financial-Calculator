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

public class F_PVAnn extends Fragment {
	String answer_pv, answer_cf, answer_r, answer_t;
	EditText pv,cf,r,t;
	TextView answer;
	int emptyfields = 0, choice = 0;
	Button calc, info;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.pvann, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//hide the keyboard initially
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//get all the answer Strings and labels, etc...
		answer_pv = (String) getActivity().getResources().getString(R.string.answer_pvann);
		answer_cf = (String) getActivity().getResources().getString(R.string.answer_cf);
		answer_r = (String) getActivity().getResources().getString(R.string.answer_r);
		answer_t = (String) getActivity().getResources().getString(R.string.answer_t);
		calc = (Button) getActivity().findViewById(R.id.pvann_calc);
		info = (Button) getActivity().findViewById(R.id.pvann_infobutton);
		
		buttonCalc();
		boolean mDualPane=MiscMethods.landscapeChecker(getActivity());
		if(mDualPane == false){buttonInfo();}

	}

	
	
	public void buttonInfo() {
		info.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), DetailsActivity2.class);
				intent.putExtra("infos", "pvann");
				startActivity(intent);
			}
		});
	}
	public void buttonCalc() {
		calc.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//get values from user inputs
				pv = (EditText) getActivity().findViewById(R.id.pvann_pv);
				cf = (EditText) getActivity().findViewById(R.id.pvann_cf);
				r = (EditText) getActivity().findViewById(R.id.pvann_r);
				t = (EditText) getActivity().findViewById(R.id.pvann_t);
				answer = (TextView) getActivity().findViewById(R.id.pvann_answer);
				//check which field was left empty, or if too many were left empty
				if (pv.getText().toString().equals("")) {emptyfields++;choice = 1;}
				if (cf.getText().toString().equals("")) {emptyfields++;choice = 2;}
				if (r.getText().toString().equals("")) {emptyfields++;choice = 3;}
				if (t.getText().toString().equals("")) {emptyfields++;choice = 4;}
				if (emptyfields > 1) {MiscMethods.ErrorToast(1);}
				//if all is well, do respective calculation
				else {
					emptyfields--;
					switch (choice) {
					case 1:// pv
						double cf1 = Double.parseDouble(cf.getText().toString());
						double r1 = Double.parseDouble(r.getText().toString());
						double t1 = Double.parseDouble(t.getText().toString());
						double result1 = (cf1/r1)*(1-(Math.pow(1+r1,-t1)));
						result1 = MiscMethods.rounder(result1, 2);
						answer.setText(answer_pv+ result1);
						break;
					case 2:// cf
						double pv2 = Double.parseDouble(pv.getText().toString());
						double r2 = Double.parseDouble(r.getText().toString());
						double t2 = Double.parseDouble(t.getText().toString());
						double result2 = (pv2*r2)/(1-(Math.pow(1+r2,-t2)));
						result2 = MiscMethods.rounder(result2, 2);
						answer.setText(answer_cf + result2);
						break;
					case 3:// r
						MiscMethods.ErrorToast(2);
						break;
					case 4:// t
						double pv4 = Double.parseDouble(pv.getText().toString());
						double cf4 = Double.parseDouble(cf.getText().toString());
						double r4 = Double.parseDouble(r.getText().toString());
						double result4 = (Math.log(1/(1-(pv4*r4/cf4))))/(Math.log(1 + r4));
						result4 = MiscMethods.rounder(result4, 4);
						answer.setText(answer_t	+" "+ result4);
						break;
					default:
						MiscMethods.ErrorToast(3);
						break;
					}// switch ends
				}// else ends

			}
		});
	}

}
