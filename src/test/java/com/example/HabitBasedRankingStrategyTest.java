package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HabitBasedRankingStrategyTest {

    @Test
    public void GivenOnlyOneCandidate_ReturnThatCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "", 1, 1);
        Individual candidate = new Individual(2, Gender.MALE, 20, "", "", 1, 1);

        // act
        List<Individual> rankedCandidates = new HabitBasedRankingStrategy().rank(individual, List.of(candidate));

        // assert
        Assert.assertEquals(1, rankedCandidates.size());
        Assert.assertEquals(candidate, rankedCandidates.get(0));
    }

    @Test
    public void GivenTwoDifferentHabitsCandidate_ReturnFirstCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "jogging", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "jogging", 1, 1);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "mountaineering", 1, 1);

        // act
        List<Individual> rankedCandidates = new HabitBasedRankingStrategy().rank(individual, List.of(candidate1, candidate2));

        // assert
        Assert.assertEquals(2, rankedCandidates.size());
        Assert.assertEquals(candidate1, rankedCandidates.get(0));
    }

    @Test
    public void GivenTwoDifferentHabitsCandidate_ReturnSecondCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "jogging", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "mountaineering", 1, 1);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "jogging", 1, 1);

        // act
        List<Individual> rankedCandidates = new HabitBasedRankingStrategy().rank(individual, List.of(candidate1, candidate2));

        // assert
        Assert.assertEquals(2, rankedCandidates.size());
        Assert.assertEquals(candidate2, rankedCandidates.get(0));
    }

    @Test
    public void GivenTwoSameHabitsCandidate_ReturnFirstCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "jogging", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "jogging", 1, 1);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "jogging", 1, 1);

        // act
        List<Individual> rankedCandidates = new HabitBasedRankingStrategy().rank(individual, List.of(candidate1, candidate2));

        // assert
        Assert.assertEquals(2, rankedCandidates.size());
        Assert.assertEquals(candidate1, rankedCandidates.get(0));
    }

    @Test
    public void GivenTwoSameHabitsCandidate_ReturnSecondCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "jogging", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "jogging", 1, 1);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "jogging", 1, 1);

        // act
        List<Individual> rankedCandidates = new HabitBasedRankingStrategy().rank(individual, List.of(candidate2, candidate1));

        // assert
        Assert.assertEquals(2, rankedCandidates.size());
        Assert.assertEquals(candidate1, rankedCandidates.get(0));
    }

}