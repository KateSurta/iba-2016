package context;

import state.StateInterface;

public class Context implements StateInterface{
	 private StateInterface state;

	    public StateInterface getState() {
	        return state;
	    }

	    public void setState(StateInterface state) {
	        this.state = state;
	    }   

	    
	    public void action() {
	        this.state.action();
	    }
	   

}
