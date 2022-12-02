package com.nscaleintermodal;

public class Hand {

    String other;
    String me;
    public Hand(String other, String me) {
        this.other=other;
        this.me=me;
    }

    public int score() {
        if (other.equals("A")) {  // Rock
            if(me.equals("X")){  // Rock
                return 1 + 3; // rock + tie
            } else if(me.equals("Y")) { // Paper
                return 2 + 6; // paper + win
            }  else if(me.equals("Z")) { // Scissors
                return 3+0 ; // scissors + loss
            }
        } else if (other.equals("B")) { // Paper
            if(me.equals("X")){  // Rock
                return 1 + 0; // rock + loss
            } else if(me.equals("Y")) { // Paper
                return 2 + 3; // paper + tie
            }  else if(me.equals("Z")) { // Scissors
                return 3 + 6 ; // scissors + win
            }
        } else { // Other equals "C" // Scissors
            if(me.equals("X")){  // Rock
                return 1 + 6; // rock + win
            } else if(me.equals("Y")) { // Paper
                return 2 + 0; // paper + loss
            }  else if(me.equals("Z")) { // Scissors
                return 3 + 3 ; // scissors + tie
            }
        }
        return 0;
    }

    public int predict() {
        if (other.equals("A")) {  // Rock
            if(me.equals("X")){  // loss
                return 3+0 ; // scissors + loss
            } else if(me.equals("Y")) { // draw
                return 1 + 3; // rock + tie
            }  else if(me.equals("Z")) { // win
                return 2 + 6; // paper + win
            }
        } else if (other.equals("B")) { // Paper
            if(me.equals("X")){  // loss
                return 1 + 0; // rock + loss
            } else if(me.equals("Y")) { // draw
                return 2 + 3; // paper + tie
            }  else if(me.equals("Z")) { // win
                return 3 + 6 ; // scissors + win
            }
        } else { // Other equals "C" // Scissors
            if(me.equals("X")){  // loss
                return 2 + 0; // paper + loss
            } else if(me.equals("Y")) { // draw
                return 3 + 3 ; // scissors + tie
            }  else if(me.equals("Z")) { // win
                return 1 + 6; // rock + win
            }
        }
        return 0;
    }
}
