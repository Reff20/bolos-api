package br.com.belluzzibolos.lojabolosback.service;

import br.com.belluzzibolos.lojabolosback.dto.request.RequestLogin;
import br.com.belluzzibolos.lojabolosback.dto.request.RequestRegister;
import br.com.belluzzibolos.lojabolosback.dto.response.ResponseError;
import br.com.belluzzibolos.lojabolosback.dto.response.ResponseSuccess;
import br.com.belluzzibolos.lojabolosback.model.LoginModel;
import br.com.belluzzibolos.lojabolosback.repository.LoginRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginService {

    @Value("12")
    private Integer salt;

    @Value("admin123")
    private String pass;

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public ResponseEntity<Object> createUser(RequestRegister newUser){
        ResponseSuccess success = new ResponseSuccess();
        ResponseError error = new ResponseError();
        try{
            if(!newUser.getFullName().isEmpty() || !newUser.getUserName().isEmpty()){
                Optional<LoginModel> validateName = loginRepository.findByFullName(newUser.getFullName());
                Optional<LoginModel> validateUser = loginRepository.findByUserName(newUser.getUserName());
                if(!validateName.isPresent() || !validateUser.isPresent()){
                    String pw = BCrypt.hashpw(newUser.getUserPassword(), BCrypt.gensalt(salt));
                    Date now = new Date();

                    LoginModel user = new LoginModel();

                    user.setUserName(newUser.getUserName());
                    user.setUserPassword(pw);
                    user.setUserPermission(newUser.getUserPermisson());
                    user.setFullName(newUser.getFullName());
                    user.setDateCreated(now);

                    loginRepository.save(user);
                    success.setStatus(201);
                    success.setMsg("USUÁRIO CRIADO COM SUCESSO!");
                    success.setRenew(true);

                    return new ResponseEntity<>(success, HttpStatus.OK);
                }else{
                    error.setMsg("Faild Process...");
                    error.setStatus(400);
                    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
                }
            }else{
                error.setMsg("Not Found...");
                error.setStatus(404);
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    public ResponseEntity<Object> validateLogin(RequestLogin login){
        ResponseSuccess success = new ResponseSuccess();
        ResponseError error = new ResponseError();
        try{
            Optional<LoginModel> user = loginRepository.findByUserName(login.getUser());
            if(!user.isPresent()){
                error.setStatus(404);
                error.setMsg("Usuário ou Senha não encontrado.");
                error.setError("Error");
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            } else if (BCrypt.checkpw(login.getPass(),user.get().getUserPassword())) {
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_USER");
                String token = Jwts
                        .builder().setId("loginJWT")
                        .setSubject(login.getUser())
                        .claim("authorities", grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + 28800000))
                        .signWith(SignatureAlgorithm.HS256, pass.getBytes()).compact();
                success.setToken("Bearer " + token);
                success.setStatus(200);
                success.setMsg("ACESSO PERMITIDO");
                success.setAccess(user.get().getUserPermission());
                return new ResponseEntity<>(success, HttpStatus.OK);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}
