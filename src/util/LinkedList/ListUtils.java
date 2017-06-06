package util.LinkedList;

public class ListUtils {

	public static <E> boolean identifical(Node<E> list1, Node<E> list2) {
		while (list1 != null && list2 != null) {
			if (list1.getData() != null && !list1.getData().equals(list2.getData())) {
				break;
			}
			list1 = list1.getNext();
			list2 = list2.getNext();
		}

		return list1 == null && list2 == null;
	}

	public static <E> boolean identificalRecursive(Node<E> list1, Node<E> list2) {
		if (list1 == null && list2 == null) {
			return true;
		}

		if (list1 == null || list2 == null) {
			return false;
		}

		return list1.getData().equals(list2.getData()) && identificalRecursive(list1.getNext(), list2.getNext());
	}

	public static <E> Node<E> sortedMerge(Node<E> header, Node<E> next) {
		return sortedMerge(header, next, true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <E> Node<E> sortedMerge(Node<E> header1, Node<E> next1, boolean isAscending) {

		if (header1 == null) {
			return next1;
		}
		if (next1 == null) {
			return header1;
		}

		Node<E> result = null, temp = null;
		Node<E> header = header1, next = next1;
		while (header != null && next != null) {
			boolean compare = ((Comparable) header.getData()).compareTo(next.getData()) > 0;
			compare = isAscending ? compare : !compare;
			if (compare) {
				if (result == null) {
					result = next;
					temp = next;
				} else {
					temp.setNext(next);
					temp = temp.getNext();
				}
				next = next.getNext();
			} else {
				if (result == null) {
					result = header;
					temp = header;
				} else {
					temp.setNext(header);
					temp = temp.getNext();
				}
				header = header.getNext();
			}
		}

		if (header != null) {
			temp.setNext(header);
		}

		if (next != null) {
			temp.setNext(next);
		}

		return result;
	}

	public static <E> Node<E> mergeSort(Node<E> header) {
		return mergeSort(header, true);
	}

	public static <E> Node<E> mergeSort(Node<E> header, boolean isAscending) {
		if (header == null || header.getNext() == null) {
			return header;
		}

		Node<E> slow = header, fast = slow.getNext();
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		Node<E> next = slow.getNext();
		slow.setNext(null);

		header = mergeSort(header, isAscending);
		next = mergeSort(next, isAscending);

		return sortedMerge(header, next, isAscending);
	}

	public static <E> void print(Node<E> header) {
		Node<E> temp = header;
		while (temp != null) {
			System.out.print(temp.getData() + ", ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public static void findTriplet(int givenNumber, Node<Integer> header1, Node<Integer> header2,
			Node<Integer> header3) {
		if (header1 == null || header2 == null || header3 == null) {
			return;
		}

		header2 = mergeSort(header2);
		header3 = mergeSort(header3, false);

		Node<Integer> node1 = header1, node2 = header2, node3 = header3;

		while (node1 != null) {
			node2 = header2;
			node3 = header3;
			while (node2 != null && node3 != null) {
				int diff = node1.getData() + node2.getData() + node3.getData() - givenNumber;
				if (diff == 0) {
					// System.out.println(node1.getData() + ", " +
					// node2.getData() + ", " + node3.getData());
					break;
				} else if (diff > 0) {
					node3 = node3.getNext();
				} else {
					node2 = node2.getNext();
				}
			}

			node1 = node1.getNext();
		}

	}

	public static <T> int size(Node<T> node) {
		if (node == null) {
			return 0;
		}
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(Node<T> node, T[] a) {
		int size = size(node);
		if (a.length < size)
			a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
		int i = 0;
		Object[] result = a;
		for (Node<T> x = node; x != null; x = x.getNext())
			result[i++] = x.getData();

		if (a.length > size)
			a[size] = null;

		return a;
	}

	public static Node<Integer> addReverse(Node<Integer> list1, Node<Integer> list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		Node<Integer> sum = new Node<Integer>();
		Node<Integer> result = sum;

		int size1 = size(list1);
		int size2 = size(list2);

		if (size1 == size2) {
			int carry = addSameSize(sum, list1, list2);
			result = result.getNext();
			result = reverse(result);
			if(carry != 0) {
				Node<Integer> carryNode = new Node<Integer>(carry);
				carryNode.setNext(result);
				result = carryNode;
			}
		} else if (size1 > size2) {
			Node<Integer> temp1 = list1;
			for (int i = size1 - size2; i > 0; i--) {
				temp1 = temp1.getNext();
			}
			Integer carry = addSameSize(sum, temp1, list2);
			result = result.getNext();
			result = reverse(result);

			Node<Integer> sumNode = new Node<Integer>();
			carry = addCarryToRemaining(sumNode, carry, size1 - size2, list1);

			if (carry != null && carry != 0) {
				sumNode.setData(carry);
			} else {
				sumNode = sumNode.getNext();
			}

			Node<Integer> temp = result;
			result = sumNode;

			while (sumNode.getNext() != null) {
				sumNode = sumNode.getNext();
			}

			sumNode.setNext(temp);
		}

		return result;
	}

	public static <E> Node<E> reverse(Node<E> header) {
		Node<E> prev = null, current = header, next = current.getNext();

		while (next != null) {
			current.setNext(prev);
			prev = current;
			current = next;
			next = current.getNext();
		}

		current.setNext(prev);
		header = current;
		return header;
	}

	private static Integer addCarryToRemaining(Node<Integer> sumNode, Integer carry, int size, Node<Integer> list1) {
		if (size <= 0) {
			return carry;
		}
		carry = addCarryToRemaining(sumNode, carry, --size, list1.getNext());

		int sum = list1.getData() + carry;
		carry = sum / 10;
		int reminder = sum % 10;
		Node<Integer> newNode = new Node<Integer>(reminder);

		while (sumNode.getNext() != null) {
			sumNode = sumNode.getNext();
		}
		sumNode.next = newNode;

		return carry;
	}

	private static Integer addSameSize(Node<Integer> result, Node<Integer> node1, Node<Integer> node2) {
		if (node1 == null && node2 == null) {
			return 0;
		}
		Integer carry = addSameSize(result, node1.getNext(), node2.getNext());

		int sum = node1.getData() + node2.getData() + carry;
		carry = sum / 10;
		int reminder = sum % 10;
		Node<Integer> newNode = new Node<Integer>(reminder);

		while (result.getNext() != null) {
			result = result.getNext();
		}
		result.next = newNode;
		return carry;
	}

	public static <E> Node<E> mergeAlternate(Node<E> node1, Node<E> node2) {
		return mergeAlternate(node1, node2, true);
	}

	private static <E> Node<E> mergeAlternate(Node<E> node1, Node<E> node2, boolean alternate) {
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}

		Node<E> result = null;
		if (alternate) {
			result = node1;
			result.next = mergeAlternate(node1.getNext(), node2, !alternate);
		} else {
			result = node2;
			result.next = mergeAlternate(node1, node2.getNext(), !alternate);
		}
		return result;
	}
}
