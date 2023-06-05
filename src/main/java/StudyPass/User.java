package StudyPass;

import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private String type;
    private Progress progress;
    private ArrayList<Subject> subjects;

    public User(String username, String password, String type) {
        this.id = -1;
        this.username = username;
        this.password = password;
        this.type = type;
        this.progress = new Progress();
        this.subjects = new ArrayList<>();
    }


    public User(int id, String username, String password, String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.progress = new Progress();
    }

    public User(int id, String username, String password, String type, Progress progress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.progress = progress;
        this.subjects = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }
}
