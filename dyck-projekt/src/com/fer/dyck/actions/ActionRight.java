package com.fer.dyck.actions;

import com.fer.dyck.Dyck;
import com.fer.dyck.Paths;

public class ActionRight implements Runnable {
	Dyck dyck;

	public ActionRight(Dyck dyck) {
		this.dyck = dyck;
	}

	@Override
	public void run() {
		if (Paths.index < Paths.set1.size() - 1) {
			Paths.index++;
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