package com.example.demo.model;

public class Quiz {

  private static int score;
  private String answer;

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getAnswer() { 
    // every time call getContent (Spring calls)
    // -- putting count here may cause weird behavior as we don't have control over how many times it gets called.
    // in fact, as soon as view is put up, it's called once. why this matters: need a way to go through different q's
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}