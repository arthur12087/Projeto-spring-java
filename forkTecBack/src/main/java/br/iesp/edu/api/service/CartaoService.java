package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Cartao;
import br.iesp.edu.api.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository repository;


    public Cartao create(Cartao cartao) {
        return repository.save(cartao);
    }

    public Cartao atualizarCartao(Cartao cartao) {
        if (cartao.getId()==null) {
            throw new RuntimeException("ID de cartão nulo");
        }
        return repository.save(cartao);
    }

    public void deleteCartao(Cartao cartao) {
        repository.delete(cartao);
    }

    public void deleteCartaoById(Long id) {
        repository.deleteById(id);
    }

    public List<Cartao> listarCartoes() {
        return repository.findAll();
    }

    public Optional findCartaoById(Long id) {
        return repository.findById(id);
    }
}
