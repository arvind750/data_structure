
public class FirstLastOccurence {
    public int first(int[] nums,int target){
        int index=-1;
        int l=0,h=nums.length-1;
        while(l<=h){
            int m=l+((h-l)/2);
            if(nums[m]>target){
                h=m-1;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                index=m;
                h=m-1;
            }
        }
        return index;
    }
    public int last(int[] nums,int target){
        int index=-1;
        int l=0,h=nums.length-1;
        while(l<=h){
            int m=l+((h-l)/2);
            if(nums[m]>target){
                h=m-1;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                index=m;
                l=m+1;
            }
        }
        return index;
    }
}
