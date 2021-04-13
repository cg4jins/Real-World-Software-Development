package com.iteratrlearning.shu_book.chapter_05;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Facts {

    private static final String RESOURCES = "src/main/resources/";

    private final Map<String, String> facts = new HashMap<>();

    public String getFact(String name) {
        return this.facts.get(name);
    }

    public void addFact(String name, String value) {
        this.facts.put(name, value);
    }

    public void addFactsFromJsonFile(String file) throws IOException {
        final Path path = Paths.get(RESOURCES + file);
        final String json = Files.readString(path);
        final ObjectMapper mapper = new ObjectMapper();
        final Map<String, String> map = mapper.readValue(json, new TypeReference<>() {
        });

        facts.putAll(map);
    }

}
