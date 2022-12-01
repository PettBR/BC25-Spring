package org.soulcodeacademy.helpr.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

// O objetivo desta classe é:
// Validar JWT, gerar JWT e extrair dados do JWT

@Component // instaciar automaticamente o TokenUtil
public class TokenUtil {
    @Value("${senhaJwt}") // injeta o valor da variável (em application.properties) no campo abaixo
    private String senhaJwt;

    @Value("${validadeJwt}")
    private Long validadeJwt;


    public String gerarToken(String email, String perfil) { // Não uso o enum de perfil (Perfil perfil) porque o Jwt não suporta
        // System.currentTimeMillis() => Pega o momento atual em ms
        // new Date(System.currentTimeMillis() + this.validadeJwt) => Indica a data futura que o token vai expirar
        return JWT.create()
                .withSubject(email)
                .withClaim("perfil", perfil)
                .withExpiresAt(new Date(System.currentTimeMillis() + this.validadeJwt))
                .sign(Algorithm.HMAC512(this.senhaJwt));
    }

    public String extrairEmail(String token) {
        return JWT.require(Algorithm.HMAC512(this.senhaJwt))
                .build()
                .verify(token)
                .getSubject();
    }

    public boolean validarToken(String token) {
        // Caso ocorra erro no try, o token passado é inválido:
        // Não foi gerado por nós ou expirou
        try {
            JWT.require(Algorithm.HMAC512(this.senhaJwt))
                    .build()
                    .verify(token);
            return true;
        } catch(JWTVerificationException ex) {
            return false;
        }
    }

}
