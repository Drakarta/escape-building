package org.example.classes.rooms.cells;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.example.classes.hints.DisplayHint;
import org.example.classes.questions.Question;
import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.UnlockDoors;
import org.example.classes.singleton.CurrentRoom;

public class QuestionCell implements Cell {
    private QuestionsForm questionsForm;
    private final Random random = new Random();
    private boolean answered = false;

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
        if (answered){
            System.out.println("You've already answered this question!");
        } else {
            String questiontype = questionsForm.getQuestionType();
            String question = questionsForm.getQuestion();
            ArrayList<String> questionsOrAnswers = questionsForm.getQuestionsOrAnswers();
            Question questioner = new Question();
            boolean answer = questioner.ask(questiontype, question, questionsOrAnswers);

            if (answer) {
                System.out.println("Correct!");
                unlockDoors(room);
                answered = true;
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
    }

    public void unlockDoors(RoomLayout room){
        new UnlockDoors(room);
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

    public void setQuestion(QuestionsForm question) {
        if (question == null) {
            System.err.println("Question could not be set, door automatically unlocked");
            unlockDoors(CurrentRoom.getInstance().getCurrentRoom().getRoomLayout());

        } else {
            this.questionsForm = question;
        }
    }
}