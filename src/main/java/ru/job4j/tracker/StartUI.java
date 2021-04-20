package ru.job4j.tracker;

import ru.job4j.tracker.action.ReplaceAction;
import ru.job4j.tracker.io.ConsoleInput;
import ru.job4j.tracker.io.ConsoleOutput;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class StartUI {
    public static void main(String[] args) {
//        Item itemFirst = new Item(1, "first");
//        System.out.println(itemFirst.toString());

        Output output = new ConsoleOutput();
        Input input =new ConsoleInput();
        Tracker tracker = new Tracker();
        ReplaceAction replaceAction = new ReplaceAction(output);

        replaceAction.execute(input, tracker);
     }
}
