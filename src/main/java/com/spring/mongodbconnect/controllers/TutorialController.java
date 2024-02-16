package com.spring.mongodbconnect.controllers;

import com.spring.mongodbconnect.models.Tutorial;
import com.spring.mongodbconnect.services.TutorialService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;

    @GetMapping(value = "/tutorials")
    public ResponseEntity<?> getTutorials(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tutorialService.getAllTutorials());
    }

    @GetMapping(value = "/tutorials/{id}")
    public ResponseEntity<?> getTutorial(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tutorialService.getTutorial(id));
    }

    @PostMapping(value = "tutorials")
    public ResponseEntity<?> addTutorial(@RequestBody Tutorial tutorial){
        Tutorial tutorialObj = this.tutorialService.saveTutorial(tutorial);
        if (tutorialObj!=null){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(tutorialObj);
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tutorial not created");
    }

    @PutMapping(value = "tutorials/")
    public ResponseEntity<?> updateTutorial(@RequestBody Tutorial tutorial){
        Tutorial baseObj = this.tutorialService.getTutorial(tutorial.getIdNum());
        if (baseObj!=null){
            Tutorial tutorialObj = this.tutorialService.saveTutorial(tutorial);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(tutorialObj);
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tutorial not found");


    }

    @DeleteMapping(value = "tutorials/{id}")
    public ResponseEntity<?> deleteTutorial(@RequestParam("id") String id){
        Tutorial checkTutorial = this.tutorialService.getTutorial(id);
        boolean deleteBool = this.tutorialService.deleteTutorial(id);
        if (checkTutorial!=null && deleteBool){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Tutorial " + id + " deleted");
        }else if (checkTutorial!=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Attempt to deleted tutorial " + id + " but could not do so.");
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tutorial " + id + " could not be found.");
    }
}
