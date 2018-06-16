package de.raywo.tutorials.bank.logic;

import java.text.NumberFormat;


/**
 * Stellt ein Girokonto unserer Bank dar.
 *
 * Ein Girokonto hat zusätzlich zu den Eigenschaften eines Kontos einen
 * Dispokredit. Dieser wird bei Abhebungen berücksichtig. Im Rahmen dieses
 * Kredits kann das Konto überzogen werden.
 *
 * @author Ray Wojciechowski
 */
public class CurrentAccount extends Account {
  private long limit;


  /**
   * Erzeugt ein neues Girokonto.
   *
   * @param iban die IBAN des neuen Girokontos
   * @param owner der Inhaber des neuen Girokontos
   */
  public CurrentAccount(String iban, Customer owner) {
    super(iban, owner);

    this.limit = 0;
  }


  /**
   * Liefert das Dispolimit dieses Girokontos.
   *
   * Der Dispo wird wie der Saldo in Cent angegeben.
   *
   * @return das Dispolimit dieses Girokontos in Cent
   */
  public long getLimit() {
    return limit;
  }


  /**
   * Liefert das Dispolimit dieses Girokontos als formatierten String.
   *
   * @return den Disporahmen dieses Girokontos als formatierten String
   */
  public String getFormattedLimit() {
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    return nf.format(this.getLimit() / 100);
  }


  /**
   * Setzt das Dispolimit dieses Girokontos.
   *
   * Der Dispo wird wie der Saldo in Cent angegeben.
   *
   * @param limit das neue Dispolimit (in Cent)
   */
  public void setLimit(long limit) {
    this.limit = limit;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "(Giro) " + super.toString()
        + "\t - Limit: " + this.getFormattedLimit();
  }


  /**
   * Gibt an ob der angefragte Betrag verfügbar ist.
   *
   * Von einem Girokonto kann über den Bestand hinaus im Rahmen des
   * Dispokredites verfügt werden.
   *
   * @param amount der Betrag, dessen Verfügbarkeit geprüft werden soll
   * @return true gdw. der Saldo + Dispo größer oder gleich dem angefragten
   * Betrag ist
   */
  @Override
  protected boolean amountIsAvailable(long amount) {
    return this.getBalance() + this.getLimit() >= amount;
  }
}
