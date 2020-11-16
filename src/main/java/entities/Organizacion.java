package entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class Organizacion extends EntidadPersistente{

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EntidadJuridica> entidadesJuridicas;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EntidadBase> entidadesBase;

    public Organizacion() {
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EntidadJuridica> getEntidadesJuridicas() {
        return entidadesJuridicas;
    }

    public void setEntidadesJuridicas(List<EntidadJuridica> entidadesJuridicas) {
        this.entidadesJuridicas = entidadesJuridicas;
    }

    public List<EntidadBase> getEntidadesBase() {
        return entidadesBase;
    }

    public void setEntidadesBase(List<EntidadBase> entidadesBase) {
        this.entidadesBase = entidadesBase;
    }


}
