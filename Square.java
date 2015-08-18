class Square{
	private int x;
	private int y;
	private boolean alive;
	private boolean willLive;

	void setXY(int a, int b){
		x = a;
		y = b;
	}

	int getX(){
		return this.x;
	}

	int getY(){
		return this.y;
	}

	void setAlive(boolean aliveOrDead){
		System.out.println("matando ou morrendo");
		System.out.println(aliveOrDead);
		alive = aliveOrDead;
	}

	boolean getAlive(){
		return alive;
	}

	void setWillLive(boolean liveOrNot){
		willLive = liveOrNot;
	}

	boolean getWillLive(){
		return willLive;
	}

	int nearSquares(Board board){
		int countNears = 0;

		for(int i = x-1; i <= x + 1; i++){
			for(int j = y-1; j <= y +1; j++){
				if(board.hasSquare(i,j)){
					countNears++;
				}
			}
		}
		return countNears-1;
	}
}