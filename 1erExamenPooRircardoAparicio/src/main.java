import estudiantes.Estudiante;
import estudiantes.EstudianteImpl;
import examenes.Examen;
import examenes.ExamenEscrito;
import examenes.ExamenOral;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Primero hacemos unas inserciones de prueba, para observar que el programa se conecta con las clases y
        //metodos correctamente, se pueden crear 2 examenes distintos y añadirlos a un estudiante en este ejemplo

        //Creamos un examen oral
        Examen Disertar = new ExamenOral("18/08/2002","suficiente");

        //Creamos un examen escrito
        Examen mate = new ExamenEscrito("18/12/2022",60,8);

        //Creamos un estudiante
        EstudianteImpl estudiante1 = new EstudianteImpl("06234903-8","Aparicio","Ricardo");

        //Añadimos el examen oral, debido a que el método acepta cualquier método que tenga como padre examen,
        //no hay problema alguno
        estudiante1.agregarExamen(Disertar);

        //Añadimos el examne escrito
        estudiante1.agregarExamen(mate);

        //Mostramos los examenes
        estudiante1.listaDeExamenes();

        //Determinamos si está aprobado
        estudiante1.esAprobado();

        //Finalmente imprimimos los datos del estudiante
        System.out.println(estudiante1.toString());


        //Esta parte del código representa una lógica un poco más funcional de como se haría un sistema
        //basado en el problema que se nos ha presentado

        //Primero establecemos las variables que utilizaremos para la seleccion de menus
        int  op1=0, op2=0;

        //establecemos la lista a donde se guardaran los estudiantes nuevos que se introduzcan
        List<EstudianteImpl> estudiantes = new ArrayList<>();
        do{
            //Imprimimos el menu
            menu();

            //Hacemos que el usuario escoja la opcion
            op1 = scan.nextInt(); scan.nextLine();
            switch (op1){
                //Listamos los usuarios con un foreach
                case 1:
                    for (EstudianteImpl estudiante: estudiantes) {
                        System.out.println(estudiante.toString());
                    }
                    break;
                //El usuario introducirá los campos pertinentes, para posteriormente, crear un nuevo objeto de tipo
                //estudiante y almacenarlo en la lista.
                case 2:
                    System.out.println("Introduzca los siguientes campos");

                    System.out.println("Apellido");
                    String apellido = scan.nextLine();

                    System.out.println("Nombre");
                    String nombre = scan.nextLine();

                    System.out.println("DUI");
                    String dui = scan.nextLine();

                    estudiantes.add(new EstudianteImpl(dui,apellido,nombre));
                    break;
                //Para que un usuario pueda agregarle un examen o verificar si un estudiante está aprobado
                //primero tendrá que "acceder a él" introduciendo el id del estudiante y así poder hacer las operaciones
                //necesarias, a través de un foreach
                case 3:
                    System.out.println("Introduzca el id del estudiante al que desea acceder: ");
                    int idEstudiante = scan.nextInt(); scan.nextLine();
                    for (EstudianteImpl estudiante: estudiantes) {
                        if(estudiante.getEstudianteId()==idEstudiante){
                            do{
                                //En el caso de "acceder" a un estudiante, se le mostrará que operaciones se pueden
                                //hacer con él
                                menu2();
                                op2 = scan.nextInt(); scan.nextLine();
                                switch(op2){
                                    //Listar los examenes adjuntos al usuario
                                    case 1:
                                        estudiante.listaDeExamenes();
                                        break;
                                    //Agregar un examen oral, primero se le pide al usuario los datos pertinentes
                                    //para posteriormente, crear un objeto de tipo "ExamenOral" y añadirlo con el método
                                    //"agregarExamen" de estudiante
                                    case 2:
                                        System.out.println("Introduzca los siguientes campos");

                                        System.out.println("Fecha de realizacion");
                                        String fechaO = scan.nextLine();

                                        System.out.println("Satisfaccion");
                                        String satisfaccion = scan.nextLine();

                                        estudiante.agregarExamen(new ExamenOral(fechaO,satisfaccion));
                                        break;
                                    //Agregar un examen escrito, primero se le pide al usuario los datos pertinentes
                                    //para posteriormente, crear un objeto de tipo "ExamenEscrito" y añadirlo con el método
                                    //"agregarExamen" de estudiante
                                    case 3:
                                        System.out.println("Introduzca los siguientes campos");

                                        System.out.println("Fecha de realizacion");
                                        String fecha = scan.nextLine();

                                        System.out.println("duracion");
                                        int duracion = scan.nextInt(); scan.nextLine();

                                        System.out.println("nota");
                                        int nota = scan.nextInt(); scan.nextLine();

                                        estudiante.agregarExamen(new ExamenEscrito(fecha,duracion,nota));
                                        break;
                                    //Verifica si el estudiante está aprobado con el método de la clase estudiante
                                    case 4:
                                        estudiante.esAprobado();
                                        break;
                                    //Si se decide regresar, simplemente se despliega un mensaje y la condicion del while se
                                    //cumple para terminar el ciclo
                                    case 0:
                                        System.out.println("Regresando al menu principal");
                                        break;
                                    //En caso se introduzca un número erróneo/no contemplado
                                    default:
                                        System.out.println("Opcion invalida, intentelo nuevamente");
                                }
                            }while(op2!=0);
                        }
                    }
                    break;
                //Si se decide terminar el programa, simplemente se despliega un mensaje y la condicion del while se
                //cumple para terminar el ciclo
                case 0:
                    System.out.println("Se ha terminado el programa correctamente");
                    break;
                //En caso se introduzca un número erróneo/no contemplado
                default:
                    System.out.println("Opcion invalida, intentelo nuevamente");
            }
        }while(op1!=0);
    }

    //Funciones que contienen las opciones que se mostrarán al usuario
    public static void menu(){
        System.out.println("1. Ver estudiantes");
        System.out.println("2. Agregar a un estudiante");
        System.out.println("3. Acceder a un estudiante");
        System.out.println("0. Salir");
    }

    public static void menu2(){
        System.out.println("1. Ver todos los examenes");
        System.out.println("2. Agregar examen oral");
        System.out.println("3. Agregar examen escrito");
        System.out.println("4. Determinar si esta aprobado");
        System.out.println("0. regresar");
    }
}