import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ListCommandTest {
    @Test
    public void executeTest() throws DukeException {
        Ui uiManager = new Ui();
        TaskList taskList = new TaskList();
        Storage storeManager = new Storage("StoreTest.sav");

        AddCommand addTodo;
        AddCommand addDeadline;
        AddCommand addEvent;

        try {
            addTodo = new AddCommand(new Todo("This is a Todo"));
            addDeadline = new AddCommand(new Deadline("This is a Deadline", "02/03/2004 22:22"));
            addEvent = new AddCommand(new Event("This is an Event", "02/03/2004 22:22"));
        } catch (DukeException e) {
            throw new DukeException("The test itself have an error");
        }

        try {
            addTodo.execute(uiManager, taskList, storeManager);
            addDeadline.execute(uiManager, taskList, storeManager);   
            addEvent.execute(uiManager, taskList, storeManager);
        } catch (DukeException e) { 
            // But fail for addCommand failure
            fail();
        }

        ListCommand listCommand = new ListCommand();

        try {
            listCommand.execute(uiManager, taskList, storeManager);
        } catch (DukeException e) {
            fail();
        }
    }
}