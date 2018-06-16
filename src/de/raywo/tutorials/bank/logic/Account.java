package de.raywo.tutorials.bank.logic;

import java.text.NumberFormat;

/**
 * Stellt ein Konto unserer Bank dar.
 *
 * Ein Konto hat eine unveränderliche IBAN, die beim Erzeugen eines Kontos
 * mitgeliefert werden muss. Das Konto ist nicht für die Einmaligkeit der IBAN
 * verantwortlich.
 *
 * Außerdem hat das Konto einen Inhaber, der später auch nicht mehr verändert
 * werden kann.
 *
 * Der Saldo des Kontos wird als `long` gespeichert, um
 * Rundungsfehler zu vermeiden. Das heißt, der Saldo wird in Cent gespeichert.
 *
 * @author Ray Wojciechowski
 */
public class Account implements Comparable<Account> {
  private final String iban;
  private final Customer owner;
  private long balance;


  /**
   * Erzeugt ein neues Konto.
   *
   * IBAN und Inhaber müssen mitgeliefert werden. Der Saldo wird immer auf
   * `0` gesetzt. Soll das Konto einen Anfangsbestand ungleich 0 haben, muss
   * eine Einzahlung durchgeführt werden.
   *
   * @param iban  die IBAN dieses Kontos. Für die Einmaligkeit der IBAN muss
   *              der Aufrufer selbst Sorge tragen
   * @param owner der Inhaber dieses Kontos
   */
  public Account(final String iban, final Customer owner) {
    this.iban = iban;
    this.owner = owner;
    this.balance = 0;
  }


  /**
   * Bucht eine Abhebung von diesem Konto.
   *
   * **Hinweis:** Der abzuhebende Betrag wird in Cent angegeben!
   *
   * @param amount abzuhebender Betrag in Cent
   */
  public void withdraw(final long amount) {
    this.balance -= amount;
  }


  /**
   * Bucht eine Einzahlung auf dieses Konto.
   *
   * **Hinweis:** Der einzuzahlende Betrag wird in Cent angegeben!
   *
   * @param amount einzuzahlender Betrag in Cent
   */
  public void deposit(final long amount) {
    this.balance += amount;
  }


  /**
   * Gibt die IBAN des Kontos zurück.
   *
   * @return die IBAN dieses Kontos
   */
  public String getIban() {
    return iban;
  }


  /**
   * Gibt den Inhaber dieses Kontos zurück.
   *
   * @return den Inhaber diese Kontos
   */
  public Customer getOwner() {
    return owner;
  }


  /**
   * Gibt den Saldo dieses Kontos zurück.
   *
   * **Hinweis:** Der Saldo wird in Cent angegeben!
   *
   * @return den Saldo dieses Kontos in Cent
   */
  public long getBalance() {
    return balance;
  }


  /**
   * Gibt den Saldo als formatierten String zurück.
   *
   * Das Format des zurückgegebenen Strings wird durch die Locale des Systems
   * festgelegt.
   *
   * @return den Saldo dieses Kontos als formatierten String.
   */
  public String getFormattedBalance() {
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    return nf.format(this.getBalance() / 100);
  }


  @Override
  public String toString() {
    return "IBAN: " + this.getIban()
        + " - Inhaber: " + this.getOwner()
        + " - Kontostand: " + this.getFormattedBalance();
  }


  /**
   * Gibt an, ob ein anderes Objekt gleich zu diesem ist.
   *
   * Zwei Konten sind genau dann gleich, wenn sie beim Vergleich mittels
   * `compareTo` als gleich identifiziert werden.
   *
   * @param other das andere Objekt, mit dem verglichen werden soll
   * @return true, gdw. das andere Objekt ein Konto ist und die selbe IBAN
   * hat wie dieses; `false` sonst
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Account) {
      Account otherAccount = (Account) other;

      return this.iban.compareTo(otherAccount.iban) == 0;
    }

    return false;
  }


  /**
   * Vergleicht dieses Konto mit einem anderen Konto.
   *
   * Die Ordnung über Konten wird über deren IBAN festgelegt.
   *
   * @param other das Konto, mit dem verglichen werden soll
   * @return eine negative Zahl, Null oder eine positive Zahl, gdw. die IBAN
   * dieses Kontos kleiner, gleich oder größer als die des anderen ist
   */
  @Override
  public int compareTo(Account other) {
    return this.iban.compareTo(other.getIban());
  }
}
