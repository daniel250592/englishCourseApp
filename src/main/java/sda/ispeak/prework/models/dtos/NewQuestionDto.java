package sda.ispeak.prework.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Builder
@AllArgsConstructor
public class NewQuestionDto {

    @NotBlank(message = "Wpisz id")
    @NotNull(message = "Wpisz id")
    private long id;

    @NotBlank(message = "Wpisz pytanie")
    @NotNull(message = "Wpisz pytanie")
    @Size(min = 10, max = 200, message = "Twoje pytanie nie spełnia standardów")
    private String question;
    private String questionSubject;

    @NotBlank(message = "Wpisz odpowiedź")
    @NotNull(message = "Wpisz odpowiedź")
    @Size(min = 1, max = 100, message = "Podana odpowiedź nie spełnia standardów")
    private String firstAnswerContent;
    @NotBlank(message = "Wpisz odpowiedź")
    @NotNull(message = "Wpisz odpowiedź")
    @Size(min = 1, max = 100, message = "Podana odpowiedź nie spełnia standardów")
    private String secondAnswerContent;
    @NotBlank(message = "Wpisz odpowiedź")
    @NotNull(message = "Wpisz odpowiedź")
    @Size(min = 1, max = 100, message = "Podana odpowiedź nie spełnia standardów")
    private String thirdAnswerContent;
    @NotBlank(message = "Wpisz odpowiedź")
    @NotNull(message = "Wpisz odpowiedź")
    @Size(min = 1, max = 100, message = "Podana odpowiedź nie spełnia standardów")
    private String fourthAnswerContent;


    private boolean firstCorrect = false;
    private boolean secondCorrect = false;
    private boolean thirdCorrect = false;
    private boolean fourthCorrect = false;


    public NewQuestionDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
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
