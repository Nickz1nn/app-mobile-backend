//package com.appsport.appsportapi.infra.security;
//
//import com.appsport.appsportapi.domain.usuario.Usuario;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//
//@Service
//public class TokenService {
//    @Value("${api.security.token.secret}")
//    private String secret;
//
//    public String generateToken(Usuario usuario) {
//        try{
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            String token = JWT.create()
//                    .withIssuer("appsport-api")
//                    .withSubject(usuario.getEmail())
//                    .withExpiresAt(genExpirationDate())
//                    .sign(algorithm);
//            return token;
//        } catch (JWTCreationException exception) {
//            throw new RuntimeException("Error while generation token", exception);
//        }
//    }
//
//    public String validateToken(String token) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            var verifier = JWT.require(algorithm)
//                    .withIssuer("appsport-api")
//                    .build();
//            var decodedJWT = verifier.verify(token);
//            return decodedJWT.getSubject();
//        } catch (JWTVerificationException exception) {
//            throw new RuntimeException("Token inválido ou expirado", exception);
//        }
//    }
//
//
//    private Instant genExpirationDate(){
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//    }
//}