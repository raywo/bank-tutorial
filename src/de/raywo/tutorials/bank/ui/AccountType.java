package de.raywo.tutorials.bank.ui;

/**
 * Aufzählung der bekannten Kontotypen der Bank.
 *
 * Diese Aufzählung enthält alle Kontoarten unserer Bank. Bei jeder Art ist
 * zusätzlich ein String gespeichert, der einen für Menschen lesbaren Namen
 * dieser Kontoart beinhaltet.
 */
public enum AccountType {
  /**
   * Girokontoart
   */
  CURRENT_ACCOUNT("Girokonto"),
  /**
   * Sparkontoart
   */
  SAVINGS_ACCOUNT("Sparkonto");

  private final String humanReadableName;


  /**
   * Erzeugt eine neue Kontoart.
   *
   * @param humanReadable für Menschen lesbarer Name dieser Kontoart
   */
  AccountType(String humanReadable) {
    this.humanReadableName = humanReadable;
  }


  /**
   * Liefert den für Menschen lesbaren Namen dieser Kontoart.
   *
   * @return den für Menschen lesbaren Namen dieser Kontoart
   */
  public String getHumanReadableName() {
    return humanReadableName;
  }
}
