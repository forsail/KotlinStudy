package command;

/**
 * Created by Administrator on 2018/3/13.
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void doAction() {
        command.execute();
    }
}
