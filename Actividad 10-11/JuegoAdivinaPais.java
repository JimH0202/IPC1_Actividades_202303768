import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaPais {
    private ArrayList<Pais> paises;
    private Random random;
    private Scanner scanner;

    public JuegoAdivinaPais() {
        paises = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
        cargarPaises();
    }

    private void cargarPaises() {
        String linea;
        boolean primeraLinea = true;

        try (BufferedReader br = new BufferedReader(new FileReader("paises.csv"))) {
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",");
                String nombre = datos[0].replace("\"", "");
                String codigo = datos[1];
                paises.add(new Pais(nombre, codigo));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de países: " + e.getMessage());
            System.exit(1);
        }
    }

    public void jugar() {
        while (true) {
            Pais paisElegido = paises.get(random.nextInt(paises.size()));
            String nombrePais = paisElegido.getNombre();
            String primeraLetra = nombrePais.substring(0, 1);
            String segundaLetra = nombrePais.length() > 1 ? nombrePais.substring(1, 2) : "";
            
            System.out.println("\n¡Adivina el país!");
            System.out.println("Primera pista: El país empieza con la letra '" + primeraLetra + "'");
            System.out.println("Segunda pista: La segunda letra es '" + segundaLetra + "'");
            System.out.println("El país tiene " + nombrePais.length() + " letras");
            System.out.print("Tu respuesta: ");

            String respuestaUsuario = scanner.nextLine().trim();

            if (respuestaUsuario.equalsIgnoreCase(paisElegido.getNombre())) {
                System.out.println("¡Correcto! ¡Has adivinado el país!");
            } else {
                System.out.println("Incorrecto. El país era: " + paisElegido.getNombre());
            }

            System.out.print("\n¿Quieres jugar otra vez? (s/n): ");
            String continuar = scanner.nextLine().trim().toLowerCase();
            if (!continuar.equals("s")) {
                break;
            }
        }

        System.out.println("\n¡Gracias por jugar!");
        scanner.close();
    }

    public static void main(String[] args) {
        JuegoAdivinaPais juego = new JuegoAdivinaPais();
        juego.jugar();
    }
}