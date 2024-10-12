package lk.ijse.note_collector_V2.Entity.EntityIMPL;


import jakarta.persistence.*;
import lk.ijse.note_collector_V2.Entity.Role;
import lk.ijse.note_collector_V2.Entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity, UserDetails {
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
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
