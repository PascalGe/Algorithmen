package paper3;

public class Main {
	// TODO: Set this to 'true', if you test your code and to 'false', if you want
	// the running time.
	private static final boolean TESTING = true;

	private static final int TEST_RUNS = 1; // for testing do a single run
	private static final int RUNNING_TIME_RUNS = 20; // to get the average running time use more runs
	private static final double MAX_ENTRY_PERCENTAGE = 0.25; // maximal entry in the array

	/* START OF TESTING */
	public static void main(String[] args) {
		java.util.Random random = new java.util.Random();

		java.util.Map<Integer, Long> heapSortRuntimeAverage = new java.util.TreeMap<Integer, Long>();
		java.util.Map<Integer, Long> quickSortRuntimeAverage = new java.util.TreeMap<Integer, Long>();
		java.util.Map<Integer, Long> countingSortRuntimeAverage = new java.util.TreeMap<Integer, Long>();

		int RUNS = TESTING ? TEST_RUNS : RUNNING_TIME_RUNS;
		if (!TESTING) {
			System.out.println("Doing " + RUNS + " runs of each algorithm. This can take some time.");
			System.out.print("Current array size: ");
		}

		for (int arraySize = 100000; arraySize <= 1000000; arraySize = arraySize + 100000) {

			if (!TESTING) {
				System.out.print(arraySize + "...");
			}

			long runtimeHeapSort = 0;
			long runtimeQuicksort = 0;
			long runtimeCountingsort = 0;

			for (int run = 1; run <= RUNS; run++) {

				// Create a new array with integer values and fill it with random numbers.
				int[] randomArray = new int[arraySize];
				for (int i = 0; i < randomArray.length; i++) {
					randomArray[i] = random.nextInt((int) (arraySize * MAX_ENTRY_PERCENTAGE));
				}

				// Sort with heapSort
				int[] copy1 = java.util.Arrays.copyOf(randomArray, randomArray.length);
				long timerStart = System.currentTimeMillis();
				heapSort(copy1);
				long runtime = System.currentTimeMillis() - timerStart;
				runtimeHeapSort += runtime;

				if (TESTING) {
					for (int i = 0; i < copy1.length - 1; i++) {
						if (copy1[i] > copy1[i + 1]) {
							System.err.println("Error in heapSort at position " + i);
							break;
						}
					}
				}

				// Sort with quickSort
				int[] copy2 = java.util.Arrays.copyOf(randomArray, randomArray.length);
				timerStart = System.currentTimeMillis();
				quickSort(copy2);
				runtime = System.currentTimeMillis() - timerStart;
				runtimeQuicksort += runtime;

				if (TESTING) {
					for (int i = 0; i < copy2.length - 1; i++) {
						if (copy2[i] > copy2[i + 1]) {
							System.err.println("Error in quickSort at position " + i);
							break;
						}
					}
				}

				// Sort with countingSort
				int[] copy3 = java.util.Arrays.copyOf(randomArray, randomArray.length);
				timerStart = System.currentTimeMillis();
				countingSort(copy3);
				runtime = System.currentTimeMillis() - timerStart;
				runtimeCountingsort += runtime;

				if (TESTING) {
					for (int i = 0; i < copy2.length - 1; i++) {
						if (copy3[i] > copy3[i + 1]) {
							System.err.println("Error in countingSort at position " + i);
							break;
						}
					}
				}
			}

			heapSortRuntimeAverage.put(arraySize, runtimeHeapSort / RUNS);
			quickSortRuntimeAverage.put(arraySize, runtimeQuicksort / RUNS);
			countingSortRuntimeAverage.put(arraySize, runtimeCountingsort / RUNS);
		}

		if (TESTING) {
			System.out.println("If no errors have been printed, then you passed the test ");
		} else {
			// print the running time

			System.out.println();
			System.out.println();

			System.out.println("Heap Sort");
			heapSortRuntimeAverage.forEach((key, value) -> System.out.println(key + ": " + value));

			System.out.println();

			System.out.println("Quick Sort");
			quickSortRuntimeAverage.forEach((key, value) -> System.out.println(key + ": " + value));

			System.out.println();

			System.out.println("Counting Sort");
			countingSortRuntimeAverage.forEach((key, value) -> System.out.println(key + ": " + value));
		}
	}
	/* END OF TESTING */

