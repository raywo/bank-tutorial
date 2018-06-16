package de.raywo.tutorials.bank.ui;

import de.raywo.tutorials.bank.logic.Account;
import de.raywo.tutorials.bank.logic.Bank;
import de.raywo.tutorials.bank.logic.Customer;


/**
 * Die „Start“-Klasse unseres Banksystems.
 * <p>
 * ### Anmerkung zum Seminar:
 * In der `main`-Methode dieser Klasse ist viel mehr Code enthalten, als zum
 * Starten des Programms tatsächlich notwendig wäre. Außerdem enthält der
 * Code jede Menge Code-Dopplungen.
 * <p>
 * Das „Ausprobieren“ der Funktionen unserer Bank sollte besser durch Tests
 * geschehen. Das ist jedoch nicht Fokus dieses Seminars.
 *
 * @author Ray Wojciechowski
 */
public class BankSystem {

  /**
   * Startet das Programm.
   *
   * @param args Liste von Parametern
   */
  public static void main(String[] args) {
    Bank bank = new Bank();

    Customer albert = new Customer("Albert", "Artig");
    bank.addCustomer(albert);

    Customer berta = new Customer("Berta", "Beschäftigt");
    bank.addCustomer(berta);

    Customer clemens = new Customer("Clemens", "Clever");
    bank.addCustomer(clemens);

    Account albertsAccount = new Account("DE47111234567", albert);
    bank.addAccount(albertsAccount);

    Account bertasAccount = new Account("DE47113456789", berta);
    bank.addAccount(bertasAccount);

    Account clemensAccount = new Account("DE47114567890", clemens);
    bank.addAccount(clemensAccount);

    printCustomers(bank);
    printAccounts(bank);

    System.out.println("\n\nTransaktionen");
    System.out.println("-------------");
    System.out.println("50€ auf Alberts Konto einzahlen: ");
    albertsAccount.deposit(5000);
    System.out.println(albertsAccount);
    System.out.println("20€ von Alberts Konto abheben: ");
    albertsAccount.withdraw(2000);
    System.out.println(albertsAccount);
    System.out.println("50€ von Alberts Konto abheben: ");
    albertsAccount.withdraw(5000);
    System.out.println(albertsAccount);
  }


  private static void printCustomers(final Bank bank) {
    System.out.println("\n\nKunden der Bank:");
    System.out.println("----------------");

    for (Customer customer : bank.getCustomers()) {
      System.out.println(customer);
    }
  }


  private static void printAccounts(final Bank bank) {
    System.out.println("\n\nKonten der Bank:");
    System.out.println("----------------");

    for (Account account : bank.getAccounts()) {
      System.out.println(account);
    }
  }
}
