package lk.ijse.note_collector_V2.DAO;


import lk.ijse.note_collector_V2.Entity.EntityIMPL.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {  //as a parameeter you must include entity class and it's primary key type
    Optional<UserEntity> findByEmail(String email);
}
