package game;

public abstract class Game{
	Player kinhas;
	
	Game(int credit){
		kinhas= new Player(credit);
	}
	
	abstract void  init(); 
	

}
