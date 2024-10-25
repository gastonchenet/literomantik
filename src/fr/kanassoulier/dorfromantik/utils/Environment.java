package fr.kanassoulier.dorfromantik.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Scanner chargeant en mémoire des variables d'exécution
 * 
 * @author Gaston Chenet, Maxence Raymond
 * @version 1.1
 */
public class Environment {
  private static HashMap<String, String> values = new HashMap<String, String>();

  public static void load() {
    InputStream envFileStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(".env");
    if (envFileStream == null) {
      System.err.println("Variables d'environnement inaccessibles.");
      System.exit(1);
    }
    Scanner scanner = new Scanner(envFileStream);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String removeComments = line.split("#")[0];
      String[] parts = removeComments.split("=");

      if (parts.length != 2)
        continue;

      String key = parts[0].trim();
      String value = parts[1].trim();

      if (key.isEmpty() || value.isEmpty())
        continue;

      Environment.values.put(key, value);
    }

    scanner.close();
  }

  public static String getValue(String key) {
    String value = Environment.values.get(key);

    if (value == null)
      throw new IllegalArgumentException("La variable d'environnement spécifiée n'existe pas.");

    return value;
  }
}
