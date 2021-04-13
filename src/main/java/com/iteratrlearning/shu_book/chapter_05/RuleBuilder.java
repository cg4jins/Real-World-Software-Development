package com.iteratrlearning.shu_book.chapter_05;

public class RuleBuilder {

    private Condition[] conditions;
    private Action action;
    private String name;
    private String description;

    public RuleBuilder() {

    }

    public RuleBuilder conditions(Condition ... conditions) {
        this.conditions = conditions;
        return this;
    }

    public RuleBuilder action(Action action) {
        this.action = action;
        return this;
    }

    public RuleBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RuleBuilder description(String description) {
        this.description = description;
        return this;
    }

    public Rule build() {
        return new Rule(conditions, action, name, description);
    }
}