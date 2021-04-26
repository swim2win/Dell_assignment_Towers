package com.solver.models;

public class Hanoi implements Comparable<Hanoi> {
	private int size;
	public Hanoi(int size) {
		this.size = size;
	}
	
	@Override
	public int compareTo(Hanoi o) {
		
		return this.size - o.size;
	}
	public String toString() {
		return "Hanoi["+size+"]";
	}
	
}
