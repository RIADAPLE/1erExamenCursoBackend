package examenes;

//Examen Oral, hereda de la clase general Examen, lo cuál nos permite utilizar sus atributos y métodos, utilizando super
public class ExamenOral extends Examen{

    //Establecemos sus atributos
    private int idExamen;
    private String satisfaccion;


    //Establecemos los constructores
    public ExamenOral(){
    }

    public ExamenOral(String fechaRealizacion, String satisfaccion){
        idExamen = contadorExamenes++;
        super.fechaRealizacion = fechaRealizacion;
        this.satisfaccion = satisfaccion;
    }

    //Setters y getters
    public String getSatisfaccion() {
        return satisfaccion;
    }

    public void setSatisfaccion(String satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    //Función que determina si un estudiante ha aprobado un determinado examen oral, ya que el requisito para reprobar
    //es únicamente, que la satisfaccion sea "insuficiente" se valida que la satisfaccion sea igual a eso,
    //sino, está aprobado.
    @Override
    public Boolean examenAprobado(){
        if(satisfaccion.equals("insuficiente")){
            return false;
        } else
            return true;
    }

    //Colocamos el toString

    @Override
    public String toString() {
        return ":\nExamenOral {" +
                "\nidExamen= " + idExamen +
                "\nsatisfaccion= '" + satisfaccion + '\'' +
                "\nfechaRealizacion= '" + fechaRealizacion + '\'' + '\n'+
                "}\n";
    }
}
