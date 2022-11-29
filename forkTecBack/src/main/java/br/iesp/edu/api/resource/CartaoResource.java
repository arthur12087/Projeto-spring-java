package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Cartao;
import br.iesp.edu.api.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartao")
public class CartaoResource {

    @Autowired
    CartaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cartao> create(@RequestBody Cartao cartao) {
        Cartao cartaoCreated = service.create(cartao);

        return ResponseEntity.status(201).body(cartaoCreated);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Cartao> getAllCartao() {
        return service.listarCartoes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional getCartaoById(@PathVariable Long id) {
        return service.findCartaoById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Cartao atualizarCartao(@RequestBody Cartao cartao) {
        return service.atualizarCartao(cartao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCartaoById(@PathVariable Long id) {
        service.deleteCartaoById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCartao(@RequestBody Cartao cartao) {
        service.deleteCartao(cartao);
    }

}
