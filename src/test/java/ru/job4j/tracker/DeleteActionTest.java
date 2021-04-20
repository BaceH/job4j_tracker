package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Delete item");
        tracker.add(item);
        DeleteAction deleteAction = new DeleteAction(out);

        Input input = mock(Input.class);
        int delId = item.getId();
        when(input.askInt(any(String.class))).thenReturn(delId);


        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        System.out.println(out.toString());
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Delete item is done." + ln));
        assertNull(tracker.findById(delId));
    }
}
