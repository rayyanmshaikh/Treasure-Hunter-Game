/**
 *       A class that can be used for many purposes, but usually for a counter or a delay counter;
 *       this is a non-displayable object that does not have an act method; a world or actor class 
 *       creates a Timer object and keeps a reference to that object; that class will provide that
 *       object with an integer value that will be the number of counts before it returns a 'false'
 *       value.  It may seem strange to return a 'false' value when the count is complete; however,
 *       it will be apparent why.  To execute one step of the timer, the 'iterating' method is called.
 *       This method will return a boolean value informing the caller whether the counter is running
 *       or not (or has not yet reached zero, when looping).  If it is running, then we are still in
 *       delay mode and should not do whatever action the timer is controlling.
 * 
 * <br />
 * <br />Author: danpost
 * <br />Date: May 19, 2013
 */
public class Timer  
{
    private int delayAmount; // the number of steps to complete one cycle
    private int counter; // the current value of the timer
    private boolean paused; // the current paused state of the timer
    private boolean looping; // the looping state of the timer
    
    /**
     * this secondary constructor creates a timer object that does not loop automatically
     *
     * @param amount the number of steps to complete one cycle
     */
    public Timer(int amount)
    {
        this(amount, false); // calls the primary constructor with a looping value of false
    }
    
    /**
     * this primary constructor sets up a timer object
     *
     * @param amount the number of steps to complete one cycle
     * @param toLoop a flag indicating whether the timer should loop automatically or not
     */
    public Timer(int amount, boolean toLoop)
    {
        delayAmount = amount; // number of steps to delay
        looping = toLoop; // save looping state
        if (looping) counter = -1; // adjust counter if looping (looping counters must be explicitly started)
    }
    
    /**
     * usually called by the object that created the timer to execute one step and return a boolean value
     * indicating whether the timer is still running or not; a paused state is a busy state and returns a
     * true value just as if the timer was still running
     *
     * @return a boolean value indicating whether the timer is paused or has not completed a cycle, or not
     */
    public boolean iterating()
    {
        if (paused) return true; // timer is paused
        if (counter == 0 && looping) counter = delayAmount; // reset counter if end of cycle and looping
        if (counter > 0) counter--; // decrement counter
        return counter > 0; // return true if cycle is not complete
    }
    
    /**
     * stops the timer
     */
    public void stop()
    {
        counter = -1; // sets counter value to one indicating the timer is stopped
        paused = true; // sets paused flag to true
    }
    
    /**
     * starts the timer
     */
    public void start()
    {
        paused = false; // sets pausd flag to false
        counter = looping ? 0 : delayAmount; // sets counter to an appropriate value depending on looping state
    }
    
    /**
     * un-pauses the timer
     */
    public void resume()
    {
        paused = false; // sets paused flag to false
    }
    
    /**
     * pauses the timer
     */
    public void pause()
    {
        paused = true; // sets paused flag to true
    }
}