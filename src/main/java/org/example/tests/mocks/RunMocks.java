package org.example.tests.mocks;

import org.example.classes.items.Item;
import org.example.classes.questions.QuestionsForm;

public class RunMocks {
    public static void main(String[] args) {
        QuestionsListMock questionsMock = new QuestionsListMock();
        QuestionsForm q = questionsMock.getRandomQuestionWithQuestionSort("dailyStandup");

        System.out.println("did we get a *random* question? -> " + questionsMock.getRandomQuestionCalled);
        System.out.println("was the questionSort dailyStandup? -> " + "dailyStandup".equals(questionsMock.lastSortRequested)); 

        LootTableMock lootMock = new LootTableMock();
        Item dropped = lootMock.rollLoot();

        System.out.println("was RollLoot called? -> " + lootMock.wasRollLootCalled); 
        System.out.println("was dropped.getname equal to Test Sword? -> " + "Test Sword".equals(dropped.getName())); 
    }
}

