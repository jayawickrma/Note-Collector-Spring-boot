package lk.ijse.note_collector_V2.DTO.IMPL;



import lk.ijse.note_collector_V2.DTO.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteDTO implements SuperDTO {
    public String noteID;
    public String noteTitle;
    public String noteDesc;
    public String createDate;
    public String priorityLevel;
    public String userId;
}
