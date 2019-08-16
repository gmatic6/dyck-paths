package com.fer.dyck;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;

import javax.swing.JPanel;

class Panel extends JPanel {

	private static final long serialVersionUID = -6102860987241624421L;
	private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
	private Color lineColor = new Color(44, 102, 230, 180);

	public void paint(Graphics g) {
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setColor(lineColor);
		g2.setStroke(GRAPH_STROKE);
		ArrayList<String> list = new ArrayList<String>();
		for (String temp : Paths.set1) {
			list.add(temp);
		}
		y1 = getHeight();
		if (!list.isEmpty()) {
			String uno = list.get(Paths.index);
			for (int i = 0; i < uno.length(); i++) {
				Character c = uno.charAt(i);
				if (c == '(') {
					x2 = x1 + (getWidth() / uno.length());
					y2 = y1 - (getHeight() / uno.length());
				} else if (c == ')') {
					x2 = x1 + (getWidth() / uno.length());
					y2 = y1 + (getHeight() / uno.length());
				} else if (c == '-') {
					x2 = x1 + (getWidth() / uno.length());
					y2 = y1;
				}
				g2.drawLine(x1, y1, x2, y2);
				g2.fillOval(x2 - 3, y2 - 2, 7, 7);
				x1 = x2;
				y1 = y2;
			}
		}
	}
}