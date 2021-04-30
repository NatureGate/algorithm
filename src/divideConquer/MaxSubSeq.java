package divideConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*【问题描述】给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
【样例输入】-2 1 -3 4 -1 2 1 -5 4
【样例输出】6
【样例说明】连续子数组 [4,-1,2,1] 的和最大，为 6*/
public class MaxSubSeq {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arrSeq = new ArrayList<>();

        while (sc.hasNext()) {
            String num = sc.next();
            if(null==num||"".equals(num)){
              break;
            }
            System.out.println(num);
            //String[] numStr = str.split("\b");
            arrSeq.add(Integer.valueOf(num));

        }
        sc.close();
        //int[] seq = new int[arrSeq.size()];
        int result = getMaxSeq(arrSeq);
    }

    public static int  getMaxSeq(List<Integer> seq){

        int startIndex = 0; int endIndex = 0;
        int sum = 0; int maxSum =0;
        int[] result = new int[3];
        for(int i = 0;i < seq.size();++i){
            if(startIndex==endIndex){
                if(sum<=0&&seq.get(i)<0){
                    startIndex =i;
                    endIndex =i;
                }else if(sum <=0&&seq.get(i)>0){
                    startIndex = i;
                    endIndex = i;
                    sum = seq.get(i);
                    if(maxSum<sum){
                        maxSum = sum;
                        result[0] = startIndex;
                        result[1] = endIndex;
                        result[2] = maxSum;
                    }

                }else if(sum > 0&& (sum+seq.get(i)>0)){
                    endIndex = i;
                    sum += seq.get(i);
                    if(maxSum<sum){
                        maxSum = sum;
                        result[0] = startIndex;
                        result[1] = endIndex;
                        result[2] = maxSum;
                    }
                }else if(sum > 0&& (sum+seq.get(i) <= 0)){
                    sum = 0;
                    startIndex = i;
                    endIndex = i;
                }
            }else{
                if(sum > 0&& (sum+seq.get(i)>0)){
                    endIndex++;
                    sum += seq.get(i);
                    if(maxSum<sum){
                        maxSum = sum;
                        result[0] = startIndex;
                        result[1] = endIndex;
                        result[2] = maxSum;
                    }
                }else if(sum > 0&& (sum+seq.get(i)<=0)){
                    startIndex = endIndex = i+1;
                    sum =0;
                }
            }
        }
        System.out.println(result[2]);
        return result[2];
    }
}
