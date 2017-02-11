package start;

import context.Context;
import state.Smile;
import state.StateInterface;
import state.Ungry;

public class Start {
	public static void main(String[] args) {

        Context context = new Context();
        
        StateInterface  stateSmile = new Smile();
        StateInterface stateUngry = new Ungry();

        context.setState(stateSmile);
        context.action();

        context.setState(stateUngry);
        context.action();
        
    }

}
