package lk.ijse.note_collector_V2.DTO.IMPL;


import lk.ijse.note_collector_V2.DTO.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserStatus {
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String profilePic;
    public List<NoteDTO> notes;
}
