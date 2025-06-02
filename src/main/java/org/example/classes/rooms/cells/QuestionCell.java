package org.example.classes.rooms.cells;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.example.classes.hints.DisplayHint;
import org.example.classes.questions.Question;
import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomLayout;

public class QuestionCell implements Cell {
    private QuestionsForm questionsForm;
    Random random = new Random();

    @Override
    public String printIcon() {
        return "?";
    }

    @Override
    public boolean isWalkable() {
    return false;
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    @Override
    public void interact(PlayerCell player, RoomLayout room) {
        if (questionsForm == null) {
            System.err.println("No question assigned to this cell.");
            return;
        }

        String questiontype = questionsForm.getQuestionType();
        String question = questionsForm.getQuestion();
        ArrayList<String> questionsOrAnswers = questionsForm.getQuestionsOrAnswers();
        Question questioner = new Question();
        boolean answer = questioner.ask(questiontype, question, questionsOrAnswers);

        if (answer) {
            System.out.println("Correct!");
            unlockDoors(room);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            System.out.println("Wrong answer!");
            System.out.println("Do you want a hint? Y/N");
            Scanner sc = new Scanner(System.in);
            String hintYN = sc.nextLine();
            if (hintYN.equalsIgnoreCase("Y")) {
                displayHint();
            }
        }
    }

    public void unlockDoors(RoomLayout room){
        for (int y = 0; y < room.getRoomLayout().size(); y++) {
            for (int x = 0; x < room.getRoomLayout().get(y).size(); x++) {
                Cell cell = room.getCell(x, y);
                if (cell instanceof DoorCell) {
                    ((DoorCell) cell).unlock();
                }
            }
        }
        System.out.println("All doors have been unlocked.");
    }

     public void displayHint(){
         ArrayList<DisplayHint> hints = questionsForm.getHints();
         questionsForm.getHints().getFirst().getHintText();
         if (hints.isEmpty()) {
             System.out.println("No hints available.");
         } else {
             DisplayHint chosenHint = hints.get(random.nextInt(hints.size()));
             System.out.println(chosenHint.getHintText());
         }
     }

    @Override
    public void setQuestion(QuestionsForm question) {
        this.questionsForm = question;
    }


}