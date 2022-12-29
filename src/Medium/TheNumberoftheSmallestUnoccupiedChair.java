class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int len = times.length;
        int next_seat = 0;
        PriorityQueue<Integer> avai_seats = new PriorityQueue<Integer>();
        int[] friend_seat = new int[len];
        int[][] arrivals = new int[len][2]; // [arrival_time, friend_num]
        int[][] leavings = new int[len][2]; // [leaving_time, friend_num]

        for(int i = 0; i < len; i++) {
            arrivals[i] = new int[]{times[i][0], i};
            leavings[i] = new int[]{times[i][1], i};
        }
        Arrays.sort(arrivals, (x, y) -> x[0] - y[0]);
        Arrays.sort(leavings, (x, y) -> x[0] - y[0]);

        int a = 0;
        int l = 0;
        while(l < len) {
            if(arrivals[a][0] < leavings[l][0]) {
                next_seat = handleArrival(next_seat, avai_seats, friend_seat, arrivals[a][1]);
                if (arrivals[a][1] == targetFriend){
                    return friend_seat[targetFriend];
                }
                a++;
            } else {
                avai_seats.add(friend_seat[leavings[l++][1]]);
            }
        }
        return -1;
    }

    private int handleArrival(int next_seat, PriorityQueue<Integer> avai_seats, int[] friend_seat, int friend) {
        if(avai_seats.isEmpty()) {
            friend_seat[friend] = next_seat;
            return next_seat + 1;
        } else {
            friend_seat[friend] = avai_seats.poll();
            return next_seat;
        }
    }
}