package reader;

public class Algos {

	public int[] mergeTwoSortedArrays(int[] a, int[] b) {
		int[] mergedArray = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;

		while (i < a.length && j < b.length) {

			if (a[i] < b[j]) {
				mergedArray[k] = a[i];
				i++;
			} else {
				mergedArray[k] = b[j];
				j++;
			}
			k++;
		}
		while (i < a.length) {
			mergedArray[k] = a[i];
			i++;
			k++;
		}
		while (j < b.length) {
			mergedArray[k] = a[j];
			j++;
			k++;
		}

		return mergedArray;
	}

	public void bubbleSort(int[] numbers) {

		int n = numbers.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (numbers[j - 1] < numbers[j]) {
					temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

	}
	
	

}
