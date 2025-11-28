package gm.empleados.controller;

import gm.empleados.model.Empleado;
import gm.empleados.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    //mandar informacion a consola
    private static final Logger logger =
            LoggerFactory.getLogger(IndexController.class);


    @Autowired //inyectamos el servicio
    private EmpleadoService empleadoService;



    //indica la vista con la que vamos a trabajar "/"
    @RequestMapping(value="/") // carga el incio
    public String start(ModelMap modelo){ // el parametro modelo es para compartir informacion recuperada de la db atraves del servicio
        //recuperamos la lista de empleados
        List<Empleado> empleadoList = empleadoService.listEmpleados();
        //mandamos la informacion a consola
        empleadoList.forEach((empleado) -> logger.info(empleado.toString()));
        //compartir el modelo con la vista
        // id y la lista
        modelo.put("empleados",empleadoList);
        return "index"; //automaticamente se llama a la pagina de index.jsp
    }

}
