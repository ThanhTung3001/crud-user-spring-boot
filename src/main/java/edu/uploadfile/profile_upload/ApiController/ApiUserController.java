package edu.uploadfile.profile_upload.ApiController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uploadfile.profile_upload.Entity.UserEntity;
import edu.uploadfile.profile_upload.Model.ResponseMessage;
import edu.uploadfile.profile_upload.Utils.FileUploadUtil;
import edu.uploadfile.profile_upload.config.ContextPath;
import edu.uploadfile.profile_upload.service.ServiceImp.UserServiceImp;
import edu.uploadfile.profile_upload.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = {"api/users"})
public class ApiUserController {



    final UserServiceImp userService;
    public ApiUserController(UserServiceImp userService,FileUploadUtil uploadUtil) {
        this.userService = userService;

    }

    @GetMapping
    public ResponseEntity<?>getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @PostMapping(value = {"/upload"})
    public ResponseEntity<?>Add(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam(value = "model",required = false) String model) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        FileUploadUtil  fileUploadUtil  =new FileUploadUtil();
        UserEntity user = mapper.readValue(model, UserEntity.class);
        fileUploadUtil.saveFile(ContextPath.resourcePath+"users",file.getOriginalFilename(),file);
        String pathFile = "/users/"+file.getOriginalFilename();
        user.setAvatarPath(pathFile);
       UserEntity userResponse = userService.save(user);
       return ResponseEntity.ok(userResponse);
    }
    @DeleteMapping
    public ResponseEntity<?>deleteByID(@RequestParam Long id) throws Exception {
       boolean success= userService.deleteById(id);
       return success?ResponseEntity.ok(ResponseMessage.builder().message("Delete success").code(200).data(success).build()):
               ResponseEntity.badRequest().body(ResponseMessage.builder().message("delete fail").code(200).data(success).build());
    }
}
