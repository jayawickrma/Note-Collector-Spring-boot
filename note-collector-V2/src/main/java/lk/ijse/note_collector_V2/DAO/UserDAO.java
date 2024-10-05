package lk.ijse.note_collector_V2.DAO;

import lk.ijse.nodecollecter.Entity.EntityIMPL.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {  //as a parameeter you must include entity class and it's primary key type

}
