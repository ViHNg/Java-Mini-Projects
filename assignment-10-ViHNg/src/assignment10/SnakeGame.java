package assignment10;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;


public class SnakeGame {
	private final double unit = 0.02;
	
	public boolean hasEaten(Snake s, Apple a) {
		if (Math.sqrt(Math.pow(s.getX()-a.getX(),2) + Math.pow(s.getY()- a.getY(),2))<= s.getR()){
			return true;
		}
		return false;
	}
	public boolean touchBorder(List<Snake> body) {
		for (Snake s: body) {
			if (s.getX() <= s.getR() || s.getX() >= (1-s.getR()) ||s.getY() <= s.getR() || s.getY() >= (1-s.getR())){
				return true;
			}
		}
		return false;
	}
	public boolean touchBody(List<Snake> body) {
		for (Snake s: body) {
			if(s.getInd()!=1 && s.getInd()!=2) {
				if ((Math.sqrt(Math.pow(s.getX()-body.get(0).getX(),2) + Math.pow(s.getY()- body.get(0).getY(),2))<= s.getR())){
					return true;
				}
			}
			}
		return false;
	}

	public void update(Snake s) {
		if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)&&s.getDir()!=4) {
			s.setDir(2);
		} 
		else if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)&&s.getDir()!=2) {
			s.setDir(4);
		} 
		else if(StdDraw.isKeyPressed(KeyEvent.VK_UP)&&s.getDir()!=3) {
			s.setDir(1);
		} 
		else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN)&&s.getDir()!=1) {
			s.setDir(3);
		}
		else {
			s.setDir(s.getDir());
		}
	}
	
	public void move(List<Snake> snake) {
		StdDraw.clear();
		Snake[] s = new Snake[snake.size()]; 
		snake.toArray(s);
		for (int i =0 ; i<s.length; i++) {
			if (s[i].getInd()==1) {
				System.out.println("x" + s[i].getX()+"y"+s[i].getY() + " " +s[i].getInd()+"helo");
				update(s[i]);
				if (s[i].getDir() == 1) {
					s[i].setPrevX(s[i].getX());
					s[i].setPrevY(s[i].getY());
					s[i].setY(s[i].getY()+unit);
					s[i].setX(s[i].getX());
					StdDraw.pause(50);
					s[i].draw();
					System.out.println("up");
				} 
				else if(s[i].getDir() == 2) {
					s[i].setPrevX(s[i].getX());
					s[i].setPrevY(s[i].getY());
					s[i].setX(s[i].getX()-unit);
					s[i].setY(s[i].getY());
					StdDraw.pause(50);
					s[i].draw();
					System.out.println("left");
				}
				else if (s[i].getDir()==3) {
					s[i].setPrevX(s[i].getX());
					s[i].setPrevY(s[i].getY());
					s[i].setY(s[i].getY()-unit);
					s[i].setX(s[i].getX());
					StdDraw.pause(50);
					s[i].draw();
					System.out.println("down");
						
				} 
				else {
					s[i].setPrevX(s[i].getX());
					s[i].setPrevY(s[i].getY());
					s[i].setX(s[i].getX()+unit);
					s[i].setY(s[i].getY());
					StdDraw.pause(50);
					s[i].draw();
					System.out.println("right");
				}
				System.out.println("x" + s[i].getX()+"y"+s[i].getY() + " " +s[i].getInd());
			}
		
		else {
			s[i].setPrevX(s[i].getX());
			s[i].setPrevY(s[i].getY());
			s[i].setX(s[i-1].getPrevX());
			s[i].setY(s[i-1].getPrevY());
	
			s[i].draw();
			System.out.println("x" + s[i].getX()+"y"+s[i].getY() + " " +s[i].getInd());
			
			
		}
		}
			
		}
	
	public void gameOver(Snake s) {
		StdDraw.setPenRadius(0.5);
		StdDraw.setPenColor(Color.black);
		StdDraw.text(0.5,0.5,"Game Over");
		StdDraw.text(0.5, 0.6,"Score: " + (s.getLength()-1) );
		StdDraw.show();

	}
	
	
	public static void main(String[] args) {
		boolean loop = true;
		SnakeGame snakeGame = new SnakeGame();
		StdDraw.enableDoubleBuffering();  

		Snake snake = new Snake(0.5,0.5,1);
		List<Snake> body = new LinkedList<Snake>();
		body.add(snake);
		
		Apple a = new Apple();
		
		StdDraw.pause(500);
		
		while(loop) {
			//while (!(StdDraw.isKeyPressed(KeyEvent.VK_SPACE))) {
				if (snakeGame.touchBorder(body)||snakeGame.touchBody(body)) {
					snakeGame.gameOver(body.get(0));
					loop = false;
//					System.out.println("wow");
//					while (!StdDraw.hasNextKeyTyped()) {
//					}
//					loop=StdDraw.isKeyPressed(KeyEvent.VK_SPACE);
//					System.out.println(loop);
//					snakeGame.restart(body);
				}
				else {
				
				snakeGame.move(body);
				a.draw();
				if (snakeGame.hasEaten(body.get(0),a)) {
					a.setXY();
					snake.setLength();
					int i = snake.getLength();
					Snake added = new Snake(body.get(i-2).getX(),body.get(i-2).getY(),i);
					added.setPrevX(added.getX());
					added.setPrevY(added.getY());
					body.add(added);
					System.out.println(added.getX()+"Added"+i);
				}
				StdDraw.show();
			}	 
			
			
			
					
				
			}
		}
	}

     
