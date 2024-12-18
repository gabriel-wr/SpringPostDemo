package com.diffblueTest.demoPost.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPostController{

       @PostMapping("/test")
       public ResponseEntity<String> test(@RequestBody String body) {
              System.out.println("Test post got called");
              return ResponseEntity.ok("Test post called");
       }

}
