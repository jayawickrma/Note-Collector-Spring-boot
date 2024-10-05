package lk.ijse.note_collector_V2.DAO;


import lk.ijse.note_collector_V2.Entity.EntityIMPL.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {  //as a parameeter you must include entity class and it's primary key type

}
