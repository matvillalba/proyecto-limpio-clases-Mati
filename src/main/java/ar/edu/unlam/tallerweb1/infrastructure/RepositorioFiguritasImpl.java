package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.figuritas.Figurita;
import ar.edu.unlam.tallerweb1.domain.figuritas.RepositorioFiguritas;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class RepositorioFiguritasImpl implements RepositorioFiguritas {

    @Override
    public List<Figurita> listar() {
        List<Figurita> figuritas = new LinkedList<>();

        for (int i = 1; i <= 5; i++)
            figuritas.add(new Figurita(i, "Argentina"));

        return figuritas;
    }
}
