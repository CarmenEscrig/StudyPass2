package StudyPass.code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FlashCard {
    private int id;
    private String question;
    private String answer;
    private Subject subject;

    public FlashCard() {
        this.id = -1;
        this.question = "";
        this.answer = "";
    }

    public FlashCard(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }


    public FlashCard(String question, String answer, Subject subject) {
        this.id = -1;
        this.question = question;
        this.answer = answer;
        this.subject = subject;
    }

    public FlashCard(int id, String question, String answer, Subject subject) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.subject = subject;
    }

    public void transformToFile() throws IOException {
        File file = new File("src/main/resources/FlashCards/" + this.id + ".txt");
        file.createNewFile();

        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        printWriter.print(this.id + "@");
        printWriter.print(this.question + "@");
        printWriter.print(this.answer + "@");
        printWriter.print(this.subject.getId());

        printWriter.close();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
