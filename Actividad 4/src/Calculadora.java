import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion; 
        
        do {
            System.out.println("\n******* CALCULADORA *******");
            System.out.println("1. Suma ('uno')");
            System.out.println("2. Resta ('dos')");
            System.out.println("3. Multiplicación ('tres')");
            System.out.println("4. División ('cuatro')");
            System.out.println("5. Potencia ('cinco')");
            System.out.println("6. Raíz ('seis')");
            System.out.println("7. Salir ('siete')");
            System.out.print("\nElige una opción: ");
            
            opcion = sc.nextLine().toLowerCase(); // leer la opción como string y "para cambiar a int opcion para entrada de números: int opcion = Integer.parseInt(sc.nextLine()); // leer como número

            
            if (!opcion.equals("siete")) { //} while (opcion != 7);

                try {
                    System.out.print("Ingresa el valor de a: ");
                    double a = Double.parseDouble(sc.nextLine());
                    System.out.print("Ingresa el valor de b: ");
                    double b = Double.parseDouble(sc.nextLine());

                    switch (opcion) {
                        case "uno": // Suma            //case 1: 
                            System.out.println("Resultado: " + (a + b));
                            break;
                        case "dos": // Resta
                            System.out.println("Resultado: " + (a - b));
                            break;
                        case "tres": // Multiplicación
                            System.out.println("Resultado: " + (a * b));
                            break;
                        case "cuatro": // División
                            if (b != 0) {
                                System.out.println("Resultado: " + (a / b));
                            } else {
                                System.out.println("Error: División entre cero no permitida.");
                            }
                            break;
                        case "cinco": // Potencia
                            System.out.println("Resultado: " + Math.pow(a, b));
                            break;
                        case "seis": // Raíz
                            if (b == 0) {
                                System.out.println("Error: No se puede calcular raíz de índice 0.");
                            } else {
                                double resultado = Math.pow(a, 1.0 / b);
                                System.out.println("Resultado: " + resultado);
                            }
                            break;
                        default:
                            System.out.println("Opción no válida. al seleccionar la acción del menú coloca el número por su nombre.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debes ingresar números válidos.");
                }
            }

        } while (!opcion.equals("siete"));
        
        System.out.println("Cerrando calculadora.......");
        sc.close();
    }

    @Override
    public String toString() {
        return "Calculadora []";
    }
}
