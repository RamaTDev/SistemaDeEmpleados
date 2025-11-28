package gm.empleados.repository;

import gm.empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

//extendemos de de JpaRepository
//indicando la clase identidad y su llave primeria idEmpleado de tipo Integer
//se agregan metodos como listar empleados, guardar, eliminar , buscar, automaticamente
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
