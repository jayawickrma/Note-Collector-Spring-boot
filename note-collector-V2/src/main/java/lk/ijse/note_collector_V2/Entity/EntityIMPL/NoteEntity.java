package lk.ijse.note_collector_V2.Entity.EntityIMPL;

import jakarta.persistence.*;
import lk.ijse.nodecollecter.Entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "note")
public class NoteEntity implements SuperEntity {
    @Id
    public String noteID;
    public String noteTitle;
    public String noteDesc;
    public String createDate;
    public String priorityLevel;
    @ManyToOne
    @JoinColumn(name = "userID",nullable = false)
    public UserEntity user;
}
