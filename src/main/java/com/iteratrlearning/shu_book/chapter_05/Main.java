package com.iteratrlearning.shu_book.chapter_05;

import java.io.IOException;

public class Main {

    public static void main(final String... args) throws IOException {

        var env = new Facts();
        env.addFact("name", "Bob");
        env.addFact("jobTitle", "CEO");

        final var businessRuleEngine = new BusinessRuleEngine(env);

        final Rule ruleSendEmailToSalesWhenCEO = new RuleBuilder()
                .name("CEO rule")
                .description("if CEO then print name")
                .condition(facts -> "CEO".equals(facts.getFact("jobTitle")))
                .action(facts -> {
                    var name = facts.getFact("name");
                    System.out.println("Relevant customer!!!: " + name);
                })
                .build();

        businessRuleEngine.addRule(ruleSendEmailToSalesWhenCEO);

        businessRuleEngine.run();

        var env2 = new Facts();
        env2.addFactsFromJsonFile("fact-data.json");

        final var businessRuleEngine2 = new BusinessRuleEngine(env2);

        final Rule rule2 = new RuleBuilder()
                .name("rule2")
                .description("print name, jobTitle")
                .condition(facts -> true)
                .action(facts -> {
                    var name = facts.getFact("name");
                    var jobTitle = facts.getFact("jobTitle");
                    System.out.println(name + " is " + jobTitle);
                })
                .build();

        businessRuleEngine2.addRule(rule2);

        businessRuleEngine2.run();

    }
}
