public class Plane {

    private float fuelLevel;
    private String pilotCallSign;
    private String squadNumber;

    private boolean flaps;
    private boolean landingGear;
    private boolean ejectionSystem;

    private boolean seatOccupation;

    public Plane(float fuelLevel, String pilotCallSign, String squadNumber) {
        this.fuelLevel = fuelLevel;
        this.pilotCallSign = pilotCallSign;
        this.squadNumber = squadNumber;
        this.flaps = true;
        this.landingGear = false;
        this.ejectionSystem = false;
        this.seatOccupation = true;
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

    public void setSeatOccupation(boolean pilotSeated) {
        seatOccupation = pilotSeated;
    }

    public String stringifyFlapsState() {
        return flaps ? "Arriba" : "Abajo";
    }

    public String stringifyLandingGear() {
        return landingGear ? "Arriba" : "Abajo";
    }

    public String stringifyEjectionSystem() {
        return ejectionSystem ? "Armado" : "Desarmado";
    }

    public String stringifySeatOccupation() {
        return seatOccupation ? "Verdadero" : "Falso";
    }

    @Override
    public String toString() {
        return  " -------------------------------------- " + "\n" +
                "Plane:" +
                "\n\t" + "Nivel de Combustible: " + fuelLevel +
                "\n\t" + "Apodo del piloto: " + pilotCallSign +
                "\n\t" + "Numero de escuadrón: " + squadNumber +
                "\n\t" + "Estado de los flaps: " + this.stringifyFlapsState() +
                "\n\t" + "Estado del tren de aterrizaje: " + this.stringifyLandingGear() +
                "\n\t" + "Estado del sistema de eyección del piloto: " + this.stringifyEjectionSystem() +
                "\n\t" + "Asiento ocupado (?): " + this.stringifySeatOccupation();
    }
}
