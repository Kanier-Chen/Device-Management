package test阶乘;

import java.math.BigInteger;
import java.util.Scanner;

public class N {
	private static int[] resultArray = new int[10000000]; 
	 
	static int resultJinwei = 0;
	static long index = 0;
	
	public static void main(String[] args) {
		System.out.println("请输入要求阶乘的N的值：");
		Scanner sin = new Scanner(System.in);
		int number = sin.nextInt();
		long maxIndex = method(number);
		System.out.println("阶乘为:");
		for (long i = maxIndex-1; i >= 0; i--) {
			System.out.print(resultArray[(int) i]);
			if(i % 100 == 0) { //此处对输出格式做处理时因为eclipse编译器的控制台每行输出的长度有限定，所以处理成每行输出100个数
				System.out.println();
			}
		}
	}
 
	public static long method(long number) {
		long maxIndex = 1;
		int temp = 0;
		//int tempMaxIndex = 0;
		resultArray[0] = 1;
		for (long i = 1; i <= number; i++) {
			for (long j = 0; j < maxIndex; j++) {
				resultArray[(int) j] *= i;
				resultArray[(int) j] += resultJinwei;
				temp = resultArray[(int) j];
				if (temp >= 10) {
					resultArray[(int) index] = temp % 10;
					resultJinwei = temp / 10;
					index++;
					if(maxIndex<index+1)
						maxIndex = index+1;
					
				} else {
					index++;
					resultJinwei = 0;
				}				
			}
			index = 0;
			
		}
		return maxIndex;
	}


}
