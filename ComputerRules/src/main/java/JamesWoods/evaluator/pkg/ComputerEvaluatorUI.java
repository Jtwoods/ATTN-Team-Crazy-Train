package JamesWoods.evaluator.pkg;

import java.util.ArrayList;

/**
 * ComputerEvaluatorUI is a simple UI that allows a user to 
 * view the results of the ComputerEvaluator and allow for multiple 
 * evaluations. 
 * @author jameswoods
 *
 */
public class ComputerEvaluatorUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Build the computers to evaluate.
		Computer c1 = new Computer("Tundy 3000", 5, "none", 2, 800.00);
		Computer c2 = new Computer("Delaware", 3, "average", 8, 1500.00);
		Computer c3 = new Computer("Getaway", 1, "none", 1, 400.00);
		Computer c4 = new Computer("Decepticon", 4, "premium", 16, 3000.00);
		Computer c5 = new Computer("KingBook Pro", 5, "none", 32, 8000.00);
		Computer c6 = new Computer("ElectroPC", 2, "premium", 2, 5500.00);
		
		//Create an ArrayList of Computer elements to hold the Computers.
		ArrayList<Computer> computers = new ArrayList<Computer>();
		
		//Add the Computers to the ArrayList.
		computers.add(c1);
		computers.add(c2);
		computers.add(c3);
		computers.add(c4);
		computers.add(c5);
		computers.add(c6);
		
		//Instantiate a ComputerEvaluator object with the ArrayList of Computers.
		ComputerEvaluator eval = new ComputerEvaluator(computers);
		//Evaluate the computers.
		eval.evaluateComputers("ComputerEvaluationRules.drl");
		
		//Print the contents of the ComputerEvaluator.
		System.out.println(eval.toString());
		
		//Perform a second evaluation based on information from the first. 
		eval.evaluateComputers("ComputerEvaluationRulesFinal.drl");
	}

}
