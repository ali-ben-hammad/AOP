package test;

import metier.Compte;
import metier.IMetier;
import metier.IMetierImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    public void start(){
        System.out.println("App starting");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a code");
        Long code = scanner.nextLong();
        System.out.println("Enter a solde");
        double solde = scanner.nextDouble();
        IMetier metier = new IMetierImpl();
        metier.addCompte(new Compte(code, solde));
        while (true){
            try {
                System.out.println("1-Deposit");
                System.out.println("2-Withdraw");
                System.out.println("3-Get Compte");
                System.out.println("4-Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter amount");
                        double amount = scanner.nextDouble();
                        metier.deposit(code, amount);
                        break;
                    case 2:
                        System.out.println("Enter amount");
                        amount = scanner.nextDouble();
                        metier.withdraw(code, amount);
                        break;
                    case 3:
                        Compte cp = metier.getCompte(code);
                        System.out.println("Compte" + cp);
                        break;
                    case 4:
                        System.exit(0);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}

