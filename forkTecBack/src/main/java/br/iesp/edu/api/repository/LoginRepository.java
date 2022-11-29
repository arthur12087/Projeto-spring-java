package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,String> {
    @Query(value = "SELECT userName,senha FROM Usuario WHERE userName = :userName and senha = :senha")
    Login buscarUsernameESenha(@Param("userName") String userName, @Param("senha") String senha);

    Login findByUserName(String userName);
}
