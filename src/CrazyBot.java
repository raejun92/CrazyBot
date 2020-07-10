import java.util.*;

public class CrazyBot {

	boolean[][] grid = new boolean[100][100]; // 로봇이 방문한 곳을 기억하기 위한 그리드
	int vx[] = { 1, -1, 0, 0 };  // 동쪽 1   서족 -1     북쪽 0   남쪽   0
	int vy[] = { 0, 0, 1, -1 };  //    0      0     1    -1

	double[] prob = new double[4];

	public double getProbability(int n, int east, int west, int south, int north) {

		prob[0] = east / 100.0;
		prob[1] = west / 100.0;
		prob[2] = south / 100.0;
		prob[3] = north / 100.0;

		return dfs(50, 50, n); // 동,서,남,북으로 최대 50까지 갈 수 있고 n번 움직임
	}

	double dfs(int x, int y, int n) {

		if (grid[x][y]) // 방문했던 지점을 방문하게 되는 경로인 경우, 경로 무효화
			return 0;
		if (n == 0) // 움직이는 횟수를 다 사용한 경우(말단 노드)
			return 1;

		grid[x][y] = true; // 방문하게 된 지점을 표시

		double ret = 0.0;

		for (int i = 0; i < 4; i++) { // 동,서,남,북 4번 수행 
			ret += dfs(x + vx[i], y + vy[i], n - 1) * prob[i]; // 동,서,남,북에 대한 확률
		}
		grid[x][y] = false;

		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CrazyBot cb = new CrazyBot();

		int n = 1;
		int west = 25;
		int south = 25;
		int east = 25;
		int north = 25;

		System.out.println(cb.getProbability(n, east, west, south, north));

	}

}
