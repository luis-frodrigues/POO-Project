package game;

public class RetVerify {
	int n_ret;
	private int posRet[];
	
	public RetVerify(int n_ret) {
		this.n_ret=n_ret;
		posRet= new int [n_ret];
	}
	void setPos(int[] positions){
		for(int i=0;i<n_ret;i++){
			posRet[i]=positions[i];
		}
	}
	public int getPosRet(int position) {
		if(position>0&&position<n_ret)
			return posRet[position];
		return-1;
	}
	
}
