package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Usuario;
import br.iesp.edu.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario usuarioCreated = service.create(usuario);

        return ResponseEntity.status(201).body(usuarioCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        return service.atualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUsuarioById(@PathVariable Long id) {
        service.deleteUsuarioById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional getUsuarioById(@PathVariable Long id) {
        return service.getUsuarioById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getAllUsuarios() {
        return service.listarUsuarios();
    }
}
