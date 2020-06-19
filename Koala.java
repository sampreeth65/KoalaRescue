/**
 * A class to store the koala age and health
 *
 * @author Sampreeth Amith Kumar
 * @version 11.06.2020
 */
public class Koala
{
    //fields to set age and health of koala
    private int age;
    private int health;
    
    /**
     * Create Koala
     */
    public Koala()
    {
        age = 1;
        health = 1;
    }
    
    public Koala(int newAge,int newHealth)
    {
        if (newAge < 0 || newHealth < 0)
        {
            age = 1;
            health = 1;
        }
        else
        {
            age = newAge;
            health = newHealth;
        }
    }
    
    /**
     * Returns true if the koala of newAge and newHealth is present
     * @param newAge checks the koala with age
     * @param newHealth checks the koala with health
     */
    public boolean contains(int newAge,int newHealth)
    {
        if (newAge == age && newHealth == health)
            return true;
        return false;
    }
    
    /**
     * Displays the Age and health of koala
     */
    public void display()
    {
        System.out.println("Age of Koala: " + Integer.toString(getAge()) + " Health: " + Integer.toString(getHealth()));
    }
    
    /**
     * Create Koala with newAge and newHealth
     * @param newAge adds the age to the koala
     * @param newHealth adds the health to the koala
     */

    
    /**
     * Returns the age of the koala
     * @return int age of the koala
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Returns the Health of the Koala
     * @param int health of the koala
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Set age of koala
     * @param newAge changes the age of the koala
     */
    public void setAge(int newAge)
    {
        age = newAge;
    }
    
    /**
     * sets the health of the Koala
     * @param newHealth sets the health of the koala
     */
    public void setHealth(int newHealth)
    {
        health = newHealth;
    }
    
    /**
     * Returns the strings value of age and health of koala
     * @return String age and health
     */
    public String toString()
    {
        return "Age of Koala: " + Integer.toString(getAge()) + " Health: " + Integer.toString(getHealth());
    }
}