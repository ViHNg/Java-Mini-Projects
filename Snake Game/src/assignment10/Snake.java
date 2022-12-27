package assignment10;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;

public class Snake {
	private int length;
	private int index;
	private double X;
	private double Y;
	private double prevX;
	private double prevY;
	private int dir; // 1 = up, 3 = down, 2 = left, 4 = right
	private final double R;
	private final double Reyes;
	private final Color snakeColor;
	public Snake(double x, double y, int i) {
		this.length = 1;
		this.index = i;
		this.X = x;
		this.Y= y;
		this.prevX = 0.5;
		this.prevY = 0.5;
		this.dir = 1;
		this.R = 0.02;
		this.Reyes = 0.005;
		this.snakeColor = Color.green;
	}
	// Getters
	public int getLength() {
		return this.length;
	}
	public int getInd() {
		return this.index;
	}
	public double getX() {
		return this.X;
	}
	public double getY() {
		return this.Y;
	}
	public double getR() {
		return this.R;
	}
	public double getPrevX() {
		return this.prevX;
	}
	public double getPrevY() {
		return this.prevY;
	}
	public int getDir() {
		return this.dir;
	}
	// Setters
	public void setInd(int i) {
		this.index = i;
	}
	public void setX(double d) {
		this.X = d;
	}
	public void setY(double d) {
		this.Y = d;
	}
	public void setPrevX(double d) {
		this.prevX = d;
	}
	public void setPrevY(double d) {
		this.prevY = d;
	}
	public void setDir(int d) {
		this.dir = d;
	}
	public void setLength() {
		this.length++;
	}
	public void draw() {
		// Draw the head
		if (this.index == 1) {
			StdDraw.setPenColor(this.snakeColor);
			StdDraw.filledCircle(getX(),getY(), R);
			StdDraw.setPenColor(Color.black);
			if (getDir() == 1) {
				StdDraw.filledCircle( X-R/2, Y+R/2, Reyes);
				StdDraw.filledCircle( X+R/2, Y+R/2, Reyes);
			}
			else if(getDir() ==2) {
				StdDraw.filledCircle(X-R/2, Y+R/2, Reyes);
				StdDraw.filledCircle (X-R/2, Y-R/2, Reyes);
			}
			else if(getDir() == 3) {
				StdDraw.filledCircle(X-R/2, Y-R/2, Reyes);
				StdDraw.filledCircle (X+R/2, Y-R/2, Reyes);
			}
			else {
				StdDraw.filledCircle(X+R/2, Y+R/2, Reyes);
				StdDraw.filledCircle (X+R/2, Y-R/2, Reyes);
			}
		}
		else {
			StdDraw.setPenColor(transparentColor(Color.green, (int)(256-this.index)/2));
			StdDraw.filledCircle(getX(),getY(), R);
		}
		
		//body.add(this);
//		if (getLength() > 1) {
//				StdDraw.setPenColor(transparentColor(Color.red, 255));
//				StdDraw.pause(20);
//				StdDraw.filledCircle(getX(),getY(),R);
			//}
		}
	//public void update
	public static Color transparentColor(Color c, int alpha) {
		Color res = new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
		return res;   
	}
	
			
	
}
