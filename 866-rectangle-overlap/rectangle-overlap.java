class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // if either of them is a line then they don't overlap
        boolean line = (rec1[0] == rec1[2] || rec1[1] == rec1[3]) || (rec2[0] == rec2[2] || rec2[1] == rec2[3]);
        
        if (line) return false;

        // check if the rectangles do not overlap (use pen and paper)
        boolean left = rec1[2] <= rec2[0];
        boolean right = rec1[0] >= rec2[2];
        boolean top = rec1[1] >= rec2[3];
        boolean bottom = rec1[3] <= rec2[1];

        return !(left || right || top || bottom);
    }
}