package game;

class Player {
	Hand myhand;
	Credit mycredit;
	
	Player(int credit){
		myhand=new Hand();
		mycredit= new Credit(credit);
	}
}
