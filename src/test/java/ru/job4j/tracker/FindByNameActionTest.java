package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String findName = "Find by name item";
        tracker.add(new Item(findName));

        FindByNameAction findByNameAction = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(findName);

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        System.out.println(out.toString());
        assertThat(out.toString(), is("=== Show items ===" + ln + "Item with name=" + findName + ":" + ln + tracker.findAll()[0].toString()+ ln));
        assertThat(tracker.findByName(findName)[0].getName(), is(findName));
    }
}
