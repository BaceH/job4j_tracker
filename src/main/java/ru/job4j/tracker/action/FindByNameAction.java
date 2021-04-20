package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class FindByNameAction implements UserAction {

    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Show items ===");
        String name = input.askStr("Enter name Item to search: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            output.println(String.format("Item with name=%s:", name ));
            tracker.print(items, output);
        } else {
            output.println(String.format("Item with name=%s not found.", name));
        }
        return true;
    }
}
