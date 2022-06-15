# Enunciado del problema 

En esta ocasión nos han contactado desde la base aérea de Miramar en Estados Unidos. La base de miramar es famosa por alojar a los pilotos del programa TopGun.

Parece ser que los responsables de desarrollar el software interno de los F-18 Super Hornet Block III han cometido errores importantes y han tenido que contactar con desarrolladores y desarrolladoras de verdad, es decir, con nosotros.

El principal problema radica en que, una vez en vuelo, si el sistema se reinicia, se pierde toda la configuración del mismo y esto, cuando estás volando a velocidad MACH 2,2 parece bastante mala idea.

Desde la base aérea de Miramar se nos pide que desarrollemos un software que cumpla con los siguientes requisitos.

<p align="center">
    <img src="https://cdn.akamai.steamstatic.com/steam/apps/1692462/capsule_616x353.jpg?t=1637110860" alt="Imagen F18">
</p>

Nuestro programa debe modelar el estado de los siguientes elementos de un F18:
Nivel de combustible.
Estado de los flaps.
Estado del tren de aterrizaje.
Estado del sistema de eyección del piloto.
Asiento ocupado.
Nuestro programa tendrá que ejecutarse en una de las pantallas del F18, por lo que su menú tendrá que ser exactamente este:

1. Inicializar F18.
2. Alternar estado de los flaps (Los flaps pueden estar en uno de los siguientes estados: Abajo o Arriba).
3. Alternar estado del tren de aterrizaje (El tren de aterrizaje puede estar en uno de los siguientes estados: Abajo o Arriba).
4. Armar sistema de eyección (El sistema de eyección debe estar desarmado cuando se inicializa el F18, una vez que se pulsa esta opción el sistema de eyección pasa a estar activo).
5. Eyectar piloto (Esta opción sólo funcionará si el sistema de eyección está armado).<br/>

Para salir se utilizará la tecla "Q".



Cada una de las opciones queda especificada a continuación:

**Cuando el usuario pulse la opción 1:**

El sistema deberá preguntarle cuánto combustible tiene el avión a bordo, el apodo del piloto y su número de escuadrón.
Una simulación de la secuencia de acciones podría ser:

**Introduzca el número de litros de combustible cargados:** 1123 <br/>
**Introduzca apodo del piloto:** Reaper <br/>
**Introduzca número de escuadrón:** VFC-101 <br/>

Una vez concluya la fase de toma de datos el sistema tendrá que crear un modelo del F18 que incluya las entradas del usuario y que garantice que los siguientes parámetros siempre serán estos:

**Estado de los flaps:** Arriba. <br/>
**Estado del tren de aterrizaje:** Abajo. <br/>
**Estado del sistema de eyección del piloto:** Desarmado. <br/>
**Asiento ocupado:** Verdadero. <br/>

A continuación debe mostrar el estado del avión

**Cuando el usuario pulse la opción 2:**

El estado de los flaps debe alternarse, es decir, si antes de pulsarlo, los flaps estaban Abajo, pasarán a estar Arriba. Si por el contrario, antes de pulsarlo, los flaps estaban Arriba, pasarán a estar Abajo. A continuación debe mostrar el estado del avión

**Cuando el usuario pulse la opción 3:**

El estado del tren de aterrizaje debe alternarse, es decir, si antes de pulsarlo, estaba **Abajo**, deberán pasar a estar **Arriba**. Si por el contrario, antes de pulsarlo, estaban **Arriba**, pasarán a estar **Abajo**.

A continuación debe mostrar el estado del avión

**Cuando el usuario pulse la opción 4:**

El estado del sistema de eyección (Que si no lo sabes, es el que permite que el piloto salte en paracaídas cuando la cosa se pone fea) también debe alternarse como en los casos anteriores, es decir debe pasar de Desarmado a Armado y viceversa. A continuación debe mostrar el estado del avión

**Cuando el usuario pulse la opción 5:**

Si el estado del sistema de eyección es Armado, el piloto saltará en paracaídas, por lo tanto tendrá que cambiar el estado del asiento de ocupado a desocupado.
A continuación debe mostrar el estado del avión

**Cuando el usuario pulse la opción Q:**

El estado del avión deberá guardarse en un fichero dentro de la carpeta data y con nombre plane.dat, es decir, su ruta completa será data/plane.dat

Si al iniciar el sistema ya existe un archivo en dicha ubicación tendremos que cargar los datos contenidos en el mismo antes de mostrar de nuevo el menú.

<hr>

A continuación debe mostrar el estado del avión

Para facilitarles el trabajo les ofrezco la clase que modela el avión para que puedan utilizarla directamente en su código.

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
            
            // Completa el código para cumplir con los requisitos.
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
    
        @Override
        public String toString() {
            return "Plane{" +
                    "fuelLevel=" + fuelLevel +
                    ", pilotCallSign='" + pilotCallSign + '\'' +
                    ", squadNumber='" + squadNumber + '\'' +
                    ", flaps=" + flaps +
                    ", landingGear=" + landingGear +
                    ", ejectionSystem=" + ejectionSystem +
                    ", seatOccupation=" + seatOccupation +
                    '}';
        }
    }