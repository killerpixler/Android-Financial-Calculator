package com.mwerner.mycalc.finance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class F_Growth extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.growth, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Button calc = (Button) getActivity().findViewById(R.id.grwoth_calc);
		calc.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				EditText g = (EditText) getActivity().findViewById(
						R.id.growth_g);
				EditText div0 = (EditText) getActivity().findViewById(
						R.id.growth_divnow);
				EditText div_t = (EditText) getActivity().findViewById(
						R.id.growth_div_t);
				EditText t = (EditText) getActivity().findViewById(
						R.id.growth_t);
				TextView answer = (TextView) getActivity().findViewById(
						R.id.growth_answer);
				int emptyfieldss = 0;
				int choice = 0;
				if (g.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 1;
				}
				if (div0.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 2;
				}
				if (div_t.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 3;
				}
				if (t.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 4;
				}
				if (emptyfieldss > 1) {
					Toast errormsg = Toast.makeText(getActivity(),
							"Error! you left more than one field empty!",
							Toast.LENGTH_SHORT);
					errormsg.setGravity(Gravity.CENTER, 0, 0);
					errormsg.show();
				} else {
					switch (choice) {
					case 1:// g
						double div01 = Double.parseDouble(div0.getText()
								.toString());
						double divt1 = Double.parseDouble(div_t.getText()
								.toString());
						double t1 = Double.parseDouble(t.getText().toString());
						double result1 = Math.pow(div01 / divt1, 1 / t1) - 1;
						result1 = (double) (Math.round(result1 * 100)) / 100;
						double result11 = (double) result1 * 100;
						answer.setText("The growth rate is: " + result1
								+ " or " + result11 + "%");
						break;
					case 2:// div0
						double g2 = Double.parseDouble(g.getText().toString());
						double divt2 = Double.parseDouble(div_t.getText()
								.toString());
						double t2 = Double.parseDouble(t.getText().toString());
						double result2 = (Math.pow(g2 + 1, t2)) * divt2;
						result2 = (double) (Math.round(result2 * 100)) / 100;
						answer.setText("The dividends today are " + result2);
						break;
					case 3:// div_t
						double div03 = Double.parseDouble(div0.getText()
								.toString());
						double t3 = Double.parseDouble(t.getText().toString());
						double g3 = Double.parseDouble(g.getText().toString());
						double result3 = div03 / Math.pow(g3 + 1, t3);
						result3 = (double) Math.round(result3 * 100) / 100;
						answer.setText("The dividens -T- years ago were "
								+ result3);
						break;
					case 4:// t
						double div04 = Double.parseDouble(div0.getText()
								.toString());
						double g4 = Double.parseDouble(g.getText().toString());
						double divt4 = Double.parseDouble(div_t.getText()
								.toString());
						double result4 = (Math.log(div04 / divt4))
								/ (Math.log(g4 + 1));
						result4 = (double) Math.round(result4 * 100) / 100;
						answer.setText("It has been " + result4
								+ " years between the dividend payments.");
						break;

					default:
						break;
					}
				}

			}
		});

		Button info = (Button) getActivity().findViewById(
				R.id.growth_infobutton);
		info.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Intent infos = new Intent();
				infos.setClass(getActivity(), DetailsActivity2.class);
				infos.putExtra("infos", "growth");
				startActivity(infos);
			}
		});

	}// onActivityCreated ends
}
