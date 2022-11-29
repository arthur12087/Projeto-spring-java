package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userLogin")
public class LoginResource {

    @Autowired
    LoginService service;

    @PostMapping("/loginUsuario")
    @ResponseStatus(HttpStatus.OK)
    public Login efetuarLogin(@RequestBody Login login) {
       return service.logarNoSistema(login);
    }

}
