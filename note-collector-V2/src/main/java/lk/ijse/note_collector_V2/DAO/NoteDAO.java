package lk.ijse.note_collector_V2.DAO;


import lk.ijse.note_collector_V2.Entity.EntityIMPL.NoteEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDAO extends JpaRepository<NoteEntity,String> {
}
