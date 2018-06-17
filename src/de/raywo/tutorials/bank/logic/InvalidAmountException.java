package de.raywo.tutorials.bank.logic;

/**
 * Die Exception zeigt an, dass der angegebene Betrag nicht den
 * Spezifikationen eines gültigen Betrages entspricht. Diese Exception wird
 * von Methoden geworfen, die Beträge entgegennehmen und diese gegen die
 * Spezifikationen prüfen.
 */
public class InvalidAmountException extends Exception {
  public InvalidAmountException(String message) {
    super(message);
  }
}
