package edu.uploadfile.profile_upload.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/users"})
public class UserController {
    @GetMapping
    public String index(){
        return"index";
    }
}
