package com.finabil.springrest.controller;

import com.finabil.springrest.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    // Getting data via Body, Json format data
    @GetMapping   ("/hello")
    public HashMap<String, Object> hello(){
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("fullName", "FINabil");
        hm.put("Age", "-30");
        hm.put("hobbies", List.of("Nap", "Sleep", "ZZZzzzzz"));
        return hm;
    }

    // Posting/Submitting Data via body, Json format data
    // this is a basic request body field, we will work with model in later methods
    @PostMapping("/hello2")
    public void hello2(@RequestBody HashMap<String,Object>hm){
        System.out.println(hm.get("fullName"));
        System.out.println(hm.get("email"));
    }



    // via only path variable (Here we create the url by putting /info1/info2/... in postman)

    @PostMapping("/submit2/{fullName}/{nickname}")
    public void submit2(@PathVariable String fullName, @PathVariable String nickname){
        System.out.println(fullName + " " + nickname);
    }

    // Via path variable and query param both, (we will add key/values in postman query param field)
//    @PostMapping("/submit2/{fullName}")
//    public void submit2(@PathVariable String fullName, @RequestParam  String nickname){
//        System.out.println(fullName + " " + nickname);
//    }


    @GetMapping("/getsomething")
    public ResponseEntity<?> lol(){
        User user = new User();
        user.setFullName("Fahim Istiak Nabil");
        user.setAge(444);
        user.setHobbies(List.of("eat", "sleep", "code"));
      //  ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
     //   return responseEntity;
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/postsomething")
    public ResponseEntity<?> lel(@RequestBody User user){
        System.out.println(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // searchig user
    @GetMapping("find-user/{id}")
    public ResponseEntity<?> findUserId( @PathVariable Integer id){
        // imagining some DB searching
        System.out.println(id);
        if(id==1234){
            User user = new User("Reza", null, null);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            Map<String, String> errorResponse = new HashMap<>();
            // making the message Json type
            errorResponse.put("message", "User not found with this id");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

        }
    }

}