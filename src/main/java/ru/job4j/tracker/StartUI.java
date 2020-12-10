package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item(1, "first");
        tracker.add(itemFirst);
        Item itemSecond = new Item(2, "second");
        tracker.add(itemSecond);
        Item find = tracker.findById(1);
        System.out.println(find.toString());
     }
}
