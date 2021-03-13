package sda.ispeak.prework.models.questions;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
public class Question {

    @Id
    private long id;

    private String content;
    private String questionSubject;

    private String firstAnswerContent;
    private String secondAnswerContent;
    private String thirdAnswerContent;
    private String fourthAnswerContent;


    private boolean firstCorrect = false;
    private boolean secondCorrect = false;
    private boolean thirdCorrect = false;
    private boolean fourthCorrect = false;


    public Question() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestionSubject() {
        return questionSubject;
    }

    public void setQuestionSubject(String questionSubject) {
        this.questionSubject = questionSubject;
    }

    public String getFirstAnswerContent() {
        return firstAnswerContent;
    }

    public void setFirstAnswerContent(String firstAnswerContent) {
        this.firstAnswerContent = firstAnswerContent;
    }

    public String getSecondAnswerContent() {
        return secondAnswerContent;
    }

    public void setSecondAnswerContent(String secondAnswerContent) {
        this.secondAnswerContent = secondAnswerContent;
    }

    public String getThirdAnswerContent() {
        return thirdAnswerContent;
    }

    public void setThirdAnswerContent(String thirdAnswerContent) {
        this.thirdAnswerContent = thirdAnswerContent;
    }

    public String getFourthAnswerContent() {
        return fourthAnswerContent;
    }

    public void setFourthAnswerContent(String fourthAnswerContent) {
        this.fourthAnswerContent = fourthAnswerContent;
    }

    public boolean isFirstCorrect() {
        return firstCorrect;
    }

    public void setFirstCorrect(boolean firstCorrect) {
        this.firstCorrect = firstCorrect;
    }

    public boolean isSecondCorrect() {
        return secondCorrect;
    }

    public void setSecondCorrect(boolean secondCorrect) {
        this.secondCorrect = secondCorrect;
    }

    public boolean isThirdCorrect() {
        return thirdCorrect;
    }

    public void setThirdCorrect(boolean thirdCorrect) {
        this.thirdCorrect = thirdCorrect;
    }

    public boolean isFourthCorrect() {
        return fourthCorrect;
    }

    public void setFourthCorrect(boolean fourthCorrect) {
        this.fourthCorrect = fourthCorrect;
    }

}
