package ar.edu.unlam.tallerweb1.domain.figuritas;

import ar.edu.unlam.tallerweb1.SpringTest;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioFiguritasTest extends SpringTest {

    public static final int CANTIDAD_FIGURITAS = 5;
    private List<Figurita> figuritas;
    private ServicioFiguritas servicioFiguritas;
    private RepositorioFiguritas repositorioFiguritas;

    @Before
    public void init(){
        this.repositorioFiguritas = mock(RepositorioFiguritas.class);
        this.servicioFiguritas = new ServicioFiguritasImpl(this.repositorioFiguritas);
    }

    @Test
    public void alPedirTodasLasFiguritasObtengoLaListaCompleta(){
        dadoQueExistenFiguritas(CANTIDAD_FIGURITAS, "Argentina");

        List<Figurita> figuritas = cuandoListoFiguritas();

        entoncesEncuentro(figuritas, CANTIDAD_FIGURITAS);
    }

    private void entoncesEncuentro(List<Figurita> figuritas, int cantidadFiguritasEsperada){
        assertThat(figuritas).hasSize(cantidadFiguritasEsperada);
    }

    private List<Figurita> cuandoListoFiguritas(){
        return this.servicioFiguritas.listar();
    }

    private void dadoQueExistenFiguritas(int cantidadFiguritas, String equipo) {
//        this.servicioFiguritas = new ServicioFiguritasImpl();
        List<Figurita> figus = new LinkedList<>();
        for(int i = 1; i<=cantidadFiguritas; i++)
            figus.add(new Figurita(i, equipo));

        when(this.repositorioFiguritas.listar()).thenReturn(figus);
    }
}
