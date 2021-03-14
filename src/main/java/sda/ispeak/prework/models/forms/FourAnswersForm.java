package sda.ispeak.prework.models.forms;

import lombok.ToString;
import sda.ispeak.prework.models.questions.Question;

@ToString
public class FourAnswersForm {

    private String firstAnswerContent;
    private String secondAnswerContent;
    private String thirdAnswerContent;
    private String fourthAnswerContent;


    private boolean firstCorrect = false;
    private boolean secondCorrect = false;
    private boolean thirdCorrect = false;
    private boolean fourthCorrect = false;

    private Question question;

    public FourAnswersForm() {

    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
