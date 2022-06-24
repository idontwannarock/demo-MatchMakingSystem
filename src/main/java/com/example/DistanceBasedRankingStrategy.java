package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DistanceBasedRankingStrategy implements RankingStrategy {

    private final boolean shouldReverseRanking;

    public DistanceBasedRankingStrategy() {
        this.shouldReverseRanking = false;
    }

    public DistanceBasedRankingStrategy(boolean shouldReverseRanking) {
        this.shouldReverseRanking = shouldReverseRanking;
    }

    @Override
    public List<Individual> rank(Individual individual, List<Individual> candidates) {
        return candidates.stream()
                .sorted(shouldReverseRanking
                        ? Comparator
                            .comparingDouble(individual::distance)
                            .thenComparing(Individual::getId)
                            .reversed()
                        : Comparator
                            .comparingDouble(individual::distance)
                            .thenComparing(Individual::getId))
                .collect(Collectors.toList());
    }
}
