package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.figuritas.Figurita;
import ar.edu.unlam.tallerweb1.domain.figuritas.RepositorioFiguritas;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RepositorioFiguritasTest extends SpringTest {

    public static final int CANTIDAD_FIGURITAS = 5;
    public static final String EQUIPO_ARGENTINA = "Argentina";
    private RepositorioFiguritas repositorioFiguritas;

    @Test
    public void alPedirTodasLasFiguritasObtengoLaListaCompleta(){
        dadoQueExistenFiguritas(CANTIDAD_FIGURITAS, EQUIPO_ARGENTINA);
        List<Figurita> figuritas = cuandoListoFiguritas();
        entoncesEncuentro(figuritas, CANTIDAD_FIGURITAS);
    }

    private void entoncesEncuentro(List<Figurita> figuritas, int cantidadFiguritasEsperada){
        assertThat(figuritas).hasSize(cantidadFiguritasEsperada);
    }

    private List<Figurita> cuandoListoFiguritas(){
        return this.repositorioFiguritas.listar();
    }

    private void dadoQueExistenFiguritas(int cantidadFiguritas, String equipo) {
        this.repositorioFiguritas = new RepositorioFiguritasImpl();
    }
}
