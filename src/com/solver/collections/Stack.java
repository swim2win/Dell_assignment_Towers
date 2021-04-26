package com.solver.collections;

import java.util.LinkedList;

public  class  Stack<T> extends LinkedList<T> {
//	LinkedList<T> list = new LinkedList<>();
	
	public void push(T element) {
		add(element);
	}
	public T pop() {
		return remove(size()-1);
	}
	public T top() {
		
		return get(size()-1);
	}
}
