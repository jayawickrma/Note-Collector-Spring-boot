package lk.ijse.note_collector_V2.service.IMPL;

import jakarta.transaction.Transactional;
import lk.ijse.note_collector_V2.CustomStatusCode.SelectedUserStatus;
import lk.ijse.note_collector_V2.DAO.UserDAO;
import lk.ijse.note_collector_V2.DTO.IMPL.UserDTO;
import lk.ijse.note_collector_V2.Entity.EntityIMPL.UserEntity;
import lk.ijse.note_collector_V2.Exeptions.DataPersistExeption;
import lk.ijse.note_collector_V2.Utill.Mapping;
import lk.ijse.note_collector_V2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
  @Autowired
   private UserDAO userDAO;
  @Autowired
  private Mapping mapping;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity saveuser=userDAO.save(mapping.toUserEntity(userDTO));
        if (saveuser==null){
          throw new DataPersistExeption("something went wrong0");
        }
        return mapping.touserDTO(saveuser);

    }

  @Override
  public List<UserDTO> getAllUsers() {
    List<UserEntity> allUsers = userDAO.findAll();
    return mapping.allUsers(allUsers);
  }

  @Override
  public UserDTO getUser(String userId) {
      if (userDAO.existsById(userId)){
        UserEntity selectedUser = userDAO.getReferenceById(userId);
        return mapping.touserDTO(selectedUser);
      }else {
        return new SelectedUserStatus(2,"User With ID " + userId + " Not found");
      }

  }

  @Override
  public void deleteUser(String userId) {
      userDAO.deleteById(userId);

  }

  @Override
  public void updateUser(String userId, UserDTO userDTO) {
    Optional<UserEntity>id = userDAO.findById(userId);
      if (id.isPresent()){
        id.get().setFirstName(userDTO.getFirstName());
        id.get().setLastName(userDTO.getLastName());
        id.get().setEmail(userDTO.getEmail());
        id.get().setPassword(userDTO.getPassword());
        id.get().setProfilePic(userDTO.getProfilePic());
      }
  }
}

