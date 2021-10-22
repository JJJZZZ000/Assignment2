package Question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>(); // list that collects all possible answer;

        int too, good; // set two variable to represent the value of TOO and GOOD

        // use for-loop to traverse all values for each letter
        for (int t = 0; t < 10; t++) {                                   // iterate t from 0 to 10
            for(int o = 0; o < 10; o++){                                 // iterate o from 0 to 10
                if(o == t) continue;                                     // skip repeat value; make sure o and t have different value
                for(int g = 0; g < 10; g++){                             // iterate g from 0 to 10
                    if(g == t || g == o) continue;                       // each loop has a judgement, if values are same, continue
                    for(int d = 0; d < 10; d++){                         // iterate d from 0 to 10
                        if(d == t || d == o || d == g) continue;         // skip repeat value;
                        too = t * 100 + o * 10 + o;                      // calculate the value of two numbers, based on the the value of each letter
                        good = g * 1000 + o * 100 + o * 10 + d;


                        if(4 * too == good) {                            // select the combination that satisfy the equation
                            result.add(Arrays.asList(t, o, g, d));       // add to a list
                        }
                    }
                }
            }
        }

        for(List<Integer> l : result){ // iterate the list and print out the solutions;
            System.out.println("t = " + l.get(0) + " " + "o = " + l.get(1) + " " +  "g = " + l.get(2) + " d = " + l.get(3));
        }
    }
}
