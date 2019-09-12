import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class DoneCommandTest {
    @Test
    public void executeTest() {
        Ui uiManager = new Ui();
        TaskList taskList = new TaskList();
        Storage storeManager = new Storage("StoreTest.sav");
        Parser parseManager = new Parser();

        Command addTodo = null;
        Command addDeadline = null;
        Command addEvent = null;

        try {
            addTodo = parseManager.parseToCommand("todo This is a Todo");
            addDeadline = parseManager.parseToCommand("deadline This is a deadline /by 02/03/2004 22:22");
            addEvent = parseManager.parseToCommand("event This is an event /at 02/03/2004 22:22");
        } catch (DukeException e) {
            // Not suppose to happen
            fail(e.getMessage());
        }

        try {
            addTodo.execute(uiManager, taskList, storeManager);
            addDeadline.execute(uiManager, taskList, storeManager);   
            addEvent.execute(uiManager, taskList, storeManager);
        } catch (DukeException e) { 
            // But fail for addCommand failure
            fail();
        }

        DoneCommand doneThird = new DoneCommand(3);
        DoneCommand doneSecond = new DoneCommand(2);
        DoneCommand doneFirst = new DoneCommand(1);
        try {
            doneThird.execute(uiManager, taskList, storeManager);
            doneSecond.execute(uiManager, taskList, storeManager);
            doneFirst.execute(uiManager, taskList, storeManager);
        } catch (DukeException e) {
            fail();
        }

    }

}