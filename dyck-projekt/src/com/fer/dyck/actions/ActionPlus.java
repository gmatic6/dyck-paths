package com.fer.dyck.actions;

import com.fer.dyck.Dyck;
import com.fer.dyck.Paths;

public class ActionPlus implements Runnable {
	Dyck dyck;

	public ActionPlus(Dyck dyck) {
		this.dyck = dyck;
	}

	@Override
	public void run() {
		int limit = 11;
		if (dyck.motzkin == true) limit = 14;
		if (dyck.i < limit) {
			dyck.i ++;
			if (!dyck.s.isEmpty()) {
				Paths.start(dyck.i, dyck.s, dyck.motzkin);
				if (dyck.motzkin == false) dyck.lbl3.setText("N("+dyck.i+","+dyck.s+")="+Paths.naranaya);
			} else {
				Paths.start(dyck.i, "0", dyck.motzkin);
				dyck.lbl3.setText("");
			}
			dyck.gpanel.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dyck.lbl1.setText("  n = " + dyck.i.toString());
			if (Paths.set1.size() > 0) {
				dyck.lbl2.setText("1/" + Paths.set1.size() + "  ");
			} else {
				dyck.lbl2.setText("0/" + Paths.set1.size() + "  ");
			}
		}
	}
}