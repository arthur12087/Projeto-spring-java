package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.ListaDeFavoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeFavoritosRepository extends JpaRepository<ListaDeFavoritos, Long> {
}
