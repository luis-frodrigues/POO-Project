package strategy;

import java.util.Arrays;

public class RetVerify {
	private int nRet;
	private int posRet[];
	private int size;
	
	/**
	 * Creates an RetVerify which may have 
	 * the positions of a certain number of cards
	 * given in the paramenter 'size'.
	 * @param size Corresponds to the number of 
	 * cards positions that can be stored.
	 */
	RetVerify(int size) {
		this.size=size;
		posRet= new int [size];
	}
	/**
	 * Stores a maximum number 'size' of cards positions,
	 * which are in the given array 'positions'. It only
	 * stores the values from the index 0 to the size-1 of 
	 * the array 'positions'.  
	 * @param positions Array with the positions of cards.
	 */
	void setPos(int[] positions){
		if(positions==null){
			posRet=null;
		}else{
			for(int i=0;i<size;i++){
				posRet[i]=positions[i];
			}
		}
	}
	/**
	 * Gives the position of the card stored
	 * in the index of array 'position'
	 * @param position
	 * @return
	 */
	int getPosRet(int position) {
		if(position>=0&&position<size)
			return posRet[position];
		return-1;
	}
	/**
	 * It sets the value of a int(nRet) which can be usefull for
	 * returning additional information in hand types
	 * verification. 
	 * @param nret
	 */
	void setNRet(int nret ){
		if(nret>=0)
			nRet=nret;
	}
	/**
	 * @return Returns the value of nRet.
	 */
	int getnRet() {
		return nRet;
	}
	@Override
	public String toString() {
		return "Return int=" + nRet + ", posRet=" + Arrays.toString(posRet);
	}
		
}
