# SWExpertAcademy_D4_Java_8567

## SW Expert Academy D4 8567. 약수의 개수가 많은 수

### 1. 문제설명

출처: https://swexpertacademy.com/main/code/problem/problemList.do

input으로 숫자 `N`이 들어온다. `1`이상 `N`이하의 자연수 중에서, 약수이 개수가 가장 많은 수를 구하여 출력하는 문제.

[입력]
> 첫 번째 줄에 테스트 케이스의 수 `T`가 주어진다.
> 각 테스트 케이스의 첫 번째 줄에는 하나의 정수 `N(1 ≤ N ≤ 10^5)`이 주어진다.

[출력]
> 각 테스트 케이스마다 `#x`(`x`는 테스트케이스 번호를 의미하며 `1`부터 시작한다)를 출력하고,
> 각 테스트 케이스 마다 `1`이상 `N`이하의 자연수 중에서, 약수의 개수가 가장 많은 수를 출력한다.
> 그런 수가 여럿 있다면 그 중에서 가장 큰 수를 출력해야 한다.

* 100000개의 테스트케이스를 합쳐서 *Java기준 2초*

### 2. 풀이

테스트케이스의 크기가 커스 `N`의 최대 크기 `100000`개에 대하여 값을 구한다음 들어오는 `N`에 대하여 배열에서 값만 던져주는 방법을 사용하기로 하였다. 하지만 `%`연산자를 이용하여 약수의 개수를 찾는 방법을 이용하였는데 `100000`개의 숫자의 약수의 개수를 구하는 것에 2초이상이 소요되었다...

더 약수의 개수를 빠르게 구하는 방법을 찾다 `+`를 이용하여 약수를 카운트하는 방법을 찾게되었다. 시간이 재어보지는 않았지만 `5`배이상 빠른것 같았다.

```java
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
```
