package game;

import java.util.Hashtable;

abstract class  Pay_table {
	int elem_on_table=0;
	int max_pay_types=0;
	Hashtable<Object, Object> PayTable;
	Hashtable<Object,Integer>[] aux;
	
	@SuppressWarnings("unchecked")
	Pay_table(int max_pay_types){
		PayTable = new Hashtable<Object, Object>();
		aux= new Hashtable[max_pay_types];
		this.max_pay_types=max_pay_types;
	}
		
	void intsertValue(Object OutcomeType, Object Credit, int Value){
		if((PayTable.containsKey(OutcomeType))&&(elem_on_table>0)){
			Hashtable<Object, Integer> tmp= (Hashtable<Object, Integer>) PayTable.get(OutcomeType);
			tmp.put(Credit, Value);
		}else{
			if(elem_on_table<max_pay_types){
				aux[elem_on_table]=new Hashtable<Object, Integer>();
				aux[elem_on_table].put(Credit, Value);
				PayTable.put(OutcomeType, aux[elem_on_table]);
				elem_on_table++;
			}else{
				System.out.println("Table at full capacity");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	int check_payout(Object OutcomeType, Object Credit){
		if(PayTable.containsKey(OutcomeType)){
			Hashtable<Object,Integer> tmp= (Hashtable<Object, Integer>) PayTable.get(OutcomeType);
			if(tmp.containsKey(Credit)){
				int i=(int) tmp.get(Credit);
				return i;
			}
			return 1;
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	void removeValue(Object OutcomeType, Object Credit){
		if(PayTable.containsKey(OutcomeType)){
			Hashtable<Object, Integer> tmp= (Hashtable<Object, Integer>) PayTable.get(OutcomeType);
			if(tmp.contains(Credit)){
				tmp.remove(Credit);
			}
			if(tmp.size()==0){
				PayTable.remove(tmp);
				elem_on_table--;
			}
		}	
	}
}
