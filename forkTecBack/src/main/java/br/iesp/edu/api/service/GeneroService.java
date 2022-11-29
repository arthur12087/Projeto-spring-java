package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Genero;
import br.iesp.edu.api.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository repository;

    public List<Genero> listarGeneros() {
        return repository.findAll();
    }

    public Optional findGeneroById(Integer id) {
        return repository.findById(id);
    }

    public Genero atualizarGenero(Genero genero) {
        return repository.save(genero);
    }

    public void deletarGenero(Genero genero) {
        if(genero.getGenero()==null) {
            throw new RuntimeException("Genero nulo!");
        }
        repository.delete(genero);
    }

    public Genero createGenero(Genero genero) {
        return repository.save(genero);
    }
}
