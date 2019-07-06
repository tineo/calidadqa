package unmsm.fisi.calidad.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "asignacion")
public class Asignacion {
    @Id
    @Column
    private int id;
    @Column(name="usuario_id")
    private int usuarioId;
    @Column(name="curso_id")
    private int cursoId;
    @Column(name="anio")
    private int anio;
    @Column(name="ciclo")
    private String ciclo;

    public int getId() {
        return id;
    }

    public Asignacion setId(int id) {
        this.id = id;
        return this;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public Asignacion setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public int getCursoId() {
        return cursoId;
    }

    public Asignacion setCursoId(int cursoId) {
        this.cursoId = cursoId;
        return this;
    }

    public int getAnio() {
        return anio;
    }

    public Asignacion setAnio(int anio) {
        this.anio = anio;
        return this;
    }

    public String getCiclo() {
        return ciclo;
    }

    public Asignacion setCiclo(String ciclo) {
        this.ciclo = ciclo;
        return this;
    }
}
