package assignment10;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Apple {
	private final double R;
	private double x;
	private double y;
	private final Color apple;
	private final Color leaf;
	public Apple() {
		this.R = 0.02;
		this.x = Math.random();
		this.y = Math.random();
		this.apple = Color.red;
		this.leaf = Color.green;
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public void setXY() {
		this.x = Math.random()*0.95;
		if (this.x <0.05) {
			this.x += 0.05;
		}
		this.y = Math.random()*0.95;
		if (this.y <0.05) {
			this.y += 0.05;
		}
	}
	public void draw() {
		StdDraw.setPenColor(apple);
		StdDraw.filledCircle(x,y,R);
		StdDraw.setPenColor(leaf);
		StdDraw.line(x, y+4*R/5,x, y+6*R/5);

		
	}

}
