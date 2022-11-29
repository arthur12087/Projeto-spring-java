package br.iesp.edu.api.service;


import br.iesp.edu.api.entity.Cartao;
import br.iesp.edu.api.entity.Usuario;
import br.iesp.edu.api.repository.UsuarioRepository;
import org.apache.commons.codec.cli.Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Usuario create(Usuario usuario) {

        String encryptedPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(usuario.getSenha());
        usuario.setSenha(encryptedPassword);
        usuario.setConfirmarSenha(encryptedPassword);


        return repository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {

        return repository.save(usuario);
    }

    public Optional getUsuarioById(Long id) {
        return repository.findById(id);
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public void deleteUsuarioById(Long id) {
        repository.deleteById(id);
    }

}
