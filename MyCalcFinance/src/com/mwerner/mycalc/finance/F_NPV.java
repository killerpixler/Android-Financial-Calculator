package com.mwerner.mycalc.finance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
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
	EditText r = (EditText) getActivity().findViewById(R.id.npv_rate);
	Button calc = (Button) getActivity().findViewById(R.id.npv_calc);
	EditText[] DynamicField = new EditText[16];

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.npv, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		final LinearLayout linearLayout = (LinearLayout) getActivity()
				.findViewById(R.id.npv_calcfields);
		EditText editText = new EditText(getActivity());
		editText.setId(i);

		editText.setLayoutParams(new LayoutParams(

		LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		SeekBar bar = (SeekBar) getActivity().findViewById(R.id.npv_seekbar);
		final TextView selection = (TextView) getActivity().findViewById(
				R.id.npv_selected);

		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar seekbar, int progress,
					boolean fromUser) {
				selection.setText("You have selcted " + progress + " periods.");
				if (progress == 0) {
					String normalstring = getActivity().getResources()
							.getString(R.string.npv1);
					selection.setText(normalstring);

				}
				if (i > progress) {
					while (i > progress) {
						i--;
						EditText editText = (EditText) getActivity()
								.findViewById(i);
						linearLayout.removeView(editText);
					}

				} else {
					while (i < progress) {
						EditText editText = new EditText(getActivity());
						editText.setId(i);
						editText.setLayoutParams(new LayoutParams(
								LayoutParams.FILL_PARENT,
								LayoutParams.WRAP_CONTENT));
						linearLayout.addView(editText);
						editText.setHint("Cash Flow " + i);
						i++;
					}

				}
			}

			public void onStopTrackingTouch(SeekBar arg0) {
			}

			public void onStartTrackingTouch(SeekBar arg0) {
			}
		});

		calc.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Double r1 = Double.parseDouble(r.getText().toString());
				EditText editText = (EditText) getActivity().findViewById(i);
				TextView answer = (TextView) getActivity().findViewById(
						R.id.npv_answer);
				double[] CashFlows;
				CashFlows = new double[i];
				double result = 0;
				CashFlows[i] = (Double.parseDouble(editText.getText()
						.toString())) / (Math.pow(1 + r1, i));

				for (double d : CashFlows) {
					result += d;
				}
				answer.setText("answer is " + result);

			}
		});

	}
}
