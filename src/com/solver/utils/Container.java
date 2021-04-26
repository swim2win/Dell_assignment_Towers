package com.solver.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Container<T extends AtomicInteger> {
	T item;
	public Container() {
		item = (T) new AtomicInteger(0);
	}
	public Container(T item) {
		this.item = item;
	}
	public int increment() {
		return item.incrementAndGet();
	}
	public int get() {
		return item.get();
	}
	public void reset() {
		item.set(0);
	}
}
