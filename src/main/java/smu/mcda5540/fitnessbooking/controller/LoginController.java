package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.dto.Credential;
import smu.mcda5540.fitnessbooking.service_interface.LoginService;

@RequestMapping(value = "/data")
@CrossOrigin
@RestController
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody Credential credential) throws Exception {
        Object object = loginService.login(credential.getUsername(), credential.getPassword());

        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}