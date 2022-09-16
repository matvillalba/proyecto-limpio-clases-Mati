package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.figuritas.Figurita;
import ar.edu.unlam.tallerweb1.domain.figuritas.ServicioFiguritas;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

public class ControladorFiguritasTest extends SpringTest {
    public static final int CANTIDAD_FIGURITAS = 5;
    public static final String EQUIPO_ARGENTINA = "Argentina";
    private ControladorFiguritas controladorFiguritas;
    private ServicioFiguritas servicioFiguritas;

    @Before
    public void init(){
        this.servicioFiguritas = mock(ServicioFiguritas.class);
        this.controladorFiguritas = new ControladorFiguritas(this.servicioFiguritas);
    }

    @Test
    public void alPedirTodasLasFiguritasObtengoLaListaCompleta(){
        // Preparacion
        dadoQueExistenFiguritas(CANTIDAD_FIGURITAS, EQUIPO_ARGENTINA);

        // Ejecucion
        ModelAndView mav = cuandoListoFiguritas();

        // Verificacion
        entoncesEncuentro(mav, CANTIDAD_FIGURITAS);
        entoncesMeLLevaALaVista(mav, "lista-figuritas");
    }

    private void entoncesMeLLevaALaVista(ModelAndView mav, String vistaEsperada) {
        assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
    }

    private void entoncesEncuentro(ModelAndView mav, int cantidadFiguritasEsperada){
        assertThat((List<Figurita>)mav.getModel().get("figuritas")).hasSize(cantidadFiguritasEsperada);
    }

    private ModelAndView cuandoListoFiguritas(){
        return controladorFiguritas.listar();
    }

    private void dadoQueExistenFiguritas(int cantidadFiguritas, String equipo) {
        List<Figurita> figuritas = new LinkedList<>();
        for(int i = 1; i <= cantidadFiguritas; i++)
            figuritas.add(new Figurita(i, equipo));
        when(this.servicioFiguritas.listar()).thenReturn(figuritas);
    }
}
