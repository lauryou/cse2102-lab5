package com.example.demo.model;

public class Login {

  private String email;
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() { 
    // every time call getContent (Spring calls)
    // -- putting count here may cause weird behavior as we don't have control over how many times it gets called.
    // in fact, as soon as view is put up, it's called once. why this matters: need a way to go through different q's
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}