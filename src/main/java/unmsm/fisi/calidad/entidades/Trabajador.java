package unmsm.fisi.calidad.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @Column
    private int id;
    @Column
    private String nombres;
    @Column(name = "ape_paterno")
    private String apePaterno;
    @Column(name = "ape_materno")
    private String apeMaterno;
    @Column(name = "usuario_id")
    private int usuarioId;

    public int getId() {
        return id;
    }

    public Trabajador setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombres() {
        return nombres;
    }

    public Trabajador setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public Trabajador setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
        return this;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public Trabajador setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
        return this;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public Trabajador setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }
}
