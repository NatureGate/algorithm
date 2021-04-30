package divideConquer;
/*【问题描述】给定含有n 个元素的多重集合S，每个元素在S 中出现的次数称为该元素的重数。多重集S 中重数最大的元素称为众数。
【样例输入】1 2 2 2 3 5
【样例输出】
 2
 3
【样例说明】输出第一行为众数，第二行为众数的重数*/


import java.util.HashMap;
import java.util.Map;

public class MostNum {

    public static void main(String[] args) {
        //Scanner
        int[] inSeq = {1 ,2,8,8 ,2, 2 ,3, 5,7,8,4,8};

        getMostNum(inSeq);

    }

    private static void getMostNum(int[] inSeq) {
        Map<Integer,Integer> numMap = new HashMap<>();
        Integer maxNum = inSeq[0];
        Integer maxTimes = 0;
        for(int i =0;i<inSeq.length;i++){
            if(numMap.containsKey(inSeq[i])){
                numMap.replace(inSeq[i],numMap.get(inSeq[i])+1);
                if(numMap.get(inSeq[i])>maxTimes){
                    maxNum = inSeq[i];
                    maxTimes = numMap.get(inSeq[i]);
                }
            }else{
                numMap.put(inSeq[i],1);
            }
        }
        System.out.println(maxNum);
        System.out.println(maxTimes);
    }
}
