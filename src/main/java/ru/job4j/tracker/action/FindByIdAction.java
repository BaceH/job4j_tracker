package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class FindByIdAction implements UserAction {

    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find Item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Show item ===");
        int id = input.askInt("Enter id: ");

        Item item = tracker.findById(id);

        if (item != null) {
            output.println(String.format("Item with id=%s:", id ));
            output.println(item);
        } else {
            output.println(String.format("Item with id=%s not found.", id));
        }
        return true;
    }
}
