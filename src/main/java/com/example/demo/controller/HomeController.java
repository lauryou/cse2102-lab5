package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Login;
import com.example.demo.model.Count;
import com.example.demo.model.Quiz;
import com.example.demo.model.Question;

@Controller
public class HomeController {

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/welcome")
    public String loginSubmit(@ModelAttribute Login login, Model model) {
        model.addAttribute("login", login);
        String email = login.getEmail();
        if (!email.contains("@")) {
            return "bad_email";
        }

        String password = login.getPassword();
        if (password.length() < 10) {
            return "bad_password";
        }

        return "welcome";
    }

    @GetMapping("/quiz") // get happens the first time, after is all post
    public String quizGet(Model model) {
        Count count = new Count();
        count.count = count.count + 1; // increment so that it starts at 1. in getQuestion / Answer methods, count is decremented to match index

        Question question = new Question();
        String newQuestion = question.getQuestion();
        question.setQuestion(newQuestion);

        String newAnswer = question.getAnswer();
        question.setAnswer(newAnswer);

        model.addAttribute("count", count);
        model.addAttribute("question", question);
        model.addAttribute("quiz", new Quiz());

        return "quiz";
    }

    @PostMapping("/quiz")
    public String quizPost(@ModelAttribute Quiz quiz, @ModelAttribute Count count, @ModelAttribute Question question, Model model) {
        model.addAttribute("quiz", quiz);

        String answer = quiz.getAnswer();
        if (answer.equals(question.getAnswer())) { // if answer matches, increase score
            quiz.setScore(quiz.getScore() + 20);
        }

        count.count = count.count + 1; // increment to get next question
        if (count.count > 5) { // 5 questions total (0-4 index). because of extra increment at start, need to stop after 5
            return "done";
        }
        
        String newQuestion = question.getQuestion();
        question.setQuestion(newQuestion);

        String newAnswer = question.getAnswer();
        question.setAnswer(newAnswer);

        return "quiz";
    }
}