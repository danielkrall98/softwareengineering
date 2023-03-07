package mvc.controller;

public interface BookManagerObserver {
    
    /**
     * Updates the view with the new state of the bookManager
     * @param message The message containing the new state of the bookManager
     */
    public void update(BCMessage message);
}
