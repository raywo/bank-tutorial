package de.raywo.tutorials.bank.logic;


import java.util.Set;
import java.util.TreeSet;

/**
 * Stellt die Bank in unserem Banksystem dar.
 *
 * Eine Bank hat eine BIC und einen Namen. Außerdem verfügt sie über eine Liste
 * von Kunden und Konten.
 *
 * Die Kunden und Konten werden mit Hilfe von Mengen (`Set`) verwaltet. So
 * kann sehr einfach verhindert werden, dass Kunden bzw. Konten doppelt
 * gespeichert werden. Außerdem vereinfacht es das Hinzufügen und Löschen,
 * weil dafür die Funktionalität der Set-Implementierung verwendet werden
 * kann. Allerdings ist es dafür notwendig, dass sowohl Konten als auch
 * Kunden vergleichbar sind. Sie müssen also das `Comparable`-Interface
 * implementieren.
 *
 * @author Ray Wojciechowski
 *
 * @see Set
 * @see TreeSet
 */
public class Bank {
  private final String bic;
  private final Set<Account> accounts;
  private final Set<Customer> customers;
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
    this.accounts = new TreeSet<>();
    this.customers = new TreeSet<>();
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
   * Liefert eine flache Kopie der Liste der gespeicherten Konten.
   *
   * @return eine flache Kopie der Liste der gespeicherten Konten
   */
  public Set<Account> getAccounts() {
    TreeSet<Account> treeSet = (TreeSet<Account>) this.accounts;

    return (Set<Account>) treeSet.clone();
  }


  /**
   * Liefert eine flache Kopie der Liste der gespeicherten Kunden.
   *
   * @return eine flache Kopie der Liste der gespeicherten Kunden
   */
  public Set<Customer> getCustomers() {
    TreeSet<Customer> treeSet = (TreeSet<Customer>) this.customers;

    return (Set<Customer>) treeSet.clone();
  }


  /**
   * Fügt der Bank einen neuen Kunden hinzu.
   *
   * @param newCustomer der hinzuzufügende Kunde
   */
  public void addCustomer(Customer newCustomer) {
    this.customers.add(newCustomer);
  }


  /**
   * Entfernt den angegebenen Kunden aus der Bank.
   *
   * @param customer der zu entfernende Kunde
   */
  public void removeCustomer(Customer customer) {
    this.customers.remove(customer);
  }


  /**
   * Fügt der Bank ein neues Konto hinzu.
   *
   * @param newAccount das hinzuzufügende Konto
   */
  public void addAccount(Account newAccount) {
    this.accounts.add(newAccount);
  }


  /**
   * Entfernt das angegebene Konto aus der Bank.
   *
   * @param account das zu entfernende Konto
   */
  public void removeAccount(Account account) {
    this.accounts.remove(account);
  }


  @Override
  public String toString() {
    return this.getName() + " (" + this.getBic() + ")";
  }
}
