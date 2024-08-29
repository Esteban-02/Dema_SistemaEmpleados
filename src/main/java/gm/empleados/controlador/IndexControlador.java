package gm.empleados.controlador;


import com.sun.net.httpserver.HttpsServer;
import gm.empleados.modelo.Empleado;
import gm.empleados.servicio.ServicioEmpleado;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexControlador {
    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);
    @Autowired
    ServicioEmpleado servicioEmpleado;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        List<Empleado> listaEmpleados = servicioEmpleado.listarEmpleados();
        listaEmpleados.forEach((empleado -> logger.info(empleado.toString()))); //La lista se imprime solamente en sonsola
        // Compartir modelo con la vista
        // para esto se nececita el id que es "listaEmpleados" y se pasa la lista que se esta iterando
        modelo.put("listaEmpleados", listaEmpleados);       // el valor que esta entre "" significa la llave y el valor respesctivo
        return "index";     // Retornamos la pagina principal
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(){
        return "agregar"; //agregar.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("empleado a agregar"+ empleado);
        servicioEmpleado.guardarEmpleado(empleado);
        return "redirect:/";    //Redirigue al path inicial
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarEdicion(@RequestParam int idEmpleado, ModelMap modelo){            // RequestParam trae el parametro que es seleccionado en la pagina, es decir el idEmpleado que se esta seleccionando en la tabla
        Empleado empleado =servicioEmpleado.buscarEmpleadoId(idEmpleado);
        logger.info("Empleado a editar" + empleado);
        modelo.put("empleado", empleado);
        return "editar"; //Mostrar la pagina de mostrar
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a editar: "+empleado );
        servicioEmpleado.guardarEmpleado(empleado);
        return "redirect:/"; // redirigimos el al index
    }


}
