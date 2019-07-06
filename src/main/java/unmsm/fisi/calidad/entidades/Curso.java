package unmsm.fisi.calidad.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @Column
    private int id;
    @Column
    private String nombre;
    @Column(name="escuela_id")
    private int escuelaId;

    public int getId() {
        return id;
    }

    public Curso setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Curso setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getEscuelaId() {
        return escuelaId;
    }

    public Curso setEscuelaId(int escuelaId) {
        this.escuelaId = escuelaId;
        return this;
    }
}
