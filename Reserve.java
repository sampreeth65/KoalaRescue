import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Reserve class to save koala at each point of observation
 *
 * @author sampreeth
 * @version 11.06.2020
 */
public class Reserve
{
   //fields Objects of ObservationPoint and SafeHaven
    private ObservationPoint[] pointOfObservation;
    private SafeHaven koalas;

    private static int injuredKoalaTakenToSafeHavenCount = 0;
    private static int koalaRelocatedCount = 0;
    private static int treeLostCount = 0;
    private static int koalaDeaths = 0;

    /**
     * Create Reserve 
     */
    public Reserve()
    {
        pointOfObservation = new ObservationPoint[10];
        koalas = new SafeHaven();
        addPredators();
        numberOfKoala();
        readFile();
    }
    
    /**
     * A random number 0-4 is choosen and set to number of predators at
     * each Observation point
     */
    public void addPredators()
    {
        RandomNumber predators; 
        for (int predatorIndex = 0; predatorIndex < 10; predatorIndex++)
        {
            predators = new RandomNumber(0, 4);
            pointOfObservation[predatorIndex] = new ObservationPoint(predators.getRandomNumber());
        }
    }
    
    /**
     * Once the trees are added to each observation point
     * Before the rescue begins, Probability of tree burnt of each type
     * at each observation point is updated.
     * @param observationPointIndex burns the tree at particular location.
     */
    public void burntTrees(int observationPointIndex) 
    {
        RandomNumber probabilityOfBurnt;
        for (int burntProbabilityCounter = 0; burntProbabilityCounter < 5; burntProbabilityCounter++)
        {
            probabilityOfBurnt = new RandomNumber(1,20);
            if (probabilityOfBurnt.getRandomNumber() == 20)
            {
                if (burntProbabilityCounter == 0)
                {
                    if (pointOfObservation[observationPointIndex].removeTree("Manna Gum"))
                        treeLostCount++;
                }
                else if (burntProbabilityCounter == 1)
                {
                    if (pointOfObservation[observationPointIndex].removeTree("Swamp Gum"))
                        treeLostCount++;
                }
                else if (burntProbabilityCounter == 2)
                {
                    if (pointOfObservation[observationPointIndex].removeTree("Blue Gum"))
                        treeLostCount++;
                }
                else if (burntProbabilityCounter == 3)
                {
                    if (pointOfObservation[observationPointIndex].removeTree("River Red Gum"))
                        treeLostCount++;
                }
                else if (burntProbabilityCounter == 4)
                {
                    if (pointOfObservation[observationPointIndex].removeTree("Wattle"))
                        treeLostCount++;   
                }
            }
        }
    }

    /**
     * Prints the total injured Koala taken to safe haven,
     * total koala relocated, total tree lost and total koala died,
     */
    public void display()
    {
        System.out.println("Injured Koala taken to Safe Haven: " + Integer.toString(injuredKoalaTakenToSafeHavenCount) +
        		"Koala Relocated to Observation point: " + Integer.toString(koalaRelocatedCount) + "Toatal Tree Lost: " + Integer.toString(treeLostCount)
        		+ "Total Koala Died: " + Integer.toString(koalaDeaths));
    }

    /**
     * Returns the available food at particular point
     * @param observationPointIndex returns the food available at given observation point
     * @return double returns the avaialble food at the obseration point
     */
    public double foodAvailable(int observationPointIndex)
    {
        return pointOfObservation[observationPointIndex].avaiableFood();
    }

    /**
     * Returns the Injured Koala taken to safe haven
     * @return int injured koala taken to safe haven
     */
    public int getInjuredKoalaTakenToSafeHavenCount()
    {
        return injuredKoalaTakenToSafeHavenCount;
    }

    /**
     * Returns the number of koala died
     * @return int Koala died
     */
    public int getKoalaDeaths()
    {
        return koalaDeaths;
    }

    /**
     * Returns the number of koala relocated back to observation point
     * @return int number of koala relocated back to observation point
     */
    public int getKoalaRelocatedCount()
    {
        return koalaRelocatedCount;
    }

