package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HabitBasedRankingStrategy implements RankingStrategy {

    private final boolean shouldReverseRanking;

    public HabitBasedRankingStrategy() {
        this.shouldReverseRanking = false;
    }

    public HabitBasedRankingStrategy(boolean shouldReverseRanking) {
        this.shouldReverseRanking = shouldReverseRanking;
    }

    @Override
    public List<Individual> rank(Individual individual, List<Individual> candidates) {
        return candidates.stream()
                .sorted(shouldReverseRanking
                        ? Comparator
                            .comparingLong(individual::countSameHabits).reversed()
                            .thenComparing(Individual::getId)
                            .reversed()
                        : Comparator
                            .comparingLong(individual::countSameHabits).reversed()
                            .thenComparing(Individual::getId))
                .collect(Collectors.toList());
    }
}
