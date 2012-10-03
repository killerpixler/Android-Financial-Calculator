package com.mwerner.mycalc.finance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class F_NPV extends Fragment {
	int i = 0;
	Button calc;
	EditText r;
	EditText[] DynamicField = new EditText[16];
	String s_answer;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.npv, container, false);
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//hide the keyboard initially
		getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//vatriable Initialization
		s_answer = (String) getActivity().getResources().getString(R.string.answer_npv);
		r = (EditText) getActivity().findViewById(R.id.npv_rate);
		calc = (Button) getActivity().findViewById(R.id.npv_calc);
		final LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.npv_calcfields);
		EditText editText = new EditText(getActivity());
		editText.setId(i);
		editText.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		SeekBar bar = (SeekBar) getActivity().findViewById(R.id.npv_seekbar);
		final TextView selection = (TextView) getActivity().findViewById(R.id.npv_selected);

		seekbarChangeViewAdder(linearLayout, bar, selection);
		calculationButton();

	}

	private void seekbarChangeViewAdder(final LinearLayout linearLayout,SeekBar bar, final TextView selection) {
		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
				selection.setText("You have selcted " + progress + " periods.");
				if (progress == 0) {
					String normalstring = getActivity().getResources().getString(R.string.npv1);
					selection.setText(normalstring);

				}
				if (i > progress) {
					while (i > progress) {
						i--;
						EditText editText = (EditText) getActivity().findViewById(i);
						
						linearLayout.removeView(editText);
					}

				} else {
					while (i < progress) {
						EditText editText = new EditText(getActivity());
						editText.setId(i);
						editText.setLayoutParams(new LayoutParams(
								LayoutParams.FILL_PARENT,
								LayoutParams.WRAP_CONTENT));
						editText.setInputType(2);
						linearLayout.addView(editText);
						editText.setHint("Cash Flow " + i);
						i++;
					}

				}
			}

			public void onStopTrackingTouch(SeekBar arg0) {}
			public void onStartTrackingTouch(SeekBar arg0) {}
		});
	}

	private void calculationButton() {

		
		calc.setOnClickListener(new OnClickListener() {

	        public void onClick(View view) {
	            Double r1 = Double.parseDouble((r.getText().toString()).equals("") ? "0" : r.getText().toString());
	            TextView answer = (TextView) getActivity().findViewById(R.id.npv_answer);
	            final LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.npv_calcfields);
	            int size = linearLayout.getChildCount();
	            double[] CashFlows = new double[size];
	            double result = 0;
	            for (int i = 0; i < size; i++) {
	                EditText editText = (EditText) linearLayout.getChildAt(i);
	                String tmp = editText.getText().toString();
	                CashFlows[i] = (Double.parseDouble(tmp.equals("") ? "0": tmp)) / (Math.pow(1 + r1, i));
	            }
	            for (double d : CashFlows) {
	                result += d;
	            }
	            result = MiscMethods.rounder(result, 2);
	            answer.setText(s_answer+" " + result);
	        }
	    });
		
	}


}