	/* START OF HEAPSORT */

	/**
	 * Calls heapSort.
	 * 
	 * @param array
	 */
	public static void heapSort(int[] array) {

		// heapsort here
		// build heap (back to front)
		for (int i = array.length / 2; i >= 0; i--) {
			heapify(array, i, array.length - 1);
		}

		for (int i = array.length - 1; i > 0; i--) {

			// extract elements
			swapElements(array, 0, i);

			// restore heap property
			heapify(array, 0, i - 1);

		}
	}

	// additional methods for heapsort here
	private static void heapify(int[] array, int parent, int lastChildInHeap) {
		int firstChild = 2 * parent + 1;
		int secondChild = firstChild + 1;

		if (secondChild <= lastChildInHeap) {
			int greaterElement = (array[firstChild] > array[secondChild]) ? firstChild : secondChild;

			if (array[greaterElement] > array[parent]) {
				swapElements(array, parent, greaterElement);
				heapify(array, greaterElement, lastChildInHeap);
			}
		} else if (firstChild <= lastChildInHeap) {
			if (array[firstChild] > array[parent]) {
				swapElements(array, firstChild, parent);
			}
		}
	}

	private static void swapElements(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	/* END OF HEAPSORT */

	/* START OF QUICKSORT */

	/**
	 * Sorts an array by the divide-and-conquer approach with quicksort.
	 * 
	 * @param array
	 */
	public static void quickSort(int[] array) {

		// quicksort here
		if (array.length <= 1) {
			return;
		}
		quickSort(array, 0, array.length - 1);
	}

	// additional methods for quicksort here
	private static void quickSort(int[] array, int minIndex, int maxIndex) {
		// return, if only one element is to sort
		if (minIndex >= maxIndex) {
			return;
		}
		// choose pivot and marker
		int pivot = array[minIndex];
		int lowerMarker = minIndex + 1;
		int upperMarker = maxIndex;
		boolean running = true;
		// swap elements
		while (running) {
			// skip elements til marker found element to swap
			while (lowerMarker <= maxIndex && array[lowerMarker] <= pivot) {
				lowerMarker++;
			}
			while (upperMarker >= minIndex && array[upperMarker] > pivot) {
				upperMarker--;
			}
			if (lowerMarker < upperMarker) {
				// swap elements
				int temp = array[upperMarker];
				array[upperMarker] = array[lowerMarker];
				array[lowerMarker] = temp;
			} else {
				running = false;
			}
		}
		// sort in pivot
		int temp = array[minIndex];
		array[minIndex] = array[upperMarker];
		array[upperMarker] = temp;

		// sort lower part
		quickSort(array, minIndex, upperMarker - 1);
		// sort upper part
		quickSort(array, upperMarker + 1, maxIndex);
	}

	/* END OF QUICKSORT */

	/* START OF COUNTINGSORT */

	/**
	 * Sorts an array of integers.
	 * 
	 * @param array
	 */
	public static void countingSort(int[] array) {

		// countingsort here
		if (array.length < 2) {
			return;
		}

		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		countingSort(array, max);
	}

	// additional methods for countingsort here
	private static void countingSort(int[] array, int max) {

		int[] C = new int[max + 1];
		// Here: C[0] to C[max] available

		// counting
		for (int i = 0; i < array.length; i++) {
			C[array[i]]++;
		}
		// Here: C[i] = #i in array
		// set last index for 0
		C[0]--;
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		// Here: C[i] = last index where i is to place

		int[] R = new int[array.length];

		for (int i = R.length - 1; i >= 0; i--) {
			R[C[array[i]]] = array[i];
			C[array[i]]--;
		}
		for (int i = 0; i < R.length; i++) {
			array[i] = R[i];
		}
	}

	/* END OF COUNTINGSORT */
}