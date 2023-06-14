package StudyPass.tests;

import StudyPass.defcode.*;

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

        FlashCard flashCard1 = new FlashCard("¿Cuándo comenzó la revolución francesa en el juego de pelota?", "20 de junio de 1789", subject5);
        FlashCard flashCard2 = new FlashCard("¿Cuándo empezó la primera guerra mundial?", "28 de jul. de 1914", subject5);
        FlashCard flashCard3 = new FlashCard("¿Cuándo empezó la primera guerra mundial?", "1 de set. de 1939", subject5);
        FlashCard flashCard4 = new FlashCard("¿Cuándo empezó la guerra civil?", "17 de jul. de 1936", subject5);
        FlashCard flashCard5 = new FlashCard("¿Cuánto duró la guerra de los 100 años?", "116 años", subject5);

        FlashCard flashCard6 = new FlashCard("¿Está bien hecha la siguiente fórmula de pitágoras? a2 = √ c3 – b3", "No, la respuesta es a = √ c2 – b2", subject);
        FlashCard flashCard7 = new FlashCard("¿Cuanto es 4+8?", "12", subject);
        FlashCard flashCard8 = new FlashCard("¿Cuanto es 4+8(12-2)?", "84", subject);
        FlashCard flashCard9 = new FlashCard("¿Cuanto es √5?", "2,236067977", subject);
        FlashCard flashCard10 = new FlashCard("¿Cuanto es -1-1?", "-2", subject);

        FlashCard flashCard11 = new FlashCard("¿Cuando se acentúan las palabras llanas?", "Cuando no terminan en -n, en -s o en vocal", subject2);
        FlashCard flashCard12 = new FlashCard("¿Se puede poner acentos abiertos?", "No, sólo cerrados.", subject2);
        FlashCard flashCard13 = new FlashCard("¿Se dice Castellón o Castelló?", "Castellón", subject2);
        FlashCard flashCard14 = new FlashCard("¿Se dice Almassora o Almazora?", "Almazora", subject2);
        FlashCard flashCard15 = new FlashCard("¿Cómo se llama la persona que escribió el Quijote?", "Miguel de Cervantes Saavedra", subject2);

        FlashCard flashCard16 = new FlashCard("¿Cuál es el elemento número 6 en la tabla periódica?", "Carbono", subject1);
        FlashCard flashCard17 = new FlashCard("¿Cuál es la combinación molecular del agua usando la tabla periódica?", "H2O", subject1);
        FlashCard flashCard18 = new FlashCard("¿Cuál es la fórmula del peróxido de sodio?", "NA2O2", subject1);
        FlashCard flashCard19 = new FlashCard("¿Qué significa en la tabla periódica Pm?", "Promethium", subject1);
        FlashCard flashCard20 = new FlashCard("¿Cuántos elementos tiene la tabla periódica?", "118", subject1);

        FlashCard flashCard21 = new FlashCard("¿Qué es necesario usar cuando usamos el verbo en -ing?", "Be", subject3);
        FlashCard flashCard22 = new FlashCard("¿Cómo se dice en español play?", "Jugar", subject3);
        FlashCard flashCard23 = new FlashCard("¿Pronombre posesivo de you?", "yours", subject3);
        FlashCard flashCard24 = new FlashCard("¿Paso de la tercera columna de cut?", "cut", subject3);
        FlashCard flashCard25 = new FlashCard("¿Pasado del verbo play?", "played", subject3);

        FlashCard flashCard26 = new FlashCard("¿Qué es un string?", "Es una secuencia de caracteres usado para representar el texto", subject4);
        FlashCard flashCard27 = new FlashCard("¿Que es un bucle?", "Operaciones que se repiten indefinidamente o hasta que se cumple una condición.", subject4);
        FlashCard flashCard28 = new FlashCard("¿JAva es un lenguaje?", "No, el lenguaje de programación es Java", subject4);
        FlashCard flashCard29 = new FlashCard("¿Cxx existe como lenguaje de programación?", "No, en tal caso es C++", subject4);
        FlashCard flashCard30 = new FlashCard("¿Como se puede romper un bucle sin una condición y sin que pase la cantidad de veces que se debe de hacer?", "Con un break en cierta condición", subject4);


        subject5.addFlashCard(flashCard1);
        subject5.addFlashCard(flashCard2);
        subject5.addFlashCard(flashCard3);
        subject5.addFlashCard(flashCard4);
        subject5.addFlashCard(flashCard5);

        subject.addFlashCard(flashCard6);
        subject.addFlashCard(flashCard7);
        subject.addFlashCard(flashCard8);
        subject.addFlashCard(flashCard9);
        subject.addFlashCard(flashCard10);

        subject2.addFlashCard(flashCard11);
        subject2.addFlashCard(flashCard12);
        subject2.addFlashCard(flashCard13);
        subject2.addFlashCard(flashCard14);
        subject2.addFlashCard(flashCard15);

        subject1.addFlashCard(flashCard16);
        subject1.addFlashCard(flashCard17);
        subject1.addFlashCard(flashCard18);
        subject1.addFlashCard(flashCard19);
        subject1.addFlashCard(flashCard20);

        subject3.addFlashCard(flashCard21);
        subject3.addFlashCard(flashCard22);
        subject3.addFlashCard(flashCard23);
        subject3.addFlashCard(flashCard24);
        subject3.addFlashCard(flashCard25);

        subject4.addFlashCard(flashCard26);
        subject4.addFlashCard(flashCard27);
        subject4.addFlashCard(flashCard28);
        subject4.addFlashCard(flashCard29);
        subject4.addFlashCard(flashCard30);

        subject4.addUser(prof);
        subject4.addUser(user);
        subject1.addUser(prof);


        SubjectRepositoryImpl subjectRepository = new SubjectRepositoryImpl();
        subjectRepository.save(subject);
        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
        subjectRepository.save(subject3);
        subjectRepository.save(subject4);
        subjectRepository.save(subject5);

        FlashRepositoryImpl flashRepository = new FlashRepositoryImpl();
        flashRepository.save(flashCard1);
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
