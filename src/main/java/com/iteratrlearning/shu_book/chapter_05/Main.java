package com.iteratrlearning.shu_book.chapter_05;

public class Main {

    public static void main(final String... args) {

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

    }
}
