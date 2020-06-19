/**
 * A class to generate integer RandomNumber in the given range.
 *
 * @author Sampreeth Amith Kumar 
 * @version 04/05/2020
 */
public class RandomNumber
{
	//randomNumber to store the generated random integer.
    private int randomNumber;
    /**
     * Create a RandomNumber from 0 to 1
     */
    public RandomNumber()
    {
        randomNumber = (int) (Math.random() * (1 - 0 + 1) + 0);
    }
    
    /**
     * Create a RandomNumber from minimum to maximun value.
     * @param min is the minimum value to start from
     * @param max is the maximun range from minimum value.
     */
    public RandomNumber(int min,int max)
    {
        randomNumber = (int) (Math.random() * (max - min + 1) + min);
    }
    
    /**
     * Prints the random number 
     */
    public void display()
    {
        System.out.println("RandomNumber: " + Integer.toString(getRandomNumber()));
    }
    /**
     * Return random number 
     * @return random number 
     */
    public int getRandomNumber()
    {
        return randomNumber;
    }

    /**
     * Returns the random number 
     * @return returns the random number in String formate. 
     */
    public String toString()
    {
        return "RandomNumber: " + Integer.toString(getRandomNumber());
    }
}
