package de.raywo.tutorials.bank.logic;

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
 * ### Anmerkung zum Seminar:
 * * Fortgeschrittene User können hier auch `BigDecimal` als Datentyp verwenden.
 * * Dadurch, dass der Saldo und auch alle anderen Beträge als `long`
 * angegeben werden, ist die Ausgabe nicht sehr elegant. Das gleiche gilt
 * auch für `BigDecimal`. Im nächsten Schritt sollte das verbessert werden.
 *
 * @author Ray Wojciechowski
 */
public class Account {
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
   * Gibt an, ob ein anderes Objekt gleich zu diesem ist.
   *
   * Zwei Konten sind genau dann gleich, wenn deren IBAN identisch ist.
   *
   * **Anmerkung zum Seminar:**
   *
   * Im ersten Schritt wird geprüft, ob das `other` Objekt überhaupt ein
   * Konto ist. Ist das nicht der Fall, sind die Objekte nicht gleich und es
   * wird `false` zurückgegeben.
   *
   * Ist `other` auch ein Konto wird geprüft, ob die IBANs gleich sind. Dazu
   * wird die `equals`-Methode von `String` verwendet.
   *
   * @param other das andere Objekt, mit dem verglichen werden soll
   * @return true, gdw. das andere Objekt ein Konto ist und die selbe IBAN
   * hat wie dieses; `false` sonst
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Account) {
      Account otherAccount = (Account) other;

      return this.iban.equals(otherAccount.iban);
    } else {
      return false;
    }
  }


  @Override
  public String toString() {
    return "IBAN: " + this.getIban()
        + " - Inhaber: " + this.getOwner()
        + " - Kontostand: " + this.getBalance();
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
}
