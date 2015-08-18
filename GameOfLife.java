import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
		
class GameOfLife implements ActionListener
{		
	JFrame frame = new JFrame("Porta100");
	JButton botao1 = new JButton("cavar as gerações");
	Board board;

	public static void main(String [] args)
	{								
		GameOfLife gui = new GameOfLife();
		gui.go();					
	}											
	public void go(){			
		board = new Board();
		botao1.addActionListener(this);

		Square square1 = new Square();
		Square square2 = new Square();					
		Square square3 = new Square();
		Square square4 = new Square();
		Square square5 = new Square();
		Square square6 = new Square();
		Square square7 = new Square();
		Square square8 = new Square();

		square1.setXY(0, 0);
		square1.setAlive(true);	

		square2.setXY(1, 0);
		square2.setAlive(true);	

		square3.setXY(0, 1);
		square3.setAlive(true);	

		square4.setXY(1, 1);
		square4.setAlive(true);

		square5.setXY(2, 2);
		square5.setAlive(true);	

		square6.setXY(2, 3);
		square6.setAlive(true);	

		square7.setXY(3, 2);
		square7.setAlive(true);	

		square8.setXY(3, 3);
		square8.setAlive(true);	

		board.addSquare(square1);
		board.addSquare(square2);							
		board.addSquare(square3);	
		board.addSquare(square4);
		board.addSquare(square5);							
		board.addSquare(square6);
		board.addSquare(square7);
		board.addSquare(square8);							


		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.setSize(800,800);
		frame.setVisible(true);
		frame.getContentPane().add(BorderLayout.SOUTH,botao1);
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}			
	public 	void actionPerformed(ActionEvent e)
	{
		board.counterGeracoes++;		
				
		frame.repaint();
	}	

	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{	
					
			board.drawBoard(g);

		}
	}
}
