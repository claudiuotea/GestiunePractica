package application.controllers;

import application.Entities.User;
import application.repositories.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    RepoUser repoUser;

    /*
    Returns the username and the JWT if the user has an account, bad credentials otherwise
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody User user){
        try{
            User logged = repoUser.findUser(user);
            return new ResponseEntity<>(logged, HttpStatus.OK);
        }
        catch(ServerException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
    Returns OK if the account was created, error otherwise
     */
    @RequestMapping(value = "/register",method = RequestMethod.PUT)
    public ResponseEntity<?> updateAliment(@RequestBody User user){
        try{
            repoUser.addUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (ServerException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String error(ServerException e){return e.getMessage();}


}
