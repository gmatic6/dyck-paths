package com.fer.dyck;
import com.fer.dyck.actions.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Dyck extends JFrame implements ActionListener {
	
	//TODO: remove public, add getters and setters
	public Boolean motzkin = false;
	public String[] droplist = {"Dyck", "Motzkin"};
	public Integer i = 0;
	public JPanel panel = (JPanel) getContentPane();
	public JPanel panel2 = new JPanel();
	public JButton plus = new JButton("+");
	public JButton minus = new JButton("-");
	public JButton left = new JButton("<");
	public JButton right = new JButton(">");
	public JButton ucitaj = new JButton("Učitaj");
	public JLabel lbl1 = new JLabel("  n = 0 ");
	public JLabel lbl2 = new JLabel(" -/- ");
	public JLabel lbl3 = new JLabel("");
	public JLabel emptyLabel = new JLabel("");
	public JLabel lbl4 = new JLabel("Broj vrhova  ");
	public JPanel gpanel = new Panel();
	public JTextField txt = new JTextField();
	public JComboBox<String> menu = new JComboBox<String>(droplist);
	public String s = new String();

	private static final long serialVersionUID = -6150200825512862158L;

	public Dyck() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Dyck path generator");
		setVisible(true);
		setSize(1000, 600);

		panel.setLayout(new BorderLayout());
		
		panel.add(panel2, BorderLayout.SOUTH);
		panel.add(gpanel, BorderLayout.CENTER);

		panel2.setLayout(new GridLayout(2, 6));
		
		panel2.add(minus);
		panel2.add(plus);
		panel2.add(lbl1);
		panel2.add(lbl2);
		panel2.add(left);
		panel2.add(right);
		panel2.add(menu);
		panel2.add(emptyLabel);
		panel2.add(lbl3);
		panel2.add(lbl4);
		panel2.add(txt);
		panel2.add(ucitaj);

		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		ucitaj.addActionListener(this);
		menu.addActionListener(this);

		@SuppressWarnings("unused")
		String s = txt.getText();
	}

	//TODO: apply design patterns to avoid multiple if statements
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(plus)) {
			Thread th = new Thread(new ActionPlus(this));
			th.start();
		} else if (e.getSource().equals(minus)) {
			Thread th2 = new Thread(new ActionMinus(this));
			th2.start();
		} else if (e.getSource().equals(left)) {
			Thread th3 = new Thread(new ActionLeft(this));
			th3.start();
		} else if (e.getSource().equals(right)) {
			Thread th4 = new Thread(new ActionRight(this));
			th4.start();
		} else if (e.getSource().equals(ucitaj)) {
			Thread th5 = new Thread(new ActionRead(this));
			th5.start();
		} else if (e.getSource().equals(menu)) {
			Thread th6 = new Thread(new ActionMenu(this));
			th6.start();
		}
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				Dyck dyck1 = new Dyck();
			}
		});
	}
}