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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] resultItem = new Item[items.length];
        int size = 0;
        for (int i = 0; i < this.size; i++ ){
            if (items[i].getName().equals(key)){
                resultItem[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(resultItem, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int findId = indexOf(id);
        if (findId != -1) {
            item.setId(id);
            items[findId] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int findId = indexOf(id);
        if (findId != -1) {
            System.arraycopy(items, findId + 1, items, findId, size - findId);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}