package gm.empleados.service;

import gm.empleados.model.Empleado;
import gm.empleados.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //componente de Spring para decirle que es un servicio
public class EmpleadoService implements  IEmpleadoService {

    //comunicarse con el Repository
    @Autowired //spring inyecta automaticamente - inyeccion de dependencia
    private IEmpleadoRepository empleadoRepository;
    //ahora podemos comunicarnos con la capa repositorio

    @Override
    public List<Empleado> listEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findEmpleadoById(Integer id) {
        //findById retorna un objecto de tipo Optional
        //el orElse le dice que si no encontro el registro retorne null
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        return empleado;
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
        //guarda el empleado
        empleadoRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }
}
