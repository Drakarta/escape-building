package org.example.classes.rooms.cells;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.example.classes.Player;
import org.example.classes.combat.CombatLoop;
import org.example.classes.hints.DisplayHint;
import org.example.classes.monsters.Goblin;
import org.example.classes.monsters.Monster;
import org.example.classes.questions.Question;
import org.example.classes.questions.QuestionsForm;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.singleton.CurrentUser;

public class QuestionCell implements Cell {
    private QuestionsForm questionsForm;
    private final Random random = new Random();
    private boolean answered = false;
    private final List<DoorCell> observers = new ArrayList<>();

    public void addObserver(DoorCell observer) {
        this.observers.add(observer);
    }

    public void removeObserver(DoorCell observer) {
        this.observers.remove(observer);
    }

    public void updateObserversCorrect() {
        for (DoorCell observer : observers) {
            observer.unlock();  //Observer method call
        }
    }

    public void updateObserversIncorrect() {
        Scanner scanner = new Scanner(System.in);
        Player player = CurrentUser.getInstance().getCurrentPlayer();
        Monster goblin = new Goblin();
        CombatLoop combat = new CombatLoop(player, goblin, scanner);
        combat.startCombat();
    }

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
        if (answered) {
            System.out.println("You've already answered this question!");
        } else {
            String questiontype = questionsForm.getQuestionType();
            String question = questionsForm.getQuestion();
            ArrayList<String> questionsOrAnswers = questionsForm.getQuestionsOrAnswers();
            Question questioner = new Question();
            boolean answer = questioner.ask(questiontype, question, questionsOrAnswers);

            if (answer) {
                System.out.println("Correct!");
                updateObserversCorrect();  //Notify observers to unlock
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
                try {
                    Thread.sleep(1000);
                    System.out.println("Also Prepare for Combat...    GoodLuck!");
                    Thread.sleep(2000);
                }
                catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                updateObserversIncorrect();
            }
        }
    }

    public void displayHint() {
        ArrayList<DisplayHint> hints = questionsForm.getHints();
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
            updateObserversCorrect(); // Unlock doors if question is null
        } else {
            this.questionsForm = question;
        }
    }
}
