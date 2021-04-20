package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item findItem = new Item("Find item by ID");
        tracker.add(findItem);
        int findId = findItem.getId();
        FindByIdAction findByIdAction = new FindByIdAction(out);
        String testName ="Find item by ID";

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(findId);


        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        System.out.println(out.toString());
        assertThat(out.toString(), is("=== Show item ===" + ln + "Item with id=" + 1 + ":" + ln + tracker.findById(1).toString()+ ln));
        assertThat(tracker.findById(findId).getName(), is(testName));
    }
}
