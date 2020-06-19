/**
 * Tree class to store the tree variety,usage and edible amount
 *
 * @author Sampreeth Amith Kumar
 * @version 11.06.2020
 */
public class Tree 
{
    //Fields to set variety,usage and edible
    private String variety;
    private String usage;
    private double edible;
    
    /**
     * Create Tree
     */
    public Tree()
    {
        variety = "Manna Gum";
        usage = "Food";
        edible = 1.0;
    }
    
    /**
     * Create Tree
     * @param newVariety adds the tree of given variety
     */
    public Tree(String newVariety)
    {
        if (newVariety == "Manna Gum")
        {
            variety = newVariety;
            usage = "Food";
            edible = 1.00;
        }
        else if (newVariety == "Swamp Gum")
        {
            variety = newVariety;
            usage = "Food";
            edible = 0.34;
        }
        else if (newVariety == "Blue Gum")
        {
            variety = newVariety;
            usage = "Food";
            edible = 0.90;
        }
        else if (newVariety == "River Red Gum")
        {
            variety = newVariety;
            usage = "Food";
            edible = 0.40;
        }
        else if (newVariety == "Wattle")
        {
            variety = newVariety;
            usage = "Shelter";
            edible = 0;
        }
        else 
        {
            variety = "Manna Gum";
            usage = "Food";
            edible = 1.0;
        }
    }
    
    /**
     * Prints the values of Tree type,usage and edible amount
     */
    public void display()
    {
        System.out.println("Tree Type: " + getVariety() + " Usage: " + getUsage() + " Edible: " + getEdible());
    }
    
    /**
     * Returns the Tree Edible amount
     * @return double Tree edible amount
     */
    public double getEdible()
    {
        return edible;
    }
    
    /**
     * Returns the Tree usage
     * @return String Tree usage
     */
    public String getUsage()
    {
        return usage;
    }
    
    /**
     * Returns the tree variety
     * @return String tree variety
     */
    public String getVariety()
    {
        return variety;
    }
    
    /**
     * Sets the Tree Edible amount
     * @param newEdible sets the Tree Edible amount
     */
    public void setEdible(double newEdible)
    {
        edible = newEdible;
    }
    
    /**
     * Sets the Tree Usage
     * @param newUsage sets the Tree Usage
     */
    public void setUsage(String newUsage)
    {
        usage =  newUsage;
    }
           
    /**
     * Sets the Tree Variety
     * @param newVariety sets the type of Tree
     */
    public void setVariety(String newVariety)
    {
        variety = newVariety;
    }

    /**
     * Returns the String values of Tree type,usage and edible amount
     * @return String values of Tree type,usagea dn edible amount
     */
    public String toString()
    {
        return "Tree Type: " + getVariety() + " Usage: " + getUsage() + " Edible: " + getEdible();  
    }
}
