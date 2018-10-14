package Max_Heap_Sort;

public class maxHeap {
	
	private int[] arr;
	private int size;

	public maxHeap(int[] arr) {
		this.arr = arr;
		this.size = arr.length;
	}
	
	// n: 히프의 원소 개수, i는 마지막 내부 노드 인덱스
	public static void build_recu_max_heap(int[] a, int i, int n) { 
		if(i >= n/2) // 리프노드이면
			return;
		build_recu_max_heap(a, 2*i+1, n);
		build_recu_max_heap(a, 2*i+2, n);
		heapify(a,i,n);
	}
	
	public static int[] heapSort(int[] arr) {
		int length = arr.length;
		build_recu_max_heap(arr, 0, length);
		for (int i = length-1; i >= 1; i--) {
			swap(arr, 0, i);
			length-=1;
			heapify(arr, 0, length);
		}
		return arr;
	}

	public static void heapify(int[] a, int i, int n) {
		int temp = a[i];
		while(i < n/2) // 리프가 아닌 동안
		{
			int j = 2*i +1; // 왼쪽 자식
			if(j + 1 < n && a[j +1] > a[j])
				++j;
			if(a[j] < temp) // 왼쪽 자식이 부모보다 작으면
				break;
			a[i] = a[j]; // 왼쪽 자식을 부모노드로 
			i = j;
			a[i] = temp; // 값 바꿔주기
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
