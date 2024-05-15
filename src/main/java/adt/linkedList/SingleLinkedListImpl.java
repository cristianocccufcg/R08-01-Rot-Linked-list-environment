package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while (!aux.isNIL()) {
			size += 1;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHEAD = head;
		while (!auxHEAD.isNIL() && auxHEAD.data != element) {
			auxHEAD = auxHEAD.next;
		}
		return (T) auxHEAD.data;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHEAD = head;
		if (head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, head);
			newHead.next = head;
			this.head = newHead;
		} else {
			while (!auxHEAD.isNIL()) {
				auxHEAD = auxHEAD.next;
			}
			auxHEAD.data = element;
			auxHEAD.next = new SingleLinkedListNode<>();
		}
	}

	@Override
	public void remove(T element) {
		if (head.data == element) {
			this.head = head.next;
		} else {
			SingleLinkedListNode<T> aux = head;
			while (!aux.isNIL() && aux.data != element) {
				aux = aux.next;
			}
			if (!aux.isNIL()) {
				aux.data = aux.next.data;
				aux.next = aux.next.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];

		int index = 0;
		SingleLinkedListNode<T> aux = this.head;

		while (!aux.isNIL()) {
			array[index++] = aux.getData();
			aux = aux.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
