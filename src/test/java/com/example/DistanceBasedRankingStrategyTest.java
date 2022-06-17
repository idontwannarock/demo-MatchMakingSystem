package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DistanceBasedRankingStrategyTest {

    @Test
    public void OnlyOneCandidate_ReturnThatCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "", 1, 1);
        Individual candidate = new Individual(2, Gender.MALE, 20, "", "", 1, 1);

        // act
        List<Individual> rankedCandidates = new DistanceBasedRankingStrategy().rank(individual, List.of(candidate));

        // assert
        Assert.assertEquals(1, rankedCandidates.size());
        Assert.assertEquals(candidate, rankedCandidates.get(0));
    }

    @Test
    public void TwoCandidates_ReturnFirstCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 20, "", "", 1, 1);
        Individual candidate2 = new Individual(3, Gender.MALE, 21, "", "", 2, 2);

        // act
        List<Individual> rankedCandidates = new DistanceBasedRankingStrategy().rank(individual, List.of(candidate1, candidate2));

        // assert
        Assert.assertEquals(2, rankedCandidates.size());
        Assert.assertEquals(candidate1, rankedCandidates.get(0));
    }

    @Test
    public void TwoCandidates_ReturnSecondCandidate() {
        // arrange
        Individual individual = new Individual(1, Gender.FEMALE, 18, "", "", 1, 1);
        Individual candidate1 = new Individual(2, Gender.MALE, 21, "", "", 2, 2);
        Individual candidate2 = new Individual(3, Gender.MALE, 20, "", "", 1, 1);

        // act
        List<Individual> rankedCandidates = new DistanceBasedRankingStrategy().rank(individual, List.of(candidate1, candidate2));

        // assert
        Assert.assertEquals(2, rankedCandidates.size());
        Assert.assertEquals(candidate2, rankedCandidates.get(0));
    }

}
