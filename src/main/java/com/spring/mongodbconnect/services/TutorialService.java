package com.spring.mongodbconnect.services;

import com.spring.mongodbconnect.models.Tutorial;
import com.spring.mongodbconnect.repositories.TutorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TutorialService {
    @Autowired
    TutorialRepo tutorialRepo;

    public Tutorial saveTutorial(Tutorial tutorial){
        tutorialRepo.save(tutorial);
        return tutorialRepo.findById(tutorial.getIdNum()).orElse(null);
    }

    public Tutorial getTutorial(String id){
        return tutorialRepo.findById(id).orElse(null);
    }

    public List<Tutorial> getAllTutorials(){
        return tutorialRepo.findAll();
    }

    public boolean deleteTutorial(String id){
        tutorialRepo.deleteById(id);
        Tutorial checkTutorial = this.getTutorial(id);
        return Objects.isNull(checkTutorial);
    }
}
