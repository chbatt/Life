package gameOfLife;

import javax.swing.JFrame;

public class Main {

	public final static int FRAME_SIZE = 600;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Conway's Game Of Life");
		Simulation simulation = new Simulation();
		
		frame.setBounds(100, 100, FRAME_SIZE, FRAME_SIZE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(simulation);
		
		
		
	}
	
	
}
