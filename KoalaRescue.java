import java.util.Scanner;
/**
 * A class to rescue the koala
 *
 * @author Sampreeth Amith Kumar
 * @version 11.06.2020
 */
public class KoalaRescue
{
    //Object of reserve and field to store budget
    private Reserve reserve;
    private double budget;

    /**
     * Create KoalaRescue 
     */
    public KoalaRescue()
    {
        reserve = new Reserve();
        welcomeMessage();
        enterName();
        budget = enterBudget();
        visitPointOfObservation();
    }

    /**
     * User entered action To perform
     * @param newPoint observation point number
     * @return double amount spent of operation
     */
    public double actionToPerform(int newPoint)
    {
        Scanner scan = new Scanner(System.in);
        String choice;
        double amountSpent = 0;
        boolean flag = true;
        do {
            System.out.println("Menu Options: ");
            System.out.println("A: Move an Injured Koala to Safe Haven");
            System.out.println("B: Move a Healthy Koala to safe Haven");
            System.out.println("C: Relocate a koala to this location");
            System.out.println("D: No further action");
            System.out.print("Enter your choice: ");
            choice = scan.next();
            if ((choice.equals("a")) || 
                (choice.equals("A")))
            {
                if (budget >= 20)
                {
                    if(reserve.moveInjuredToSafeHaven(newPoint))
                    {
                        budget = budget - 20;
                        amountSpent = amountSpent + 20;
                        System.out.println("------------------------------------------");
                        System.out.println();
                        System.out.println("Injured Koala moved to Safe Haven.");
                        System.out.println("It Costed $20");
                        System.out.println();
                        System.out.println("------------------------------------------");
                    }
                    else
                    {
                        System.out.println("------------------------------------------");
                        System.out.println();
                        System.out.println("!!Unsuccessfull!!");
                        System.out.println("No Injured Koala to move.");
                        System.out.println();
                        System.out.println("------------------------------------------");
                    }
                }

                else
                {
                    System.out.println("------------------------------------------");
                    System.out.println();
                    System.out.println("Available budget is below $20.");
                    System.out.println();
                    System.out.println("------------------------------------------");
                }
                displayAtLocation(newPoint);
            }
            else if ((choice.equals("b")) || 
                      (choice.equals("B")))
            {
                if (budget >= 10)
                {
                    if (reserve.moveHealthyToSafeHaven(newPoint))

                    {
                        budget = budget - 10;
                        amountSpent = amountSpent + 10;
                        System.out.println("------------------------------------------");
                        System.out.println();
                        System.out.println("Healthy Koala moved to Safe Haven.");
                        System.out.println("It Costed $10");
                        System.out.println();
                        System.out.println("------------------------------------------");
                    }
                    else
                    {
                        System.out.println("------------------------------------------");
                        System.out.println();
                        System.out.printf("%30s %n","!!Unsuccessfull!!");
                        System.out.println("No Healthy Koala to move.");
                        System.out.println();
                        System.out.println("------------------------------------------");
                    }
                }
                else
                {
                    System.out.println("------------------------------------------");
                    System.out.println();
                    System.out.println("Available budget is below $10");
                    System.out.println();
                    System.out.println("------------------------------------------");
                }
                displayAtLocation(newPoint);
            }
            else if ((choice.equals("c")) || 
                    (choice.equals("C")) )
            {
                if (reserve.moveFromSafeHaven(newPoint))
                {
                    budget = budget + 5;
                    System.out.println("------------------------------------------");
                    System.out.println();
                    System.out.println("Koala moved from Safe Haven to this Location.");
                    System.out.println("$5 credited.");
                    System.out.println();
                    System.out.println("------------------------------------------");
                }
                else
                {
                    System.out.println("------------------------------------------");
                    System.out.println();
                    System.out.printf("%30s %n","!!Unsuccessfull!!");
                    System.out.println("Due to one of the below reasons:");
                    System.out.println("1 No Koala in SafeHaven");
                    System.out.println("2 No Healthy Koala in SafeHaven");
                    System.out.println("3 Available food or shelter is less to add to this location.");
                    System.out.println("4 More predators in this location.");
                    System.out.println();
                    System.out.println("------------------------------------------");
                }
                displayAtLocation(newPoint);
            }
            else if((choice.equals("d")) || 
                    (choice.equals("D")))
            {
                int totalDeath = reserve.noAction(newPoint);
                System.out.println("---------------------------------------------");
                System.out.printf("%30s %d %s %n","Rescue at ObservationPoint:", newPoint + 1, " Completed.");
                System.out.println("Total Number of Koala died: " + totalDeath);
                System.out.println("Available Budget: " + budget);
                System.out.println("---------------------------------------------");
                flag = false;
            }
            else
            {
                System.out.println("------------------------------------------");
                System.out.println("Invalid Input.");
                System.out.println("Please enter a valid choice.");
                System.out.println("Valid Input A, B, C, D");
                System.out.println("------------------------------------------");
            }
        } while (flag);
        return amountSpent;
    }

    /**
     * Budget is validated, value should be between 100-200 only
     * @param newBudget checks if user entered budget is between 100 
     * and 200
     * @return true when the user has entered value in the range.
     */
    public boolean budgetCheck(double newBudget)
    {
        if (newBudget < 100 || newBudget > 200)
        {
            System.out.println("Please enter budget in range of 100 - 200");
            return false;
        }
        return true;
    }

