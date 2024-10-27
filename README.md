# Literomantik

![Logo](./resources/images/favicon.png)

Répertoire contenant le code et les ressources pour le jeu Literomantik

Diagramme de classes UML pour le jeu Dorfromantik : [lien](./resources/Diagrams.mdj)

## Utilisation

Utiliser la `commande` make crée un jar et le lance automatiquement  
La librairie mariadb-client.jar doit se trouver dans un dossier ressources situé dans le même répertoire que le jar.
**Il est possible de modificier cet emplacement en modifiant le champ : `Class-Path:` dans le fichier Manifest.txt. Cela est réservé aux utilisateurs avancés.**

### Les buts make disponible sont : 

```
make clean
make jar
make build
make run
make javadoc
```

# Documentation

Une documentation javadoc est disponible via la commande : `make javadoc`  
Un diagramme de classes simplifié est disponible : [lien](./resources/Diagrams.mdj)  
Un rapport d'avancement est disponible : [lien](./resources/Rapport.pdf)  

