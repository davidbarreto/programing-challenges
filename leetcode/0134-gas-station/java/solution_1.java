class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;

        int sumDiff = 0;
        int startIndex = -1;
        int sumCost = 0;
        int sumGas = 0;
        for (int i = 0; i < n; i++) {
            sumDiff += gas[i] - cost[i];
            if (sumDiff >= 0 && startIndex == -1) {
                startIndex = i;
            }

            if (sumDiff < 0) {
                startIndex = -1;
                sumDiff = 0;
            }

            sumCost += cost[i];
            sumGas += gas[i];
        }

        //System.out.println(String.format("sumGas = %d sumCost = %d startIndex = %d", sumGas, sumCost, startIndex));

        return sumGas >= sumCost ? startIndex : -1;
    }
}