import java.util.Scanner;

public class ActasDeNotas {
    static Scanner x = new Scanner(System.in);

    public static String mesaje(String mensaje) {
        System.out.print("Ingrese " + mensaje + " :");
        return x.nextLine();
    }

    public static int Numero(String mensaje) {
        System.out.print("Ingrese " + mensaje + " :");
        return x.nextInt();
    }

    public static double Nota(String mensaje, double limite) {
        double nota;
        do {
            System.out.print("Ingrese " + mensaje + " (limite " + limite + " ): ");
            nota = x.nextDouble();
        } while (nota < 0 || nota > limite);
        return nota;
    }

    public static boolean Proyecto() {
        String afirmacion;
        System.out.println("LLeva proyecto de curso? (Si/No)");
        afirmacion = x.next();
        return afirmacion.equalsIgnoreCase("Si");
    }

    public static boolean deserciones() {
        String afirmacion;
        System.out.println("ha desertado el estudiante? (Si/No)");
        afirmacion = x.next();
        return afirmacion.equalsIgnoreCase("Si");

    }

    public static int matriculaEfectiva(int matriculaInicial, int[] deserciones) {
        int matriculaEfectiva = matriculaInicial;
        for (int desercion : deserciones) {
            matriculaEfectiva = matriculaEfectiva - desercion;
        }
        return matriculaEfectiva;
    }

    public static int deserciones(int[] Deserciones) {
        int numDeserciones = 0;
        for (int desercion : Deserciones) {
            numDeserciones = numDeserciones + desercion;
        }
        return numDeserciones;
    }

    public static int aprobados(boolean[] Aprobados) {
        int numAprobados = 0;
        for (boolean aprobado : Aprobados) {
            if (aprobado) {
                numAprobados++;
            }
        }
        return numAprobados;
    }

    public static double porcentajeAprobados(int numAprobados, int matriculaEfectiva) {
        if (matriculaEfectiva == 0) {
            return 0;
        }
        return (double) numAprobados / matriculaEfectiva * 100;
    }

    public static double notaMinima(double[] Notas) {
        double minimo = Double.MAX_VALUE;
        for (double nota : Notas) {
            if (nota < minimo) {
                minimo = nota;

            }
        }
        return minimo;
    }

    public static double notaMaxima(double[] Notas) {
        double maximo = Double.MIN_VALUE;
        for (double nota : Notas) {
            if (nota > maximo) {
                maximo = nota;
            }
        }
        return maximo;
    }

    public static double promedio(double[] Notas) {
        double suma = 0;
        if (Notas.length == 0) {
            return 0;
        }
        for (double nota : Notas) {
            suma = suma + nota;
        }
        return suma / Notas.length;
    }

    public static void main(String[] args) {
        String nombreCurso, periodoLectivo, carrera, modalidad, codCurso, grupo, codAsignatura, codPrograma, numCarnet,
                nombresApellidos;
        int numEstudiantes, matriculaInicial, matriculaEfectiva, numDeserciones, cantidadAprobados, cantidadReprobados;
        double parcial1, parcial2, notFinal, pruebas, PorcenAprobados, PorcenReprobados, NotaMinima, NotaMaxima,
                promedioNotas;

        nombreCurso = mesaje("Digite el nombre del curso ");
        periodoLectivo = mesaje("Digite el periodo lectivo ");
        carrera = mesaje("Digite su carrera  ");
        modalidad = mesaje("Digite la modalidad ");
        codCurso = mesaje("Digite el codido del curso ");
        grupo = mesaje("Digite el grupo en el que se encuentra ");
        codAsignatura = mesaje("Digite el codido de la asignatura ");
        codPrograma = mesaje("Digite el codigo del programa ");
        numEstudiantes = Numero("Digite la cantidad de estudiantes a gestionar ");

        int[] deserciones = new int[numEstudiantes];
        boolean[] aprobados = new boolean[numEstudiantes];
        double[] notaFinales = new double[numEstudiantes];

        System.out.println("Digite los datos de los estudiantes: ");
        for (int i = 0; i < numEstudiantes; i++) {
            numCarnet = mesaje("Digire su numero de carnet ");
            nombresApellidos = mesaje("Digite sus nombres y apellidos ");
            parcial1 = Nota("Digite la nota del primer parcial ", 35);
            pruebas = Nota("Digite el valor de las pruebas ", 30);

            if (Proyecto()) {
                double notaProyecto;
                notaProyecto = Nota("Digite el valor del proyecto: ", 35);
                notFinal = parcial1 + pruebas + notaProyecto;
            } else {
                parcial2 = Nota("Digite la nota del segundo parcial: ", 35);
                notFinal = parcial1 + parcial2 + pruebas;
            }

            if (notFinal < 60) {
                double examenConvo1 = Nota("Digite la nota de la primera convocatoria: ", 70);
                notFinal = pruebas + examenConvo1;

                if (notFinal < 60) {
                    double examenConvo2 = Nota("Digite la nota de la segunda convocatoria: ", 100);
                    notFinal = examenConvo2;
                }

            } else {
                aprobados[i] = true;
            }
            notaFinales[i] = notFinal;

            boolean deser = deserciones();
            if (deser) {
                deserciones[i] = 1;
            }
            System.out.println(" ");
        }
        matriculaInicial = numEstudiantes;
        matriculaEfectiva = matriculaEfectiva(matriculaInicial, deserciones);
        numDeserciones = deserciones(deserciones);
        cantidadAprobados = aprobados(aprobados);
        PorcenAprobados = porcentajeAprobados(cantidadAprobados, matriculaEfectiva);
        cantidadReprobados = matriculaEfectiva - cantidadAprobados;
        PorcenReprobados = 100 - PorcenAprobados;
        NotaMinima = notaMinima(notaFinales);
        NotaMaxima = notaMaxima(notaFinales);
        promedioNotas = promedio(notaFinales);

        System.out.println("Resultados: ");
        System.out.println("Matricula inicial: " + matriculaInicial);
        System.out.println("Matricula efectiva: " + matriculaEfectiva);
        System.out.println("Numero de deserciones: " + numDeserciones);
        System.out.println("cantidad de alumnos aprobados: " + cantidadAprobados);
        System.out.println("Porcentaje aprobados: " + PorcenAprobados);
        System.out.println("cantidad de alumnos reprobados: " + cantidadReprobados);
        System.out.println("Porcentaje de reprobados: " + PorcenReprobados);
        System.out.println("Nota maxima: " + NotaMaxima);
        System.out.println("Nota minima: " + NotaMinima);

    }

}
