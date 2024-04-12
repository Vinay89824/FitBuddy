package com.example.giatorsjava.Test;

public class Situations {
public String questions;
public String choice_a;
public String choice_b;
public String choice_c;
public String choice_d;

    public Situations(String questions, String choice_a, String choice_b, String choice_c, String choice_d) {
        this.questions = questions;
        this.choice_a = choice_a;
        this.choice_b = choice_b;
        this.choice_c = choice_c;
        this.choice_d = choice_d;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getChoice_a() {
        return choice_a;
    }

    public void setChoice_a(String choice_a) {
        this.choice_a = choice_a;
    }

    public String getChoice_b() {
        return choice_b;
    }

    public void setChoice_b(String choice_b) {
        this.choice_b = choice_b;
    }

    public String getChoice_c() {
        return choice_c;
    }

    public void setChoice_c(String choice_c) {
        this.choice_c = choice_c;
    }

    public String getChoice_d() {
        return choice_d;
    }

    public void setChoice_d(String choice_d) {
        this.choice_d = choice_d;
    }
}
