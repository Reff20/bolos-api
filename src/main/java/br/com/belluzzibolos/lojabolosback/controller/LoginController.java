package br.com.belluzzibolos.lojabolosback.controller;

import br.com.belluzzibolos.lojabolosback.dto.request.RequestLogin;
import br.com.belluzzibolos.lojabolosback.dto.request.RequestRegister;
import br.com.belluzzibolos.lojabolosback.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody RequestRegister newUser){
        return loginService.createUser(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody RequestLogin login){
        return loginService.validateLogin(login);
    }

}
