package unmsm.fisi.calidad.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "escuela")
public class Escuela {
    @Id
    private int id;
    @Column
    private String nombre;

    public int getId() {
        return id;
    }

    public Escuela setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Escuela setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
