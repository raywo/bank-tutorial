package de.raywo.tutorials.bank.logic;


/**
 * Stellt die Bank in unserem Banksystem dar.
 * <p>
 * Eine Bank verfügt über eine Liste von Kunden und Konten.
 * <p>
 * ### Anmerkung zum Seminar:
 * <p>
 * Die Implementierung dieser Bank ist noch sehr rudimentär. Da für die
 * Kunden- und Kontenliste ein Array verwendet wird, ist von vornherein
 * festgelegt wie viele Kunden und Konten diese Bank verwalten kann. Das
 * Hinzufügen und Löschen von Kunden bzw. Konten ist auch recht aufwändig und
 * enthält unnötige Code-Doppelungen.
 * <p>
 * In einem nächsten Schritt sollte das geändert werden.
 *
 * @author Ray Wojciechowski
 */
public class Bank {
  private final Account[] accounts;
  private final Customer[] customers;


  /**
   * Erzeugt eine Bank und initialisiert deren Kunden- und Kontenliste.
   */
  public Bank() {
    this.accounts = new Account[10];
    this.customers = new Customer[10];
  }


  /**
   * Liefert die Liste der gespeicherten Konten.
   *
   * @return die Liste der gespeicherten Konten in Form eines Array.
   */
  public Account[] getAccounts() {
    return accounts;
  }


  /**
   * Liefert die Liste der gespeicherten Kunden.
   *
   * @return die Liste der gespeicherten Kunden in Form eines Array.
   */
  public Customer[] getCustomers() {
    return customers;
  }


  /**
   * Fügt der Bank einen neuen Kunden hinzu.
   * <p>
   * **Anmerkung zum Seminar:**
   * <p>
   * Die aktuelle Implementierung kann maximal 10 Kunden speichern. Wird
   * versucht einen weiteren Kunden hinzuzufügen, wird keine leere Stelle mehr
   * gefunden und das Hinzufügen wird kommentarlos unterlassen.
   *
   * @param newCustomer der hinzuzufügende Kunde
   */
  public void addCustomer(Customer newCustomer) {
    for (int i = 0; i < this.customers.length; i++) {
      if (this.customers[i] == null) {
        this.customers[i] = newCustomer;
      }
    }
  }


  /**
   * Entfernt den angegebenen Kunden aus der Bank.
   * <p>
   * **Anmerkung zum Seminar:**
   * <p>
   * Um den zu entfernenden Kunden zu finden, wird zunächst das Kunden-Array
   * durchlaufen und verglichen, ob das aktuelle Element dem angegebenen
   * Kunden entspricht. Ist das der Fall wird der Kunde entfernt, indem die
   * Referenz im Array auf `null` gesetzt wird. Dadurch entstehen Lücken in
   * der Liste, die in der Ausgabe unvorteilhaft aussehen können und auch
   * sonst ein Reihe von Problemen bereiten können.
   * <p>
   * Für den Vergleich zweier Kunden wird die `equals`-Methode aus der
   * `Customer`-Klasse verwendet.
   *
   * @param customer der zu entfernende Kunde
   */
  public void removeCustomer(Customer customer) {
    for (int i = 0; i < this.customers.length; i++) {
      if (this.customers[i].equals(customer)) {
        this.customers[i] = null;
      }
    }
  }


  /**
   * Fügt der Bank ein neues Konto hinzu.
   * <p>
   * **Anmerkung zum Seminar:**
   * <p>
   * Die aktuelle Implementierung kann maximal 10 Konten speichern. Wird
   * versucht ein weitere Konto hinzuzufügen, wird keine leere Stelle mehr
   * gefunden und das Hinzufügen wird kommentarlos unterlassen.
   *
   * @param newAccount das hinzuzufügende Konto
   */
  public void addAccount(Account newAccount) {
    for (int i = 0; i < this.accounts.length; i++) {
      if (this.accounts[i] == null) {
        this.accounts[i] = newAccount;
      }
    }
  }


  /**
   * Entfernt das angegebene Konto aus der Bank.
   * <p>
   * **Anmerkung zum Seminar:**
   * <p>
   * Um das zu entfernende Konto zu finden, wird zunächst das Konten-Array
   * durchlaufen und verglichen, ob das aktuelle Element dem angegebenen
   * Konto entspricht. Ist das der Fall wird das Konto entfernt, indem die
   * Referenz im Array auf `null` gesetzt wird. Dadurch entstehen Lücken in
   * der Liste, die in der Ausgabe unvorteilhaft aussehen können und auch
   * sonst ein Reihe von Problemen bereiten können.
   * <p>
   * Für den Vergleich zweier Konten wird die `equals`-Methode aus der
   * `Account`-Klasse verwendet.
   *
   * @param account das zu entfernende Konto
   */
  public void removeAccount(Account account) {
    for (int i = 0; i < this.accounts.length; i++) {
      if (this.accounts[i].equals(account)) {
        this.accounts[i] = null;
      }
    }
  }
}
