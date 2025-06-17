package org.example.classes.questions;

import org.example.classes.hints.DisplayHint;
import org.example.classes.hints.FunnyHint;
import org.example.classes.hints.HelpHint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionsList {
    protected String questionSort;
    protected String questiontype;
    protected String question;
    protected ArrayList<String> questionOrAnswer = new ArrayList<>();
    protected ArrayList<DisplayHint> hintList = new ArrayList<>();
    private ArrayList<QuestionsForm> questionslist = new ArrayList<>();


    public QuestionsList(){
        String multipleChoice = "multipleChoiceQuestions";
        String open = "openquestion";
        String multipleAnswer = "multipleAnswersQuestion";
        // hier nieuw questions aanmaken en toevoegen aan de questionslist
        questionSort = "introduction";
        questiontype = open;
        question = "Hoeveel dagen heeft een jaar?";
        questionOrAnswer.add("365");
        hintList.add(new FunnyHint("Een jaar heeft 1 dag minder dan een schrikkeljaar!"));
        hintList.add(new HelpHint("Een jaar heeft 52 weken"));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        questionSort = "sprintPlanning";
        questionOrAnswer.add("2 weken");
        questionOrAnswer.add("1 week");
        questionOrAnswer.add("2 weken");
        questionOrAnswer.add("1 maand");
        question = "Hoelang duren de sprints voor ons?";
        questiontype = multipleChoice;
        hintList.add(new FunnyHint("We hebben net genoeg tijd gehad om fortnite te spelen"));
        hintList.add(new HelpHint("3 sprints in 6 weken."));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        questionSort = "sprintPlanning";
        questionOrAnswer.add("Product Owner");
        questionOrAnswer.add("Scrum Master");      
        questionOrAnswer.add("Product Owner");     
        questionOrAnswer.add("Development Team");  
        question = "Wie bepaalt wat er in de sprint backlog komt?";
        questiontype = multipleChoice;
        hintList.add(new FunnyHint(""));
        hintList.add(new HelpHint("De sprint backlog wordt beheerd door de Scrum master."));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        questionSort = "TIA";
        questionOrAnswer.add("ja");
        question = "Was de game leuk?";
        questiontype = open;
        hintList.add(new FunnyHint("Niemand heeft een mes mee :)"));
        hintList.add(new HelpHint("Pas op voor het mes achter de laptop :)"));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        questionSort = "scrumBoard";
        questionOrAnswer.add("Product backlog");
        questionOrAnswer.add("Sprint backlog");
        questionOrAnswer.add("Doing");
        questionOrAnswer.add("Review");
        questionOrAnswer.add("Done");
        question = "Wat zijn de onderdelen van een trello board?";
        questiontype = multipleAnswer;
        hintList.add(new FunnyHint("Er zijn meer dan 2 onderdelen."));
        hintList.add(new HelpHint("Veel success man kon geen goede hint maken."));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        questionSort = "dailyScrum";
        questionOrAnswer.add("Wat je vandaag gaat doen.");
        questionOrAnswer.add("Wat je voor ontbijt had.");
        questionOrAnswer.add("Wat je vandaag gaat doen.");
        questionOrAnswer.add("Hoeveel je hebt geslapen.");
        question = "Wat moet in de daily standup worden genoemd?";
        questiontype = multipleChoice;
        hintList.add(new FunnyHint("Niemand boeit je prive leven loser."));
        hintList.add(new HelpHint("Het moet relevant zijn voor iedereen."));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        questionSort = "sprintReview";
        questionOrAnswer.add("Aan het begin van de week.");
        questionOrAnswer.add("Aan het begin van de week.");
        questionOrAnswer.add("Aan het einde van de week.");
        question = "Wanneer houd je een sprint review?";
        questiontype = multipleChoice;
        hintList.add(new FunnyHint("Het is niet een retrospective."));
        hintList.add(new HelpHint("Een review gaat over de vorige sprint."));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();

        questionSort = "retrospective";
        questionOrAnswer.add("Aan het einde van de week.");
        questionOrAnswer.add("Aan het begin van de week.");
        questionOrAnswer.add("Aan het einde van de week.");
        question = "Wanneer houd je een sprint retrospective?";
        questiontype = multipleChoice;
        hintList.add(new FunnyHint("Het is niet een review."));
        hintList.add(new HelpHint("Een retrospective gaat over de afgelopen sprint."));
        questionslist.add(new QuestionsForm(questionSort, questiontype, question, new ArrayList<>(questionOrAnswer), new ArrayList<>(hintList)));
        questionOrAnswer.clear();
        hintList.clear();
    }

    public List<QuestionsForm> getQuestionsListWithQuestionSort(String questionSort) {
        List<QuestionsForm> tempQuestionList = new ArrayList<>();
        for (QuestionsForm q : questionslist){
            if (q.getQuestionSort().equalsIgnoreCase(questionSort)){
                tempQuestionList.add(q);
            }
        }
        return tempQuestionList;
    }

    public QuestionsForm getRandomQuestionWithQuestionSort(String questionSort) {
        List<QuestionsForm> tempQuestionList = getQuestionsListWithQuestionSort(questionSort);
        if (tempQuestionList.isEmpty()) {
            System.err.println("No questions found for sort: " + questionSort);
            return null;  // Or throw exception, or handle differently
        }

        Random random = new Random();
        return tempQuestionList.get(random.nextInt(tempQuestionList.size()));
    }
}