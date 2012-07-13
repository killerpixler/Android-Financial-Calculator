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

public class F_Bonds extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.bonds, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		Button calc = (Button) getActivity().findViewById(R.id.bonds_calc);

		// clickhandler
		calc.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				EditText cp = (EditText) getActivity().findViewById(
						R.id.bonds_cp);
				EditText fv = (EditText) getActivity().findViewById(
						R.id.bonds_fv);
				EditText r = (EditText) getActivity()
						.findViewById(R.id.bonds_r);
				EditText n = (EditText) getActivity()
						.findViewById(R.id.bonds_n);
				EditText t = (EditText) getActivity()
						.findViewById(R.id.bonds_t);
				TextView answer = (TextView) getActivity().findViewById(
						R.id.pv_answer);
				int emptyfieldss = 0;
				if (cp.getText().toString().equals("")) {
					emptyfieldss++;
				}
				if (fv.getText().toString().equals("")) {
					emptyfieldss++;
				}
				if (r.getText().toString().equals("")) {
					emptyfieldss++;
				}
				if (n.getText().toString().equals("")) {
					emptyfieldss++;
				}
				if (t.getText().toString().equals("")) {
					emptyfieldss++;
				}
				if (emptyfieldss > 1) {
					Toast errormsg = Toast.makeText(getActivity(),
							"Error! you left more than one field empty!", Toast.LENGTH_SHORT);
					errormsg.setGravity(Gravity.CENTER, 0, 0);
					errormsg.show();
				} else {
					double cp1 = Double.parseDouble(cp.getText().toString());
					double fv1 = Double.parseDouble(fv.getText().toString());
					double r1 = Double.parseDouble(r.getText().toString());
					double n1 = Double.parseDouble(n.getText().toString());
					double t1 = Double.parseDouble(t.getText().toString());
					double result1 = (cp1 / r1)
							* (1 - Math.pow(1 + (r1 / n1), -n1 * t1))
							+ (fv1 / Math.pow(1 + (r1 / n1), n1 * t1));
					result1 = (double) (Math.round(result1 * 100)) / 100;
					answer.setText("The Present Value of the cash flow is: "
							+ result1);

				}// else ends

			}
		});
		// clickhandler end
		
		Button info = (Button) getActivity().findViewById(R.id.bonds_infobutton);
		info.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
			Intent info = new  Intent();
			info.setClass(getActivity(), DetailsActivity2.class);
			info.putExtra("infos", "bonds");
			startActivity(info);
			}
		});

	}// onActivityCreated ends
}
