package de.raywo.tutorials.bank.logic;


/**
 * Diese Exception zeigt an, dass der angegebene Betrag auf dem Konto nicht
 * verfügbar ist. Diese Methode wird von Methoden geworfen, die eine
 * Verfügbarkeitsprüfung machen.
 */
public class NotAvailableException extends Exception {
  public NotAvailableException(String message) {
    super(message);
  }
}
