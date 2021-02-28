package sda.ispeak.prework.models.mappers;



import sda.ispeak.prework.models.forms.FourAnswersForm;
import sda.ispeak.prework.models.questions.Answer;

import java.util.ArrayList;
import java.util.List;

public class FourAnswersMapper {

    public static List<Answer> map(FourAnswersForm fourAnswersForm) {

        List<Answer> answers = new ArrayList<>();

        Answer first = new Answer(fourAnswersForm.getFirstAnswerContent(), fourAnswersForm.isFirstCorrect());
        Answer second = new Answer(fourAnswersForm.getSecondAnswerContent(), fourAnswersForm.isSecondCorrect());
        Answer third = new Answer(fourAnswersForm.getThirdAnswerContent(), fourAnswersForm.isThirdCorrect());
        Answer fourth = new Answer(fourAnswersForm.getFourthAnswerContent(), fourAnswersForm.isFourthCorrect());

        answers.add(first);
        answers.add(second);
        answers.add(third);
        answers.add(fourth);

        return answers;
    }
}
