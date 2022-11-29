package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.ListaDeFavoritos;
import br.iesp.edu.api.repository.ListaDeFavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListaDeFavoritosService {

    @Autowired
    ListaDeFavoritosRepository repository;

    public ListaDeFavoritos create(ListaDeFavoritos listaDeFavoritos) {
        return repository.save(listaDeFavoritos);
    }

    public Optional getListaDeFavoritosById(Long id) {
        return repository.findById(id);
    }

    public ArrayList<ListaDeFavoritos> getAllListaDeFavoritos() {
        return (ArrayList<ListaDeFavoritos>) repository.findAll();
    }
}
