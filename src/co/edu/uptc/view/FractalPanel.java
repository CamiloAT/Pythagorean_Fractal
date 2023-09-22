package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FractalPanel extends JPanel{

	private int level;

	public FractalPanel(int level) {
		this.level = level;
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int base = this.getWidth()/7;
		int x1 = (this.getWidth()/2)-(base/2);
		int x2 = (this.getWidth()/2)+(base/2);
		int x3 = this.getWidth()/2;
		int y1 = (this.getHeight()-(this.getHeight()/15))-base;
		int y2 = this.getHeight()-(this.getHeight()/15);
		int y3 = (this.getHeight()-(this.getHeight()/15))-(base+(base/2));
		g.setColor(new Color(82, 184, 255));
		g.fillPolygon(new int[]{x1, x1, x2, x2, x1}, new int[]{y1, y2, y2, y1, y1}, 4);
		
		if(this.level > 0) {
			paintIterations(this.level-1, g, x1, x3, x2, y1, y3, y1);
			paintIterations(this.level-1, g, x2, x3, x1, y1, y3, y1);
		}
	}

	public void paintIterations(int depth, Graphics g, double x1_1, double x2_1, double x3_1, double y1_1, double y2_1, double y3_1){

		int x1 = (int)(x1_1 + (x2_1-x3_1));
		int x2 = (int)(x2_1 + (x2_1-x3_1));
		int x3 = (int)(((x2_1 + (x2_1-x3_1)) + ((x2_1-x3_1)/2)) + ((x1_1-x2_1)/2));
		int y1 = (int)(y1_1 + (y2_1-y3_1));
		int y2 = (int)(y2_1 + (y2_1-y3_1));
		int y3 = (int)(((y1_1 + (y2_1-y3_1)) + ((y2_1-y1_1)/2)) + ((y2_1-y3_1)/2));
		int[] a = {(int)x1, (int)x1_1, (int)x2_1, (int)x2};
		int[] b = {(int)y1, (int)y1_1, (int)y2_1, (int)y2};
		
		g.setColor(new Color(82, 184, 255));
		g.fillPolygon(a, b, 4);

		if(depth > 0){
			paintIterations(depth-1, g, x1, x3, x2, y1, y3, y2);
			paintIterations(depth-1, g, x2, x3, x1, y2, y3, y1);
		}
	}
}
