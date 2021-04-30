package divideConquer;

import java.util.Scanner;

/*【问题描述】求n个数的中位数（即数组中第[n/2]大的元素，假设数组中的元素不重复）
【样例输入】4 8 5 6 3 9 1 7 2
【样例输出】5*/
public class Median {

    public static void main(String[] args) {
        //Scanner
        int[] inSeq = {2,3,4,5,1,7,18,20,-3};
        getMedia(inSeq,0,8,2);

    }

    public static int getMedia(int[] inSeq,int start,int end,int baseNum){
        int startIndex = start;
        int endIndex = end;
        while (startIndex<endIndex){
            while(inSeq[endIndex]>baseNum&&startIndex<endIndex){
                --endIndex;
            }
            if(startIndex<endIndex){
                inSeq[startIndex] = inSeq[endIndex];
                ++startIndex;
            }
            while (inSeq[startIndex]<baseNum&&startIndex<endIndex){
                ++startIndex;
            }
            if(startIndex<endIndex){
                inSeq[endIndex] = inSeq[startIndex];
                --endIndex;
            }
        }
        inSeq[startIndex] = baseNum;

        if((inSeq.length-1)/2==endIndex){
            System.out.println(baseNum);
            return baseNum;
        }else if ((inSeq.length-1)/2<endIndex){
            --endIndex;
            return getMedia( inSeq,start,endIndex,inSeq[start]);
        }else{
            ++endIndex;
            return getMedia( inSeq,endIndex,end,inSeq[endIndex]);
        }
    }
}
