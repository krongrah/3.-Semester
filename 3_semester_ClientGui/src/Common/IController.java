package Common;


/**
 * Interface for a controller that needs contract to a parent controller
 **/
public interface IController<T> {
    /**
     * Sets the parents controller
     * @param parentController the parent controller
     */
    void setParrentController(T parentController);
    
    /**
     * Allows the controller to stop threads and clean up
     */
    void unload();
}
