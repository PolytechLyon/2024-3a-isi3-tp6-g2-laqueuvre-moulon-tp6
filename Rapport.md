# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme :
- LAQUEUVRE Damien
- MOULON Florent

## Exercices 1

## Exercices 2
> La méthode `getVelocity()` utilise le **patron de conception itérateur** pour parcourir les composants d'un véhicule.
> L'avantage de ce patron est qu'il permet de parcourir une collection d'objets sans exposer sa structure interne.
> Ainsi tant qu'une class implémente l'interface `Iterable`, on peut la parcourir avec un itérateur et donc l'utiliser dans la méthode `getVelocity()` sans avoir à modifier son implémentation.
> 
> On change la structure de donnée utilisée pour stocker les composants d'un `Vehicule`
> - de : ``protected final Set<MobileObject> components = new HashSet<>();``
> - à  : ``protected final List<MobileObject> components = new ArrayList<>();``
> 
> Nous n'avons pas besoin de modifier l'implementation de la méthode ``getVelocity()`` car elle utilise déjà un itérateur pour parcourir les composants du véhicule.
> Elle est donc indépendante de la structure de donnée utilisée pour stocker les composants puisques les deux classes (`Set` et `List`) implémentent l'interface ``Iterable``.

## Exercices 3

## Exercices 4
#### Les classes Bike et Wheel, appartiennent-elles au même paquetage[^3] ? Quel type de dépendance y a-t-il entre les deux classes ? Cette dépendance adhère-t-elle aux bonnes pratiques de conception ?
> Les classes `Bike` et `Wheel` n'appartiennent pas au même paquet age. En effet :
> - `Bike` appartient au paquet `fr.polytech.sim.cycling`
> - alors que `Wheel` appartient au paquet `fr.polytech.sim.transport`
> 
> La dépendance entre les deux classes est une dépendance de composition cyclique. 
> En effet, `Wheel` a une référence vers `Bike` pour obtenir l'effort appliqué sur la roue. 
> Et `Bike` a une référence vers `Wheel` pour pouvoir calculer la masse du vélo.
> 
> Cette dépendance n'adhère pas aux bonnes pratiques de conception car elle crée une forte dépendance (interdépendance) entre les deux classes.

#### Quelle fonctionnalité de la classe Bike utilise la classe Wheel ? Y a-t-il déjà une abstraction de la classe Bike qui isole cette fonctionnalité ? Dans quel paquetage se trouve cette abstraction ?
> La classe `Bike` utilise la méthode `getMass()` et `getVelocity()` de la classe `Wheel` pour calculer la masse du vélo.
> Cette fonctionalité est absstraite dans la classe abstraite `Vehicule` qui se trouve dans le paquetage `fr.polytech.sim.transport`.

#### Proposez, et réalisez, une solution pour casser la dépendance cyclique entre les classes Bike et Wheel.
> Pour casser la dépendance cyclique entre les classes `Bike` et `Wheel`, nous allons utiliser une abstraction de la fonctionalité `getPush()` de `Bike` (qui est utilisée par `Wheel`) que nous mettrons dans le paquetage `transport`.
> Ainsi la classe ``Bike`` sera dépendante du paquet `transport` mais `Wheel` ne sera plus dépendante du paquet `cycling`.
> 
> Par chance, cette abstraction existe déjà dans la classe abstraite `Vehicule` qui se trouve dans le paquetage `fr.polytech.sim.transport`.
> Il nous suffit donc de mofiier la variable `drive` de ``Wheel`` pour qu'elle soit de type `Vehicule` et non plus de type `Bike`.
> Ce changement suffis car `Vehicule` contient déjà la méthode `getPush()` qui est utilisée par `Wheel` et `Bike` implémente déjà cette méthode.


## Exercices 5
> On utilise le patron de conception patron de méthode pour centraliser l'étape commune des 2 classes à un seul endroit.
> Pour ce faire, on découpe la méthode `log()` en 2 méthodes : `construction_du_log()` et `ecriture_du_log()`. 
> 
> La méthode ``log()`` devient alors notre **patron de méthose** qui appelle les 2 méthodes `construction_du_log()` et `ecriture_du_log()` :
> L'étape commune de fabrication du message final est donc centralisée dans la méthode `construction_du_log()` et implémenter directement dans las classe abstraite ``NamedLogger``.
> 
> 
> La méthode `ecriture_du_log()` est quant à elle abstraite et doit être implémentée par les classes filles.
> On remplace donc la méthode `log()` des classes `FileLogger` et `ConsoleLogger` par la méthode `ecriture_du_log()`.
> 
> ```java
>    public void log(String format, Object... args) {
>        String message = this.construction_du_log(format);
>        this.ecriture_du_log(message);
>    }
>
>    protected String construction_du_log(String format, Object... args) {
>        String entry = String.format(format, args);
>        String message = String.format("%s\t%s\n", this.name, entry);
>
>        return message;
>    }
>
>    abstract protected void ecriture_du_log(String message);
>```
> ![Diagramme_question_5](./images/diagramme_question_5.png)


## Exercices 6

## Exercices 7

## Exercices 8
#### Quel patron de conception suit la classe Context vis-à-vis l'outil ServiceLoader ?
> La classe Context adapte l'outil ```ServiceLoader``` grâce au patron de conception **adaptateur avec délégation**.

#### Utilisez la classe utilitaire Context pour injecter un objet de type Bike dans la simulation, au lieu de l'instancier avec le mot clef new. Changez la classe injectée de SimpleBike à TagAlongBike.
> Dans la classe `BikeSimulator`, on utilise la classe `Context` pour injecter un objet de type `Bike` dans la simulation :
> ```java
> Context ctx = new Context();
> Bike bike = ctx.inject(Bike.class);
>```
> 
> Puis on modifie dans le fichier ```fr.polytech.sim.cycling.Bike``` la classe pour mettre la classe `TagAlongBike` à la place de `SimpleBike`.

#### Peut-on avoir plusieurs lignes dans le fichier fr.polytech.sim.cycling.Bike ? À quoi correspond chaque de ces lignes ?
> 


## Exercices 9
