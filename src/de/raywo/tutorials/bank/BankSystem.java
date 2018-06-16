package de.raywo.tutorials.bank;

import de.raywo.tutorials.bank.ui.BankUI;

import java.util.Locale;


/**
 * Die „Start“-Klasse unseres Banksystems.
 *
 * ### Anmerkung zum Seminar:
 * Jetzt erfüllt diese Klasse genau nur noch eine Funktion: Sie startet das
 * Programm und gibt die Kontrolle an eine UI-Klasse weiter, die dann den Rest
 * übernimmt.
 *
 * @author Ray Wojciechowski
 */
public class BankSystem {

  /**
   * Startet das Programm.
   *
   * @param args Liste von Parametern
   */
  public static void main(String[] args) {
    Locale.setDefault(Locale.GERMANY);

    BankUI bankUI = new BankUI();
    bankUI.showMainMenu();

    // Für den Anfang "probiert" diese Methode einige Funktion der
    // programmierten Klassen aus. Sobald eine UI existiert, kann diese
    // Methode dann verschwinden.
    bankUI.tryOutBank();
  }
}
