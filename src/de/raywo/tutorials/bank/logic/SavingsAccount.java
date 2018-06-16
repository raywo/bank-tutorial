package de.raywo.tutorials.bank.logic;

import java.text.NumberFormat;


/**
 * Stellt ein Sparkonto unserer Bank dar.
 *
 * Ein Sparkonto hat zusätzlich zu den Eigenschaften eines Kontos einen
 * Zinssatz, mit dem das Guthaben verzinst wird. Der Zinssatz kann jederzeit
 * geändert werden.
 *
 * Von einem Sparkonto kann nur so viel abgehoben werden, wie an Bestand
 * vorhanden ist.
 *
 * @author Ray Wojciechowski
 */
public class SavingsAccount extends Account {
  private double interestRate;


  /**
   * Erzeugt ein neues Sparkonto mit einem Zinssatz von 0%.
   *
   * @param iban die IBAN des neuen Sparkontos
   * @param owner der Inhaber des neuen Sparkontos
   */
  public SavingsAccount(String iban, Customer owner) {
    this(iban, owner, 0.0);
  }


  /**
   * Erzeugt ein neues Sparkonto mit dem übergebenen Zinssatz.
   *
   * Der Zinssatz wird als Hundertstel angegeben (2,5% werden als 0.025
   * angegeben).
   *
   * @param iban die IBAN des neuen Sparkontos
   * @param owner der Inhaber des neuen Sparkontos
   * @param interestRate der Zinssatz
   */
  public SavingsAccount(String iban, Customer owner, double interestRate) {
    super(iban, owner);

    this.setInterestRate(interestRate);
  }


  /**
   * Liefert den Zinssatz dieses Sparkontos.
   *
   * Der Zinssatz wird als Hundertstel angegeben (2,5% werden als 0.025
   * angegeben).
   *
   * @return den Zinssatz
   */
  public double getInterestRate() {
    return interestRate;
  }


  /**
   * Liefert den Zinssatz dieses Sparkontos als formatierten String.
   *
   * @return den Zinssatz als formatierten String
   */
  public String getFormattedInterestRate() {
    NumberFormat nf = NumberFormat.getPercentInstance();
    nf.setMinimumFractionDigits(2);
    nf.setMaximumFractionDigits(2);

    return nf.format(this.getInterestRate());
  }


  /**
   * Setzt den Zinssatz dieses Kontos.
   *
   * Der Zinssatz wird als Hundertstel angegeben (2,5% werden als 0.025
   * angegeben).
   *
   * @param interestRate der neue Zinssatz
   */
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "(Spar) " + super.toString()
        + "\t - Zinssatz: " + this.getFormattedInterestRate();
  }


  /**
   * Gibt an ob der angefragte Betrag verfügbar ist.
   *
   * Auf einem Sparkonto ist nur so viel verfügbar, wie vorher eingezahlt
   * wurde. Das Konto kann nicht überzogen werden.
   *
   * @param amount der Betrag, dessen Verfügbarkeit geprüft werden soll
   * @return true gdw. der Saldo größer oder gleich dem angefragten Betrag ist
   */
  @Override
  protected boolean amountIsAvailable(long amount) {
    return this.getBalance() >= amount;
  }
}
