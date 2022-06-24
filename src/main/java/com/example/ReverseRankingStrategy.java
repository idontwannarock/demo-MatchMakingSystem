package com.example;

import java.util.Collections;
import java.util.List;

public class ReverseRankingStrategy implements RankingStrategy {

    @Override
    public List<Individual> rank(Individual individual, List<Individual> candidates) {
        Collections.reverse(candidates);
        return candidates;
    }
}
