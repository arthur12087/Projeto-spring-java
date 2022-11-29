package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository repository;

    public Login logarNoSistema(Login login) {

        String encryptedPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(login.getSenha());
        login.setSenha(encryptedPassword);

        Login loginBuscado = repository.buscarUsernameESenha(login.getUserName(), login.getSenha());


        return loginBuscado;
    }
}
