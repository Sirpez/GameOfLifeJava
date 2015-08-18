import java.util.*;
import java.awt.*;
class Board
{
	ArrayList<Square> squares = new ArrayList<Square>();
	int counterGeracoes = 0;

	public void addSquare(Square square)
	{
		squares.add(square);
	}
	void drawBoard(Graphics g){

		System.out.println("= counterGeracoes ===========================================");
		System.out.println(counterGeracoes);
		System.out.println("============================================");

		if (counterGeracoes > 0){
			for(Square square : squares){
				if(square.getWillLive()){
					square.setAlive(true);
				}
				else{
					square.setAlive(false);				
				}
			}
		}

		System.out.println("============================================");

		for(Square square : squares)
		{	
			System.out.println("-----------------------");
			System.out.println(square.getX());
			System.out.println(square.getY());
			System.out.println(square.getAlive());
			System.out.println(square.nearSquares(this));

			if (square.getAlive()){
				if (square.nearSquares(this) < 2){
					System.out.println("vai morrer");
					square.setWillLive(false);
				}
				else if (square.nearSquares(this) == 2 || square.nearSquares(this) == 3) {
					System.out.println("vai viver");
					square.setWillLive(true);
				}
				else if (square.nearSquares(this) > 3) {
					System.out.println("vai morrer");
					square.setWillLive(false);
				}
			}
			else
			{
				if (square.nearSquares(this) == 3) {
					System.out.println("vai reviver");
					square.setWillLive(true);
				}
			}		
		}

		for(Square square : squares){

			g.fillRect(square.getX()*151,square.getY()*151,150,150);

			if(counterGeracoes == 0){
				g.setColor(Color.BLACK);
			} 
			else {
				if(square.getWillLive()){
					g.setColor(Color.BLACK);
				} 
				else{
					g.setColor(Color.WHITE);
				}
			}
		}
	}
	

	boolean hasSquare(int x,int y){
		for(Square square : squares){
			if(square.getAlive() && square.getX() == x && square.getY() == y){
				return true;
			}
		}
		return false;
	}
}