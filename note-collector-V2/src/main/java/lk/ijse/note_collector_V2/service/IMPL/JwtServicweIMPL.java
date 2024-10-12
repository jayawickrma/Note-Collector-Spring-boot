package lk.ijse.note_collector_V2.service.IMPL;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.websocket.Decoder;
import lk.ijse.note_collector_V2.service.JWTservice;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.function.Function;

import static org.springframework.security.config.Elements.JWT;

@Service
public class JwtServicweIMPL implements JWTservice {

    @Override
    public String extractUserName(String token) {
        return "";
    }

    @Override
    public String generateToken(UserDetails user) {
        return "";
    }

    @Override
    public boolean validateToken(String token, UserDetails user) {
        return false;
    }
    private <T> T ectractClaim(String token , Function<Claims,T> getSubject){
        getClames(token);
    }

    private Claims getClames(String token) {
        Jwts.parser().setSigningKey();
    }
    private Key getKey(String token){
    }
}
