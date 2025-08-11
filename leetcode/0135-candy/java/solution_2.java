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
            //System.out.println(String.format("elements = %d, previousElements = %d, count = %d, current = %d, previous = %d, r[%d] = %d, r[%d] = %d", elements, previousElements, count, ramp, previousRamp, i, ratings[i], (i-1), ratings[i-1]));

            if (ramp != previousRamp && previousRamp != NONE) {
                count += calculate(previousRamp, elements, previousElements, firstCalculation); 
                //System.out.println(String.format("Calculated for direction %d and elements = %d, count = %d", previousRamp, elements, count));
      
                previousElements = elements;
                if (previousRamp == SAME) {
                    previousElements = 1;
                }
                
                elements = 2;
                firstCalculation = false;
            } else {
                //System.out.println("Incrementing elements...");
                elements++;
            }

            //System.out.println("--------");
            previousRamp = ramp;
        }

        //System.out.println(String.format("Calculating the last count (current %d) for ramp = %d, elements = %d, previousElements = %d", count, previousRamp, elements, previousElements));
        count += calculate(previousRamp, elements, previousElements, firstCalculation);
        //System.out.println("Last count = " + count);
        return count;
    }
    // [0,0,0,0,0,0,1,2,30,20,10,2,1]
    // [1,1,1,1,1,1,2,3,5 ,4 ,3 ,2,1]

    // [0,0,0,0,0,0,30,20,10,2,3,4,5]
    // [1,1,1,1,1,1,4, 3 ,2 ,1,2,3,4]

    // [10,20,30,40,5,4,3,2,1]
    // [1,  2, 3, 4,5,4,3,2,1]

    // [10,10,10,10,5,4,3,2,1]
    // [1,  1, 1, 6,5,4,3,2,1]

    // [1,3,2,2,1]
    // [1,2,1,2,1]

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