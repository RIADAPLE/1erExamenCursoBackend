package examenes;


/*Se hace una clase general Examen, la cuál nos va a servir de base para los examenes más específicos
es decir, el escrito y el oral*/
public class Examen {

    //Debido a que los 2 tipos de examenes solo tendrán en común los atributos de id y fecha de realización, solo esos
    //2, se pondrán También se utilizará la palabra "protected", lo que nos permitirá heredarla, pero aún así estar protegida
    protected String fechaRealizacion;
    protected static int contadorExamenes;
    //Establecemos Los constructores, tanto el vacío, como el que contiene datos
    public Examen() {

    }

    public Examen(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Boolean examenAprobado(){
        return false;
    }

    //Ponemos los setters y getters

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    //Y por último, colocamos el to String, procurando utilizar Override, ya que es un método que tiene que ser
    //sobreescrito
    @Override
    public String toString() {
        return "Examen{" +
                "fechaRealizacion='" + fechaRealizacion + '\'' +
                '}';
    }
}
