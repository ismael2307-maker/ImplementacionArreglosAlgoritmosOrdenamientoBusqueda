import java.util.Scanner;

public class hojaDeMatricula {
    public static int NumeroEntero(String ventana) {
        Scanner s = new Scanner(System.in);
        System.out.print(ventana);
        return s.nextInt();
    }

    public static String PedirNombres(String ventana) {
        Scanner w = new Scanner(System.in);
        System.out.print(ventana);
        return w.next();
    }

    public static int PedirClases() {
        int cantidad;
        do {
            cantidad = NumeroEntero("Digite la cantidad de clases que llevara: ");
            if (cantidad > 7) {
                System.out.println("La cantidad de clases debe ser menor de 7");
            }
        } while (cantidad <= 0 || cantidad > 7);
        return cantidad;
    }

    public static void main(String[] args) throws Exception {
        Scanner x = new Scanner(System.in);
        boolean requisitos = true;
        int numRecibo = 0, numInscripcion = 0, Semestre = 0, CantidadDeClases = 0, totCreditos = 0;
        String nombresyApellidos = " ", numCarnet = " ", Carrera = " ", Turno = " ", planEstudio = " ", Fecha = " ";
        do {
            System.out.println("Ingrese los datos del estudiante: ");
            numRecibo = NumeroEntero("Digite el numero de recibo: ");
            numInscripcion = NumeroEntero("Digite el numero de inscripcion: ");
            nombresyApellidos = PedirNombres("Digite sus nombres y apellidos: ");
            numCarnet = PedirNombres("Digite su numero de carnet: ");
            Carrera = PedirNombres("Digite el nombre de su carrera: ");
            Turno = PedirNombres("Digite su turno de clases: ");
            planEstudio = PedirNombres("Digite el plan de estudio: ");
            Semestre = NumeroEntero("Digite el semestre en el que va: ");
            Fecha = PedirNombres("Digite la fecha de matricula: ");
            CantidadDeClases = PedirClases();

            System.out.println(" ");

            System.out.println("Inscripcion de clases: ");
            for (int i = 0; i < CantidadDeClases; i++) {
                System.out.println("Digite los datos de la clase #" + (i + 1) + " : ");
                System.out.println(" ");
                String CodigoDeClase = PedirNombres("Digite el codigo de la asignatura: ");
                String NombreDeClase = PedirNombres("Digite el nombre de la clase: ");
                String AulaYgrupo = PedirNombres("Digite el codigo de la asignatura: ");
                int creditos = NumeroEntero("Digite la cantidad de creditos: ");
                int FrencuenciaDeInscripcion = NumeroEntero("Digite la frencuancia de inscripcion: ");
                if (creditos > 4 || FrencuenciaDeInscripcion > 3) {
                    requisitos = false;
                    System.out.println("La clase #" + (i + 1) + "No cumple los requisitos");
                }
                totCreditos = totCreditos + creditos;
                System.out.println("Clase #" + (i + 1) + " : ");
                System.out.println("Nombre: " + NombreDeClase);
                System.out.println("Codigo " + CodigoDeClase);
                System.out.println("Aula y grupo: " + AulaYgrupo);
                System.out.println("Creditos: " + creditos);
                System.out.println("Frencuencia de inscripcion: " + FrencuenciaDeInscripcion);
            }
            if (requisitos) {
                System.out.println("Matricula del estudiante: ");
                System.out.println("Numero de recibo: " + numRecibo);
                System.out.println("Numero de inscripcion: " + numInscripcion);
                System.out.println("Nombres y apellidos: " + nombresyApellidos);
                System.out.println("Numero de carnet " + numCarnet);
                System.out.println("Carrera: " + Carrera);
                System.out.println("Turno: " + Turno);
                System.out.println("Plan de estudio: " + planEstudio);
                System.out.println("Semestre: " + Semestre);
                System.out.println("Fecha de matricula: " + Fecha);
                System.out.println("Total de creditos usados: " + totCreditos);
            }       
            System.out.println("Quiere generar otra hoja de matricula? ");
            String op =x.next().toLowerCase();
            if(!op.equals("Si")){
                break;
            }
        } while (true);
       System.out.println("Graciar por usar el programa. Vuelva pronto ");
       x.close();
    }
 
}

