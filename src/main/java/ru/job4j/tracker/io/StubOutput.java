package ru.job4j.tracker.io;

import ru.job4j.tracker.io.Output;

public class StubOutput implements Output {
    private final StringBuilder stubOutput = new StringBuilder();
    
    @Override
    public void println(Object obj) {

        stubOutput.append(obj.toString()).append(System.lineSeparator());
//        System.out.println(obj.toString());
    }

    @Override
    public String toString() {
        return stubOutput.toString();
    }
}
