package JamesWoods.evaluator.pkg;

import java.util.ArrayList;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * ComputerEvaluator allows for the input and storage of descriptions of computers as Computer objects
 * and uses .drl files to evaluate these computers in various ways.  The evaluation information is saved 
 * in the Computer object so that the Computer can be evaluated again based on the results of the first 
 * evaluation.
 * @author jameswoods
 *
 */
public class ComputerEvaluator {

	/**
	 * computers is an ArrayList of Computer objects that will be evaluated 
	 * using a drool .drl rule set
	 */
	ArrayList<Computer> computers;

	/**
	 * ComputerEvaluator initializes the computers ArrayList with the computersArrayList
	 * given it during instantiation.
	 * @param computersArray is an ArrayList of Computer class object elements
	 */
	public ComputerEvaluator(ArrayList<Computer> computersArray) {
		
		computers = computersArray;
		
	}
	
	/**
	 * evaluateComputers uses a drool .drl file to evaluate all of the 
	 * Computer objects in the computers ArrayList according to the given rules.
	 * evaluateComputers uses readKnowledgeBase to help open and set up a KnowledgeBase.
	 */
	public void evaluateComputers(String toRead) {
		//Try using readKnowledgeBase and catch any exceptions.
		try {
	        // load up the knowledge base
	        KnowledgeBase kbase = readKnowledgeBase(toRead);
	        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
	        
	        //Create a KnowledgeRuntimeLogger and give it the StatefulKnowledgeSession.
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "Computer Evaluation");
	            
	        //Iterate through the computers ArrayList and "fire" the tests for each
	        //Computer.
	        for(int i = 0; i < computers.size(); i++){
	        	ksession.insert(computers.get(i));
	        	ksession.fireAllRules();
	        }
	        //Close the logger, which will release the resources that it has been given.
	        logger.close();
	        
	    //Catch any exceptions and print the stack trace.         
	    } catch (Throwable t) {
	         t.printStackTrace();
	    }
		
	}
	
	/**
	 * readKnowledgeBase is a helper method to the ComputerEvaluator and provides assistance by opening 
	 * a .drl file that contains rules, checking for errors, printing any errors, and returning the KnowledgeBase.
	 * @param knowledge the name of the .drl file that contains rules for evaluating computers.
	 * @return kbase the KnowledgeBase that is being constructed with the rules on the .drl file.
	 * @throws Exception
	 */
    private static KnowledgeBase readKnowledgeBase(String knowledge) throws IllegalArgumentException {
    	//Create a KnowledgeBuilder object
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        //Add the .drl file resource 
        kbuilder.add(ResourceFactory.newClassPathResource(knowledge), ResourceType.DRL);
        //Check for errors
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        //Print any errors and throw an exception if there were any errors.
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        //Create a KnowledgeBase object and add the KnowledgeBuilder packages to it using getKnowledgePackages() method.
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        
        //Return the KnowledgeBase
        return kbase;
    }
	
	/**
	 * toString provides a neatly formatted String of data representing all 
	 * information for each Computer in the ComputerEvaluator.
	 */
	public String toString(){
		
		//Create a StringBuffer to hold the String data as it is being built.
		StringBuffer toReturn = new StringBuffer();
		
		//Iterate through the ArrayList of Computer elements and add their 
		//information to the StringBuffer.
		for(int i = 0; i < computers.size(); i++)
			toReturn.append("\n" + computers.get(i).toString());
		
		//convert the StringBuffer to String and return it.
		return toReturn.toString();
	}
}
