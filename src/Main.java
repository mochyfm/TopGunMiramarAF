import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        final String filePath = "data/plane.dat";

        FileInputStream inputStream = null;
        BufferedInputStream bufferedInput = null;
        ObjectInputStream objectInput = null;

        Plane f18 = null;

        try {

            inputStream = new FileInputStream(filePath);
            bufferedInput = new BufferedInputStream(inputStream);
            objectInput = new ObjectInputStream(bufferedInput);

            try {

                f18 = (Plane) objectInput.readObject();

                System.out.println("\n" + Colors.ANSI_GREEN + "SUCCESS: Se ha cargado el archivo guardado correctamente." + Colors.RESET);

            } catch (IOException e) {
                System.out.println("\n" + Colors.ANSI_RED + "ERROR: Se ha producido un error en la E/S" + Colors.RESET);
            } catch (ClassNotFoundException e) {
                System.out.println("\n" + Colors.ANSI_RED + "ERROR: Se ha producido un error intentando leer la información" + Colors.RESET);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("\n" + Colors.ANSI_YELLOW + "WARNING: No se ha encontrado un archivo con datos " +
                    "guardados, se creará uno al cerrar por voluntad la sesion" + Colors.RESET);
        } catch (IOException e) {
            System.out.println("\n" + Colors.ANSI_RED + "ERROR: Se ha producido un error en la E/S" + Colors.RESET);
        }



        FileOutputStream outputFile = null;
        BufferedOutputStream bufferedOutput = null;
        ObjectOutputStream objectOutput = null;

        Scanner scanner = new Scanner(System.in);
        boolean out = false;

        while (!out) {

            System.out.println("\n");
            System.out.println("1. Inicializar F18. ");
            System.out.println("2. Alternar estado de los flaps. ");
            System.out.println("3. Alternar estado del tren de aterrizaje. ");
            System.out.println("4. Armar sistema de eyección. ");
            System.out.println("5. Eyectar piloto. ");
            System.out.println("Q. Salir");
            System.out.println("\n");
            System.out.println("En caso de pulsar cualquier otro número, si hay un avión ya creado " +
                    "se mostrará su información.");
            System.out.println("\n");

            System.out.print("Selección: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":

                    System.out.print("\n" + "Introduzca el número de litros de combustible cargados: ");
                    int liters = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Introduzca el apodo del piloto: ");
                    String nickname = scanner.nextLine();

                    System.out.print("Introduzca el número de escuadrón: ");
                    String squadNum = scanner.nextLine();

                    f18 = new Plane(liters, nickname, squadNum);

                    System.out.println("\n" + "El avión ha sido asignado: ");
                    System.out.println(f18);

                    f18.setInitializedState(true);

                    break;

                case "2":

                    if (!f18.getInitializedState()) System.out.println("\n" + Colors.ANSI_RED + "ERROR: No hay un avión todavia creado" + Colors.RESET);
                    else f18.toggleFlaps(); System.out.println("\n" + "Los flaps están " + f18.stringifyFlapsState() + "\n");

                    break;

                case "3":

                    if (!f18.getInitializedState()) System.out.println("\n" + Colors.ANSI_RED + "ERROR: No hay un avión todavia creado" + Colors.RESET);
                    else  f18.toggleLandingGear(); System.out.println("\n" + "El sistema de aterrizaje está " + f18.stringifyLandingGear());

                    break;

                case "4":

                    if (!f18.getInitializedState()) System.out.println("\n" + Colors.ANSI_RED + "ERROR: No hay un avión todavia creado" + Colors.RESET);
                    else if (f18.getEjectionSystem()) System.out.println("El sistema de ejección ya está armado");
                    else f18.ejectionSystem(); System.out.println("\n" + "El sistema de eyección está: " + f18.stringifyEjectionSystem());

                    break;

                case "5":

                    if (!f18.getInitializedState()) System.out.println("\n" + Colors.ANSI_RED + "ERROR: No hay un avión todavia creado" + Colors.RESET);
                    else if (!f18.getEjectionSystem()) { System.out.println("\n" + "¡¡ El sistema de ejección está desarmado !!," +
                            " debe armarlo primero"); }
                    else { f18.ejectionSystem(); System.out.println("\n" + "El sistema de eyección está: " + f18.stringifyEjectionSystem() + " el piloto ha sido eyectado. "); f18.setSeatOccupation(false); }

                    break;

                case "Q":
                case "q":

                    try {

                        outputFile = new FileOutputStream(filePath);
                        bufferedOutput = new BufferedOutputStream(outputFile);
                        objectOutput = new ObjectOutputStream(bufferedOutput);

                        objectOutput.writeObject(f18);

                    } catch (FileNotFoundException e) {
                        System.out.println("\n" + Colors.ANSI_RED + "ERROR: La ruta marcada no existe" + Colors.RESET);
                    } catch (IOException e) {
                        System.out.println("\n" + Colors.ANSI_RED + "ERROR: Se ha producido un error en la E/S" + Colors.RESET);
                    } finally {
                        try  {
                            if (objectOutput != null) objectOutput.close();
                            if (bufferedOutput != null) objectOutput.close();
                            if (outputFile != null) objectOutput.close();
                        } catch (IOException e) {
                            System.out.println("\n" + Colors.ANSI_RED + "ERROR: No se ha podido cerrar el archivo" + Colors.RESET);
                        }
                    }

                    out = true;

                    break;

                default:

                    if (!f18.getInitializedState()) System.out.println("\n" + Colors.ANSI_RED + "ERROR: No hay un avión todavia creado" + Colors.RESET);
                    else System.out.println(f18);



            }

        }

    }
}