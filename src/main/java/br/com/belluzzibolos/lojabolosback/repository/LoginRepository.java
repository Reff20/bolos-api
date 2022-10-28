package br.com.belluzzibolos.lojabolosback.repository;

import br.com.belluzzibolos.lojabolosback.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Integer> {

    @Query(value = "SELECT * FROM TB_USER WHERE USER_FULLNAME=:fullname", nativeQuery = true)
    Optional<LoginModel> findByFullName(@Param("fullname") String fullname);

    @Query(value = "SELECT * FROM TB_USER WHERE USER_NAME=:username", nativeQuery = true)
    Optional<LoginModel> findByUserName(@Param("username") String username);
}
