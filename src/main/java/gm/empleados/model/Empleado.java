package gm.empleados.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data //genera automaticamente getters y setters
@NoArgsConstructor //constructor Vacio
@AllArgsConstructor // constructor todos sus parametros
@ToString
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEmpleado; // en db se crea id_empleado
    String nombreEmpleado;// en db se crea nombre_empleado
    String departamento;
    Double sueldo;




}
