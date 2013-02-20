package JamesWoods.evaluator.pkg;

import java.util.ArrayList;

/**
 * The Computer class of objects stores information about a computer 
 * and relays this information to clients of the computer class through
 * five public methods: getModelName(), getCPUSpeed(), getGraphicsCard(), 
 * getMemory(), and getPrice().
 * @author jameswoods
 *
 */
public class Computer {

	/**
	 * modelName is the computers model name or type
	 */
	private String modelName;
	
	/**
	 * cpuSpeed is the speed of the CPU in GHz
	 */
	private int cpuSpeed;
	
	/**
	 * graphicsCard is the graphics card description (none, average, or premium)
	 */
	private String graphicsCard;
	
	/**
	 * memory is the memory size in GB
	 */
	private int memory;
	
	/**
	 * price is the price of the machine in dollars
	 */
	private double price;
	
	/**
	 * description is an arrayList of descriptive qualities assigned by the
	 * ComputerEvaluatorRules
	 */
	private ArrayList<String> description;
	
	/**
	 * Computer is the constructor for the Computer class object and provides 
	 * initialization of five data members: modelName, cpuSpeed, graphicsCard,
	 * memory, and price.  Throws an IllegalArgumentException if the 
	 * parameter card is not one of the three possible: none, average, premium.
	 * @param name is the name of the computer.
	 * @param speed is the CPU speed (in GHz).
	 * @param card is the graphics card type (none, average, or premium)
	 * @param ram is the memory size (in GB)
	 * @param cost is the price of the machine (in dollars)
	 */
	public Computer(String name, int speed, String card, int ram, double cost){
		//Verify that the graphics card type is a correct value.
		//If it is not throw an IllegalArgumentException.
		if("none".equals(card) || "average".equals(card) || "premium".equals(card))
			graphicsCard = card;
		else
			throw new IllegalArgumentException();
		//Set the remaining data members. 
		modelName = name;
		cpuSpeed = speed;
		memory = ram;
		price = cost;
		
		//initialize the description ArrayList
		description = new ArrayList<String>();
	}

	/**
	 * addDescriptor allows clients of the Computer class to 
	 * add descriptions to the computer object.
	 */
	public void addDescription(String described){
		description.add(described);
	}
	
	/**
	 * getModelName returns the Computer's model name.
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * setModelName changes the Computer's model name to the one given in the param.
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * getCpuSpeed returns the Computer's CPU speed.
	 * @return the cpuSpeed
	 */
	public int getCpuSpeed() {
		return cpuSpeed;
	}

	/**
	 * setCpuSpeed changes the CPU speed of the Computer to the one given in param.
	 * @param cpuSpeed the cpuSpeed to set
	 */
	public void setCpuSpeed(int cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	/**
	 * getGraphicsCard returns the graphics card information for the Computer.
	 * @return the graphicsCard
	 */
	public String getGraphicsCard() {
		return graphicsCard;
	}

	/**
	 * setGraphicsCard sets the graphics card type for the Computer and performs minimal
	 * checking to ensure that the graphics card is of type: none, average, or premium. 
	 * @param graphicsCard the graphicsCard to set
	 */
	public void setGraphicsCard(String graphicsCard) {
		if("none".equals(graphicsCard) || "average".equals(graphicsCard) || "premium".equals(graphicsCard))
			this.graphicsCard = graphicsCard;
		else
			throw new IllegalArgumentException();
	}

	/**
	 * getMemory returns the memory of the Computer.
	 * @return the memory
	 */
	public int getMemory() {
		return memory;
	}

	/**
	 * setMemory changes the memory of the Computer.
	 * @param memory the memory to set
	 */
	public void setMemory(int memory) {
		this.memory = memory;
	}

	/**
	 * getPrice returns the price of the Computer.
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * setPrice changes the Computer's price.
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * descriptionContains allows clients to check the content
	 * of the description arrayList for a specific value.
	 * @param toCheck the value to check the ArrayList for.
	 * @return whether the ArrayList contains the specified value or not.
	 */
	public boolean descriptionContains(String toCheck){
		
		return description.contains(toCheck);
			
	}
	
	/**
	 * toString provides clients with a neatly formatted String
	 * representing the information contained in the Computer object.
	 * @return the String representation of the objects state.
	 */
	public String toString(){
		//Create a StringBuffer to house the formatted information
		//as it is being built.
		StringBuffer toReturn = new StringBuffer();
		
		//Add the Computer object's information to the StringBuffer
		toReturn.append(modelName + ":\n" + 
				memory + " GB\n" +
				cpuSpeed + " GHz\n" +
				graphicsCard + "\n" +
				"$" + price + "\n");
		
		//If description is not empty add the descriptions to the StringBuffer while adding
		//proper format.
		if(description.size() > 0){
			toReturn.append("This computer ");
			for(int i = 0; i < description.size(); i++){
				toReturn.append(description.get(i));
				if(i < description.size() - 2 && description.size() >= 3)
					toReturn.append(", ");
				if(i == description.size() - 2 && description.size() >= 3)
					toReturn.append(", and ");
				if(i == description.size() - 2 && description.size() == 2)
					toReturn.append(" and ");
			}
			//Add a period and white space for formatting.
		    toReturn.append(".\n");
		}
	    
	    //Convert the StringBuffer to a String and return.
	    return toReturn.toString();
		
	}
	
	
}
