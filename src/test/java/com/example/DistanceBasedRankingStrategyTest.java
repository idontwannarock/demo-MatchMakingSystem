package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DistanceBasedRankingStrategyTest {

    @Test
    public void OnlyOneCandidate_ReturnThatCandidate() {
        // arrange
        Individual candidate = new Individual(1, Gender.MALE, 20, "", "", 1, 1);
        Individual individual = new Individual(2, Gender.FEMALE, 18, "", "", 1, 1);

        // act
        List<Individual> rankedCandidates = new DistanceBasedRankingStrategy().rank(individual, List.of(candidate));

        // assert
        Assert.assertEquals(1, rankedCandidates.size());
        Assert.assertEquals(candidate, rankedCandidates.get(0));
    }
}
