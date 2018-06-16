package de.raywo.tutorials.bank.logic;


/**
 * Stellt die Bank in unserem Banksystem dar.
 *
 * Eine Bank verfügt über eine Liste von Kunden und Konten.
 *
 * ### Anmerkung zum Seminar:
 *
 * Die Implementierung dieser Bank ist noch sehr rudimentär. Da für die
 * Kunden- und Kontenliste ein Array verwendet wird, ist von vornherein
 * festgelegt wie viele Kunden und Konten diese Bank verwalten kann. Das
 * Hinzufügen und Löschen von Kunden bzw. Konten ist auch recht aufwändig und
 * enthält unnötige Code-Doppelungen.
 *
 * In einem nächsten Schritt sollte das geändert werden.
 *
 * @author Ray Wojciechowski
 */
public class Bank {
  private final String bic;
  private final Account[] accounts;
  private final Customer[] customers;
  private String name;


  /**
   * Erzeugt eine Bank und initialisiert deren Kunden- und Kontenliste.
   *
   * @param bic die BIC dieser Bank
   * @param name den Namen dieser Bank
   */
  public Bank(String bic, String name) {
    this.bic = bic;
    this.setName(name);
    this.accounts = new Account[10];
    this.customers = new Customer[10];
  }


  /**
   * Liefert die BIC dieser Bank.
   *
   * @return die BIC dieser Bank
   */
  public String getBic() {
    return bic;
  }


  /**
   * Liefert den Namen dieser Bank.
   *
   * @return den Namen dieser Bank
   */
  public String getName() {
    return name;
  }


  /**
   * Setzt den Namen dieser Bank.
   *
   * @param name der neue Name der Bank
   */
  public void setName(String name) {
    this.name = name;
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
   *
   * **Anmerkung zum Seminar:**
   *
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
        return;
      }
    }
  }


  /**
   * Entfernt den angegebenen Kunden aus der Bank.
   *
   * **Anmerkung zum Seminar:**
   *
   * Um den zu entfernenden Kunden zu finden, wird zunächst das Kunden-Array
   * durchlaufen und verglichen, ob das aktuelle Element dem angegebenen
   * Kunden entspricht. Ist das der Fall wird der Kunde entfernt, indem die
   * Referenz im Array auf `null` gesetzt wird. Dadurch entstehen Lücken in
   * der Liste, die in der Ausgabe unvorteilhaft aussehen können und auch
   * sonst ein Reihe von Problemen bereiten können.
   *
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
   *
   * **Anmerkung zum Seminar:**
   *
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
        return;
      }
    }
  }


  /**
   * Entfernt das angegebene Konto aus der Bank.
   *
   * **Anmerkung zum Seminar:**
   *
   * Um das zu entfernende Konto zu finden, wird zunächst das Konten-Array
   * durchlaufen und verglichen, ob das aktuelle Element dem angegebenen
   * Konto entspricht. Ist das der Fall wird das Konto entfernt, indem die
   * Referenz im Array auf `null` gesetzt wird. Dadurch entstehen Lücken in
   * der Liste, die in der Ausgabe unvorteilhaft aussehen können und auch
   * sonst ein Reihe von Problemen bereiten können.
   *
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


  @Override
  public String toString() {
    return this.getName() + " (" + this.getBic() + ")";
  }
}
