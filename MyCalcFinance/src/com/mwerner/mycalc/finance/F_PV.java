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

public class F_PV extends Fragment {
	Button calc, info;
	String answer_pv,answer_fv,answer_r,answer_t,answer_n, error_emptyFields, error_featureComingSoon, error_switch;
	EditText pv, fv, r, n, t;
	TextView answer;
	int emptyfields = 0, choice =0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.pv, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//hide the keyboard initially
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//get Strings etc...
		calc = (Button) getActivity().findViewById(R.id.pv_calc);
		info = (Button) getActivity().findViewById(R.id.pv_infobutton);
		answer_pv = (String) getActivity().getResources().getString(R.string.answer_pv);
		answer_fv = (String) getActivity().getResources().getString(R.string.answer_fv);
		answer_r = (String) getActivity().getResources().getString(R.string.answer_r);
		answer_n = (String) getActivity().getResources().getString(R.string.answer_n);
		answer_t = (String) getActivity().getResources().getString(R.string.answer_t);
		
		buttonCalc();
		boolean mDualPane=MiscMethods.landscapeChecker(getActivity());
		if(mDualPane == false){buttonInfo();}

	}// onActivityCreated ends

	public void buttonInfo() {
		info.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(getActivity(), DetailsActivity2.class);
				intent.putExtra("infos", "pv");
				startActivity(intent);
			}
		});
	}
	public void buttonCalc() {
		calc.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				pv = (EditText) getActivity().findViewById(R.id.pv_pv);
				fv = (EditText) getActivity().findViewById(R.id.pv_fv);
				r = (EditText) getActivity().findViewById(R.id.pv_r);
				n = (EditText) getActivity().findViewById(R.id.pv_n);
				t = (EditText) getActivity().findViewById(R.id.pv_t);
				answer = (TextView) getActivity().findViewById(R.id.pv_answer);
				//check for fields and choice
				if (pv.getText().toString().equals("")) {emptyfields++;choice = 1;}
				if (fv.getText().toString().equals("")) {emptyfields++;choice = 2;}
				if (r.getText().toString().equals("")) {emptyfields++;choice = 3;}
				if (n.getText().toString().equals("")) {emptyfields++;choice = 4;}
				if (t.getText().toString().equals("")) {emptyfields++;choice = 5;}
				if (emptyfields > 1) {MiscMethods.ErrorToast(1);}
				else{
					emptyfields--;
					switch (choice) {
					case 1:// pv
						double fv1 = Double.parseDouble(fv.getText().toString());
						double r1 = Double.parseDouble(r.getText().toString());
						double n1 = Double.parseDouble(n.getText().toString());
						double t1 = Double.parseDouble(t.getText().toString());
						double result1 = fv1/(Math.pow(1+(r1/n1),n1*t1));
						result1 = MiscMethods.rounder(result1, 2);
						answer.setText(answer_pv + result1);
						break;
					case 2:// fv
						double pv2 = Double.parseDouble(pv.getText().toString());
						double r2 = Double.parseDouble(r.getText().toString());
						double n2 = Double.parseDouble(n.getText().toString());
						double t2 = Double.parseDouble(t.getText().toString());
						double result2 = pv2*(Math.pow(1 + (r2 / n2), n2 * t2));
						result2 = MiscMethods.rounder(result2, 2);
						answer.setText(answer_fv + result2);
						break;
					case 3:// r
						double pv3 = Double.parseDouble(pv.getText().toString());
						double fv3 = Double.parseDouble(fv.getText().toString());
						double n3 = Double.parseDouble(n.getText().toString());
						double t3 = Double.parseDouble(t.getText().toString());
						double result3 = ((Math.pow(fv3 / pv3, (1 / (n3 * t3)))) - 1)* n3;
						result3 = (double) MiscMethods.rounder(result3, 4);
						answer.setText(answer_r	+" "+ result3 + " / " + (result3*100)+"%");
						break;
					case 4:// n
						MiscMethods.ErrorToast(2);
						break;
					case 5:// t
						double pv5 = Double.parseDouble(pv.getText().toString());
						double fv5 = Double.parseDouble(fv.getText().toString());
						double n5 = Double.parseDouble(n.getText().toString());
						double r5 = Double.parseDouble(r.getText().toString());
						double result5 = (Math.log((fv5 / pv5))) / ((Math.log((1 + (r5 / n5)))) * n5);
						result5 = (double) MiscMethods.rounder(result5, 2);
						answer.setText(answer_t +" "+ result5);
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
