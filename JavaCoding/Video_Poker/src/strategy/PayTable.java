package strategy;

import java.util.Hashtable;

abstract class  PayTable {
	private int elem_on_table=0;
	private int max_pay_types=0;
	protected int max_credits=0;
	protected Hashtable<Object, Object> PayTable;
		
	/**
	 * Creates a Paytable that imposes a limit on the number of
	 *  different hands results(max_pay_types) and also stablishes
	 * the number of different ammounts that can be bet.
	 * @param max_pay_types number of different hands results.
	 * @param max_credits number of different ammounts that can be bet.
	 */
	PayTable(int max_pay_types, int max_credits){
		PayTable = new Hashtable<Object, Object>();
		this.max_credits=max_credits;
		this.max_pay_types=max_pay_types;
	}
		
	/**
	 * Inserts in the PayTable the value for a certain HandType
	 * and ammount of bet which correspond to the paremeters
	 * HandType and Credit
	 * @param HandType An object which represents a HandType
	 * @param Credit An object which represents a Credit
	 * @param Value The corresponding value as a int.
	 */
	@SuppressWarnings("unchecked")
	void intsertValue(Object HandType, Object Credit, int Value){
		if((PayTable.containsKey(HandType))&&(elem_on_table>0)){
			Hashtable<Object, Integer> tmp=  (Hashtable<Object, Integer>) PayTable.get(HandType);
			if(tmp.size()<max_credits){
				tmp.put(Credit, Value);
			}else{
				System.out.println("Max credits reached");
			}
		}else{
			if(elem_on_table<max_pay_types){
				Hashtable<Object, Integer> aux=new Hashtable<Object, Integer>();
				aux.put(Credit, Value);
				PayTable.put(HandType, aux);
				elem_on_table++;
			}else{
				System.out.println("Table at full capacity");
			}
		}
	}
	
	/**
	 * Gives the value for a certain HandType and ammount
	 * of bet which correspond to the paremeters HandType
	 *  and Credit.
	 * @param HandType
	 * @param Credit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int check_payout(Object HandType, Object Credit){
		if(PayTable.containsKey(HandType)){
			Hashtable<Object,Integer> tmp= (Hashtable<Object, Integer>) PayTable.get(HandType);
			if(tmp.containsKey(Credit)){
				int i=(int) tmp.get(Credit);
				return i;
			}
			System.out.println("Credit '"+Credit+"' does not exist for that HandType");
			return -1;
		}
		System.out.println("HandType '"+HandType+"' does not exist");
		return -2;
	}
	
	/**
	 * Removes, if exists, the value and the corresponding ammount of bet
	 * associated with a certain HandType. If the HandType stays with 0 
	 * amounts of bet associated it is also removed from the table.
	 * @param HandType
	 * @param Credit
	 */
	@SuppressWarnings("unchecked")
	public void removeValue(Object HandType, Object Credit){
		if(PayTable.containsKey(HandType)){
			Hashtable<Object, Integer> tmp= (Hashtable<Object, Integer>) PayTable.get(HandType);
			if(tmp.containsKey(Credit)){
				tmp.remove(Credit);
			}
			if(tmp.size()==0){
				PayTable.remove(tmp);
				elem_on_table--;
			}
		}	
	}
}
