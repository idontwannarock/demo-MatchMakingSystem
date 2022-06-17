package com.example;

import lombok.Data;

import java.util.Collections;
import java.util.List;

public class MatchMakingSystem {
    private final RankingStrategy rankingStrategy;
    private List<Individual> candidates;

    public MatchMakingSystem(RankingStrategy rankingStrategy, List<Individual> candidates) {
        if (rankingStrategy == null) throw new IllegalArgumentException("you must choose one ranking strategy");
        this.rankingStrategy = rankingStrategy;
        if (candidates.isEmpty()) throw new IllegalArgumentException("there must be at lease 1 candidate");
        this.candidates = candidates;
    }

    public MatchMakingSystem rankWith(Individual individual) {
        candidates = rankingStrategy.rank(individual, candidates);
        return this;
    }

    public MatchMakingSystem reverse() {
        Collections.reverse(candidates);
        return this;
    }

    public Individual match() {
        return candidates.get(0);
    }
}
