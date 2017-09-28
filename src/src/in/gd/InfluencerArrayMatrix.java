package src.in.gd;

public class InfluencerArrayMatrix {

	public static int influencer(final int[][] jobs, final int r, final int c) {
		int[] degree_in = new int[jobs.length];
		int[] degree_out = new int[jobs.length];

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (jobs[i][j] == 1) {
					// i influences j
					degree_out[i]++;
					degree_in[j]++;
				}
			}
		}

		for (int i = 0; i < r; ++i) {
			if (degree_out[i] == r - 1 && degree_in[i] == 0) {
				return i;
			}
		}

		return -1;
	}

}