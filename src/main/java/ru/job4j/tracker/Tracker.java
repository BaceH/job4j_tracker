package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] tempItems = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                tempItems[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(tempItems, size);
    }

    public Item[] findByName(String key) {
        Item[] resultItem = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item.getName().equals(key)){
                resultItem[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(resultItem, size);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}