package com.example.demo.model;

import java.util.ArrayList;
import com.example.demo.model.Count;

public class Question {
    private ArrayList <String> arrayQuestions = new ArrayList<String>();
    private ArrayList <String> arrayAnswers = new ArrayList<String>();

    private String question;
    private String answer;

    public Question() { // class constructor
        arrayQuestions.add("Sea level has remained fairly constant throughout Earth's history.");
        arrayQuestions.add("Melting sea ice has the potential to raise sea level by several meters.");
        arrayQuestions.add("El Niño is the result of global warming.");
        arrayQuestions.add("Plants on land have taken in approximately half of the carbon dioxide that humans have put into the atmosphere over the last several decades.");
        arrayQuestions.add("The pull of gravity is the same everywhere on Earth.");

        arrayAnswers.add("False");
        arrayAnswers.add("False");
        arrayAnswers.add("False");
        arrayAnswers.add("False");
        arrayAnswers.add("False");
    }

    public String getQuestion() { // getter -- return question
        return arrayQuestions.get(Count.count - 1);
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return arrayAnswers.get(Count.count - 1);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}