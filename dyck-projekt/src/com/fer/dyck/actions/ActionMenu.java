package com.fer.dyck.actions;

import com.fer.dyck.Dyck;
import com.fer.dyck.Paths;

public class ActionMenu implements Runnable {

	Dyck dyck;

	public ActionMenu(Dyck dyck) {
		this.dyck = dyck;
	}
	
	@Override
	public void run() {
		dyck.i = 0;
		dyck.lbl1.setText("  n = 0 ");
		if (dyck.menu.getSelectedIndex() == 1){
			dyck.motzkin = true;
			dyck.lbl3.setText("");
			dyck.setTitle("Motzkin path generator");
		}else{
			dyck.motzkin = false;
			dyck.setTitle("Dyck path generator");
		}
		Paths.set1.clear();
		dyck.panel.repaint();
		System.out.println();
	}
}