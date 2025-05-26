package org.example.classes.questions;

import org.example.classes.hints.DisplayHint;
import org.example.classes.hints.FunnyHint;
import org.example.classes.hints.HelpHint;

import java.util.ArrayList;
import java.util.Random;

public class QuestionsList {
    protected int belongsToRoomID;
    protected String questiontype;
    protected String question;
    protected ArrayList<String> questionOrAnswer = new ArrayList<>();
    protected ArrayList<DisplayHint> hintList = new ArrayList<>();
    private ArrayList<QuestionsForm> questionslist = new ArrayList<>();


    public QuestionsList(){
        // hier nieuw questions aanmaken en toevoegen aan de questionslist
        belongsToRoomID = 1;
        questiontype = "openquestion";
        question = "Hoeveel dagen heeft een jaar?";
        questionOrAnswer.add("365");
        hintList.add(new FunnyHint("Een jaar heeft 1 dag minder dan een schrikkeljaar!"));
        hintList.add(new HelpHint("Een jaar heeft 52 weken"));
        questionslist.add(new QuestionsForm(belongsToRoomID, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        belongsToRoomID = 2;
        questionOrAnswer.add("7");
        question = "Hoeveel dagen in een week?";
        questiontype = "openQuestion";
        hintList.add(new FunnyHint("Heb jij de peuterspeelzaal wel gehaald?"));
        hintList.add(new HelpHint("Je kan op je vingers tellen hoeveel er zijn."));
        questionslist.add(new QuestionsForm(belongsToRoomID, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();
    }

    public ArrayList<QuestionsForm> getQuestionsListWithRoomID(int roomID) {
        ArrayList<QuestionsForm> tempRoomList = new ArrayList<>();
        for (QuestionsForm q : questionslist){
            if (q.getBelongsToRoomID() == roomID){
                tempRoomList.add(q);
            }
        }
        return tempRoomList;
    }

    public QuestionsForm getRandomQuestionWithRoomID(int roomID) {
        ArrayList<QuestionsForm> tempRoomList = new ArrayList<>();
        for (QuestionsForm q : questionslist){
            if (q.getBelongsToRoomID() == roomID){
                tempRoomList.add(q);
            }
        }
        Random random = new Random();
        return tempRoomList.get(random.nextInt(questionslist.size()));
    }
}
