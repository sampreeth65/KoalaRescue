import java.util.ArrayList;
/**
 * A class to rescue the injured koala
 *
 * @author Sampreeth Amith Kumar
 * @version 11.06.2020
 */
public class SafeHaven
{
    //ArrayList of Koala
    private ArrayList<Koala> koalas;
    
    /**
     * Create SafeHaven
     */
    public SafeHaven()
    {
        koalas = new ArrayList<>();
    }
    
    /**
     * Create SafeHaven 
     */
    public SafeHaven(int newAge,int newHealth)
    {
    	if (newAge < 0 || newHealth < 0)
    	{
    		koalas = new ArrayList<>();
            addKoala(0,0);
    	}
    	else
    	{
    		koalas = new ArrayList<>();
            addKoala(newAge,newHealth);
    	}
    }
    
    
    /**
     * Add koala to the array list
     * @param newAge adds the age
     * @param newHealth adds the health
     */
    public void addKoala(int newAge,int newHealth)
    {
        koalas.add(new Koala(newAge,newHealth));
    }
    
    /**
     * Displays the Number of healthy and injured koala in the list. 
     */
    public void display()
    {
        System.out.println("Number of Koala Injured: " + Integer.toString(getNumberOfInjuredKoala()) + 
            " Number of healthy Koala: " + Integer.toString(getNumberOfHealthyKoala())) ;
    }
    
    /**
     * Returns the arraylist of koalas
     * @return ArrayList<Koala> returns the list of koala objects
     */
    public ArrayList<Koala> getKoalas()
    {
        return koalas;
    }

    /**
     * Return Number of Healthy Koala in the array list
     * @return int number of healthy koala in the array list. 
     */
    public int getNumberOfHealthyKoala() 
    {
        int countHealthyKoala = 0;
        for (int index = 0; index < koalas.size(); index++)
        {
            Koala newKoala = koalas.get(index);
            if ( newKoala.getHealth() == 1)
                countHealthyKoala++;
        }
        return countHealthyKoala;
    }
    
    /**
     * Return the Number of Injured Koala in the array list
     * @return int the number of Injured Koala in the array list
     */
    public int getNumberOfInjuredKoala()
    {
        int countInjuredKoala = 0;
        for (int index = 0; index < koalas.size(); index++)
        {
            Koala newKoala = koalas.get(index);
            if ( newKoala.getHealth() == 0)
                countInjuredKoala++;
        }
        return countInjuredKoala;
    }
    
    /**
     * Returns the oldest Healthy koala in the array list
     * @return int oldest Healthy Koala in the array list
     */
    public int oldestHealthyKoala()
    {
        int newHealth = 1;
        int oldest = 1;
        for (int index = 0; index < koalas.size(); index++)
        {
            Koala newKoala = koalas.get(index);
            if ((newKoala.getAge() > oldest) && (newKoala.getHealth() == newHealth))
                oldest = newKoala.getAge();
        }
        return oldest;
    }

    /**
     * Remove koala from the array list
     * @param newAge looks for koala with a particular age
     * @param newHealth looks for koala with a same health
     */
    public boolean removeKoala(int newAge,int newHealth)
    {
        for (int index =0; index < koalas.size(); index++)
        {
            Koala newKoala = koalas.get(index);
            if (newKoala.contains(newAge,newHealth))
            {
                koalas.remove(index);
                return true;
            }
        } 
        return false;
    }
    
    /**
     * Returns the Number of Healthy and Injured Koala in the list
     * @return the number of healthy and injured koala in the list
     */
    public String toString()
    {
        return "Number of Koala Injured: " + Integer.toString(getNumberOfInjuredKoala()) + 
        " Number of healthy Koala: " + Integer.toString(getNumberOfHealthyKoala()) ;
    }
}
