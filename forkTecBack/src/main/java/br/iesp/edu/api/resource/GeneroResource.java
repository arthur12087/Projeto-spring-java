package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Genero;
import br.iesp.edu.api.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genero")
public class GeneroResource {

    @Autowired
    private GeneroService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Genero> listarGeneros() {
        return service.listarGeneros();
    }


    // depois tentar fazer busca colocando como chave primária o nome do genero
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional getGeneroById(@PathVariable Integer id) {
        return service.findGeneroById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Genero atualizar(@RequestBody Genero genero) {
        return service.atualizarGenero(genero);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarGenero(@RequestBody Genero genero) {
        service.deletarGenero(genero);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Genero> create(@RequestBody Genero genero) {
        Genero generoCreated = service.createGenero(genero);

        return ResponseEntity.status(201).body(generoCreated);
    }
}
