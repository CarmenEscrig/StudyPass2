package StudyPass.code;

import java.util.ArrayList;

public class Subject {
    private int id;
    private String name;
    private ArrayList<User> users;
    private ArrayList<FlashCard> flashCards;

    public Subject(String name) {
        this.id = -1;
        this.name = name;
        this.users = new ArrayList<>();
        this.flashCards = new ArrayList<>();
    }

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<FlashCard> getFlashCards() {
        return flashCards;
    }

    public void setFlashCards(ArrayList<FlashCard> flashCards) {
        this.flashCards = flashCards;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addFlashCard(FlashCard flashCard) {
        this.flashCards.add(flashCard);
    }
}
