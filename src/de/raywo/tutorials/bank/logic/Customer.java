package de.raywo.tutorials.bank.logic;


/**
 * Stellt einen Kunden unserer Bank dar.
 *
 * Ein Kunde hat einen Vor- und einen Nachnamen, die beide bei der Erstellung
 * des Kunden gesetzt werden müssen. Beide sind nachträglich änderbar.
 * Außerdem gibt es eine Funktion (`getFullname`), die den Namen
 * zusammengesetzt zurückliefert.
 *
 * @author Ray Wojciechowski
 */
public class Customer implements Comparable<Customer> {
  private String firstname;
  private String lastname;


  /**
   * Erzeugt einen neuen Kunden.
   *
   * @param firstname Vorname des Kunden
   * @param lastname  Nachname des Kunden
   */
  public Customer(final String firstname, final String lastname) {
    this.setFirstname(firstname);
    this.setLastname(lastname);
  }


  /**
   * Liefert den zusammengesetzten Namen dieses Kunden.
   *
   * Der zusammengesetzte Namen hat folgende Form:
   *
   * Nachname, Vorname
   *
   * @return der zusammengesetzte Namen
   */
  public String getFullname() {
    return this.getLastname() + ", " + this.getFirstname();
  }


  /**
   * Liefert den Nachnamen dieses Kunden.
   *
   * @return den Nachnamen des Kunden
   */
  public String getLastname() {
    return lastname;
  }


  /**
   * Liefert den Vornamen dieses Kunden.
   *
   * @return den Vornamen dieses Kunden
   */
  public String getFirstname() {
    return firstname;
  }


  /**
   * Setzt den Vornamen dieses Kunden.
   *
   * @param firstname der neue Vorname
   */
  public void setFirstname(final String firstname) {
    this.firstname = firstname;
  }


  /**
   * Setzt den Nachnamen dieses Kunden.
   *
   * @param lastname der neue Nachname
   */
  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }


  @Override
  public String toString() {
    return this.getFullname();
  }


  /**
   * Gibt an, ob ein anderes Objekt gleich zu diesem ist.
   *
   * Zwei Kunden sind genau dann gleich, wenn sie beim Vergleich mittels
   * `compareTo` als gleich identifiziert werden.
   *
   * @param other das zu vergleichende Objekt
   * @return true, gdw. das andere Objekt auch ein Kunde ist und der
   * zusammengesetzte Name identisch ist; false sonst
   *
   * @see Customer#compareTo(Customer)
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Customer) {
      Customer otherCustomer = (Customer) other;

      return this.getFullname().compareTo(otherCustomer.getFullname()) == 0;
    }

    return false;
  }


  /**
   * Vergleicht diesen Kunden mit einem anderen Kunden und stellt eine
   * Ordnung her.
   *
   * Die Ordnung über die Kunden wird durch die Ordnung über deren vollen
   * Namen hergestellt.
   *
   * @param otherCustomer der andere Kunde mit dem verglichen werden soll
   * @return eine negative Zahl, Null oder eine positive Zahl, gdw. der volle
   * Name dieses Kunden kleiner, gleich oder größer ist, als der des
   * übergebenen Kunden ist
   */
  @Override
  public int compareTo(Customer otherCustomer) {
    return this.getFullname().compareTo(otherCustomer.getFullname());
  }
}
