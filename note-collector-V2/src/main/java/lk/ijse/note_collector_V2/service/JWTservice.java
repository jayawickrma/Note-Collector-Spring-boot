package lk.ijse.note_collector_V2.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTservice {
    String extractUserName(String token);
    String generateToken(UserDetails user);
    boolean validateToken(String token,UserDetails user);


}
