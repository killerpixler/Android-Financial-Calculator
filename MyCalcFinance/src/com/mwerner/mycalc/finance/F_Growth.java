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

public class F_Growth extends Fragment {
	Button calc,info;
	EditText g,div0,div_t,t;
	int emptyfields = 0,choice = 0;
	TextView answer;
	String answer_g,answer_div0,answer_div_t, answer_growth_t;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.growth, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//hide the keyboard initially
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//strings ...
		info = (Button) getActivity().findViewById(R.id.growth_infobutton);
		calc = (Button) getActivity().findViewById(R.id.grwoth_calc);
		answer_g = (String) getActivity().getResources().getString(R.string.answer_growth);
		answer_div0 = (String) getActivity().getResources().getString(R.string.answer_div0);
		answer_div_t = (String) getActivity().getResources().getString(R.string.answer_div_t);
		answer_growth_t = (String) getActivity().getResources().getString(R.string.answer_growth_t);
		
		buttonCalc();
		boolean mDualPane=MiscMethods.landscapeChecker(getActivity());
		if(mDualPane == false){buttonInfo();}
	}// onActivityCreated ends

	private void buttonCalc() {
		
		calc.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				g = (EditText) getActivity().findViewById(R.id.growth_g);
				div0 = (EditText) getActivity().findViewById(R.id.growth_divnow);
				div_t = (EditText) getActivity().findViewById(R.id.growth_div_t);
				t = (EditText) getActivity().findViewById(R.id.growth_t);
				answer = (TextView) getActivity().findViewById(R.id.growth_answer);
				
				if (g.getText().toString().equals("")) {emptyfields++;choice = 1;}
				if (div0.getText().toString().equals("")) {emptyfields++;choice = 2;}
				if (div_t.getText().toString().equals("")) {emptyfields++;choice = 3;}
				if (t.getText().toString().equals("")) {emptyfields++;choice = 4;}
				if (emptyfields > 1) {MiscMethods.ErrorToast(1);} 
				else {
					switch (choice) {
					case 1:// g
						double div01 = Double.parseDouble(div0.getText().toString());
						double divt1 = Double.parseDouble(div_t.getText().toString());
						double t1 = Double.parseDouble(t.getText().toString());
						double result1 = Math.pow(div01 / divt1, 1 / t1) - 1;
						result1 = MiscMethods.rounder(result1, 4);
						answer.setText(answer_g + " " + result1	+ " / " + (result1*100) + "%");
						break;
					case 2:// div0
						double g2 = Double.parseDouble(g.getText().toString());
						double divt2 = Double.parseDouble(div_t.getText().toString());
						double t2 = Double.parseDouble(t.getText().toString());
						double result2 = (Math.pow(g2 + 1, t2)) * divt2;
						result2 = MiscMethods.rounder(result2, 2);
						answer.setText(answer_div0 + result2);
						break;
					case 3:// div_t
						double div03 = Double.parseDouble(div0.getText().toString());
						double t3 = Double.parseDouble(t.getText().toString());
						double g3 = Double.parseDouble(g.getText().toString());
						double result3 = div03 / Math.pow(g3 + 1, t3);
						result3 = MiscMethods.rounder(result3, 2);
						answer.setText(answer_div_t	+ result3);
						break;
					case 4:// t
						double div04 = Double.parseDouble(div0.getText().toString());
						double g4 = Double.parseDouble(g.getText().toString());
						double divt4 = Double.parseDouble(div_t.getText().toString());
						double result4 = (Math.log(div04 / divt4)) / (Math.log(g4 + 1));
						result4 = MiscMethods.rounder(result4, 2);
						answer.setText(answer_growth_t + result4);
						break;

					default:
						MiscMethods.ErrorToast(3);
						break;
					}
				}

			}
		});
	}
	
	private void buttonInfo() {
		
		info.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Intent infos = new Intent();
				infos.setClass(getActivity(), DetailsActivity2.class);
				infos.putExtra("infos", "growth");
				startActivity(infos);
			}
		});
	}
	
	
	
}
