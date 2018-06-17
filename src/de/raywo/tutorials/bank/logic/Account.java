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
public abstract class Account implements Comparable<Account> {
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
   * @throws InvalidAmountException falls der angegebene Betrag kleiner Null
   * ist
   * @throws NotAvailableException falls der angegebene Betrag nicht
   * verfügbar ist
   * @see Account#amountIsAvailable(long)
   */
  public void withdraw(final long amount) throws InvalidAmountException,
      NotAvailableException {

    if (amount < 0) {
      throw new InvalidAmountException("Der Betrag darf nicht negativ sein! "
          + "(Betrag: " + this.getFormattedAmount(amount) + ")");
    }

    if (!this.amountIsAvailable(amount)) {
      throw new NotAvailableException("Der angeforderte Betrag ("
          + this.getFormattedAmount(amount)
          + ") ist nicht verfügbar.");
    }

    this.balance -= amount;
  }


  /**
   * Bucht eine Einzahlung auf dieses Konto.
   *
   * **Hinweis:** Der einzuzahlende Betrag wird in Cent angegeben!
   *
   * @param amount einzuzahlender Betrag in Cent
   * @throws InvalidAmountException falls der angegebene Betrag kleiner Null
   * ist
   */
  public void deposit(final long amount) throws InvalidAmountException {
    if (amount < 0) {
      throw new InvalidAmountException("Der Betrag darf nicht negativ sein! "
          + "(Betrag: " + this.getFormattedAmount(amount) + ")");
    }

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
    return this.getFormattedAmount(this.getBalance());
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


  /**
   * Liefert den angegebenen Cent-Betrag als formatierten Währungsstring zurück.
   *
   * @param amount der Betrag, der als Währung formatiert werden soll
   *               (angegeben in Cent)
   * @return den formatierten Währungsbetrag
   */
  protected String getFormattedAmount(long amount) {
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    return nf.format(amount / 100);
  }


  /**
   * Gibt an ob der angefragte Betrag verfügbar ist.
   *
   * @param amount der angefragte Betrag
   * @return true gdw. der angefragte Betrag verfügbar ist; false sonst
   */
  protected abstract boolean amountIsAvailable(long amount);
}
