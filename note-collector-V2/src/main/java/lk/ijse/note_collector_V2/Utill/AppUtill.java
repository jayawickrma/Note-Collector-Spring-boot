package lk.ijse.note_collector_V2.Utill;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class AppUtill {
    public static String generateNoteID(){
        return "NOTE - " +  UUID.randomUUID();
    }
    public static String generateUserID(){
        return "USER - " +  UUID.randomUUID();
    }
    public static String generateProfilePicToBase64(MultipartFile profilePic){
        try {
            return Base64.getEncoder().encodeToString(profilePic.getBytes());  //converted to base64
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
