package util.LinkedList;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import util.generics.DeepCopy;

public class LinkedList<E> implements List<E>, Serializable {

	private static final long serialVersionUID = 6774572657184784050L;

	public Node<E> header;
	private int size;

	public LinkedList(Node<E> header) {
		this.header = header;
		this.size = 1;
	}

	public LinkedList(E data) {
		this.header = new Node<E>(data);
		this.size = 1;
	}

	public Node<E> push(Node<E> header, E data) {
		Node<E> newNode = new Node<E>(data);
		newNode.setPrevious(header);
		header = newNode;
		return header;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		Node<E> temp = header;
		while (temp != null) {
			if (o.equals(temp.getData())) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];

		int i = 0;
		for (Node<E> temp = header; temp != null; temp = temp.getNext()) {
			result[i++] = temp.getData();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
		int i = 0;
		Object[] result = a;
		for (Node<E> x = header; x != null; x = x.getNext())
			result[i++] = x.getData();

		if (a.length > size)
			a[size] = null;

		return a;
	}

	@Override
	public boolean add(E e) {
		Node<E> temp = header;
		for (; temp.getNext() != null; temp = temp.getNext()) {
		}
		temp.setNext(new Node<E>(e));
		size++;

		return true;
	}

	@Override
	public boolean remove(Object o) {
		Node<E> prev = null;
		for (Node<E> temp = header; temp != null; prev = temp, temp = temp.getNext()) {
			if ((o == null && temp.getData() == null) || temp.getData().equals(o)) {
				size--;
				if (prev == null) {
					prev = header.getNext();
					return true;
				} else {
					prev.setNext(temp.getNext());
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (c == null || c.isEmpty()) {
			return false;
		}
		Node<E> temp = header;
		for (; temp.getNext() != null; temp = temp.getNext()) {
		}
		for (E e : c) {
			temp.setNext(new Node<E>(e));
			temp = temp.getNext();
			size++;
		}

		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if (c == null || c.isEmpty()) {
			return false;
		}
		if (index > size) {
			return false;
		}
		Node<E> temp = header;
		for (; temp.getNext() != null && index < size; temp = temp.getNext(), index--) {
		}
		for (E e : c) {
			temp.setNext(new Node<E>(e));
			size++;
		}

		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (c == null || c.isEmpty()) {
			return false;
		}
		Node<E> prev = null;
		for (Node<E> temp = header; temp != null; temp = temp.getNext()) {
			if (c.contains(temp.getData())) {
				size--;
				if (prev == null) {
					prev = header.getNext();
					return true;
				} else {
					prev = temp.getNext();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		header = null;
		size = 0;
	}

	public Node<E> getAt(int index) {

		if (index > size || index <= 0) {
			return null;
		}

		Node<E> temp = header;

		while (--index > 0) {
			temp = temp.getNext();
		}

		return temp;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		if (index <= 0 || index > size) {
			return;
		}

		size++;
		Node<E> temp = header;
		Node<E> next = new Node<E>(element);
		if (index == 1) {
			next.setNext(header);
			header = next;
			return;
		}
		for (; temp.getNext() != null && --index > 0; temp = temp.getNext()) {
		}
		next.setNext(temp.getNext());
		temp.setNext(next);
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public void print() {
		int i = 0;
		Node<E> temp = header;
		for (; i <= size && temp != null; i++, temp = temp.getNext()) {
			System.out.print(temp.getData() + ", ");
		}
		if (temp == null) {
			System.out.println();
		} else {
			System.out.println(temp.getData());
		}
	}

	public void reverse() {
		Node<E> prev = null, current = header, next = current.getNext();

		while (next != null) {
			current.setNext(prev);
			prev = current;
			current = next;
			next = current.getNext();
		}

		current.setNext(prev);
		header = current;
	}

	public void reverseRecursive() {
		header = reverseRecursive(header, null);
	}

	public Node<E> reverseRecursive(Node<E> header, Node<E> previous) {
		if (header.getNext() == null) {
			header.setNext(previous);
			return header;
		}

		Node<E> next = header.getNext();
		header.setNext(previous);
		return reverseRecursive(next, header);
	}

	public int findSize() {
		if (header.getNext() == null) {
			return 1;
		}

		Node<E> temp = header.getNext();
		int size = 1;
		while (temp != null) {
			temp = temp.getNext();
			size++;
		}

		return size;
	}

	public int findSizeRecursive() {
		return findSizeRecursive(header);
	}

	private int findSizeRecursive(Node<E> header) {
		if (header.getNext() == null) {
			return 1;
		}
		return 1 + findSizeRecursive(header.getNext());
	}

	public Node<E> findMiddle() {
		Node<E> slow = header, fast = header;

		do {
			slow = slow.getNext();
			if (fast.getNext() != null) {
				fast = fast.getNext().getNext();
			}
		} while (fast != null && fast.getNext() != null && fast != slow);

		if (fast == null || fast.getNext() == null) {
			return slow;
		}
		return null;
	}

	public boolean findLoop() {
		Node<E> slow = header, fast = header;

		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if (fast == slow) {
				break;
			}
		}

		return fast != null ? true : false;
	}

	public static <T> boolean findLoop(LinkedList<T> list) {
		Node<T> slow = list.header, fast = list.header;

		do {
			slow = slow.getNext();
			if (fast.getNext() != null) {
				fast = fast.getNext().getNext();
			}
		} while (fast != null && fast != slow);

		return fast != null ? true : false;
	}

	@SuppressWarnings("unchecked")
	public LinkedList<E> clone() {
		return (LinkedList<E>) DeepCopy.copy(this);
	}

	public LinkedList<E> addRandomLoop() {
		LinkedList<E> clone = this.clone();
		Node<E> header = clone.header;
		if (header.getNext() == null) {
			header.setNext(header);
		}

		int randomIndex = new Random().nextInt(clone.findSize());
		Node<E> indexedNode = clone.getAt(randomIndex);
		Node<E> lastNode = clone.getAt(clone.findSize());

		lastNode.setNext(indexedNode);

		return clone;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public Node<E> search(E data) {
		Node<E> temp = header;
		while (temp != null) {
			if (temp.getData().equals(data)) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	public Node<E> searchRecursive(E data) {
		return searchRecursive(header, data);
	}

	private Node<E> searchRecursive(Node<E> header, E data) {
		if (header == null) {
			return null;
		}
		if (header.getData().equals(data)) {
			return header;
		}
		return searchRecursive(header.getNext(), data);
	}

	public void swapNodes(E i, E j) {
		if (size == 1 || i.equals(j)) {
			return;
		}

		Node<E> px = null, cx = header;
		Node<E> py = null, cy = header;

		while (cx != null && !i.equals(cx.getData())) {
			px = cx;
			cx = cx.getNext();
		}

		while (cy != null && !j.equals(cy.getData())) {
			py = cy;
			cy = cy.getNext();
		}

		if (cx == null || cy == null) {
			return;
		}

		if (px != null) {
			px.setNext(cy);
		} else {
			header = cy;
		}

		if (py != null) {
			py.setNext(cx);
		} else {
			header = cx;
		}

		Node<E> temp = cy.getNext();
		cy.setNext(cx.getNext());
		cx.setNext(temp);
	}

	public void swapPair() {
		if (header == null || header.getNext() == null) {
			return;
		}

		Node<E> previous = header, current = header.getNext();
		header = current;
		while (current != null) {
			Node<E> temp = current.getNext();
			current.setNext(previous);
			previous.setNext(temp);

			temp = previous;
			previous = previous.getNext();
			if (previous == null) {
				break;
			}
			current = previous.getNext();
			temp.setNext(current);
		}
	}

	public void reverseInGroups(int k) {
		if (k <= 0 || k > size) {
			return;
		}

		Node<E> head = header, tail = null;
		Node<E> temp = header;
		while (temp != null) {
			for (int i = 0; i < k && temp != null; i++) {
				temp = temp.getNext();
			}
			Node<E> prev = tail, cur = head, next = cur.getNext();
			do {
				next = cur.getNext();
				cur.setNext(prev);
				prev = cur;
				cur = next;
			} while (cur != null && !cur.equals(temp));
			if (tail == null) {
				tail = header;
				header = prev;
			} else {
				tail.setNext(prev);
				tail = head;
			}
			head.setNext(cur);
			head = cur;
		}
	}

	public void reverseInGroupsRecursive(int k) {
		if (k <= 0 || k > size) {
			return;
		}

		header = reverseInGroupsRecursive(header, k);
	}

	private Node<E> reverseInGroupsRecursive(Node<E> header, int k) {
		if (header == null) {
			return null;
		}

		Node<E> prev = null, cur = header, next = null;
		for (int i = 0; i < k && cur != null; i++) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}

		header.setNext(reverseInGroupsRecursive(cur, k));
		return prev;
	}

	public void reverseAltGroupsRecursive(int k) {
		if (k <= 0 || k > size) {
			return;
		}

		header = reverseAltGroupsRecursive(header, k);
	}

	private Node<E> reverseAltGroupsRecursive(Node<E> header, int k) {
		if (header == null) {
			return null;
		}
		Node<E> prev = null, cur = header;
		Node<E> next = null;
		for (int i = 0; i < k && cur != null; i++) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		header.setNext(next);
		for (int i = 0; i < k - 1 && cur != null; i++) {
			cur = cur.getNext();
		}
		if (cur != null) {
			cur.setNext(reverseAltGroupsRecursive(cur.getNext(), k));
		}
		return prev;
	}

	public void removeLoop() {
		if (findLoop()) {
			Node<E> slow = header, fast = header;
			do {
				slow = slow.getNext();
				if (fast.getNext() != null) {
					fast = fast.getNext().getNext();
				}
			} while (fast != null && fast != slow);

			fast = fast.getNext();
			int k = 1;
			while (fast != slow) {
				fast = fast.getNext();
				k++;
			}

			Node<E> kthNode = header;
			while (k-- > 0) {
				kthNode = kthNode.getNext();
			}

			Node<E> temp = header;
			while (kthNode != temp) {
				temp = temp.getNext();
				kthNode = kthNode.getNext();
			}

			temp = header;
			while (temp.getNext() != kthNode) {
				temp = temp.getNext();
			}
			temp.setNext(null);
		}
	}

	public void mergeSort() {
		header = mergeSort(header);
	}

	public Node<E> mergeSort(Node<E> header) {
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

		header = mergeSort(header);
		next = mergeSort(next);

		return ListUtils.sortedMerge(header, next);
	}

	public void rotate(int k) {
		if (k <= 0) {
			return;
		}

		k = k % size();

		Node<E> temp = header, first = header;
		Node<E> last = header;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		while (k-- > 0) {
			first = temp;
			temp = temp.getNext();
			last.setNext(first);
			first.setNext(null);
			last = last.getNext();
		}

		header = temp;
	}

	public Node<Integer> flatten(Node<Integer> header2) {
		return null;
	}

	public void pairwsieSwap() {
		if (header == null || header.getNext() == null) {
			return;
		}

		Node<E> current = header, previous = null;
		header = current.getNext();
		while (current != null && current.getNext() != null) {

			Node<E> next = current.getNext().getNext();
			current.next.next = current;
			if (previous != null) {
				previous.next = current.next;
			}

			current.next = next;
			previous = current;
			current = next;
		}
	}

	public void pairwsieSwapRecursive() {
		Node<E> temp = header.getNext();
		pairwsieSwapRecursive(header, null);
		header = temp;
	}

	public void pairwsieSwapRecursive(Node<E> current, Node<E> previous) {
		if (current == null || current.getNext() == null) {
			return;
		}

		Node<E> next = current.getNext().getNext();
		current.next.next = current;
		if (previous != null) {
			previous.next = current.next;
		}

		current.next = next;
		pairwsieSwapRecursive(next, current);
	}
}