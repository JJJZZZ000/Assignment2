package Question2;

// create a combatant class to represent each character
public class Combatant{
    private String name;
    private double accuracy;
    private boolean isAlive; // record the live status of the object

    // constructor to set the information of character
    public Combatant(String name, double accuracy, boolean isAlive){
        this.name = name;
        this.accuracy = accuracy;
        this.isAlive = isAlive;
    }

    // call the method when the object want to shoot another person, but we cannot decide whether he can hit the target
    public void ShootAtTarget(Combatant target){
        // create a random number dice;
        // dice obeys a uniform distribution from 0 to 1
        double dice = Math.random();
        // If the value of dice is less than accuracy, we can say that he hit the target
        // the possibility to success equals to accuracy
        if(dice <= accuracy) {
            // call get_shooted method to set the live status of target, this method is definite below
            target.get_shooted();
        }
    }

    // call the method if object is hit; set the live status to die;
    private void get_shooted(){
        isAlive = false;
    }

    // a getter method to get the live status
    public boolean isAlive() {
        return isAlive;
    }

    // reset the object to be alive again;
    public void reset(){
        isAlive = true;
    }




}