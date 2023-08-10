package 주차요금계산;


import java.util.*;

class Solution {

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTime = new HashMap<>();
        Map<String, String> inTime = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String carNumber = split[1];
            String status = split[2];

            int currentTime = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);

            if (status.equals("IN")) {
                inTime.put(carNumber, time);
            } else {
                int inTimeMinutes = Integer.parseInt(inTime.get(carNumber).split(":")[0]) * 60
                        + Integer.parseInt(inTime.get(carNumber).split(":")[1]);
                int parkedTime = currentTime - inTimeMinutes;

                parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + parkedTime);
                inTime.remove(carNumber);
            }
        }

        for (String carNumber : inTime.keySet()) {
            int inTimeMinutes = Integer.parseInt(inTime.get(carNumber).split(":")[0]) * 60
                    + Integer.parseInt(inTime.get(carNumber).split(":")[1]);
            int parkedTime = 1439 - inTimeMinutes;

            parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + parkedTime);
        }

        List<String> carNumbers = new ArrayList<>(parkingTime.keySet());
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            int totalMinutes = parkingTime.get(carNumbers.get(i));
            int fee = fees[1];
            if (totalMinutes > fees[0]) {
                fee += Math.ceil((double) (totalMinutes - fees[0]) / fees[2]) * fees[3];
            }
            answer[i] = fee;
        }

        return answer;
    }
}
public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer = sol.solution(fees, records);

        Arrays.stream(answer).forEach( ans -> System.out.println(ans));

    }
}
