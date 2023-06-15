package StudyPass.defcode;

import java.sql.SQLException;
//Esta es la clase que hace el progreso

public class Progress {
    private int id;
    private int correct;
    private int incorrect;

    public Progress() {
        this.id = -1;
        this.correct = 0;
        this.incorrect = 0;
    }

    public Progress(int id, int correct, int incorrect) {
        this.id = id;
        this.correct = correct;
        this.incorrect = incorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public void increaseCorrect() {
        this.correct ++;
        try {
            new ProgressRepositoryImpl().save(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void increaseIncorrect() {
        this.incorrect ++;
        try {
            new ProgressRepositoryImpl().save(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
