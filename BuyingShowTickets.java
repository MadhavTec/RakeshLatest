package com.techolution;

public class BuyingShowTickets {

	public static void main(String[] args) {
		int n = 4;
		int[] tickets = {5,5,2,3};
		int p = 3;
		System.out.println(waitingTime(tickets, p));
	}

	static long waitingTime(int[] tickets, int p) {
		int ticketNeeded = tickets[p];
		long res = 0L;
		int n = tickets.length;
		long time = 0;
		long offset = 0;
		while (tickets[p] > 0) {
			int min = Integer.MAX_VALUE;
			int cnt = 0, pos = -1;
			for (int i = 0; i < n; i++) {
				if (tickets[i] <= 0)
					continue;
				if (min > tickets[i]) {
					min = tickets[i];
					pos = i;
				}
				cnt++;
			}
			res += min;
			if (pos >= 0) {
				for (int i = 0; i < n; i++) {
					if (pos == p && i <= p) {
						if (tickets[i] <= 0)
							continue;
						offset++;
					}
					tickets[i] = tickets[i] - min;
				}
			}
			if (tickets[p] > 0)
				time = time + cnt * min;
		}
		return time + offset;
	}
}
