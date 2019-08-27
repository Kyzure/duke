/**
 * Represents a command which lists out the tasks left for the user.
 */
class ListCommand implements Command {
    /**
     * Default Constructor
     */
    public ListCommand() {}

    
    /**
     * This method executes the List Command, which uses uiManager to list out
     * each line of the task from the taskList.
     * 
     * @param uiManager Ui System which scans, prints and throws DukeExceptions for the User.
     * @param taskList TaskList, an ArrayList which stores Tasks.
     * @param storeManager Storage to serialize the TaskList into a Tasks.sav file. - Not in use
     */
    @Override
    public void execute(Ui uiManager, TaskList taskList, Storage storeManager) throws DukeException {
        if(taskList.listSize() == 0) {
            uiManager.printEmptyList();
        } else {
            uiManager.printListStarter();
            for (int i = 0; i < taskList.listSize(); i++) {
                uiManager.printTask(i, taskList.getTask(i, uiManager));
            }
        }
    }
}