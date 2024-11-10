package com.example.demo;

import java.util.ArrayList;
import com.example.demo.model.Login;
import com.example.demo.model.Count;
import com.example.demo.model.Quiz;
import com.example.demo.model.Question;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class WebsiteApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void loginTest() {
		Login login = new Login();
		String email = "hello@hi.com";
		login.setEmail(email);
		Assertions.assertEquals(login.getEmail(), email);

		String password = "1234567890";
		login.setPassword(password);
		Assertions.assertEquals(login.getPassword(), password);
	}

	@Test
	public void questionTest() {
		ArrayList <String> arrayQTest = new ArrayList<String>();
		arrayQTest.add("Sea level has remained fairly constant throughout Earth's history.");
        arrayQTest.add("Melting sea ice has the potential to raise sea level by several meters.");
        arrayQTest.add("El Niño is the result of global warming.");
        arrayQTest.add("Plants on land have taken in approximately half of the carbon dioxide that humans have put into the atmosphere over the last several decades.");
        arrayQTest.add("The pull of gravity is the same everywhere on Earth.");

		ArrayList <String> arrayATest = new ArrayList<String>();
		arrayATest.add("False");
        arrayATest.add("False");
        arrayATest.add("False");
        arrayATest.add("False");
        arrayATest.add("False");

		Question questions = new Question();
		Count count = new Count();

		for (int i = 0; i < 5; i++) {
			count.count++;
			String newQuestion = questions.getQuestion();
        	questions.setQuestion(newQuestion);
			Assertions.assertEquals(newQuestion, arrayQTest.get(i));
			
			String newAnswer = questions.getAnswer();
        	questions.setAnswer(newAnswer);
			Assertions.assertEquals(newAnswer, arrayATest.get(i));
		}
	}

	@Test
	public void quizScoreTest() {
		Quiz quiz = new Quiz();
		Assertions.assertEquals(quiz.getScore(), 0);

		for (int i = 1; i < 100; i++) {
			quiz.setScore(i);
			Assertions.assertEquals(quiz.getScore(), i);
		}
	}

	@Test
	public void quizAnswerTest() {
		Quiz quiz = new Quiz();
		quiz.setAnswer("Hello world!");
		Assertions.assertEquals(quiz.getAnswer(), "Hello world!");
	}

}
