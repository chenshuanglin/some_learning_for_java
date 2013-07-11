package test;

import java.util.Arrays;

public class CopyArrayTest {
	public static void main(String[] args) {
		/*
		 * System.arraycopy函数的使用
		 * */
		String[] A = {"a","b","c","d","e"};
		String[] B = new String[3];
		System.arraycopy(A, 1, B, 1, B.length-1);
		for(int i = 0 ; i < B.length ; i++)
		{
			System.out.print(B[i]+" ");
		}
		/*
		 * Arrays.asList()函数的使用
		 * */
		System.out.println(Arrays.asList(B));
		/*
		 * Arrays.binarySearch()执行快速查找函数的使用
		 * */
		int index = Arrays.binarySearch(A, "e");
		System.out.println("e 所在的下标是："+index);
		
		/*
		 * Arrays.copyOf 也是复制数组
		 * */
		String[] C = new String[4];
		C = Arrays.copyOf(A, 4);
		System.out.println(Arrays.asList(C));
		/*
		 * Arrays.copyOfRange() 复制一定范围的数组
		 *
		 * */
		String[] D = new String[3];
		D = Arrays.copyOfRange(A, 2, 4);
		System.out.println(Arrays.asList(D));
	}
}
