package examenes;

//Examen escrito hereda de Examen, lo que significa que puede utilizar sus métodos a través de la palabra super
public class ExamenEscrito extends Examen{
    //Establecemos los atributos propios de la clase
    private int idExamen;
    private int duracion;
    private int nota;

    //Establecemos los constructores
    public ExamenEscrito(){
    }

    public ExamenEscrito(String fechaRealizacion, int duracion, int nota){
        idExamen = contadorExamenes++;
        super.fechaRealizacion = fechaRealizacion;
        this.duracion = duracion;
        this.nota = nota;
    }

    //Función para determinar si un estudiante está aprobado, si la nota es mayor o igual a 6 y la duración, fue menos
    //de 90 minutos, el estudiante está aprobado
    @Override
    public Boolean examenAprobado(){
        if(nota>=6 && duracion<90){
            return true;
        } else
            return false;
    }

    //Setters y getters
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    //Colocamos el toString


    @Override
    public String toString() {
        return ":\nExamenEscrito {" +
                "\nidExamen= " + idExamen +
                "\nduracion= " + duracion +
                "\nnota= " + nota +
                "\nfechaRealizacion= '" + fechaRealizacion + '\'' + '\n' +
                "}\n";
    }
}
