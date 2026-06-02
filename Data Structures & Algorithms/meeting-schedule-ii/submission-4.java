/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // applying line sweep algorithm
        
        List<int[]> pairs = new ArrayList<>();
        for(Interval interval : intervals){
            pairs.add(new int[]{interval.start , 1});
            pairs.add(new int[] {interval.end , -1});
        }
        Collections.sort(pairs , (p1 , p2) -> {
            if(p1[0] == p2[0] ){
                return Integer.compare(p1[1],p2[1]);
            }
            else{
            return Integer.compare(p1[0], p2[0]);
            }
        });
        int requiredRooms = 0;
        int sum = 0;
        for(int[] pair : pairs){
            sum += pair[1];           
            requiredRooms = Math.max(sum ,requiredRooms);

        }
        // 0 : 1 , 5 : 1 , 10 : -1 , 15 : 1, 20 : -1 , 40 : -1
        // sum = 2 
        return requiredRooms;
    
    }
}
