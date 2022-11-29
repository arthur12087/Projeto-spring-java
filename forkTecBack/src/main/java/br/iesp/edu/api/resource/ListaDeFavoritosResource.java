package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.ListaDeFavoritos;
import br.iesp.edu.api.service.ListaDeFavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ListaDeFavoritos")
public class ListaDeFavoritosResource {

    @Autowired
    ListaDeFavoritosService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ListaDeFavoritos> create(@RequestBody ListaDeFavoritos listaDeFavoritos) {
        ListaDeFavoritos listaDeFavoritosCreated = service.create(listaDeFavoritos);

        return ResponseEntity.status(201).body(listaDeFavoritosCreated);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<ListaDeFavoritos> getAllListaDeFavoritos() {
        return service.getAllListaDeFavoritos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional getListaDeFavoritosById(@PathVariable Long id) {
        return service.getListaDeFavoritosById(id);
    }


}
