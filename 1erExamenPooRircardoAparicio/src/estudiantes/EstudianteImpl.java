package estudiantes;

import examenes.Examen;
import examenes.ExamenEscrito;
import examenes.ExamenOral;

import java.util.ArrayList;
import java.util.List;

public class EstudianteImpl implements Estudiante {

    private static int contadorEstudiante;
    private int estudianteId;
    private String dui;
    private String apellido;
    private String nombre;
    private List<Examen> examenes = new ArrayList<>();


    public EstudianteImpl(){
    }

    public EstudianteImpl(String dui, String apellido, String nombre){
        contadorEstudiante++;
        estudianteId = contadorEstudiante;
        this.dui = dui;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    //Función que recibe un examen de tipo "Examen" (Sin importar si es oral o escrito) y lo añade a la lista de examenes
    //del estudiante
    @Override
    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    //Función que determina si un estudiante ha pasado todos los examenes que se le ha agregado
    //utilizando la función general examen aprobado, si alguno de los examenes NO está aprovado,
    //se declara que el estudiante no está aprobado y se termina el loop
    @Override
    public void esAprobado() {
        boolean aprobado = true;
        for (Examen examen: examenes) {
            if(!examen.examenAprobado()){
                aprobado = false;
                break;
            }
        }
        if(aprobado){
            System.out.println("El estudiante "+ this.nombre + " " + this.apellido + " ha aprobado todos sus examenes!");
        }else
            System.out.println("El estudiante "+ this.nombre + " " + this.apellido + "está reprobado");
    }

    //Lista todos los examenes que le pertenecen a un estudiante
    @Override
    public void listaDeExamenes() {
        for (Examen examen: examenes) {
            System.out.println("Examen" + examen);
        }
    }

    //toString
    @Override
    public String toString() {
        return "Estudiante {" +
                "\nestudianteId= " + estudianteId +
                "\ndui= '" + dui + '\'' +
                "\napellido= '" + apellido + '\'' +
                "\nnombre= '" + nombre + '\'' + '\n' +
                '}';
    }

    //Setters y getters
    public static int getContadorEstudiante() {
        return contadorEstudiante;
    }

    public static void setContadorEstudiante(int contadorEstudiante) {
        EstudianteImpl.contadorEstudiante = contadorEstudiante;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }
}
