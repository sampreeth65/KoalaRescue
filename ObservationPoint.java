import java.util.ArrayList;
import java.util.Iterator;
/**
 * A class that stores value of each observation point
 *
 * @author Sampreeth Amith Kumar
 * @version 11.06.2020
 */
public class ObservationPoint
{
    //ArrayList of tree and koala class
    private ArrayList<Tree> trees; 
    private ArrayList<Koala> koalas; 
    private int predators;
    
    /**
     * Create ObservationPoint
     */
    public ObservationPoint() 
    {
        trees = new ArrayList<>();
        koalas = new ArrayList<>();
        predators = 0;
    }
    
    /**
     * Create ObservationPoint
     * @param adds predators to observation point
     */
    public ObservationPoint(int newPredators)
    {
        if (newPredators < 0)
        {
            predators  = 0;
            trees = new ArrayList<>();
            koalas = new ArrayList<>();
        }
        else
        {
            trees = new ArrayList<>();
            koalas = new ArrayList<>();
            predators = newPredators;
        }
    }
    
    /**
     * add koala to the array list of koala
     * @param newAge,newHealth adds the koala of newAge and 
     * newHealth to array list of koala
     */
    public void addKoala(int newAge, int newHealth)
    {
        koalas.add(new Koala(newAge,newHealth));
    }
    
    /**
     * Adds tree to the array list of trees
     * @param newVariety adds the new type of tree
     */
    public void addTree(String newVariety)
    {
        trees.add(new Tree(newVariety));
    }
    
    /**
     * Returns the available food at observation point
     * @return double value of food available at observation point
     */
    public double avaiableFood()
    {
        double edibleFood = 0;
        for (int i = 0; i < trees.size() ; i++ )
        {
            Tree newTree = trees.get(i);
            edibleFood = edibleFood + newTree.getEdible();
        }
        return edibleFood;
    }
    
    /**
     * Displays the Number of koalas,predators,HealthyKoala,InjuredKoala
     */
    public void display()
    {
        System.out.println("Number of Koala: " + koalas.size() + "Number of Trees: " + trees.size() + 
                "Number of Predators: " + getPredators() +
                "Number of Healthy Koala: " + getNumberOfHealthyKoala() + 
                "Number of Injured Koala: " + getNumberOfInjuredKoala());
    }
    
    /**
     * Returns koalas in observation point
     * @return ArrayList<Koala> returns koala in array list.
     */
    public ArrayList<Koala> getKoala()
    {
        return koalas;
    }
    
    /**
     * returns the koala age
     * @return int koala age
     */
    public int getKoalaAge(int newHealth)
    {
        int age;
        for (int index = 0; index < koalas.size() ; index++)
        {
            Koala newKoala = koalas.get(index);
            if ( newKoala.getHealth() == newHealth)
            {
                age = newKoala.getAge();
                return age;
            }   
        }
        return -1;
    }
    
    /**
     * Returns number of Healthy Koalas
     * @return int number of healthy koala
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
     * Returns number of Injured Koala
     * @return int number of Injured Koala
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
     * Returns numbers of predators in observation point
     * @return int number of predators.
     */
    public int getPredators()
    {
        return predators;
    }
    
    /**
     * Returns Number of trees in the observation point
     * @return String Number of trees of each type are returned. 
     */
    public String getTreeCount()
    {
        int treeMannaGum = 0;
        int treeSwampGum = 0;
        int treeBlueGum = 0;
        int treeRiverRed = 0;
        int treeWattle = 0;
        Iterator<Tree> iterate = trees.iterator();
        while(iterate.hasNext())
        {
            //System.out.println(iterate.next().getVariety());
            String treeType = iterate.next().getVariety();
            if (treeType == "Manna Gum" )
                treeMannaGum++;
            else if (treeType == "Swamp Gum")
                treeSwampGum++;
            else if (treeType == "Blue Gum")
                treeBlueGum++;
            else if (treeType == "River Red Gum")
                treeRiverRed++;
            else if (treeType == "Wattle")
                treeWattle++;
            
        }
        return Integer.toString(treeMannaGum) + "," + Integer.toString(treeSwampGum) + "," + 
                Integer.toString(treeBlueGum) + "," + Integer.toString(treeRiverRed) + "," +
                Integer.toString(treeWattle);
    }
    
    /**
     * Returns trees in observation point
     * @return ArrayList<Tree> returns trees in array list.
     */
    public ArrayList<Tree> getTrees()
    {
        return trees;
    }
    
    /**
     * Returns the one when the Injured koala was removed from the list.
     * @return int zero when the injured koala was not removed
     * from the list.
     */
    public int killInjuredKoala()
    {
        int numberOfKill = 0;
        Iterator<Koala> iterate = koalas.iterator();
        while(iterate.hasNext())
        {
            if (iterate.next().getHealth() == 0 )
            {
                numberOfKill++;
                iterate.remove();
            }
        }
        return numberOfKill;
    }
    
    /**
     * Returns one when the koala was removed from the list
     * @return int zero when the koala was not removed from the list. 
     */
    public int killKoala()
    {
        if (koalas.size() >= 1)
        {
            Koala newKoala = koalas.get(1);
            removeKoala(newKoala.getAge(),newKoala.getHealth());
            return 1;
        }
        return 0;
    }
    
    /**
     * returns the number of shelter tree
     * @return int number of Shelte Tree
     */
    public int numberOfShelterTree()
    {
        int shelterTrees = 0;
        for (int index = 0; index < trees.size() ; index++ )
        {
            Tree newTree = trees.get(index);
            if (newTree.getVariety().equals("Wattle"))
                shelterTrees++;
        }
        return shelterTrees;
    }
    
    /**
     * Removes one koala of the given age and health
     * @param newAge,newHealth removes the koala of type newAge 
     * and newHealth
     * @return true when the remove koala of type newAge and newHealth
     * is successful
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
     * removeTree removes particular tree from the array list
     * @param newVariety removes the tree of type newVariety
     * Only first element of that type is removed
     * @return true when the remove was successful. 
     */
    public boolean removeTree(String newVariety)
    {
        Iterator<Tree> iterate = trees.iterator();
        while(iterate.hasNext())
        {
            if (iterate.next().getVariety() == newVariety )
            {
                iterate.remove();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Sets the number of predators 
     * @param newPredators sets number of predators at location
     */
    public void setPredators(int newPredators)
    {
        predators = newPredators;
    }
 
    /**
     * Returns the Number of koalas,predators,HealthyKoala,InjuredKoala
     * @return String the Number of koala,predators,HealthyKoala and Injured
     * Koala
     */
    public String toString()
    {
        return "Number of Koala: " + koalas.size() + "Number of Trees: " + trees.size() + 
                "Number of Predators: " + getPredators() +
                "Number of Healthy Koala: " + getNumberOfHealthyKoala() + 
                "Number of Injured Koala: " + getNumberOfInjuredKoala();
    }
}