package services;

import Entity.CoffeeCup;
import Entity.VirtualPerson;
import Exceptions.TooColdException;
import Exceptions.TooHotException;
import Exceptions.UnusualTasteException;

public class VirtualCafe {

    public static void serveCustomer(VirtualPerson cust, CoffeeCup cup) throws UnusualTasteException {
        try {
            cust.drinkCoffee(cup);
            System.out.println("Coffee is just right");
        } catch (TooColdException e) {
            System.out.println("Coffee is too cold at " + e.getTemperature() + " degrees.");
        } catch (TooHotException e) {
            System.out.println("Coffee is too hot at " + e.getTemperature() + " degrees.");
        } catch (Exception e) {
            System.out.println("There's temperature trouble in this coffee.");
        }
    }
}
