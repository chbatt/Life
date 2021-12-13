package gameOfLife;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class GridGenerator {

	int grid[][];
	private int pixelDimension;
	
	
	public GridGenerator(int size) {
		
		grid = new int [size][size];
		
		for(int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				grid[i][j] = 0;
			}
			
		}
		pixelDimension = Main.FRAME_SIZE/size;
		
		
	}
	
	
	public void draw(Graphics2D g) {
		
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				
				if (grid[i][j] == 0) {
					g.setColor(Color.white);
					g.fillRect(j*pixelDimension, i*pixelDimension, pixelDimension, pixelDimension);
					
					g.setStroke(new BasicStroke(2));
					g.setColor(Color.black);
					g.drawRect(j*pixelDimension, i*pixelDimension, pixelDimension, pixelDimension);
				}
				
				if (grid[i][j] == 1) {
					g.setColor(Color.black);
					g.fillRect(j*pixelDimension, i*pixelDimension, pixelDimension, pixelDimension);
					
					g.setStroke(new BasicStroke(2));
					g.setColor(Color.black);
					g.drawRect(j*pixelDimension, i*pixelDimension, pixelDimension, pixelDimension);
				}
				
				
			}
		}
		
		
	}
	
	public int countNeighbors(int row, int col) {
		
		int count=0;
		
		for(int i=row-1; i<= row+1; i++) {
			for (int j=col-1; j<=col+1; j++) {
				if(i==row && j==col) {continue;} 
				if(i<0 || j<0 || i>=grid.length || j>=grid.length) { continue;}
				else {
					count += grid[i][j];
				}
			}
		}
		
		return count;
	}

	public void reviveCell(int row, int col) {
		grid[row][col] = 1;
	}

	public void killCell(int row, int col) {
		grid[row][col]=0;
	}
	
	public boolean isAlive(int row, int col) {
		return grid[row][col]==1;
	}
	
	public void randomCells() {
		
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
			
				grid[i][j] =  (int) (2*Math.random());
			}
		}
	}
	
	
	
}
