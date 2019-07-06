package unmsm.fisi.calidad.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "disponibilidad")
public class Disponibilidad {
    @Id
    @Column
    private int id;
    @Column(name="usuario_id")
    private int usuarioId;
    @Column(name="categoria_id")
    private int categoriaId;
    @Column(name="horas_disponibbles")
    private int horasDisponibbles;
    @Column(name="intervalo_disponibles")
    private String intervaloDisponibles;

    public int getId() {
        return id;
    }

    public Disponibilidad setId(int id) {
        this.id = id;
        return this;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public Disponibilidad setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public Disponibilidad setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
        return this;
    }

    public int getHorasDisponibbles() {
        return horasDisponibbles;
    }

    public Disponibilidad setHorasDisponibbles(int horasDisponibbles) {
        this.horasDisponibbles = horasDisponibbles;
        return this;
    }

    public String getIntervaloDisponibles() {
        return intervaloDisponibles;
    }

    public Disponibilidad setIntervaloDisponibles(String intervaloDisponibles) {
        this.intervaloDisponibles = intervaloDisponibles;
        return this;
    }
}
