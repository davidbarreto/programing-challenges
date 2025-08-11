class Solution {

    private static final int SAME = 0;
    private static final int UP = 1;
    private static final int DOWN = -1;
    private static final int NONE = -100;

    public int candy(int[] ratings) {
        
        int count = 0;
        boolean firstCalculation = true;
        int elements = 1;
        int previousRamp = NONE;
        int previousElements = 0;

        for (int i = 1; i < ratings.length; i++) {

            int ramp = calculateRamp(ratings, i);
            if (ramp != previousRamp && previousRamp != NONE) {
                count += calculate(previousRamp, elements, previousElements, firstCalculation); 
      
                previousElements = elements;
                if (previousRamp == SAME) {
                    previousElements = 1;
                }
                
                elements = 2;
                firstCalculation = false;
            } else {
                elements++;
            }
            previousRamp = ramp;
        }

        count += calculate(previousRamp, elements, previousElements, firstCalculation);
        return count;
    }

    private int calculateRamp(int[] ratings, int i) {
        if (ratings[i] > ratings[i-1]) {
            return UP;
        } else if (ratings[i] < ratings[i-1]) {
            return DOWN;
        } else {
            return SAME;
        }
    }

    private int calculate(int ramp, int elements, int previousElements, boolean first) {

        int count = 0;

        if (ramp == SAME) {
            count = elements;
        } else {
            count = (elements * (elements + 1))/2;
        }
    
        if (!first) {
            if (ramp == UP || ramp == SAME) {
                count--;
            } else if (ramp == DOWN) {
                count -= Math.min(elements, previousElements);
            }
        }

        return count;
    }
}