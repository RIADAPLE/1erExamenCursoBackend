package estudiantes;

import examenes.Examen;
import examenes.ExamenEscrito;
import examenes.ExamenOral;

import java.util.List;

public interface Estudiante {
    public abstract void agregarExamen(Examen examen);
    public abstract void esAprobado();
    public abstract void listaDeExamenes();
}
