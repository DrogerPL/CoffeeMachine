package machine;
import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {

    public int water = 400;
    public int milk = 540;
    public int grams = 120;
    public int cups = 9;
    public int money = 550;

    public void print() {
        System.out.println("The coffee machine has:\n" +
                +this.water + " ml of water\n" +
                +this.milk + " ml of milk\n" +
                +this.grams + " g of coffee beans\n" +
                +this.cups + " disposable cups\n" +
                +this.money + " of money");
    }

    public void buy(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String bought = scan.next();
        switch (bought) {
            case "1":
                if (isEnough(water, milk, grams, cups, bought)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 250;
                    grams -= 16;
                    money += 4;
                    cups -= 1;
                }
                break;
            case "2":
                if (isEnough(water, milk, grams, cups, bought)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    grams -= 20;
                    money += 7;
                    cups -= 1;
                }
                break;
            case "3":
                if (isEnough(water, milk, grams, cups, bought)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    grams -= 12;
                    cups -= 1;
                    money += 6;
                }
                break;

            case "back":
                break;
        }
    }

    public boolean isEnough(int water, int milk, int grams, int cups, String cas) {
        if(cas.equals("1")) {
            water -= 250;
            grams -= 16;
            cups -= 1;
        }
        else if(cas.equals("2")) {
            water -= 350;
            milk -= 75;
            grams -= 20;
            cups -= 1;
        }
        else {
            water -= 200;
            milk -= 100;
            grams -= 12;
            cups -= 1;
        }

        if(water<=0) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        else if(milk<=0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        else if(grams<=0) {
            System.out.println("Sorry, not enough coffe beans!");
            return false;
        }
        else if(cups<=0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }

    public void fill() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += scan.nextInt();;
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        grams += scan.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scan.nextInt();
    }

    public void take() {
        System.out.println("I gave you $" + money);
        System.out.println();
        money = 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine obj = new CoffeeMachine();

        String action = "";
        while (!action.equals("exit")) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scan.next();
            switch (action) {
                case "buy":
                    obj.buy();
                    break;
                case "fill":
                    obj.fill();
                    break;
                case "take":
                    obj.take();
                    break;
                case "remaining":
                    obj.print();
                    break;
                case "exit":
                    action = "exit";
                    break;
            }
        }
        }
    }

