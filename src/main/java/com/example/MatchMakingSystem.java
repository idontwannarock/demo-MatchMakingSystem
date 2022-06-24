package com.example;

import java.util.List;

public class MatchMakingSystem {
    private List<Individual> candidates;
    private final RankingStrategy[] strategies;

    public MatchMakingSystem(List<Individual> candidates, RankingStrategy... strategies) {
        if (candidates.isEmpty()) throw new IllegalArgumentException("there must be at lease 1 candidate");
        this.candidates = candidates;
        if (strategies == null || strategies.length == 0) throw new IllegalArgumentException("you must choose at least 1 ranking strategy");
        this.strategies = strategies;
    }

    public MatchMakingSystem rankWith(Individual individual) {
        for (RankingStrategy strategy : strategies) {
            candidates = strategy.rank(individual, candidates);
        }
        return this;
    }

    public Individual match() {
        return candidates.get(0);
    }
}
