package com.shashank.quizapp.controller;
import com.shashank.quizapp.model.QuestionModel;
import com.shashank.quizapp.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("question")  //Parent routing
public class QuestionController {

    //    The question service
    @Autowired      //Auto wired is so I dont need to use the 'New' keyword
    QuestionService questionService;

    //Get all questions
    @GetMapping("allquestions")
    public List<QuestionModel> getAllQuestions(){
        return questionService.getAllQuestions();
    }


    //Get Question by Category
    @GetMapping("category/{category}")
    public List<QuestionModel> getQuestionById(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public QuestionModel addQuestions(@Valid @RequestBody QuestionModel question){
        return questionService.addQuestion(question);
//        return "Added successfully";
    }
}
