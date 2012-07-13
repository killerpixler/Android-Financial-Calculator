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

public class F_PV extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.pv, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Button calc = (Button) getActivity().findViewById(R.id.pv_calc);
		Button info = (Button) getActivity().findViewById(R.id.pv_infobutton);

		// clickhandler
		calc.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				EditText pv = (EditText) getActivity().findViewById(R.id.pv_pv);
				EditText fv = (EditText) getActivity().findViewById(R.id.pv_fv);
				EditText r = (EditText) getActivity().findViewById(R.id.pv_r);
				EditText n = (EditText) getActivity().findViewById(R.id.pv_n);
				EditText t = (EditText) getActivity().findViewById(R.id.pv_t);
				TextView answer = (TextView) getActivity().findViewById(
						R.id.pv_answer);
				int emptyfieldss = 0;
				int choice = 0;
				if (pv.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 1;
				}
				if (fv.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 2;
				}
				if (r.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 3;
				}
				if (n.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 4;
				}
				if (t.getText().toString().equals("")) {
					emptyfieldss++;
					choice = 5;
				}
				if (emptyfieldss > 1) {
					Toast errormsg = Toast.makeText(getActivity(),
							"Error! you left more than one field empty!",
							Toast.LENGTH_SHORT);
					errormsg.setGravity(Gravity.CENTER, 0, 0);
					errormsg.show();
				} else {
					switch (choice) {
					case 1:// pv
						double fv1 = Double
								.parseDouble(fv.getText().toString());
						double r1 = Double.parseDouble(r.getText().toString());
						double n1 = Double.parseDouble(n.getText().toString());
						double t1 = Double.parseDouble(t.getText().toString());
						double result1 = fv1
								/ (Math.pow(1 + (r1 / n1), n1 * t1));
						result1 = (double) (Math.round(result1 * 100)) / 100;
						answer.setText("The Present Value of the cash flow is: "
								+ result1);
						break;
					case 2:// fv
						double pv2 = Double
								.parseDouble(pv.getText().toString());
						double r2 = Double.parseDouble(r.getText().toString());
						double n2 = Double.parseDouble(n.getText().toString());
						double t2 = Double.parseDouble(t.getText().toString());
						double result2 = pv2
								* (Math.pow(1 + (r2 / n2), n2 * t2));
						result2 = (double) (Math.round(result2 * 100)) / 100;
						answer.setText("The Future Value of the cash flow is: "
								+ result2);
						break;
					case 3:// r
						double pv3 = Double
								.parseDouble(pv.getText().toString());
						double fv3 = Double
								.parseDouble(fv.getText().toString());
						double n3 = Double.parseDouble(n.getText().toString());
						double t3 = Double.parseDouble(t.getText().toString());
						double result3 = ((Math.pow(fv3 / pv3, (1 / (n3 * t3)))) - 1)
								* n3;
						result3 = (double) (Math.round(result3 * 100)) / 100;
						answer.setText("The interest rate applied is: "
								+ result3);
						break;
					case 4:// n
						Toast errormsgCase4 = Toast
								.makeText(
										getActivity(),
										"Sorry but number of periods cannot be calculated",
										Toast.LENGTH_LONG);
						errormsgCase4.setGravity(Gravity.CENTER, 0, 0);
						errormsgCase4.show();
						break;
					case 5:// t
						double pv5 = Double
								.parseDouble(pv.getText().toString());
						double fv5 = Double
								.parseDouble(fv.getText().toString());
						double n5 = Double.parseDouble(n.getText().toString());
						double r5 = Double.parseDouble(r.getText().toString());
						double result5 = (Math.log((fv5 / pv5)))
								/ ((Math.log((1 + (r5 / n5)))) * n5);
						result5 = (double) (Math.round(result5 * 100)) / 100;
						answer.setText("The number of years is: " + result5);
						break;
					default:
						Toast errormsg = Toast.makeText(getActivity(),
								"Error!", Toast.LENGTH_SHORT);
						errormsg.setGravity(Gravity.CENTER, 0, 0);
						errormsg.show();
						break;
					}// switch ends
				}// else ends

			}
		});
		// clickhandler end

		info.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(getActivity(), DetailsActivity2.class);
				intent.putExtra("infos", "pv");
				startActivity(intent);
			}
		});// infobutton when shown only in small mode

	}// onActivityCreated ends

}
