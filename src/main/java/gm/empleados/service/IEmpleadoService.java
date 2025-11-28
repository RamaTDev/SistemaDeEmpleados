package gm.empleados.service;

import gm.empleados.model.Empleado;

import java.util.List;

//aqui van los metodos con los que vamos a poder interacturar con la base de datos
// atraves de la clase IEmpleadoRepository
public interface IEmpleadoService {
    //listar todos los empleados
     List<Empleado> listEmpleados();

     //buscar por ID
     Empleado findEmpleadoById(Integer id);

     // si el id es nulo crea el empelado (INSERT) , sino actualiza (UPDATE)
     void saveEmpleado(Empleado empleado);

     //elimar empleado, se puede recibir solo el Id
     void deleteEmpleado(Empleado empleado);


}
