package gm.empleados.servicio;

import gm.empleados.modelo.Empleado;

import java.util.List;

public interface IServicioEmpleado {
    public List<Empleado> listarEmpleados();
    public Empleado buscarEmpleadoId(int id);
    public void guardarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Empleado empleado);

}
