package com.example.krisattempt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TowersOfHanoiDockerApplication{
public static class HanoiTower{
		public static void main(String[] args) {
		SpringApplication.run(TowersOfHanoiDockerApplication.class, args);
	
		
		int n = 4;
		
		HanoiTower hanoiTower = new HanoiTower(n);
		hanoiTower.display();
		hanoiTower.solve(n, 'A', 'B', 'C');
		
	}
		public int n;
		public int[][] towers;
		
		public HanoiTower(int n) {
			this.n = n;
			towers = new int[n][];
			
			for(int i = 0; i < n; i++) {
				towers[i] = new int[3];
				
				for(int j = 0; j < 3; j++) {
					towers[i][j] = 0;
					
				}
			}
			for(int i = n - 1; i >= 0; i--) {
				towers[i][0] = i + 1;
				
			}
		}
		public void solve(int n, char from, char inter, char to) {
			if(n == 1) {
				System.out.println("\n\n** Disk 1 from " + from + " to "+ to);
				updateTowers(n, from, to);
				display();
			}else {
				solve(n - 1, from, to, inter);
				System.out.println("\n\n** Disk "+ n + " from "+ from + " to " + to);
				updateTowers(n, from, to);
				display();
				solve(n-1, inter, from, to);
				
			}
		}
		public int topForTower(char tower) {
			int i = n - 1;
			
			while(i >= 0 && towers[i][tower - 65] != 0) {
				i--;
			}
			return i;
			
		}
		public void updateTowers(int n, char from, char to) {
			int topForTo = topForTower(to);
			int topForFrom = topForTower(from);
			towers[topForTo][to - 65] = towers[topForFrom + 1][from - 65];
			towers[topForFrom + 1][from - 65] = 0;
		}
		
		public void display() {
			System.out.println("\n Tower Map\n");
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < 3; j++) {
					System.out.print((towers[i][j] == 0 ? " " : towers[i][j]) + "\t");
				}
				
				System.out.println();
			}
			
			for(int i = 0; i < 3; i++) {
				System.out.print((char) (i+65) + "\t");
			}
			System.out.println();
		}
}
}
