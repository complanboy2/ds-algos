package util.LinkedList;

import java.io.Serializable;

import util.generics.DeepCopy;

public class Node<T> implements Serializable {

	private static final long serialVersionUID = 6092474134696530345L;

	private Node<T> previous;
	public Node<T> next;
	private T data;

	public Node(Node<T> previous, Node<T> next, T data) {
		this.previous = previous;
		this.next = next;
		this.data = data;
	}

	public Node() {

	}

	public Node(T data) {
		this.data = data;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public Node<T> getNext() {
		return next;
	}

	public T getData() {
		return data;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [previous=" + previous + ", next=" + next + ", data=" + data + "]";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Node<T> clone() {
		return (Node<T>) DeepCopy.copy(this);
	}
}
