package com.main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	public static final int SIZE = 16;
	
	private int x, y;
	private int xVel, yVel;
	public static double speedIncrease = 1;
	private double speed = 5 + (speedIncrease * .1);
	
	public Ball() {
		reset();
		
	}

	private void reset() {
		//Initial Position
		
		x = Game.WIDTH / 2 - SIZE / 2;
		y = Game.HEIGHT / 2 - SIZE / 2;
		
		//Initial velocities
		xVel = Game.sign(Math.random() * 2.0 - 1);
		yVel = Game.sign(Math.random() * 2.0 - 1);
	}
	
	public void changeYDir() {
		yVel *= -1;
	}
	
	public void changeXDir() {
		xVel *= -1;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, SIZE, SIZE);
	}

	public void update(Paddle p1, Paddle p2) {
		//update movement
		x += xVel * speed;
		y += yVel * speed;
		
		//collisions
		if (y + SIZE >= Game.HEIGHT || y <= 0)
			changeYDir();
		
		//with walls
		if (x + SIZE >= Game.WIDTH) {
			p1.addPoint();
			reset();
		}
		
		if (x <= 0) {
			p2.addPoint();
			reset();
		
		}
			
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public static void addSpeed(double i) {
		speedIncrease += i;
	}

}
