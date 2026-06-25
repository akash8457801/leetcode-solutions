class Solution {
    public int maxArea(int[] height) {

        int left =0;
        int right = height.length-1;

        
        int mA = 0;
        while(left < right){

            int width = right - left;
            int cA = Math.min(height[left], height[right]) * width;

            mA = Math.max(cA, mA); 



            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return mA;
        

        
    }
}