package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DistanceBasedRankingStrategy implements RankingStrategy {
    @Override
    public List<Individual> rank(Individual individual, List<Individual> candidates) {
        return candidates.stream()
                .sorted(Comparator
                        .comparingDouble(individual::distance)
                        .thenComparing(Individual::getId))
                .collect(Collectors.toList());
    }
}
