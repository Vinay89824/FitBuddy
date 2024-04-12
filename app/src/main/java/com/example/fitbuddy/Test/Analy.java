package com.example.giatorsjava.Test;

public class Analy {
    public String question;
    public String choose_A;
    public String choose_B;
    public String choose_C;
    public String choose_D;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoose_A() {
        return choose_A;
    }

    public void setChoose_A(String choose_A) {
        this.choose_A = choose_A;
    }

    public String getChoose_B() {
        return choose_B;
    }

    public void setChoose_B(String choose_B) {
        this.choose_B = choose_B;
    }

    public String getChoose_C() {
        return choose_C;
    }

    public void setChoose_C(String choose_C) {
        this.choose_C = choose_C;
    }

    public String getChoose_D() {
        return choose_D;
    }

    public void setChoose_D(String choose_D) {
        this.choose_D = choose_D;
    }

    public Analy(String question, String choose_A, String choose_B, String choose_C, String choose_D) {
        this.question = question;
        this.choose_A = choose_A;
        this.choose_B = choose_B;
        this.choose_C = choose_C;
        this.choose_D = choose_D;
    }
}
