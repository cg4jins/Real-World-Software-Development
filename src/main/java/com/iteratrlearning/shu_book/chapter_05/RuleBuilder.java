package com.iteratrlearning.shu_book.chapter_05;

public class RuleBuilder {

    private Condition condition;
    private Action action;
    private String name;
    private String description;

    public RuleBuilder() {

    }

    public RuleBuilder condition(Condition condition) {
        this.condition = condition;
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
        return new Rule(condition, action, name, description);
    }
}