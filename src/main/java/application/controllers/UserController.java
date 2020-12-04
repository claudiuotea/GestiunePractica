package application.controllers;

import application.Entities.User;
import application.repositories.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RepoUser repoUser;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
    Returns the username and the JWT if the user has an account, bad credentials otherwise
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody User user){
        try{
            User logged = repoUser.findByUsername(user.getUsername());
            if(bCryptPasswordEncoder.matches(user.getPassword(),logged.getPassword()))
            return new ResponseEntity<>(logged, HttpStatus.OK);
            else throw new ServerException("Incorrect username or password!");
        }
        catch(ServerException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
    Returns OK if the account was created, error otherwise
    We use bCryptPasswordEncoder to encode the password before we save it to database
     */
    @RequestMapping(value = "/register",method = RequestMethod.PUT)
    public ResponseEntity<?> updateAliment(@RequestBody User user){
        try{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
