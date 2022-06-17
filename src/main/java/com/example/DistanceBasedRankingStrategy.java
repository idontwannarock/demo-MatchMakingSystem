package com.example;

import java.util.List;

public class DistanceBasedRankingStrategy implements RankingStrategy {
    @Override
    public List<Individual> rank(Individual individual, List<Individual> candidates) {
        return candidates;
    }
}
