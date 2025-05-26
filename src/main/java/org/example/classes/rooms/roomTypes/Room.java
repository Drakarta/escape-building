package org.example.classes.rooms.roomTypes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.example.classes.questions.QuestionsForm;
import org.example.classes.questions.QuestionsList;
import org.example.classes.rooms.Coordinates;
import org.example.classes.rooms.RoomLayout;
import org.example.classes.rooms.RoomTemplate;
import org.example.classes.rooms.cells.PlayerCell;

public class Room extends RoomTemplate {
    QuestionsForm questionsForm;
    RoomLayout roomLayout;
    public Room(int roomId, String name, RoomLayout roomLayout) {
        super(roomId, name, roomLayout);
        ArrayList<QuestionsForm> list = new QuestionsList().getQuestionsListWithRoomID(roomId);
        Random random = new Random();
        questionsForm = list.get(random.nextInt(list.size()));
        roomLayout.setQuestion(questionsForm);
        this.roomLayout = roomLayout;
    }

    @Override
    public void details() {

    }

    @Override
    public void displayRoom() {
        System.out.println(getName());
        super.getRoomLayout().printRoomLayout(new PlayerCell(new Coordinates(2, 2)));
    }

    @Override
    public void question() {
        
    }

    @Override
    public RoomLayout getRoomLayout() {
        return roomLayout;
    }
}
