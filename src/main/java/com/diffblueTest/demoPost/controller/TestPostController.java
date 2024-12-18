package com.diffblueTest.demoPost.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPostController{

       @PostMapping("/test")
       public ResponseEntity<String> test(@RequestBody String body) {
              System.out.println("Test post got called");
              return ResponseEntity.ok("Test post called");
       }

       @PostMapping("/coverTest")
       public ResponseEntity<String> coverTest(@RequestBody RequestObject requestObject) {
              System.out.println("Posted "+requestObject.numberOfTests+" tests of type "+requestObject.testType);
              return ResponseEntity.ok("Cover test post called");
       }

       public static class RequestObject {
              public int numberOfTests;
              public String testType;

              public RequestObject(int numberOfTests, String testType) {
                     this.numberOfTests = numberOfTests;
                     this.testType = testType;
              }
       }
}
