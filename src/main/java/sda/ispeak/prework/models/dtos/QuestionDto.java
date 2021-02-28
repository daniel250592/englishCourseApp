package sda.ispeak.prework.models.dtos;

import com.sun.istack.NotNull;
import lombok.ToString;
import sda.ispeak.prework.models.questions.QuestionSubject;

import javax.validation.constraints.Size;

@ToString
public class QuestionDto {

    @NotNull
    private QuestionSubject subject;

    @NotNull
    @Size(min = 15, max = 250, message = "Twoje pytanie nie spełnia standardów")
    private String content;

    public QuestionDto() {
    }

    public QuestionDto(String subject, String content) {
        this.subject = QuestionSubject.valueOf(subject);
        this.content = content;
    }

    public QuestionSubject getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public void setSubject(String subject) {
        this.subject = QuestionSubject.valueOf(subject);
    }

    public void setContent(String content) {
        this.content = content;
    }
}
