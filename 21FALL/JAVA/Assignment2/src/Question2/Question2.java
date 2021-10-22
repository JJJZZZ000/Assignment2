package Question2;

public class Question2 {


    public static void main(String[] args){
        // create three characters with name, accuracy and live status
        Combatant Deadpool = new Combatant("Deadpool", 1.0/3, true);
        Combatant Kingkong = new Combatant("Kingkong", 1.0/2, true);
        Combatant Spiderman = new Combatant("Spiderman", 1, true);

        int trials = 10000; // the number of repeated trials
        int win_1 = 0; // the number of game win using strategy 1
        int win_2 = 0; // the number of game win using strategy 2

        // Strategy 1 : Deadpool first tried his best
        // use for-loop to repeat the game
        for(int i = 0; i < trials; i++){
            // for a new start, everyone is alive
            Deadpool.reset();
            Kingkong.reset();
            Spiderman.reset();

            // the game begin.
            // Stop at the point when Deadpool is dead or only Deadpool is alive
            while(Deadpool.isAlive()){ // continue the game if Deadpool is alive
                // according to the reading, Deadpool would shoot best player alive
                if(Spiderman.isAlive()) Deadpool.ShootAtTarget(Spiderman);
                else Deadpool.ShootAtTarget(Kingkong);


                if(Kingkong.isAlive()){ // same action for Kingkong. Shoot Spiderman on priority, then Deadpool
                    if(Spiderman.isAlive()) Kingkong.ShootAtTarget(Spiderman);
                    else Kingkong.ShootAtTarget(Deadpool);
                }


                if(Spiderman.isAlive()){ // same action for Spiderman. Shoot Kingkong on priority, then Deadpool
                    if(Kingkong.isAlive()) Spiderman.ShootAtTarget(Kingkong);
                    else Spiderman.ShootAtTarget(Deadpool);
                }

                // we came to the end of one roll, check the live status of Spiderman and Kingkong
                if(!Kingkong.isAlive() && !Spiderman.isAlive()) break; // if both rival is dead, break the loop and the game end
            }
            if(Deadpool.isAlive()) win_1++; // When the game is finished, if Deadpool is alive, Strategy 1’s cumulative wins plus one

        }



        // Strategy 2 : Deadpool missed the first shoot
        // we can assume that Kingkong is the first to shoot, because neither anyone would shoot Deadpool nor Deadpool shoot others
        for(int i = 0; i < trials; i++){
            // make sure everyone is alive to start a new game.
            Deadpool.reset();
            Kingkong.reset();
            Spiderman.reset();
            // Like strategy 1, we use loop to continue the game until Deadpool is alive or others are dead
            while(Deadpool.isAlive()){
                // Deadpool missed the first shoot, initially start with Kingkong
                if(Kingkong.isAlive()){
                    if(Spiderman.isAlive()) Kingkong.ShootAtTarget(Spiderman);
                    else Kingkong.ShootAtTarget(Deadpool);
                }

                if(Spiderman.isAlive()){
                    if(Kingkong.isAlive()) Spiderman.ShootAtTarget(Kingkong);
                    else Spiderman.ShootAtTarget(Deadpool);
                }

                if(Deadpool.isAlive()){
                    if(Spiderman.isAlive()) Deadpool.ShootAtTarget(Spiderman);
                    else Deadpool.ShootAtTarget(Kingkong);
                }

                // check the live status of two rivals, if they are dead, the game end
                if(!Kingkong.isAlive() && !Spiderman.isAlive()) break;
            }
            // if Deadpool is alive in the end, the amount of games he won plus one
            if(Deadpool.isAlive()) win_2++;
        }



        // calculate the frequency that Deadpool wins
        System.out.println("Deadpool won " + (win_1+0.0)/trials * 100 + "% fights"); // 36.29%
        System.out.println("Deadpool won " + (win_2+0.0)/trials * 100 + "% fights"); // 41.88%

        // Deadpool more possible to win using strategy two, Strategy 2 is better

    }
}

