package ru.job4j.tracker.action;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Tracker;

public class CreateAction implements UserAction {

    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Create new item ===");
        String name = input.askStr("Enter new name for new Item: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("New item: " + item.toString());
        return true;
    }
}
