package sda.ispeak.prework.models.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Component()
@SessionScope
public class QuestionIdManager {

    private final Queue<Long> idQueue = new LinkedList<>();
    private boolean isEmpty = true;


    public void addValuesToQueue(List<Long> idList) {
        idList.forEach(idQueue::offer);
        isEmpty = false;
    }

    public Long pollNextId() {
        return idQueue.poll();
    }

    public boolean isEmpty() {
        return isEmpty;
    }
    public Long peekNextId(){
        return idQueue.peek();
    }

}
