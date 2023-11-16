import java.util.Scanner;

public class EquipoBaloncesto {

    public static Scanner x = new Scanner(System.in);

    public static void ordenVelocidad(String[] Nombres, double[] velocidad) {
        int op = velocidad.length;
        String intNombre;
        double intVelocidad;

        for (int i = 0; i < op - 1; i++) {
            for (int j = 0; j < op - i - 1; j++) {
                if (velocidad[j] > velocidad[j + 1]) {
                    intNombre = Nombres[j];
                    Nombres[j] = Nombres[j + 1];
                    Nombres[j + 1] = intNombre;

                    intVelocidad = velocidad[j];
                    velocidad[j] = velocidad[j + 1];
                    velocidad[j + 1] = intVelocidad;
                }
            }
        }
        System.out.println("Jugadores ordenados por velocidad: ");
        for (int i = 0; i < op; i++) {
            System.out.println(Nombres[i] + " = " + velocidad[i] + " Km/h  ");
        }
    }

    public static double promedio(int[] numeros) {
        int suma = 0;
        for (int numero : numeros) {
            suma = suma + numero;
        }
        return (double) suma / numeros.length;
    }

    public static int jugadorCompleto(int[] estaturas, double[] velocidades, int[] alcances, double[] pesos,
            int[] envergadura) {
        double[] posicion = new double[5];
        int masAlto = 0;

        for (int i = 0; i < 5; i++) {
            posicion[i] = 0.25 * estaturas[i] + 0.25 * velocidades[i] + 0.2 * alcances[i] + 0.1 * pesos[i] + 0.2
                    * envergadura[i];
        }

        for (int i = 0; i < 5; i++) {
            if (posicion[i] > posicion[masAlto]) {
                masAlto = i;
            }
        }
        return masAlto;
    }

    public static boolean clavarBalon(int estura, int envergadura, int alcSalto) {
        double fuerza;
        double aroAltura = 305;
        fuerza = aroAltura + ((envergadura / 2) * 0.7) + alcSalto;
        return estura >= fuerza;
    }

    public static void ordenIMC(String[] Nombres, double[] pesos, int[] estaturas) {
        int op = pesos.length;
        double[] imc = new double[op];

        for (int i = 0; i < op; i++) {
            imc[i] = calcularImc(pesos[i], estaturas[i]);
        }

        for (int i = 0; i < op - 1; i++) {
            for (int j = 0; j < op - i - 1; j++) {
                if (imc[j] > imc[j + 1]) {
                    String intNombre = Nombres[j];
                    Nombres[j] = Nombres[j + 1];
                    Nombres[j + 1] = intNombre;

                    double intIMC = imc[j];
                    imc[j] = imc[j + 1];
                    imc[j] = intIMC;
                }
            }
        }
        System.out.println("Judadores ordenados por IMC: ");
        for (int i = 0; i < op; i++) {
            System.out.println(Nombres[i] + " = IMC: " + imc[i]);
        }
    }

    public static double calcularImc(double peso, int estatura) {
        double estaturaMetros;
        estaturaMetros = estatura / 100;
        return peso / (estaturaMetros * estaturaMetros);
    }

    public static void main(String[] args) {
        double PromedioEstarura;
        int JugadorCompleto;
        String[] nombres = new String[5];
        int[] Estaturas = new int[5];
        int[] Edad = new int[5];
        int[] alcances = new int[5];
        int[] Envergadura = new int[5];
        double[] Velocidad = new double[5];
        double[] Peso = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite los valores del jugador #" + (i + 1) + ": ");

            System.out.print("Digite su nombre: ");
            nombres[i] = x.nextLine();

            System.out.print("Digite su estatura: ");
            Estaturas[i] = x.nextInt();

            System.out.print("Digite su edad: ");
            Edad[i] = x.nextInt();

            System.out.print("Digite su alcance: ");
            alcances[i] = x.nextInt();

            System.out.print("Digite su envergadura ");
            Envergadura[i] = x.nextInt();

            System.out.print("Digite su velocidad: ");
            Velocidad[i] = x.nextDouble();

            System.out.print("Digite su peso: ");
            Peso[i] = x.nextDouble();
        }
        // 1
        ordenVelocidad(nombres, Velocidad);

        // 2
        PromedioEstarura = promedio(Estaturas);
        System.out.println("Promedio de estarura de los jugadores: " + PromedioEstarura + "Cm");

        // 3
        JugadorCompleto = jugadorCompleto(Estaturas, Velocidad, alcances, Peso, Envergadura);
        System.out.println("Jugador mas completo: " + nombres[JugadorCompleto]);

        // 4
        System.out.println("Jugador capacitadod para clavar el balon: ");
        for (int i = 0; i < 5; i++) {
            if (clavarBalon(Estaturas[i], Envergadura[i], alcances[i])) {
                System.out.println(nombres[i]);
            }
        }

        // 5
        ordenIMC(nombres, Peso, Estaturas);
        
    }
}