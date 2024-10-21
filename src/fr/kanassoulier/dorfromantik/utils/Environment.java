package fr.kanassoulier.dorfromantik.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Environment {
  private static HashMap<String, String> values = new HashMap<String, String>();

  public static void load() {
    try {
      File envFile = new File(".env");
      Scanner scanner = new Scanner(envFile);

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
    } catch (FileNotFoundException e) {
      System.err.println("Variables d'environnement inaccessibles.");
      System.exit(1);
    }
  }

  public static String getValue(String key) {
    String value = Environment.values.get(key);

    if (value == null)
      throw new IllegalArgumentException("La variable d'environnement spécifiée n'existe pas.");

    return value;
  }
}
