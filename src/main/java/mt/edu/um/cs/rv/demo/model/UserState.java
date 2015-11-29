package mt.edu.um.cs.rv.demo.model;

/**
 * Created by dwardu on 28/11/2015.
 */
public enum UserState {
    INITIALISED,    //created but not yet active
    ACTIVE,         //active user
    INACTIVE,       //inactive - can be re-activated
    DEACTIVATED     //deactivated - this is a final state, cannot go back to ACTIVE
}
