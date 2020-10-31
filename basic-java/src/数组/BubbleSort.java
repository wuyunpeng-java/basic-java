package 数组;
/* 数组排序
* 迁移自ECLIPS
* */
public class BubbleSort {

	public static void main(String[] args) {
		int[]  arr = new int[] {2,32,89,-58,74,33,-2,32,75,61,0,-111};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + "\t");
		}
		for(int i=0;i<arr.length-1;i++) {
			for(int j =0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					 int temp =arr[j];
					 arr[j]=arr[j+1];
					 arr[j+1] = temp;
				}
				
			}
			
		}
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
