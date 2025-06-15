package org.example.classes.questions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceQuestionsTest {

    private final InputStream systemIn = System.in;

    private ArrayList<String> getSampleAnswers() {
        return new ArrayList<>(List.of(
                "Optie 1",
                "Optie 1",
                "Optie 2",
                "Optie 3"
        ));
    }

    @AfterEach
    void restoreSystemInput() {
        System.setIn(systemIn);
    }

    @Test
    void testRandOnder_Keuze0() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MultipleChoiceQuestions mcq = new MultipleChoiceQuestions();
        boolean result = mcq.ask("Vraag?", getSampleAnswers());
        assertFalse(result, "Keuze 0 is ongeldig, moet false teruggeven");
    }

    @Test
    void testOndergrens_Keuze1() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MultipleChoiceQuestions mcq = new MultipleChoiceQuestions();
        boolean result = mcq.ask("Vraag?", getSampleAnswers());
        assertTrue(result, "Keuze 1 is goed antwoord");
    }

    @Test
    void testBinnenBereik_Keuze2() {
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MultipleChoiceQuestions mcq = new MultipleChoiceQuestions();
        boolean result = mcq.ask("Vraag?", getSampleAnswers());
        assertFalse(result, "Keuze 2 is fout antwoord");
    }

    @Test
    void testBovengrens_Keuze3() {
        String input = "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MultipleChoiceQuestions mcq = new MultipleChoiceQuestions();
        boolean result = mcq.ask("Vraag?", getSampleAnswers());
        assertFalse(result, "Keuze 3 is fout antwoord");
    }

    @Test
    void testRandBoven_Keuze4() {
        String input = "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MultipleChoiceQuestions mcq = new MultipleChoiceQuestions();
        boolean result = mcq.ask("Vraag?", getSampleAnswers());
        assertFalse(result, "Keuze 4 is ongeldig, moet false teruggeven");
    }
}
