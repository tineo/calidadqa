package unmsm.fisi.calidad.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column
    private Long id;
    @Column
    private String codigo;
    @Column
    private String clave;
    @Column(name="rol_id")
    private int rolId;

    public Long getId() {
        return id;
    }

    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public Usuario setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getClave() {
        return clave;
    }

    public Usuario setClave(String clave) {
        this.clave = clave;
        return this;
    }

    public int getRolId() {
        return rolId;
    }

    public Usuario setRolId(int rolId) {
        this.rolId = rolId;
        return this;
    }
}

