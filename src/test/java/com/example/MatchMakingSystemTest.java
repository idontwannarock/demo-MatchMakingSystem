package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MatchMakingSystemTest {

    @Test
    public void GivenDistanceBasedRankingStrategy_ReturnSuitableCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "", 2, 2);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "", 1, 1);

        // act
        Individual actual = new MatchMakingSystem(new DistanceBasedRankingStrategy(), List.of(candidate1, candidate2))
                .rankWith(individual)
                .match();

        // assert
        Assert.assertEquals(candidate2, actual);
    }

    @Test
    public void GivenDistanceBasedRankingStrategyInReverse_ReturnSuitableCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "", 2, 2);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "", 1, 1);

        // act
        Individual actual = new MatchMakingSystem(new DistanceBasedRankingStrategy(), List.of(candidate1, candidate2))
                .rankWith(individual)
                .reverse()
                .match();

        // assert
        Assert.assertEquals(candidate1, actual);
    }

    @Test
    public void GivenHabitBasedRankingStrategy_ReturnSuitableCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "jogging", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "mountaineering", 1, 1);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "jogging", 1, 1);

        // act
        Individual actual = new MatchMakingSystem(new HabitBasedRankingStrategy(), List.of(candidate1, candidate2))
                .rankWith(individual)
                .match();

        // assert
        Assert.assertEquals(candidate2, actual);
    }

    @Test
    public void GivenHabitBasedRankingStrategyInReverse_ReturnSuitableCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "jogging", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "mountaineering", 1, 1);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "jogging", 1, 1);

        // act
        Individual actual = new MatchMakingSystem(new HabitBasedRankingStrategy(), List.of(candidate1, candidate2))
                .rankWith(individual)
                .reverse()
                .match();

        // assert
        Assert.assertEquals(candidate1, actual);
    }

}