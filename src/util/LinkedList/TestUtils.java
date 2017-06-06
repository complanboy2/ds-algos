package util.LinkedList;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class TestUtils {

	@Test
	public void size() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i < 10; i++) {
			list.add(i);
		}

		assertEquals(9, list.size());

	}

	@Test
	public void add() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));

		List<Integer> c = Arrays.asList(new Integer[] { 2, 3, 4 });
		list.addAll(c);

		Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
		assertEquals(new Integer[] { 1, 2, 3, 4 }, array);
	}

	@Test
	public void addAt() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i < 10; i++) {
			list.add(i);
		}

		list.add(0, 0);
		Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
		assertEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, array);

		list.add(list.size() + 1, 0);
		array = (Integer[]) list.toArray(new Integer[list.size()]);
		assertEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, array);

		list.add(1, 0);
		array = (Integer[]) list.toArray(new Integer[list.size()]);
		assertEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, array);

		list.add(list.size(), 10);
		array = (Integer[]) list.toArray(new Integer[list.size()]);
		assertEquals(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, array);

		list.add(5, 0);
		array = (Integer[]) list.toArray(new Integer[list.size()]);
		assertEquals(new Integer[] { 0, 1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 10 }, array);
	}

	@Test
	public void remove() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i < 10; i++) {
			list.add(i);
		}

		list.add(5, 0);
		list.remove(new Integer(0));
		Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
		assertEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, array);
	}

	@Test
	public void reverse() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i < 10; i++) {
			list.add(i);
		}

		list.reverse();
		Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
		List<Integer> reversedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.reverse(reversedList);
		assertEquals(reversedList, Arrays.asList(array));
	}

	@Test
	public void reverseSmall() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i <= 3; i++) {
			list.add(i);
		}

		list.reverse();
		Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
		List<Integer> reversedList = Arrays.asList(1, 2, 3);
		Collections.reverse(reversedList);
		assertEquals(reversedList, Arrays.asList(array));
	}

	@Test
	public void reverseRecursive() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i < 10; i++) {
			list.add(i);
		}

		list.reverseRecursive();
		Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
		List<Integer> reversedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.reverse(reversedList);
		assertEquals(reversedList, Arrays.asList(array));
	}

	@Test
	public void reverseRecursiveSmall() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i <= 3; i++) {
			list.add(i);
		}

		list.reverseRecursive();
		Integer[] array = (Integer[]) list.toArray(new Integer[list.size()]);
		List<Integer> reversedList = Arrays.asList(1, 2, 3);
		Collections.reverse(reversedList);
		assertEquals(reversedList, Arrays.asList(array));
	}

	@Test
	public void findSize() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		assertEquals(1, list.findSize());

		for (Integer i = 2; i <= 3; i++) {
			list.add(i);
		}

		assertEquals(3, list.findSize());

		for (Integer i = 2; i <= 10; i++) {
			list.add(i);
		}

		assertEquals(12, list.findSize());
	}

	@Test
	public void findSizeRecursive() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		assertEquals(1, list.findSizeRecursive());

		for (Integer i = 2; i <= 3; i++) {
			list.add(i);
		}

		assertEquals(3, list.findSizeRecursive());

		for (Integer i = 2; i <= 10; i++) {
			list.add(i);
		}

		assertEquals(12, list.findSizeRecursive());
	}

	@Test
	public void findMiddle() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i < 10; i++) {
			list.add(i);
		}
		assertEquals(new Integer(5), (Integer) list.findMiddle().getData());

		list.add(10);
		assertEquals(new Integer(6), (Integer) list.findMiddle().getData());
	}

	@Test
	public void getAt() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i < 10; i++) {
			list.add(i);
		}
		assertEquals(new Integer(5), (Integer) list.getAt(5).getData());
		assertEquals(new Integer(1), (Integer) list.getAt(1).getData());
		assertEquals(null, list.getAt(0));
		assertEquals(null, list.getAt(-1));
		assertEquals(null, list.getAt(11));
		assertEquals(new Integer(9), (Integer) list.getAt(9).getData());

		list.add(10);
		assertEquals(new Integer(6), (Integer) list.findMiddle().getData());
	}

	@Test
	public void findLoop() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i <= 10; i++) {
			list.add(i);
		}
		assertEquals(Boolean.FALSE, (Boolean) list.findLoop());
		LinkedList<Integer> temp = list.addRandomLoop();
		assertEquals(Boolean.TRUE, LinkedList.findLoop(temp));
	}

	@Test
	public void search() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i <= 10; i++) {
			list.add(i);
		}
		assertEquals(new Integer(10), list.search(10).getData());
		assertEquals(new Integer(6), list.search(6).getData());
		assertEquals(new Integer(4), list.searchRecursive(4).getData());
		assertEquals(new Integer(1), list.searchRecursive(1).getData());
	}

	@Test
	public void swap() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(10));
		list.addAll(Arrays.asList(15, 12, 13, 20, 14));
		list.swapNodes(10, 12);

		assertEquals(new Integer[] { 12, 15, 10, 13, 20, 14 }, list.toArray(new Integer[list.size()]));
	}

	@Test
	public void swapPair() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(10));
		list.addAll(Arrays.asList(15, 12, 13, 20, 14));

		list.swapPair();
		assertEquals(new Integer[] { 15, 10, 13, 12, 14, 20 }, list.toArray(new Integer[list.size()]));
	}

	@Test
	public void identical() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(10));
		list.addAll(Arrays.asList(15, 12, 13, 20, 14));

		LinkedList<Integer> list2 = new LinkedList<>(new Node<Integer>(10));
		list2.addAll(Arrays.asList(15, 12, 13, 20, 14));

		assertEquals(new Integer[] { 10, 15, 12, 13, 20, 14 }, list.toArray(new Integer[list.size()]));
		assertEquals(new Integer[] { 10, 15, 12, 13, 20, 14 }, list2.toArray(new Integer[list.size()]));
		assertEquals(true, ListUtils.identifical(list.header, list2.header));
		assertEquals(true, ListUtils.identifical(null, null));
		assertEquals(true, ListUtils.identificalRecursive(null, null));
		assertEquals(false, ListUtils.identifical(null, list2.header));
		assertEquals(false, ListUtils.identificalRecursive(null, list2.header));
		list.add(14);
		assertEquals(false, ListUtils.identifical(list.header, list2.header));
		assertEquals(false, ListUtils.identificalRecursive(list.header, list2.header));
	}

	@Test
	public void reverseInGroups() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		list.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

		list.reverseInGroups(5);
		list.reverseInGroupsRecursive(5);
		assertEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, list.toArray(new Integer[list.size()]));

		list = new LinkedList<>(new Node<Integer>(1));
		list.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

		list.reverseInGroups(3);
		list.reverseInGroupsRecursive(3);
		assertEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, list.toArray(new Integer[list.size()]));
	}

	@Test
	public void reverseAltGroupsRecursive() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		list.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

		list.reverseAltGroupsRecursive(3);
		assertEquals(new Integer[] { 3, 2, 1, 4, 5, 6, 8, 7 }, list.toArray(new Integer[list.size()]));
	}

	@Test
	public void removeLoop() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		for (Integer i = 2; i <= 10; i++) {
			list.add(i);
		}
		LinkedList<Integer> temp = list.addRandomLoop();
		assertEquals(Boolean.TRUE, LinkedList.findLoop(temp));

		temp.removeLoop();
	}

	@Test
	public void mergeSort() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		list.addAll(Arrays.asList(2, 7, 4, 9, 3, 6, 10, 8));

		list.mergeSort();
		assertEquals(new Integer[] { 1, 2, 3, 4, 6, 7, 8, 9, 10 }, list.toArray(new Integer[list.size()]));
	}

	@Test
	public void sortedMerge() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(0));
		list.addAll(Arrays.asList(2, 4, 6, 8, 10));

		LinkedList<Integer> list2 = new LinkedList<>(new Node<Integer>(1));
		list2.addAll(Arrays.asList(3, 5, 7, 9));

		@SuppressWarnings("unused")
		Node<Integer> header = ListUtils.sortedMerge(list.header, list2.header);
	}

	@Test
	public void findTriplet() {
		LinkedList<Integer> list1 = new LinkedList<>(new Node<Integer>(12));
		list1.addAll(Arrays.asList(6, 29));

		LinkedList<Integer> list2 = new LinkedList<>(new Node<Integer>(23));
		list2.addAll(Arrays.asList(5, 8));

		LinkedList<Integer> list3 = new LinkedList<>(new Node<Integer>(90));
		list3.addAll(Arrays.asList(20, 29));

		ListUtils.findTriplet(101, list1.header, list2.header, list3.header);
	}

	@Test
	public void rotate() {
		LinkedList<Integer> list = new LinkedList<>(new Node<Integer>(1));
		list.addAll(Arrays.asList(2, 3, 4, 6, 7, 8, 9, 10));

		list.rotate(0);
		assertEquals(new Integer[] { 1, 2, 3, 4, 6, 7, 8, 9, 10 }, list.toArray(new Integer[list.size()]));
		list.rotate(1);
		assertEquals(new Integer[] { 2, 3, 4, 6, 7, 8, 9, 10, 1 }, list.toArray(new Integer[list.size()]));
		list.rotate(2);
		assertEquals(new Integer[] { 4, 6, 7, 8, 9, 10, 1, 2, 3 }, list.toArray(new Integer[list.size()]));
		list.rotate(10);
		assertEquals(new Integer[] { 6, 7, 8, 9, 10, 1, 2, 3, 4 }, list.toArray(new Integer[list.size()]));
	}

	@Test
	public void addTwoLists() {
		LinkedList<Integer> list1 = new LinkedList<>(new Node<Integer>(7));
		list1.addAll(Arrays.asList(8, 9));

		LinkedList<Integer> list2 = new LinkedList<>(new Node<Integer>(9));
		list2.addAll(Arrays.asList(9, 7, 8, 9));

		Node<Integer> sum = ListUtils.addReverse(list2.header, list1.header);
		Integer[] array = ListUtils.toArray(sum, new Integer[ListUtils.size(sum)]);
		assertEquals(new Integer[] { 1, 0, 0, 5, 7, 8 }, array);

		LinkedList<Integer> list3 = new LinkedList<>(new Node<Integer>(9));
		list3.addAll(Arrays.asList(9, 9));

		sum = ListUtils.addReverse(list3.header, list1.header);
		array = ListUtils.toArray(sum, new Integer[ListUtils.size(sum)]);
		assertEquals(new Integer[] { 1, 7, 8, 8 }, array);
	}

	@Test
	public void mergeAlternate() {
		LinkedList<Integer> list1 = new LinkedList<>(new Node<Integer>(1));
		list1.addAll(Arrays.asList(2, 3));

		LinkedList<Integer> list2 = new LinkedList<>(new Node<Integer>(1));
		list2.addAll(Arrays.asList(4, 9, 6, 9));

		Node<Integer> result = ListUtils.mergeAlternate(list1.header, list2.header);
		Integer[] array = ListUtils.toArray(result, new Integer[ListUtils.size(result)]);

		assertEquals(new Integer[] { 1, 1, 2, 4, 3, 9, 6, 9 }, array);
	}

	@Test
	public void pairwiseSwap() {
		LinkedList<Integer> list1 = new LinkedList<>(new Node<Integer>(1));
		list1.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));

		list1.pairwsieSwap();
		assertEquals(new Integer[] { 2, 1, 4, 3, 6, 5, 8, 7, 9 }, list1.toArray(new Integer[list1.size()]));
		
		list1 = new LinkedList<>(new Node<Integer>(1));
		list1.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

		list1.pairwsieSwap();
		assertEquals(new Integer[] { 2, 1, 4, 3, 6, 5, 8, 7 }, list1.toArray(new Integer[list1.size()]));
	}
	
	@Test
	public void pairwiseSwapRecursive() {
		LinkedList<Integer> list1 = new LinkedList<>(new Node<Integer>(1));
		list1.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));

		list1.pairwsieSwapRecursive();
		assertEquals(new Integer[] { 2, 1, 4, 3, 6, 5, 8, 7, 9 }, list1.toArray(new Integer[list1.size()]));
		
		list1 = new LinkedList<>(new Node<Integer>(1));
		list1.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

		list1.pairwsieSwapRecursive();
		assertEquals(new Integer[] { 2, 1, 4, 3, 6, 5, 8, 7 }, list1.toArray(new Integer[list1.size()]));
	}
}