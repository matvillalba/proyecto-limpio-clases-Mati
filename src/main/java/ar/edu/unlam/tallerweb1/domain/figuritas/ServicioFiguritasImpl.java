package ar.edu.unlam.tallerweb1.domain.figuritas;

import ar.edu.unlam.tallerweb1.infrastructure.RepositorioFiguritasImpl;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class ServicioFiguritasImpl implements ServicioFiguritas{

    private RepositorioFiguritas repositorioFiguritas;

    public ServicioFiguritasImpl(){}

    public ServicioFiguritasImpl(RepositorioFiguritas repositorioFiguritas){
        this.repositorioFiguritas = repositorioFiguritas;
    }

    @Override
    public List<Figurita> listar() {
        return this.repositorioFiguritas.listar();
    }
}
