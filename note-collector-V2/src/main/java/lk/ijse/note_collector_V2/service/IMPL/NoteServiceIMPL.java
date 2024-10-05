package lk.ijse.note_collector_V2.service.IMPL;

import lk.ijse.nodecollecter.DAO.NoteDAO;
import lk.ijse.nodecollecter.DTO.IMPL.NoteDTO;
import lk.ijse.nodecollecter.Entity.EntityIMPL.NoteEntity;
import lk.ijse.nodecollecter.Exeptions.DataPersistExeption;
import lk.ijse.nodecollecter.Utill.AppUtill;
import lk.ijse.nodecollecter.Utill.Mapping;
import lk.ijse.nodecollecter.service.NoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceIMPL implements NoteServices {
    @Autowired
    private NoteDAO noteDAO;
    @Autowired
    private Mapping Notemapping;

    @Override
    public void saveNote(NoteDTO noteDTO) {

        noteDTO.setNoteID(AppUtill.generateNoteID());
        NoteEntity savedNote =
                noteDAO.save(Notemapping.toNoteEntity(noteDTO));
        if(savedNote == null){
            throw new DataPersistExeption("Note not saved");
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        List<NoteEntity> allNotes =noteDAO.findAll();
        return Notemapping.allNotes(allNotes);
    }

    @Override
    public NoteDTO getNote(String noteID)    {
      NoteEntity selectedNote=  noteDAO.getReferenceById(noteID);
      return Notemapping.toNoteDto(selectedNote);
    }

    @Override
    public void deleteNote(String noteID) {
            noteDAO.deleteById(noteID);
    }

    @Override
    public void updateNote(String noteId, NoteDTO noteDTO) {

    }
}
