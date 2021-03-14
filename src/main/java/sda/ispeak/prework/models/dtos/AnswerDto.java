package sda.ispeak.prework.models.dtos;

public class AnswerDto {

    private String answerContent;

    private boolean isCorrect = false;

    public AnswerDto() {
    }

    public AnswerDto(String answerContent, boolean isCorrect) {
        this.answerContent = answerContent;
        this.isCorrect = isCorrect;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
