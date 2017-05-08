package game;

public class RetVerify {
	private int nRet;
	private int posRet[];
	private int size;
	
	public RetVerify(int n_ret) {
		size=n_ret;
		posRet= new int [n_ret];
	}
	void setPos(int[] positions){
		if(positions==null){
			posRet=null;
		}else{
			for(int i=0;i<size;i++){
				posRet[i]=positions[i];
			}
		}
	}
	public int getPosRet(int position) {
		if(position>0&&position<size)
			return posRet[position];
		return-1;
	}
	void setNRet(int nret ){
		if(nret>=0)
			nRet=nret;
	}
	public int getnRet() {
		return nRet;
	}
		
}
