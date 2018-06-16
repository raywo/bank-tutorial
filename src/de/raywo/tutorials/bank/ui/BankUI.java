package de.raywo.tutorials.bank.ui;

import de.raywo.tutorials.bank.logic.*;


/**
 * Stellt eine Benutzerschnittstelle auf Kommandozeilenebene bereit.
 *
 * Hier wird das Hauptmenü der App auf die Kommandozeile ausgegeben und die
 * Nutzereingaben entsprechend verarbeitet.
 */
public class BankUI {
  private final Bank bank;
  private static int currentIban = 0;

  // Konstanten für den Typ eines Kontos
  private final int CURRENT_ACCOUNT_TYPE = 1;
  private final int SAVINGS_ACCOUNT_TYPE = 2;


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

    Account albertsCurrentAccount = this.createAccount(albert, CURRENT_ACCOUNT_TYPE);
    Account bertasSavingsAccount = this.createAccount(berta, SAVINGS_ACCOUNT_TYPE);
    Account clemensAccount = this.createAccount(clemens, CURRENT_ACCOUNT_TYPE);

    ((SavingsAccount) bertasSavingsAccount).setInterestRate(0.0125);
    ((CurrentAccount) clemensAccount).setLimit(10000);

    this.printCustomers();
    this.printAccounts();

    System.out.println("\n\nTransaktionen");
    System.out.println("-------------");
    System.out.println("50€ auf Alberts Konto einzahlen: ");
    albertsCurrentAccount.deposit(5000);
    System.out.println(albertsCurrentAccount);
    System.out.println("20€ von Alberts Konto abheben: ");
    albertsCurrentAccount.withdraw(2000);
    System.out.println(albertsCurrentAccount);
    System.out.println("50€ von Alberts Konto abheben: ");
    albertsCurrentAccount.withdraw(5000);
    System.out.println(albertsCurrentAccount);
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
  private Account createAccount(Customer customer, int accountType) {
    Account account = null;

    switch (accountType) {
      case SAVINGS_ACCOUNT_TYPE:
        account = this.createSavingsAccount(customer);
        break;

      case CURRENT_ACCOUNT_TYPE:
        account = this.createCurrentAccount(customer);
        break;
    }

    return account;
  }


  private CurrentAccount createCurrentAccount(Customer customer) {
    CurrentAccount account = new CurrentAccount(this.getNextIban(), customer);
    this.bank.addAccount(account);

    return account;
  }


  private SavingsAccount createSavingsAccount(Customer customer) {
    SavingsAccount account = new SavingsAccount(this.getNextIban(), customer);
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
