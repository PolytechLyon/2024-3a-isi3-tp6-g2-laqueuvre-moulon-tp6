package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
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
