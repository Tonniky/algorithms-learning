package DesignPattern.actionMode.Command;


public class CommandImpl extends Command{
    public CommandImpl(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.receive();
    }
}
