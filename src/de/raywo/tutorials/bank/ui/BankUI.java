package de.raywo.tutorials.bank.ui;

import de.raywo.tutorials.bank.logic.Account;
import de.raywo.tutorials.bank.logic.Bank;
import de.raywo.tutorials.bank.logic.Customer;


/**
 * Stellt eine Benutzerschnittstelle auf Kommandozeilenebene bereit.
 *
 * Hier wird das Hauptmenü der App auf die Kommandozeile ausgegeben und die
 * Nutzereingaben entsprechend verarbeitet.
 */
public class BankUI {
  private final Bank bank;
  private static int currentIban = 0;


  /**
   * Erzeugt ein neues Objekt dieser Klasse.
   */
  public BankUI() {
    this.bank = new Bank("RAYWDELEXXX", "Ray Bank Deutschland");
  }


  /**
   * Zeigt das Hauptmenu der Benutzeroberfläche an.
   *
   * Im Augenblick nicht mit echter Funktionalität versehen, da
   */
  public void showMainMenu() {
    System.out.println("\n\nWillkommen bei " + this.bank + "\n");
  }



  /**
   * Probiert einige Funktionen der anderen Klassen aus.
   * Verschwindet sobald eine echte UI vorliegt.
   */
  public void tryOutBank() {
    Customer albert = createCustomer("Albert", "Artig");
    Customer berta = createCustomer("Berta", "Beschäftigt");
    Customer clemens = createCustomer("Clemens", "Clever");

    Account albertsAccount = this.createAccount(albert);
    Account bertasAccount = this.createAccount(berta);
    Account clemensAccount = this.createAccount(clemens);

    this.printCustomers();
    this.printAccounts();

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


  /**
   * Legt einen neuen Kunden an und speichert ihn in der Bank.
   *
   * @param firstname Vorname des neuen Kunden
   * @param lastname Nachname des neuen Kunden
   * @return den neu angelegten Kunden
   */
  private Customer createCustomer(String firstname, String lastname) {
    Customer albert = new Customer(firstname, lastname);
    bank.addCustomer(albert);

    return albert;
  }


  /**
   * Legt ein neues Konto an und speichert es in der Bank.
   *
   * Die IBAN für das neue Konto wird hier unter Zuhilfenahme von
   * `getNextIban` festgelegt.
   *
   * @param customer der Inhaber des neuen Kontos
   * @return das neu angelegte Konto
   */
  private Account createAccount(Customer customer) {
    Account account = new Account(this.getNextIban(), customer);
    this.bank.addAccount(account);

    return account;
  }


  /**
   * Ermittelt die nächste verfügbare IBAN.
   *
   * ### Anmerkung zum Seminar:
   * Diese Implementierung ist auf keinen Fall geeignet für ein robuste
   * eindeutige Numerierung. Hier wird einfach eine statische Variable
   * verwendet und jedes Mal um eins hochgezählt, wenn diese Methode
   * aufgerufen wurde.
   *
   * Beachte: Der `++`-Operator wurde an das Ende des Aufrufs gestellt. Das
   * heißt `currentIban` wird erst ausgelesen und für die neue IBAN verwendet
   * und anschließend hochgezählt.
   *
   * @return die nächste verfügbare IBAN
   */
  private String getNextIban() {
    return String.format("DE47 1234 5678 9012 %04d 99",
        BankUI.currentIban++);
  }


  /**
   * Druckt die Kundenliste der Bank aus.
   */
  private void printCustomers() {
    System.out.println("\nKunden der Bank:");
    System.out.println("----------------");

    for (Customer customer : this.bank.getCustomers()) {
      System.out.println(customer);
    }
  }


  /**
   * Druckt die Kontenliste der Bank aus.
   */
  private void printAccounts() {
    System.out.println("\nKonten der Bank:");
    System.out.println("----------------");

    for (Account account : this.bank.getAccounts()) {
      System.out.println(account);
    }
  }
}
