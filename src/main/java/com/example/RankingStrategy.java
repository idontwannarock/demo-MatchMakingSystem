package com.example;

import java.util.List;

public interface RankingStrategy {
    List<Individual> rank(Individual individual, List<Individual> candidates);
}
