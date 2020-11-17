package Dominio.controllers;

import Dominio.repositories.RepositorioDeCategorias;
import Dominio.repositories.RepositorioDeCriteriosCat;
import Dominio.repositories.RepositorioDePresupuestos;
import Dominio.repositories.factories.FactoryRepositorio;
import Dominio.repositories.factories.FactoryRepositorioCategorias;
import Dominio.repositories.factories.FactoryRepositorioCriteriosCat;
import Dominio.repositories.factories.FactoryRepositorioPresupuestos;
import entities.CategoriaOperaciones;
import entities.CriterioOperaciones;
import entities.Presupuesto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PresupuestosController {

        private RepositorioDePresupuestos repositorioDePresupuestos;

        public PresupuestosController(){
            this.repositorioDePresupuestos = FactoryRepositorioPresupuestos.get();
        }

        public ModelAndView inicio(Request request, Response response){
            List<Presupuesto> presupuestos = this.repositorioDePresupuestos.buscarTodos();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("presupuestos", presupuestos);
            return new ModelAndView(parametros, "presupuestos.hbs");
        }



}
