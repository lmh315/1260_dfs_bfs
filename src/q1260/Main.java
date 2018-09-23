package q1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static int[][] edge;

	public static void main(String[] args) throws IOException {

		int i, j, k;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		edge = new int[N + 1][N + 1];
		for (i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			j = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			edge[j][k] = 1;
			edge[k][j] = 1;
		}
		DFS(V);
		System.out.println();
		BFS(V);
	}

	public static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N + 1];
		int i, j, x;

		q.add(n);
		visited[n] = true;
		
		while (!q.isEmpty()) {
			x = q.poll();
			System.out.print(x + " ");

			for (i = 1; i <= N; i++) {
				if (i == x)
					continue;
				if (visited[i] || edge[x][i] == 0)
					continue;

				q.add(i);
				visited[i] = true;
			}
		}
	}
	
	public static void DFS(int n) {
		Stack<Integer> s = new Stack<>();
		boolean visited[] = new boolean[N+1];
		boolean flag;
		int i,j,x;
		
		s.push(n);
		visited[n] = true;
		System.out.print(n + " ");
		
		while(!s.isEmpty()) {
			x = s.peek();
			
			flag = false;
			
			for(i=1; i<=N; i++) {
				if (i == x) continue;
				if (visited[i] || edge[x][i] == 0) continue;
				
				s.push(i);
				System.out.print(i + " ");
				visited[i] = true;
				flag = true;
				break;
			}
			
			if(!flag) s.pop();
		}
	}

}
