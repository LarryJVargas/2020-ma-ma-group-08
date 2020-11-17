package Dominio.repositories;

import Dominio.repositories.daos.DAO;
import entities.Presupuesto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDePresupuestos extends Repositorio<Presupuesto> {

    public RepositorioDePresupuestos(DAO<Presupuesto> dao) {
        super(dao);
    }

    public Boolean existe(String descripcion){
        return buscarPresupuesto(descripcion) != null;
    }

    public Presupuesto buscarPresupuesto(String descripcion){
        try {
            return this.dao.buscar(condicionPresupuesto(descripcion));
        }catch (Exception e){
            return null;
        }
    }

    private BusquedaCondicional condicionPresupuesto(String descripcion){
        CriteriaBuilder criteriaBuilder = criteriaBuilder();
        CriteriaQuery<Presupuesto> presupuestoQuery = criteriaBuilder.createQuery(Presupuesto.class);

        Root<Presupuesto> condicionRaiz = presupuestoQuery.from(Presupuesto.class);

        Predicate condicionDescripcion = criteriaBuilder.equal(condicionRaiz.get("descripcion"), descripcion);

        presupuestoQuery.where(condicionDescripcion);

        return new BusquedaCondicional(null, presupuestoQuery);
    }
}
