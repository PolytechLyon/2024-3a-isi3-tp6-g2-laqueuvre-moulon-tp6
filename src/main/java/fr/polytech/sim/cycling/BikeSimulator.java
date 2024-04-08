package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.utils.Context;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger = Logger.getLogger("BikeSimulator");

    public void run() {
        /*Bike bike = new SimpleBike();
        this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
        this.logger.log("Bike's mass %.2f Kg.", bike.getMass());

        this.logger.log("------------------------");

        Bike tagAlongBike = new TagAlongBike();
        this.logger.log("TagAlongBike's speed %.2f Km/h.", tagAlongBike.getVelocity());
        this.logger.log("TagAlongBike's mass %.2f Kg.", tagAlongBike.getMass());*/

        Context ctx = new Context();
        Bike bike = ctx.inject(Bike.class);

        this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
        this.logger.log("Bike's mass %.2f Kg.", bike.getMass());
    }
}
