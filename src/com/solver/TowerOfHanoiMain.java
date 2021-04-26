package com.solver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import com.solver.collections.Stack;
import com.solver.utils.Container;

/*3 towers - start, aux, end

'plates - each successive plate is larger than previous'
so, plate has size
in the beginning the plates are placed in start in the ascending order from top to down
you have to move the plates form start to end, one at a time, 
plate with smaller size can't be placed above the one of the larger size
you can use temporary variables
*/
public class TowerOfHanoiMain {
	public static void main(String[] args) {

		Solver solver = new Solver(5);

		Map<Integer, Solver> memoisedSolutions = new HashMap<>();
		memoisedSolutions.put(5, solver);
		boolean exit = false;
		int sel = 0;
		Integer hanoicount = 0;

		try (Scanner sc = new Scanner(System.in)) {
			while (!exit) {
				System.out.println(
						"please enter the option : 1.) to solve for hanoi tower, 2.) to view last solution, 10.) to exit");
				sel = sc.nextInt();
				switch (sel) {
				case 1:
					System.out.println("please enter the number of hanoi's to solve for");
					hanoicount = sc.nextInt();
					solver = memoisedSolutions.get(hanoicount);
					if (solver != null) {
						break;
					}
					solver = new Solver(hanoicount);
					memoisedSolutions.put(hanoicount, solver);
					break;
				case 2:
					System.out.println("the solution");
					System.out.println("__________");
					System.out.println("in end");
					solver.getEnd().forEach(el -> System.out.println(el + " "));
					System.out.println("___________");
					System.out.println("in start");
					solver.getStart().forEach(el -> System.out.println(el + " "));
					System.out.println("___________");
					System.out.println("in aux");
					solver.getAux().forEach(el -> System.out.println(el + " "));
					System.out.println("___________");
					System.out.println("Loop length : " + solver.getLoopLen());
					System.out.println("Hanoi count  : " + solver.getHanoiCount());
					break;
				case 10:
					exit = true;
					break;
				default:
					break;
				}
			}

		}
	}

	private static class Solver {
		private Stack<Integer> start;
		private Stack<Integer> aux;
		private Stack<Integer> end;
		private int loopLen = 0;
		private int hanoiCount = 0;

		public Solver(int count) {// 5
			this.hanoiCount = count;
			start = initialise(count);
			aux = new Stack<>();
			end = new Stack<>();
			for (int i = 0; i < count; i++)
				System.out.println("at index i = " + i + " ->  " + start.get(i));
			System.out.println("___________");
			Double tmp = Math.pow(2, count);
			loopLen = tmp.intValue() - 1;
			System.out.println("loop len : " + loopLen);
			/*
			 * count can be even or odd
			 */
			if (count <= 0)
				return;
			if (count == 1) {
				startToEnd();
				return;
			}
			Container<AtomicInteger> counter = new Container<AtomicInteger>();
//			int a = count;
//			int b = 0;
//			int c = 0;

			if (start.size() % 2 == 0) {
				while (loopLen != counter.get()) {
					startAndAux(counter);
					startAndEnd(counter);
					auxAndEnd(counter);
					System.out.println(counter.get());
				}
			} else {
				while (loopLen != counter.get()) {
					startAndEnd(counter);
					startAndAux(counter);
					auxAndEnd(counter);
					System.out.println(counter.get());
				}
			}

		}

		static Stack<Integer> initialise(int count) {
			Stack<Integer> start = new Stack<>();
			for (int n = count; n > 0; n--)
				start.push(n);
			return start;

		}

		private void moveHanoi(Stack<Integer> from, Stack<Integer> to) {
			to.push(from.pop());
		}

		private void startToEnd() {
			System.out.println("moved hanoi " + start.top() + " from start to end");
			moveHanoi(start, end);
		}

		private void endToStart() {
			System.out.println("moved hanoi " + end.top() + " from end to start");
			moveHanoi(end, start);
		}

		private void startToAux() {
			System.out.println("moved hanoi " + start.top() + " from startToAux");
			moveHanoi(start, aux);
		}

		private void auxToStart() {
			System.out.println("moved hanoi " + aux.top() + " from auxToStart");
			moveHanoi(aux, start);
		}

		private void endToAux() {
			System.out.println("moved hanoi " + end.top() + " from endToAux");
			moveHanoi(end, aux);
		}

		private void auxToEnd() {
			System.out.println("moved hanoi " + aux.top() + " from auxToEnd");
			moveHanoi(aux, end);
		}

		public Stack<Integer> getStart() {
			return start;
		}

		public Stack<Integer> getAux() {
			return aux;
		}

		public Stack<Integer> getEnd() {
			return end;
		}

		private void startAndAux(Container<AtomicInteger> counter) {
			if (counter.get() == loopLen) {
				return;
			}
			if (start.size() == 0) {
				auxToStart();
				System.out.println(counter.increment());
				return;
			}
			if (aux.size() == 0) {
				startToAux();
				System.out.println(counter.increment());
				return;
			}

			if (start.top() > aux.top()) {
				auxToStart();
				System.out.println(counter.increment());
			} else {
				startToAux();
				System.out.println(counter.increment());
			}
		}

		private void startAndEnd(Container<AtomicInteger> counter) {
			if (counter.get() == loopLen) {
				return;
			}
			if (start.size() == 0) {
				endToStart();
				System.out.println(counter.increment());
				return;
			}
			if (end.size() == 0) {
				startToEnd();
				System.out.println(counter.increment());
				return;
			}

			if (start.top() > end.top()) {
				endToStart();
				System.out.println(counter.increment());
			} else {
				startToEnd();
				System.out.println(counter.increment());
			}
		}

		private void auxAndEnd(Container<AtomicInteger> counter) {
			if (counter.get() == loopLen) {
				return;
			}
			if (end.size() == 0) {
				auxToEnd();
				System.out.println(counter.increment());
				return;
			}
			if (aux.size() == 0) {
				endToAux();
				System.out.println(counter.increment());
				return;
			}

			if (end.top() > aux.top()) {
				auxToEnd();
				System.out.println(counter.increment());
			} else {
				endToAux();
				System.out.println(counter.increment());
			}
		}

		public int getLoopLen() {
			return loopLen;
		}

		public int getHanoiCount() {
			return hanoiCount;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + hanoiCount;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Solver other = (Solver) obj;
			if (hanoiCount != other.hanoiCount)
				return false;
			return true;
		}

	}

}
