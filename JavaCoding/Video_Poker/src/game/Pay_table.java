package game;

import java.util.Hashtable;

abstract class  Pay_table {
	private int elem_on_table=0;
	private int max_pay_types=0;
	protected int max_credits=0;
	protected Hashtable<Object, Object> PayTable;
		
	Pay_table(int max_pay_types, int max_credits){
		PayTable = new Hashtable<Object, Object>();
		this.max_credits=max_credits;
		this.max_pay_types=max_pay_types;
	}
		
	@SuppressWarnings("unchecked")
	void intsertValue(Object HandType, Object Credit, int Value){
		if((PayTable.containsKey(HandType))&&(elem_on_table>0)){
			Hashtable<Object, Integer> tmp=  (Hashtable<Object, Integer>) PayTable.get(HandType);
			if(tmp.size()<max_credits){
				tmp.put(Credit, Value);
				System.out.println(Value);
			}else{
				System.out.println("Max credits reached");
			}
		}else{
			if(elem_on_table<max_pay_types){
				Hashtable<Object, Integer> aux=new Hashtable<Object, Integer>();
				aux.put(Credit, Value);
				PayTable.put(HandType, aux);
				elem_on_table++;
				System.out.println(Value);
			}else{
				System.out.println("Table at full capacity");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	int check_payout(Object HandType, Object Credit){
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
	
	@SuppressWarnings("unchecked")
	int print_paytable(Object HandType, Object Credit){
		if(PayTable.containsKey(HandType)){
			Hashtable<Object, Integer> tmp= (Hashtable<Object, Integer>) PayTable.get(HandType);
			int k = (int) tmp.get(Credit);
			return k;
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	void removeValue(Object HandType, Object Credit){
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
