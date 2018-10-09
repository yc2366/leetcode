package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Definition for an interval.


public class T056_MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		// sort start&end
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		// loop through
		List<Interval> res = new ArrayList<Interval>();
		for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
				// the start pointer goes to next element only when 
				// next start is larger than the last end
			}
		}
		return res;
	}
		
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}

/**
 * [j][][][][i+1][][][][][][][]
 * 
 * [][][][i][][][][][][][][]
 */
