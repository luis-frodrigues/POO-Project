package strategy;

import game.Hand;
import stats.Credit;
import stats.Statistics;

/**
 * This is a public abstract class which provides to the
 * user the information that the extended classes must
 * implement the methods CheckResult and Advice.
 * @author Luís Rodrigues
 * @author Eduardo Crespo
 * @author Eurico Lopes
 *
 */
public abstract class Strategy {

	public static String CheckResult(Hand hand, Credit credit, PayTable107 paytable, Statistics statistics){ 
		return null;
	}
	public static String Advice(Hand hand) {
		return null;
	}
}
