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
    protected ArrayList<QuestionsForm> questionslist = new ArrayList<>();


    public QuestionsList(){
        // hier nieuw questions aanmaken en toevoegen aan de questionslist
        belongsToRoomID = 1;
        questiontype = "openquestion";
        question = "Hoeveel dagen heeft een jaar?";
        questionOrAnswer.add("365");
        FunnyHint funhint1_1 = new FunnyHint("Een jaar heeft 1 dag minder dan een schrikkeljaar!");
        HelpHint hulphint1_1 = new HelpHint("Een jaar heeft 52 weken");
        hintList.add(funhint1_1);
        hintList.add(hulphint1_1);
        System.out.println(hintList.getFirst().getHintText());
        System.out.println(hintList.getLast().getHintText());
        QuestionsForm question1_1 = new QuestionsForm(belongsToRoomID, questiontype, question, questionOrAnswer, hintList);
        questionslist.add(question1_1);
        String hintText = questionslist.getFirst().getHints().getFirst().getHintText();
        System.out.println(hintText);
        questionOrAnswer.clear();
        hintList.clear();

        belongsToRoomID = 2;
        questionOrAnswer.add("7");
        question = "Hoeveel dagen in een week?";
        questiontype = "openQuestion";
        FunnyHint funhint = new FunnyHint("Heb jij de peuterspeelzaal wel gehaald?");
        HelpHint hulphint = new HelpHint("Je kan op je vingers tellen hoeveel er zijn.");
        hintList.add(funhint);
        hintList.add(hulphint);
        QuestionsForm question2_1 = new QuestionsForm(belongsToRoomID, questiontype, question, questionOrAnswer, hintList);
        questionslist.add(question2_1);
        questionOrAnswer.clear();
        hintList.clear();
    }

    public ArrayList<QuestionsForm> getQuestionslist() {
        return questionslist;
    }
    public ArrayList<QuestionsForm> getQuestionsListWithRoomID(int roomID) {
        ArrayList<QuestionsForm> tempRoomList = new ArrayList<>();
        for (int i =0; i<= questionslist.size(); i++){
            if (questionslist.get(i).getBelongsToRoomID() == roomID){
                tempRoomList.add(questionslist.get(i));
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