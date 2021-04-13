package com.iteratrlearning.shu_book.chapter_05;

import java.util.Arrays;

public class Rule {

    private Condition[] conditions;
    private Action action;
    private String name;
    private String description;

    public Rule(Condition[] conditions, Action action, String name, String description) {
        this.conditions = conditions;
        this.action = action;
        this.name = name;
        this.description = description;
    }

    public void perform(Facts facts) {
        if (Arrays.stream(conditions).allMatch(condition -> condition.evaluate(facts))) {
            action.execute(facts);
        }
    }
}
