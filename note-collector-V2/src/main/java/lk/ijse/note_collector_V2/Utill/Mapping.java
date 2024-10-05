package lk.ijse.note_collector_V2.Utill;

import lk.ijse.nodecollecter.DTO.IMPL.NoteDTO;
import lk.ijse.nodecollecter.DTO.IMPL.UserDTO;
import lk.ijse.nodecollecter.Entity.EntityIMPL.NoteEntity;
import lk.ijse.nodecollecter.Entity.EntityIMPL.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public UserEntity toUserEntity(UserDTO userDTO){  //to user maping
        return modelMapper.map(userDTO,UserEntity.class);
    }
    public UserDTO touserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity,UserDTO.class);
    }
    public List<UserDTO>allUsers(List<UserEntity> userEntities){
        return modelMapper.map(userEntities,new TypeToken<List<UserDTO>>(){}.getType());
    }


    //note Entity
    public  NoteEntity toNoteEntity(NoteDTO noteDTO){return modelMapper.map(noteDTO,NoteEntity.class);}
    public NoteDTO toNoteDto(NoteEntity noteEntity){return modelMapper.map(noteEntity,NoteDTO.class);}
    public List<NoteDTO>allNotes(List<NoteEntity> noteEntities){
        return modelMapper.map(noteEntities,new TypeToken<List<NoteDTO>>(){}.getType());
    }
}
