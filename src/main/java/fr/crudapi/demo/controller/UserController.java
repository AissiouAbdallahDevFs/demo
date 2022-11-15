package fr.crudapi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import fr.crudapi.demo.request.UserRequest;
import fr.crudapi.demo.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
    public ResponseEntity<?> viewUser(@Valid @RequestBody UserRequest userRequest) {

        try {
            return new ResponseEntity<>(userService.creatUser(userRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }
	@GetMapping("/")
    public ResponseEntity<?> viewUser() {

        try {
            return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }
	}
     @GetMapping("/{id}")
        public ResponseEntity<?> viewUserID(@PathVariable(required=true)Long id) {

            try {
                return new ResponseEntity<>(userService.getUserId(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);

            }

    }
    @PutMapping("/{id}")
     public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequest userRequest,@PathVariable(required=true)Long id) {

         try {
             return new ResponseEntity<>(userService.updateUser(userRequest,id), HttpStatus.OK);
         } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.CONFLICT);

         }

     }

}
