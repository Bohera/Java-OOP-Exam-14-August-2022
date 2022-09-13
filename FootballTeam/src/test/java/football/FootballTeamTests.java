package football;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FootballTeamTests {

    private String expectedName;
    private int expectedVacantPositions;
    private FootballTeam footballTeam;
    private List<Footballer> footballers;

    @Before
    public void setUp() {
        expectedName = "Loko";

        expectedVacantPositions = 5;

        footballTeam = new FootballTeam(expectedName, expectedVacantPositions);

        footballers = new ArrayList<>();

        Footballer footballer = new Footballer("Pesho");
        Footballer footballer1 = new Footballer("Gosho");
        Footballer footballer2 = new Footballer("Tosho");
        Footballer footballer3 = new Footballer("Mosho");
        Footballer footballer4 = new Footballer("Losho");
        Footballer footballer5 = new Footballer("Vosho");

        footballers.add(footballer);
        footballers.add(footballer1);
        footballers.add(footballer2);
        footballers.add(footballer3);
        footballers.add(footballer4);
        footballers.add(footballer5);

    }

    @Test(expected = NullPointerException.class)
    public void test_SetName_ShouldThrowIfNameIsNull() {
        FootballTeam footballTeamNull = new FootballTeam(null, expectedVacantPositions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetVacantPositions_ShouldThrowIfLessThanZero() {
        FootballTeam footballTeamNegativeVacant = new FootballTeam(expectedName, -5);
    }

    @Test
    public void test_GetVacantPositions_ShouldThrowIfLessThanZero() {
        assertEquals(expectedVacantPositions, footballTeam.getVacantPositions());
    }

    @Test
    public void test_GetName() {
        assertEquals(expectedName, footballTeam.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddFootballer_ShouldThrowIfThereIsNoVacantPositionsLeft() {

        for (int i = 0; i < footballers.size(); i++) {
            footballTeam.addFootballer(footballers.get(i));
        }
    }

    @Test
    public void test_AddFootballer() {
        footballTeam.addFootballer(footballers.get(1));

        assertEquals(1, footballTeam.getCount());
    }

    @Test
    public void test_GetCount_ShouldReturnCountOfFootballers() {
        for (int i = 0; i < footballers.size() - 1; i++) {
            footballTeam.addFootballer(footballers.get(i));
        }

        assertEquals(footballers.size() - 1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveFootballer_ShouldThrowIfNameIsNull() {
        footballTeam.removeFootballer(null);
    }

    @Test
    public void test_RemoveFootballer_ShouldRemove() {
        footballTeam.addFootballer(footballers.get(1));
        footballTeam.removeFootballer(footballers.get(1).getName());
        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FootballerForSale_ShouldThrowIfThereIsSuchFootballer() {
        footballTeam.footballerForSale("Test");
    }

    @Test
    public void test_FootballerForSale_ShouldReturnFootballer() {
        for (int i = 0; i < footballers.size() - 1; i++) {
            footballTeam.addFootballer(footballers.get(i));
        }

        Footballer expectedFootballer = footballers.get(1);
        String footballerName = expectedFootballer.getName();

        assertEquals(expectedFootballer, footballTeam.footballerForSale(footballerName));
    }

    @Test
    public void test_FootballerForSale_ShouldSetGivenFootballerIsActiveToFalse() {
        for (int i = 0; i < footballers.size() - 1; i++) {
            footballTeam.addFootballer(footballers.get(i));
        }

        Footballer expectedFootballer = footballers.get(1);
        String footballerName = expectedFootballer.getName();
        footballTeam.footballerForSale(footballerName);

        assertFalse(expectedFootballer.isActive());
    }

    @Test
    public void test_GetStatistics_ShouldReturnCorrectMessage() {
        footballers.remove(5);

        for (int i = 0; i < footballers.size(); i++) {
            footballTeam.addFootballer(footballers.get(i));
        }

        String names = this.footballers
                .stream()
                .map(Footballer::getName)
                .collect(Collectors.joining(", "));

        String expectedMessage = String.format("The footballer %s is in the team %s.", names, expectedName);

        assertEquals(expectedMessage, footballTeam.getStatistics());

    }


}