    /**
     * Display the available budget.
     */
    public void display()
    {
        System.out.println("Available Budget: " + budget);
    }

    /**
     * Status of each observation point 
     * @param newPoint displays the status of given obseravtion point
     */
    public void displayAtLocation(int newPoint)
    {
        System.out.println("############################################################");
        System.out.printf("%30s %d %s %n","---Observation Point ",(newPoint+1),"---");
        System.out.println();
        System.out.println("Number of Injured Koalas: " + reserve.numberOfInjuredKoalas(newPoint));
        System.out.println("Number of Healthy Koalas: " + reserve.numberOfHealthyKoalas(newPoint));
        System.out.println("Weight of Available Food: " + (Math.round(reserve.foodAvailable(newPoint) * 100d) / 100d));
        System.out.println("Number of Shelter Trees: " + reserve.numberOfShelterTree(newPoint));
        System.out.println("Number of Predators: " + reserve.numberOfPredators(newPoint));
        System.out.println("Available Budget: " + (Math.round(budget * 100d) / 100d));
        System.out.println();
        System.out.println("############################################################");
    }

    /**
     * User is asked to enter budget value
     * budget value should be between 100-200
     * @return double returns the budget entered by the user.
     */
    public double enterBudget()
    {
        String enteredValue;
        double newBudget = 0;
        int numberCheck = 0;
        Scanner scan = new Scanner(System.in);
        while (numberCheck == 0)
        {
            do
            {
                try
                {
                    System.out.print("Enter the Budget:");
                    enteredValue = scan.nextLine();
                    newBudget = Double.parseDouble(enteredValue);
                    numberCheck = 1;
                }
                catch (Exception exception)
                {
                    System.out.println("!!ONLY NUMBERS ACCEPTED!!");
                }
            } while (!budgetCheck(newBudget));
        }
        return newBudget;
    }

    /**
     * User is asked to input name.
     */
    public void enterName()
    {
        String name;
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.print("Enter your Name: ");
            name = scan.nextLine();
            name = name.trim();
        } while (!isAlphabetic(name));
    }

    /**
     * Display Welcome message with instructions to rescue the koala
     */
    public void welcomeMessage()
    {
        System.out.print('\u000C');
        System.out.println("############################################################");
        System.out.printf("%40s %n","Welcome to Koala Rescue");
        System.out.println();
        System.out.println("Instructions: ");
        System.out.println();
        System.out.println("* Rescue is done one location at a time.");
        System.out.println("* You have to make decision at each point");
        System.out.println("  to save as many koalas as possible.");
        System.out.println();
        System.out.printf("%40s %n","All The Best Saving Koala!");
        System.out.println("############################################################");
    }

    /**
     * User entered name is validated. 
     * User name should not have, numbers, charaters and special characters
     * @param newCheck checks if the user entered name is valid.
     * @return true when the user has entered valid value
     */
    public boolean isAlphabetic(String nameCheck)
    {
        if (nameCheck.length() == 0)
        {
            System.out.println("Name can't be blank.");
            return false;
        }
        if (nameCheck.length() > 16)
        {
            System.out.println("Name should be less than 16.");
            return false;
        }
        for (int index = 0; index < nameCheck.length() ; index++)
        {
            if((Character.isLetter(nameCheck.charAt(index))) ||
                (nameCheck.charAt(index) == ' '))
                continue;
            System.out.println("Invalid Name Entered.");
            System.out.println("Name can't have numbers/special Characters.");
            return false;
        }
        return true;
    }

    /**
     * Display the final status of the rescue and update the tree value.
     * @ param totalHealthyKoala Number of healthy koala value
     * @ param amountSpent total amount spent for rescuing the koala
     */
    public void statusAfterAllObservationPoint(int totalHealthyKoala,double amountSpent)
    {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("Trees Lost: " + reserve.getTreeLost());
        System.out.println("Total Healthy Koala: " + totalHealthyKoala);
        System.out.println("Injured Koalas taken to Safe Haven: " + reserve.getInjuredKoalaTakenToSafeHavenCount());
        System.out.println("Koalas reloacted: " + reserve.getKoalaRelocatedCount());
        System.out.println("Amount spent on rescue: " + amountSpent);
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.printf("%30s %n","!!Rescue Completed!!");
        System.out.println();
        if (reserve.getKoalaDeaths() >= 1)
            System.out.println("Rescue completed with " + reserve.getKoalaDeaths() + " koalas deaths");
        else 
            System.out.println("Rescue successful, with no koalas deaths");
        System.out.println();
        System.out.println("------------------------------------------");
        reserve.updateTree();
    }

    /**
     * returns the budget in string value
     * @return String of available budget.
     */
    public String toString()
    {
        return "Available Budget: " + Double.toString(budget);
    }

    /**
     * 10 Observation point is visited One after the other.
     */
    public void visitPointOfObservation()
    {
        int totalHealthyKoala = 0;
        double amountSpent = 0;
        for (int index = 0; index < 10; index++)
        {
            displayAtLocation(index);
            amountSpent = amountSpent + actionToPerform(index);
            totalHealthyKoala = totalHealthyKoala + reserve.totalHealthyKoala(index);
        }
        statusAfterAllObservationPoint(totalHealthyKoala,amountSpent);
    }
}