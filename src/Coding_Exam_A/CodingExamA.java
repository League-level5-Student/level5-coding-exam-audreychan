package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	
	int amount;
	int sides;
	Color color;
	
	Robot[] rs;
	Thread[] ts;
	
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		
		CodingExamA lol = new CodingExamA();

		
	}
	
	public CodingExamA(){
		String amountString = JOptionPane.showInputDialog("Enter number of Robots: ");
		String colorString = JOptionPane.showInputDialog("Enter color (red, green, or blue): ");
		String sidesString = JOptionPane.showInputDialog("Enter number of sides:");
		
		
		amount = Integer.parseInt(amountString);
		sides = Integer.parseInt(sidesString);
		color = Color.BLACK;
		
		rs = new Robot[amount];
		ts = new Thread[amount];
		
		if(colorString.equalsIgnoreCase("blue")) color = Color.BLUE;
		else if(colorString.equalsIgnoreCase("green")) color = Color.GREEN;
		else if(colorString.equalsIgnoreCase("red")) color = Color.RED;
		
		for(int i = 0; i < amount; i++) {
			int j = i;
			ts[i] = new Thread(()-> {
				rs[j] = new Robot();
				Robot r = rs[j];
				
				r.setX((j%4)*200+100);
				r.setY((j/4)*200+100);
				drawShape(sides, r);
			});
		}
		
		for(int i = 0; i < amount; i++) {
			ts[i].start();
		}
	}
	
	void drawShape(int sides, Robot r) {
		r.penDown();
		r.setPenColor(color);
		r.hide();
		r.setSpeed(10);
		for(int i = 0; i < sides; i++) {
			r.move(200/sides);
			r.turn(360/sides);
		}
	}
}