    /**
     * Returns the number of Trees lost
     * @return int number of Trees lost due to burnt trees
     */
    public int getTreeLost()
    {
        return treeLostCount;
    }

    /**
     * Koala is moved back from Safe Haven to Location
     * @param observationPointIndex point of observation
     * @return true when koala moved back to location was successful.
     */
    public boolean moveFromSafeHaven(int observationPointIndex)
    {
        if ((pointOfObservation[observationPointIndex].getPredators() < 3) && 
        ((int) foodAvailable(observationPointIndex) > (numberOfHealthyKoalas(observationPointIndex) + numberOfInjuredKoalas(observationPointIndex))) && 
        numberOfShelterTree(observationPointIndex) > (numberOfHealthyKoalas(observationPointIndex) + numberOfInjuredKoalas(observationPointIndex)))
        {
            if (koalas.getNumberOfHealthyKoala() >= 1)
            {
                int koalaAge = koalas.oldestHealthyKoala();
                pointOfObservation[observationPointIndex].addKoala(koalaAge, 1);
                if (koalas.removeKoala(koalaAge, 1))
                {
                    koalaRelocatedCount++;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Move healthy koala to Safe Haven 
     * @param observationPointIndex point of observation
     * @return true when the healthy Koala moved to Safe Haven 
     * was successful.
     */
    public boolean moveHealthyToSafeHaven(int observationPointIndex)
    {
        if (pointOfObservation[observationPointIndex].getNumberOfHealthyKoala() >= 1)
        {
            int koalaAge = pointOfObservation[observationPointIndex].getKoalaAge(1);
            koalas.addKoala(koalaAge, 1);
            if (pointOfObservation[observationPointIndex].removeKoala(koalaAge, 1))
                return true;
        }
        return false;
    }

    /**
     * Move Injured Koala to Safe Haven
     * @param observationPointIndex point of observation
     * @return true when the Injured Koala moved to Safe Haven was
     * successful
     */
    public boolean moveInjuredToSafeHaven(int observationPointIndex)
    {
        if (pointOfObservation[observationPointIndex].getNumberOfInjuredKoala() >= 1)
        {
            int koalaAge = pointOfObservation[observationPointIndex].getKoalaAge(0);
            koalas.addKoala(koalaAge, 0);
            if (pointOfObservation[observationPointIndex].removeKoala(koalaAge, 0))
            {
                injuredKoalaTakenToSafeHavenCount++;
                return true;
            }
        }
        return false;
    }

    /**
     * When the user enter no action
     * Injured koala not moved to Safe Haven dies
     * @param observationPointIndex point of observation
     * @return int number of koala that died because it could not be saved
     */
    public int noAction(int observationPointIndex)
    {
        RandomNumber notSurvivingFromFood;
        RandomNumber notSurvivingFromShelter;
        int koalaDeath = pointOfObservation[observationPointIndex].killInjuredKoala();
        double food = pointOfObservation[observationPointIndex].avaiableFood();
        int numberOfkoalas = pointOfObservation[observationPointIndex].getNumberOfHealthyKoala() + 
                             pointOfObservation[observationPointIndex].getNumberOfInjuredKoala();
        if (numberOfkoalas > food )
        {
            int excess = (numberOfkoalas - (int) food);
            for (int count = 0; count < excess; count++)
            {
                notSurvivingFromFood = new RandomNumber(1, 100);
                if(notSurvivingFromFood.getRandomNumber() < 80)
                    koalaDeath = koalaDeath + pointOfObservation[observationPointIndex].killKoala();
            }
        }
        int numberOfShelterTrees = pointOfObservation[observationPointIndex].numberOfShelterTree();
        if (numberOfkoalas > numberOfShelterTrees)
        {
            int excess = numberOfkoalas - numberOfShelterTrees;
            for (int count = 0; count < excess; count++)
            {
                notSurvivingFromShelter = new RandomNumber(1, 100);
                if(notSurvivingFromShelter.getRandomNumber() < 20)
                    koalaDeath = koalaDeath + pointOfObservation[observationPointIndex].killKoala();
            }
        }
        int numberOfPredators = pointOfObservation[observationPointIndex].getPredators();
        if (numberOfPredators > 3)
        {
            RandomNumber notSurvivingFromPredator = new RandomNumber(1, 100);
            if(notSurvivingFromPredator.getRandomNumber() < 50)
                koalaDeath = koalaDeath + pointOfObservation[observationPointIndex].killKoala();
        }
        koalaDeaths = koalaDeaths + koalaDeath;
        return koalaDeath;
    }

    
    /**
     * Returns the number of healthy koala at observation point
     * @param observationPointIndex helps in retreiving the healthy koala at particular
     * observation point
     * @return int number of healthy koala at observation point
     */
    public int numberOfHealthyKoalas(int observationPointIndex)
    {
        return pointOfObservation[observationPointIndex].getNumberOfHealthyKoala();
    }

    /**
     * Returns the number of Injured koala at observation point
     * @param ObservationPointIndex helps in retreiving the healthy koala at particular
     * observation point
     * @return int number of Injured koala at observation point
     */
    public int numberOfInjuredKoalas(int observationPointIndex)
    {
        return pointOfObservation[observationPointIndex].getNumberOfInjuredKoala();
    }

    /**
     * A random number of Koala is selected and added to each 
     * Observation point. 
     * Total Koala added includes 0-9 healthy koala and 0-2 Injured Koala
     */
    public void numberOfKoala()
    {
        RandomNumber koalaAge;
        RandomNumber koalaHealthy;
        RandomNumber koalaInjured;
        for (int observationPointIndex = 0; observationPointIndex < pointOfObservation.length ; observationPointIndex++)
        {
            koalaHealthy = new RandomNumber(0,9);
            koalaInjured = new RandomNumber(0,2);
            for (int healthyKoalaCount = 0; healthyKoalaCount < koalaHealthy.getRandomNumber(); healthyKoalaCount++)
            {
                koalaAge = new RandomNumber(1,18);
                pointOfObservation[observationPointIndex].addKoala(koalaAge.getRandomNumber(),1);
            }
            for (int healthyKoalaCount = 0; healthyKoalaCount < koalaInjured.getRandomNumber(); healthyKoalaCount++)
            {
                koalaAge = new RandomNumber(1,18);
                pointOfObservation[observationPointIndex].addKoala(koalaAge.getRandomNumber(), 0);
            }
        }
    }

    

    /**
     * Returns the number of predators at the observation Point
     * @param observationPointIndex helps in retreving number of predators at particular 
     * observation point
     * @return int number of predators at particular observation point
     */
    public int numberOfPredators(int observationPointIndex)
    {
        return pointOfObservation[observationPointIndex].getPredators();
    }

    /**
     * Returns the number of shelter tree at particular location
     * @param observationPointIndex helps in retreving number of shelter tree
     * at particular location
     * @return int number of shelter trees at observation point
     */
    public int numberOfShelterTree(int observationPointIndex)
    {
        return pointOfObservation[observationPointIndex].numberOfShelterTree();
    }

    /**
     * Read data from txt file
     */
    public void readFile()
    {
        String fileName = "trees.txt";
        int observationPointIndex = 0;
        String[] values = new String[5];  //Do exception checking here.
        try
        {
            FileReader inputFile = new FileReader(fileName);
            Scanner parser = new Scanner(inputFile);
            String line = "";
            while (parser.hasNext())
            {
                line = parser.nextLine();
                values = line.split(",");
                for (int lineIndex = 0; lineIndex < 5; lineIndex++)
                {
                    if (lineIndex == 0)
                    {
                        for (int count = 0; count < (Integer.parseInt(values[lineIndex])); count++)
                        {
                            pointOfObservation[observationPointIndex].addTree("Manna Gum");
                        }
                    }
                    else if (lineIndex == 1)
                    {
                        for (int count = 0; count < (Integer.parseInt(values[lineIndex])); count++)
                        {
                            pointOfObservation[observationPointIndex].addTree("Swamp Gum");
                        }
                    }
                    else if (lineIndex == 2)
                    {
                        for (int count = 0; count < (Integer.parseInt(values[lineIndex])); count++)
                        {
                            pointOfObservation[observationPointIndex].addTree("Blue Gum");
                        }
                    }
                    else if (lineIndex == 3)
                    {
                        for (int count = 0; count < (Integer.parseInt(values[lineIndex])); count++)
                        {
                            pointOfObservation[observationPointIndex].addTree("River Red Gum");
                        }
                    }
                    else if (lineIndex == 4)
                    {
                        for (int count = 0; count < (Integer.parseInt(values[lineIndex])); count++)
                        {
                            pointOfObservation[observationPointIndex].addTree("Wattle");
                        }
                    }
                }
                burntTrees(observationPointIndex);
                observationPointIndex++;
            }
            inputFile.close();
            parser.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(fileName + " not found");
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println("Array Index Out Of Bound");
        }
        catch (NoSuchElementException exception)
        {
            System.out.println("File has only 10 observation point. More Objects of ObservationPoint were created.");
        }
        catch (Exception exception)
        {
            System.out.println("Exception Occured.");
        }
    }


    /**
     * Sets the Number of Injured Koala taken to safe haven
     * @param newInjuredKoalaTakenToSafeHavenCount sets the number of injured 
     * koala taken to Safe Haven
     */
    public void setInjuredKoalaTakenToSafeHavenCount(int newInjuredKoalaTakenToSafeHavenCount)
    {
        injuredKoalaTakenToSafeHavenCount = newInjuredKoalaTakenToSafeHavenCount;
    }

    /**
     * Sets the Number of koala death 
     * @param newKoalaDeaths sets the number of koala deaths 
     */
    public void setKoalaDeaths(int newKoalaDeaths)
    {
        koalaDeaths = newKoalaDeaths;
    }

    /**
     * Sets the number of koala relocated
     * @param newKoalaRelocatedCount sets the number of koala relocated
     * to observation point
     */
    public void setKoalaRelocatedCount(int newKoalaRelocatedCount)
    {
        koalaRelocatedCount = newKoalaRelocatedCount;
    }

    /**
     * Sets the number of Tree Lost 
     * @param newTreeLost sets the number of tree lost
     */
    public void setTreeLost(int newTreeLost)
    {
        treeLostCount = newTreeLost;
    }
    
    public String toString()
    {
        return "Injured Koala taken to Safe Haven: " + Integer.toString(injuredKoalaTakenToSafeHavenCount) +
        		"Koala Relocated to Observation point: " + Integer.toString(koalaRelocatedCount) + "Toatal Tree Lost: " + Integer.toString(treeLostCount)
        		+ "Total Koala Died: " + Integer.toString(koalaDeaths);
    }
    /**
     * updateTree updates the tree value to the 
     * updateTree.txt file 
     */

    /**
     * Returns the Total Healthy Koala at Observation Point
     * @param observationPointIndex helps in retreving of total healthy 
     * at particular location
     * @return int total healthy koala at a particular location
     */
    public int totalHealthyKoala(int observationPointIndex)
    {
        return pointOfObservation[observationPointIndex].getNumberOfHealthyKoala() + koalas.getNumberOfHealthyKoala();
    }

    /**
     * Returns the String that contains number of Injured koala,
     * Koala reloacted to observation point, Total tree lost and Total Koala Died
     * @return String Returns the String that contains number of Injured koala,
     * Koala reloacted to observation point, Total tree lost and Total Koala Died
     */

    public void updateTree()
    {
        try
        {
            PrintWriter outPutFile = new PrintWriter("update.txt");
            for (int observationPointIndex = 0; observationPointIndex < 10; observationPointIndex++)
            {
                String treeCount = pointOfObservation[observationPointIndex].getTreeCount();
                outPutFile.println(treeCount);  
            }
            outPutFile.close();
        }
        catch (IOException exception)
        {
            System.out.println("Exception: File not accessed.");
        }
    }

}