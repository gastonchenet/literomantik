# Règles à respecter lors de la contribution au projet

## 1. Prérequis

**Utiliser le formateur `redhat.java` pour formater le code.**

a. Ouvrez le fichier `settings.json` de VSCode, `CTRL + SHIFT + P` puis `Open Settings (JSON)`
b. Rajouter le morceau de **JSON** suivant dans le fichier ouvert :

```json
"[java]": {
  "editor.defaultFormatter": "redhat.java",
  "editor.formatOnSave": true
}
```

c. Enregistrez le fichier et fermez-le.

## 2. Les commits

- Les commits doivent être **clairs et explicites**.
- Ne pas commiter de programme non fonctionnel.
- Si une fonctionnalité doit encore être ajoutée, utiliser l'erreur `NotImplementedException` et commenter `TODO: <fonctionnement de la fonctionnalité>`.
- Les commits doivent être en **anglais**.

## 3. Structure du programme

- Les noms de variables doivent être en **anglais**.
- Les noms de variables doivent être **explicites**.
- Lors d'une opération complexe, commenter le code pour expliquer le fonctionnement.
- Utiliser la java doc pour commenter **chacunes** des classes et méthodes.
- Utiliser le modèle **MVC** pour la structure du programme.
- Penser à indiquer la `@version` de la classe et rajoutez vos noms lors de la modification d'une classe dans le `@author`.
- Toujours utiliser `this` pour accéder aux variables de la classe et utiliser `super` pour accéder aux variables de la classe mère.
- Toujours utiliser `@Override` pour les méthodes héritées.
- Toujours utiliser le nom de la classe pour accéder aux variables et méthodes statiques.
