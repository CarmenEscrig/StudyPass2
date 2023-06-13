package StudyPass.tests;

import StudyPass.code.*;

import java.io.IOException;
import java.sql.SQLException;

public class Crear {
    public static void main(String[] args) throws SQLException, IOException {
        User user = new User("Pepe", "Taller2014", "estudiante");
        User prof = new User("Hector", "Taller2020", "profesor");

        Subject subject = new Subject("Matematicas");
        Subject subject1 = new Subject("Fisica y Quimica");
        Subject subject2 = new Subject("Castellano");
        Subject subject3 = new Subject("Ingles");
        Subject subject4 = new Subject("Programacion");
        Subject subject5 = new Subject("Historia");

        prof.addSubject(subject);
        prof.addSubject(subject4);

        user.addSubject(subject4);

        FlashCard flashCard = new FlashCard("Pregunta de programacion", "Respuesta muy elaborada", subject4);
        FlashCard flashCard2 = new FlashCard("Pregunta dificil de programacion", "Respuesta muy pocha", subject4);
        FlashCard flashCard3 = new FlashCard("Pregunta 3", "Respuesta muy elaborada", subject4);
        FlashCard flashCard4 = new FlashCard("Pregunta 4", "Respuesta muy pocha", subject4);
        FlashCard flashCard5 = new FlashCard("Pregunta 5", "Respuesta muy elaborada", subject4);
        FlashCard flashCard6 = new FlashCard("Pregunta 6 de programacion", "Respuesta muy pocha", subject4);
        FlashCard flashCard7 = new FlashCard("Pregunta 7 de programacion", "Respuesta muy elaborada", subject4);
        FlashCard flashCard8 = new FlashCard("Pregunta 8 de programacion", "Respuesta muy pocha", subject4);
        FlashCard flashCard9 = new FlashCard("Pregunta 9 de programacion", "Respuesta muy elaborada", subject4);
        FlashCard flashCard10 = new FlashCard("Pregunta 10 de programacion", "Respuesta muy pocha", subject4);
        FlashCard flashCard11 = new FlashCard("Pregunta 11 de programacion", "Respuesta muy elaborada", subject4);
        FlashCard flashCard12 = new FlashCard("Pregunta 12 de programacion", "Respuesta muy pocha", subject4);

        subject4.addFlashCard(flashCard);
        subject4.addFlashCard(flashCard2);



        SubjectRepositoryImpl subjectRepository = new SubjectRepositoryImpl();
        subjectRepository.save(subject);
        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
        subjectRepository.save(subject3);
        subjectRepository.save(subject4);
        subjectRepository.save(subject5);

        FlashRepositoryImpl flashRepository = new FlashRepositoryImpl();
        flashRepository.save(flashCard);
        flashRepository.save(flashCard2);
        flashRepository.save(flashCard3);
        flashRepository.save(flashCard4);
        flashRepository.save(flashCard5);
        flashRepository.save(flashCard6);
        flashRepository.save(flashCard7);
        flashRepository.save(flashCard8);
        flashRepository.save(flashCard9);
        flashRepository.save(flashCard10);
        flashRepository.save(flashCard11);
        flashRepository.save(flashCard12);

        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.save(user);
        userRepository.save(prof);




    }
}
