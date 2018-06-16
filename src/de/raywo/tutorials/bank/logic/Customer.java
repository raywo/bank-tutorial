package de.raywo.tutorials.bank.logic;


/**
 * Stellt einen Kunden unserer Bank dar.
 * <p>
 * Ein Kunde hat einen Vor- und einen Nachnamen, die beide bei der Erstellung
 * des Kunden gesetzt werden müssen. Beide sind nachträglich änderbar.
 * Außerdem gibt es eine Funktion (`getFullname`), die den Namen
 * zusammengesetzt zurückliefert.
 *
 * @author Ray Wojciechowski
 */
public class Customer {
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
   * Gibt an, ob ein anderes Objekt gleich zu diesem ist.
   * <p>
   * Zwei Kunden sind genau dann gleich, wenn ihr zusammengesetzter Name
   * identisch ist.
   *
   * @param other das zu vergleichende Objekt
   * @return true, gdw. das andere Objekt auch ein Kunde ist und der
   * zusammengesetzte Name identisch ist; false sonst
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Customer) {
      Customer otherCustomer = (Customer) other;

      return this.getFullname().equals(otherCustomer.getFullname());
    }

    return false;
  }


  /**
   * Liefert den zusammengesetzten Namen dieses Kunden.
   * <p>
   * Der zusammengesetzte Namen hat folgende Form:
   * <p>
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
}
