package fr.polytech.sim.log;

/**
 * Name logger that is supposed to log its name along with each log entry, to
 * facilitate tracing.
 */
public abstract class NamedLogger implements Logger {
    final protected String name;

    /**
     * Constructor.
     *
     * @param name logger name.
     */
    protected NamedLogger(String name) {
        this.name = name;
    }

    public void log(String format, Object... args) {
        String message = this.construction_du_log(format, args);
        this.ecriture_du_log(message);
    }

    protected String construction_du_log(String format, Object... args) {
        String entry = String.format(format, args);
        String message = String.format("%s\t%s\n", this.name, entry);

        return message;
    }

    abstract protected void ecriture_du_log(String message);
}
