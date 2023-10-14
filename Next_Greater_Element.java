class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //Optimised approach :
        //stack approach :

        //we process the nums 2 from right to left and then do 3 steps
        //1->Remove all the smaller elements from the Stack.. 
        //2->until the stack becomes empty or the top is greater element
        //3->take the top as nge and add the currElement back into the stack..
        Stack<Integer> stk = new Stack<Integer>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        int[] nge = new int[n2];
        

        for(int j=n2-1;j>=0;j--){
            int element = nums2[j];
            //Removing all the smaller elements :
            while(!stk.isEmpty() && element>=stk.peek() ){
                stk.pop();
            }
            //Now :
            if(stk.isEmpty()){
                nge[j]=-1;
            }
            else{
                nge[j]=stk.peek();
            }
            stk.add(element);
        }

        //now we have the nge array storing the next Greater element for all the elements in nums2
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(nums2[j]==nums1[i]){
                    ans[i]=nge[j];
                }
            }
            if(ans[i]==0){
                ans[i]=-1;
            }
        }

        return ans;










        // //brute force solution
        // //TC => O(n^3)
        // //SC=>O(1)

        // //we iterate in the nums1 and for each element 
        // //of nums 1 we find its position in nums2 
        // //and then from that position we iterate in the remaining 
        // //nums2 to the right of that position until we find the next 
        // //larger element as compared at the jth index :
        // int[] ans = new int[nums1.length];
        // for(int i=0;i<nums1.length;i++){
        //     int n1 = nums1[i];
        //     for(int j=0;j<nums2.length;j++){  
        //         if(n1==nums2[j]){
        //             for(int k=j+1;k<nums2.length;k++){
        //                 if(nums2[k]>nums2[j]){
        //                     ans[i]=nums2[k];
        //                     break;
        //                 }
        //             }
        //             if(ans[i]==0){
        //                 ans[i]=-1;
        //                 break;
        //             }
        //         }
        //     }
        // }


        // return ans;
    }
}
