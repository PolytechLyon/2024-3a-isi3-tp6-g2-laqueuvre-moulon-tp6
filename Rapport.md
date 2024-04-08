# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme :

## Exercices 1
> Le patron de conception utilisé ici est un patron composite, 
> L'interface composante est l'interface `MobileObject` , la feuille est la classe `Wheel` et les composites sont tous les `Vehicle`. Ces deux dernières imlémentant `MobileObject`, la classe `SimpleBike`, hérite de `Bike` elle même héritant de `Vehicle` possède des roues.

(ajouter diagramme de classe)
> Pour la classe `TagAlongBike`, elle hérite de `SimpleBike` et à un attribut `SimpleBike` correspondant au vélo de l'enfant. 
> Nous n'avons rien à changer sur les algorithmes, car les fonctions calculent déjà leur valeur en prennant en compte chacunes des composantes (en sommant pour la masse et donc pour le calcul de la vitesse). 

## Exercices 2
![](src/main/java/fr/polytech/sim/transport/Wheel.java)
Pour construire un pattern singleton nous avons écrit le code suivant. 
```java
public final class Clock {
    private static Clock c;
    private final int time = new Random().nextInt(25);

    // On créé un constructeur privé, qui est accessible seulement à l'intérieur de
    // la classe. Le singleton est le seul à pouvoir s'instancier (depuis getTime())
    private Clock() {
        super();
    }

    /**
     * Random integer between 0 and 24 inclusive.
     */
    public final static int getTime() {
        // On vérifie si un instance de Clock à déjà été créé
        if (Clock.c == null) {
            // Si ce n'est pas le cas nous la créons
            Clock.c = new Clock();
        }
        // Puis on return time
        return c.time;
    }
}
```

## Exercices 3

## Exercices 4

## Exercices 5

## Exercices 6

> Nous centralisons dans l'interface `Logger` une méthode statique `getLogger()` qui définit le choix de la réalisation de log.

```java
    static Logger getLogger(String name) {
        return new ConsoleLogger(name);
    }
```

> La différence avec le pattern Singleton est que, si nous avons une méthode statique à laquelle nous faisons appel, notre pattern instancie autant de classe qu'il y a d'appel. 

## Exercices 7


## Exercices 8

## Exercices 9


