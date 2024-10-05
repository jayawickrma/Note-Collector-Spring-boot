package lk.ijse.note_collector_V2.Entity.EntityIMPL;

import jakarta.persistence.*;
import lk.ijse.nodecollecter.Entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity {
    @Id
    public String userID;
    public String firstName;
    public String lastName;
    @Column(unique = true)
    public String email;
    public String password;
    @Column(columnDefinition = "LONGTEXT")
    public String profilePic;
    @OneToMany(mappedBy = "user")
    public List<NoteEntity>note;
}
