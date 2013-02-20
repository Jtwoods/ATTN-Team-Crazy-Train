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
	 * main creates six computers using the computer attributes described in the 
	 * Rally Software, Team Crazy Train, project assignment and adds these
	 * to a ComputerEvaluator.  Then the evaluateComputers method is called 
	 * with a String which is the name of the Drools file being used for the evaluation.
	 * Two evaluations are made, the first runs the initial rule set given in the assignment
	 * and the second runs the additional rules designed to answer the questions posed at
	 * the end of the assignment.
	 *  
	 * @param args arguments to be passed to main on startup (not used)
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
