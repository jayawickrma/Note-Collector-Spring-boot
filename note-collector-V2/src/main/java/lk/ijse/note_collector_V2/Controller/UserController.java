package lk.ijse.note_collector_V2.Controller;


import lk.ijse.note_collector_V2.CustomStatusCode.SelectedUserStatus;
import lk.ijse.note_collector_V2.DTO.IMPL.UserDTO;
import lk.ijse.note_collector_V2.DTO.UserStatus;
import lk.ijse.note_collector_V2.Exeptions.DataPersistExeption;
import lk.ijse.note_collector_V2.Utill.AppUtill;
import lk.ijse.note_collector_V2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(
           @RequestPart("firstName") String firstName,
           @RequestPart("lastName")  String lastName,
           @RequestPart("email") String email,
           @RequestPart("password") String password,
           @RequestPart("profilePic") MultipartFile profilePic
    ){
        try {
            //user id generate
            String userId = AppUtill.generateUserID();

            //profile pic convert to Base64
            String base64ProPic = AppUtill.generateProfilePicToBase64(profilePic);
            //todo:Build the Object
            UserDTO BuilduserDTO = new UserDTO();
            BuilduserDTO.setId(userId);
            BuilduserDTO.setFirstName(firstName);
            BuilduserDTO.setLastName(lastName);
            BuilduserDTO.setEmail(email);
            BuilduserDTO.setPassword(password);
            BuilduserDTO.setProfilePic(base64ProPic);

            userService.saveUser(BuilduserDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistExeption e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatus getSelectedUser(@PathVariable ("userId") String userId){
        String regexForUserID = "^USER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(userId);

        if(!regexMatcher.matches()){
            return new SelectedUserStatus(1,"User ID is not valid");
        }
        return  userService.getUser(userId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){

        return userService.getAllUsers();
    }
        @PutMapping(value = "/{userID}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser( @RequestPart("firstName") String firstName,
                            @RequestPart("lastName")  String lastName,
                            @RequestPart("email") String email,
                            @RequestPart("password") String password,
                            @RequestPart("profilePic") MultipartFile profilePic,
                            @PathVariable String userID){

        String base64ProPic = AppUtill.generateProfilePicToBase64(profilePic);

        UserDTO userDTO=new UserDTO();
        userDTO.setId(userID);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setProfilePic(base64ProPic);
               userService.updateUser(userID,userDTO);

    }

}
