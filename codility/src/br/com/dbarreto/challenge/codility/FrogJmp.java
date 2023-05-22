class Solution {
    public int solution(int X, int Y, int D) {
        
        int diff = Y - X;
        
        return (diff/D) + ((diff % D) > 0 ? 1 : 0);
    }
}