package stuff;
import game.*;

public class Main {

	public static void main(String[] args) {
		Credit credit = new Credit(4);
		System.out.println(credit.getActual_credit());
		credit.bet(4);
		System.out.println("Inicialmente tinhas este crédito: " + credit.getInitial_credit() + ".");
		System.out.println("Agora tens este crédito: " + credit.getActual_credit() + ".");
	}

}
