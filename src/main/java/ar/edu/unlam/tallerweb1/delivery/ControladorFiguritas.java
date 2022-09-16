package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.figuritas.Figurita;
import ar.edu.unlam.tallerweb1.domain.figuritas.ServicioFiguritas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ControladorFiguritas {

    ServicioFiguritas servicioFiguritas;

    @Autowired
    public ControladorFiguritas(ServicioFiguritas servicioFiguritas) {
        this.servicioFiguritas = servicioFiguritas;
    }

    @RequestMapping(path="/figuritas")
    public ModelAndView listar() {
        ModelMap model = new ModelMap();
        List<Figurita> figuritas = this.servicioFiguritas.listar();
        model.put("figuritas", figuritas);
        ModelAndView mav = new ModelAndView("lista-figuritas", model);
        return mav;
    }
}
