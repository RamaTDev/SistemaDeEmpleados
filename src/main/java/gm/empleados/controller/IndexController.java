package gm.empleados.controller;

import gm.empleados.model.Empleado;
import gm.empleados.service.EmpleadoService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    //mandar informacion a consola
    private static final Logger logger =
            LoggerFactory.getLogger(IndexController.class);


    @Autowired //inyectamos el servicio
    private EmpleadoService empleadoService;



    //indica la vista con la que vamos a trabajar "/"
    @RequestMapping(value="/", method = RequestMethod.GET) // carga el incio
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


    @RequestMapping(value="/agregar",method =  RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar"; //llama a agregar.jsp
    }

    //metodo post
    @RequestMapping(value="/agregar",method =  RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado){
        //@ModelAttribute le dice a springboot que el formulario lo trate como un objecto, y aqui lo etamos recibiendo con el nombre "empleadoForma"
        // y es de tipo empleado

        logger.info("empleado a agregar: "+empleado);

        //spring en el formulario toma name y deben tener el mismo nombre que la clase Empleado

        //guardamos el empleado en la base de datos
        empleadoService.saveEmpleado(empleado);

        return  "redirect:/"; //redirige al path inicial
    }


    @RequestMapping(value="/editar", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo){

        //buscamos el empleado en db
        Empleado empleado = empleadoService.findEmpleadoById(idEmpleado);
        logger.info("Empleado a editar: "+empleado);
        //compartir el objeto con el modelo
        modelo.put("empleado",empleado);
        return "editar"; //mostar la pagina editar.jsp

    }
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado){

        logger.info("Empleado a gurdar: "+empleado);

        //como el id viene distinto de nulo se hace un update
        empleadoService.saveEmpleado(empleado);

        return "redirect:/";
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado){

        Empleado empleado = empleadoService.findEmpleadoById(idEmpleado);
        logger.info("Empleado a eliminar: "+empleado);
        empleadoService.deleteEmpleado(empleado);
        return "redirect:/"; //mostar la pagina editar.jsp

    }



}
