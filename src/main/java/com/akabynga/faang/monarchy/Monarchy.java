package com.akabynga.faang.monarchy;

import java.util.*;

public class Monarchy {

    private final Map<String, Person> persons;

    public Monarchy() {
        this.persons = new LinkedHashMap<>();
    }

    public Monarchy(String king) {
        this.persons = new LinkedHashMap<>();
        this.persons.put(king, new Person(king));
    }

    public void birth(String childName, String parentName) {
        Person child = new Person(childName);
        persons.put(childName, child);

        Person parent = persons.get(parentName);
        parent.addChild(child);
    }

    public void death(String person) {
        if (persons.containsKey(person)) {
            persons.get(person).setAlive(false);
        }
    }

    public List<String> getOrderOfSuccession() {

        List<String> result = new ArrayList<>();
        Iterator<String> iterator = persons.keySet().iterator();
        if (iterator.hasNext()) {
            dfs(result, persons.get(iterator.next()));
        }

        return result;
    }

    private void dfs(List<String> order, Person person) {

        if (person.isAlive()) {
            order.add(person.getName());
        }

        for (int i = 0; i < person.getChildren().size(); i++) {
            dfs(order, person.getChildren().get(i));
        }
    }


}
