package gameOfLife;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulation extends JPanel implements ActionListener, KeyListener {

	private boolean play = false;
	private int neighborCount;
	
	private GridGenerator grid;
	private Timer timer;
	
	public Simulation() {
		addKeyListener(this);
		setFocusable(true);
		grid = new GridGenerator(50);
		repaint();
		
		timer = new Timer(500, this);
		timer.start();
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int[][] temp = grid.grid;
		
		
		grid.reviveCell(10, 9);
		grid.reviveCell(10, 10);
		grid.reviveCell(10, 11);
		

		
		
		
		if (true) {
			
			for (int i = 0; i < grid.grid.length; i++) {
				for (int j=0; j<grid.grid[i].length; j++) {
					neighborCount  = grid.countNeighbors(i, j);
					if(grid.isAlive(i, j) && (neighborCount<2 || neighborCount>3)) {
						temp[i][j] = 0;
					} 
					else if (!grid.isAlive(i, j) && neighborCount == 3) {
						temp[i][j]=1;
					}
					else {
						temp[i][j] = grid.grid[i][j];
					}
				}
				
			}
			
			grid.grid = temp;
			repaint();
			
			
			
		}
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		play = !play;
		
	}
	
	
	public void paint(Graphics g) {
		
		grid.draw((Graphics2D)g);
	}
	
	
	
	
	
	
	


	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}




	




	

}
