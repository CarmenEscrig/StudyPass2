package StudyPass;

public class FlashCard {
    private long id;
    private String question;
    private String answer;
    private Subject subject;

    public FlashCard(String question, String answer, Subject subject) {
        this.id = -1;
        this.question = question;
        this.answer = answer;
        this.subject = subject;
    }
}
