package org.example.classes.questions;

import org.example.classes.hints.DisplayHint;
import org.example.classes.hints.FunnyHint;
import org.example.classes.hints.HelpHint;

import java.util.ArrayList;
import java.util.Random;

public class QuestionsList {
    protected String questionSort;
    protected String questiontype;
    protected String question;
    protected ArrayList<String> questionOrAnswer = new ArrayList<>();
    protected ArrayList<DisplayHint> hintList = new ArrayList<>();
    private ArrayList<QuestionsForm> questionslist = new ArrayList<>();


    public QuestionsList(){
        // hier nieuw questions aanmaken en toevoegen aan de questionslist
        questionSort = "dailyStandup";
        questiontype = "openquestion";
        question = "Hoeveel dagen heeft een jaar?";
        questionOrAnswer.add("365");
        hintList.add(new FunnyHint("Een jaar heeft 1 dag minder dan een schrikkeljaar!"));
        hintList.add(new HelpHint("Een jaar heeft 52 weken"));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        questionSort = "review";
        questionOrAnswer.add("7");
        question = "Hoeveel dagen in een week?";
        questiontype = "openQuestion";
        hintList.add(new FunnyHint("Heb jij de peuterspeelzaal wel gehaald?"));
        hintList.add(new HelpHint("Je kan op je vingers tellen hoeveel er zijn."));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();
    }

    public ArrayList<QuestionsForm> getQuestionsListWithQuestionSort(String questionSort) {
        ArrayList<QuestionsForm> tempRoomList = new ArrayList<>();
        for (QuestionsForm q : questionslist){
            if (q.getQuestionSort().equalsIgnoreCase(questionSort)){
                tempRoomList.add(q);
            }
        }
        return tempRoomList;
    }

    public QuestionsForm getRandomQuestionWithQuestionSort(String questionSort) {
    ArrayList<QuestionsForm> tempRoomList = getQuestionsListWithQuestionSort(questionSort);
    
    if (tempRoomList.isEmpty()) {
        System.err.println("No questions found for sort: " + questionSort);
        return null;  // Or throw exception, or handle differently
    }

    Random random = new Random();
    return tempRoomList.get(random.nextInt(tempRoomList.size()));
}

}