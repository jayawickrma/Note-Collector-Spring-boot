package lk.ijse.note_collector_V2.CustomStatusCode;

import lk.ijse.note_collector_V2.DTO.IMPL.UserDTO;
import lk.ijse.note_collector_V2.DTO.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserStatus extends UserDTO implements UserStatus {
    private int statusCode;
    private String statusMessage;
}
