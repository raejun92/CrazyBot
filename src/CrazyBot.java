import java.util.*;

public class CrazyBot {

	boolean[][] grid = new boolean[100][100]; // �κ��� �湮�� ���� ����ϱ� ���� �׸���
	int vx[] = { 1, -1, 0, 0 };  // ���� 1   ���� -1     ���� 0   ����   0
	int vy[] = { 0, 0, 1, -1 };  //    0      0     1    -1

	double[] prob = new double[4];

	public double getProbability(int n, int east, int west, int south, int north) {

		prob[0] = east / 100.0;
		prob[1] = west / 100.0;
		prob[2] = south / 100.0;
		prob[3] = north / 100.0;

		return dfs(50, 50, n); // ��,��,��,������ �ִ� 50���� �� �� �ְ� n�� ������
	}

	double dfs(int x, int y, int n) {

		if (grid[x][y]) // �湮�ߴ� ������ �湮�ϰ� �Ǵ� ����� ���, ��� ��ȿȭ
			return 0;
		if (n == 0) // �����̴� Ƚ���� �� ����� ���(���� ���)
			return 1;

		grid[x][y] = true; // �湮�ϰ� �� ������ ǥ��

		double ret = 0.0;

		for (int i = 0; i < 4; i++) { // ��,��,��,�� 4�� ���� 
			ret += dfs(x + vx[i], y + vy[i], n - 1) * prob[i]; // ��,��,��,�Ͽ� ���� Ȯ��
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
