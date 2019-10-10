import java.util.Scanner;

class Solution
{
	private static int[][] val = new int[100001][2];

	public static void main(String args[]) throws Exception
	{
		int idx = 1;
        val[1][1] = 1;
        for (int i = 2; i < val.length; i++) {
            for (int j = i; j < val.length; j += i)
                val[j][0]++;
            if (val[i][0] > val[idx][0])
                idx = i;
            else if (val[i][0] == val[idx][0])
                idx = (i > idx) ? i : idx;
            val[i][1] = idx;
        }
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(sc.nextLine());
			System.out.println("#"+test_case+" "+val[N][1]);
		}
	}
}