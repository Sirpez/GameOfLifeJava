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


		for(Square square : squares)
		{	

			if (square.getAlive()){
				if (square.nearSquares(this) < 2){
					square.setWillLive(false);
				}
				else if (square.nearSquares(this) == 2 || square.nearSquares(this) == 3) {
					square.setWillLive(true);
				}
				else if (square.nearSquares(this) > 3) {
					square.setWillLive(false);
				}
			}
			else
			{
				if (square.nearSquares(this) == 3) {
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