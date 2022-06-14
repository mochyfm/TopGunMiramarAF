public class Plane {

    private float fuelLevel;
    private String pilotCallSign;
    private String squadNumber;
    private boolean flaps;
    private boolean landingGear;
    private boolean ejectionSystem;

    private boolean seatOccupation;

    private boolean initializedState;

    public Plane(float fuelLevel, String pilotCallSign, String squadNumber) {
        this.fuelLevel = fuelLevel;
        this.pilotCallSign = pilotCallSign;
        this.squadNumber = squadNumber;
        this.flaps = true;
        this.landingGear = false;
        this.ejectionSystem = false;
        this.seatOccupation = true;
        this.initializedState = false;
    }

    public void toggleFlaps() {
        flaps = !flaps;
    }

    public void toggleLandingGear() {
        landingGear = !landingGear;
    }

    public void ejectionSystem() {
        ejectionSystem = !ejectionSystem;
    }

    public boolean getEjectionSystem() {
        return ejectionSystem;
    }

    public void setSeatOccupation(boolean pilotSeated) {
        seatOccupation = pilotSeated;
    }

    public String stringifyFlapsState() {
        return flaps ? Colors.ANSI_GREEN + "Arriba" + Colors.RESET : Colors.ANSI_RED + "Abajo" + Colors.RESET;
    }

    public String stringifyLandingGear() {
        return landingGear ? "Arriba" : "Abajo";
    }

    public String stringifyEjectionSystem() {
        return ejectionSystem ? Colors.ANSI_GREEN + "Armado" + Colors.RESET : Colors.ANSI_RED + "Desarmado" + Colors.RESET;
    }

    public String stringifySeatOccupation() {
        return seatOccupation ? Colors.ANSI_GREEN + "Verdadero" + Colors.RESET : Colors.ANSI_RED + "Falso" + Colors.RESET;
    }

    public void setInitializedState(boolean state) {
        initializedState = state;
    }

    public boolean getInitializedState() {
        return initializedState;
    }

    @Override
    public String toString() {
        return  "\n" + " -------------------------------------- " + "\n" +
                "\n" + "Plane:" + "\n" +
                "\n\t" + Colors.ANSI_CYAN + "Nivel de Combustible: " + Colors.RESET + fuelLevel +
                "\n\t" + Colors.ANSI_CYAN + "Apodo del piloto: " + Colors.RESET + pilotCallSign + ". " +
                "\n\t" + Colors.ANSI_CYAN + "Numero de escuadrón: " + Colors.RESET + squadNumber + ". " +
                "\n\t" + Colors.ANSI_CYAN + "Estado de los flaps: " + Colors.RESET + this.stringifyFlapsState() + ". " +
                "\n\t" + Colors.ANSI_CYAN + "Estado del tren de aterrizaje: " + Colors.RESET + this.stringifyLandingGear() + ". " +
                "\n\t" + Colors.ANSI_CYAN + "Estado del sistema de eyección del piloto: " + Colors.RESET + this.stringifyEjectionSystem() + ". " +
                "\n\t" + Colors.ANSI_CYAN + "Asiento ocupado (?): " + Colors.RESET + this.stringifySeatOccupation() + ". " +
                "\n\n" + " -------------------------------------- " + "\n";
    }
}
