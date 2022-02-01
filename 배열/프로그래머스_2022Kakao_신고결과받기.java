import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
       List<String> idList = new ArrayList<String>();
		for (String id : id_list) {
			idList.add(id);
		}

		int len = idList.size();

		List<List<Integer>> reportList = new ArrayList<List<Integer>>();
		for (int i = 0; i < len; i++) {
			reportList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i], " ");
			int a = idList.indexOf(st.nextToken());
			int b = idList.indexOf(st.nextToken());

			if (!reportList.get(b).contains(a))
				reportList.get(b).add(a);
		}

		int[] mailing = new int[len];

		for (int i = 0; i < len; i++) {
			if (reportList.get(i).size() >= k) {
				for (int id : reportList.get(i)) {
					mailing[id]++;
				}
			}
		}

		return mailing;
    }
}