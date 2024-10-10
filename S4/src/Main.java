import Entity.CoffeeCup;
import Entity.VirtualPerson;
import services.VirtualCafe;
import Exceptions.UnusualTasteException;




public class Main {
    public static void main(String[] args) {
        CoffeeCup cup = new CoffeeCup();
        VirtualPerson cust = new VirtualPerson();

        cup.setTemperature(90);

        try {
            VirtualCafe.serveCustomer(cust, cup);
        } catch (UnusualTasteException e) {
            System.out.println("This coffee has an unusual taste: " + e.getMessage());
        }
    }
}