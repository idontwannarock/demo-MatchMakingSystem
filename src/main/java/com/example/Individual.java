package com.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@ToString
public class Individual {
    private final int id;
    private final Gender gender;
    private final int age;
    private final String introduction;
    private final List<String> habits;
    private final Coordinate coord;

    public Individual(int id, Gender gender, int age, String introduction, String habits, int x, int y) {
        if (id <= 0) throw new IllegalArgumentException("id must be larger than zero");
        this.id = id;
        this.gender = gender;
        if (age < 18) throw new IllegalArgumentException("age must be older than or equal to 18");
        this.age = age;
        if (introduction.length() > 200) throw new IllegalArgumentException("introduction cannot be longer than 200 words");
        this.introduction = introduction;
        this.habits = Arrays.stream(habits.split(",")).collect(Collectors.toList());
        this.coord = new Coordinate(x, y);
    }
}
