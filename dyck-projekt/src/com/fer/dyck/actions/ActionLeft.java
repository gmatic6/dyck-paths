package com.fer.dyck.actions;

import com.fer.dyck.Dyck;
import com.fer.dyck.Paths;

public class ActionLeft implements Runnable {
	Dyck dyck;

	public ActionLeft(Dyck dyck) {
		this.dyck = dyck;
	}

	@Override
	public void run() {
		if (Paths.index > 0) {
			Paths.index--;
			dyck.gpanel.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dyck.lbl2.setText(Paths.index + 1 + "/" + Paths.set1.size() + "  ");
		}
	}
}
