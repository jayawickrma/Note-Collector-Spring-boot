package lk.ijse.note_collector_V2.service.IMPL;

import lk.ijse.note_collector_V2.service.JWTservice;
import org.springframework.security.core.userdetails.UserDetails;

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
}
