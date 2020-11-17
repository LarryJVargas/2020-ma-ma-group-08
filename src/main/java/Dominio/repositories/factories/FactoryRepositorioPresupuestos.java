package Dominio.repositories.factories;

import Dominio.repositories.RepositorioDePresupuestos;
import Dominio.repositories.daos.DAO;
import Dominio.repositories.daos.DAOHibernate;
import config.Config;
import entities.Presupuesto;

public class FactoryRepositorioPresupuestos {
    private static RepositorioDePresupuestos repo;

    static {
        repo = null;
    }

    public static RepositorioDePresupuestos get(){
        if(repo == null){
            if(Config.useDataBase){
                DAO<Presupuesto> dao = new DAOHibernate<>(Presupuesto.class);
                repo = new RepositorioDePresupuestos(dao);
            }
            else{
                repo = null;
            }
        }
        return repo;
    }
}
