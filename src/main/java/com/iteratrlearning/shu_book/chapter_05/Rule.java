package com.iteratrlearning.shu_book.chapter_05;

public class Rule {

    private Condition condition;
    private Action action;
    private String name;
    private String description;

    public Rule(Condition condition, Action action, String name, String description) {
        this.condition = condition;
        this.action = action;
        this.name = name;
        this.description = description;
    }

    public void perform(Facts facts) {
        if(condition.evaluate(facts)){
            action.execute(facts);
        }
    }
}
