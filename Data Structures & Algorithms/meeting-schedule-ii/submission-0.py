"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        n = len(intervals)

        if(n == 0 or n == 1):
            return n
        intervals.sort(key = lambda x : x.start)
        listOfInterval = []
        for i in range(len(intervals)):
            listOfInterval.append((intervals[i].start, 1))
            listOfInterval.append((intervals[i].end, -1))
        listOfInterval.sort(key = lambda x : (x[0], x[1]))
        maxRooms = 0
        currRooms = 0
        
        for time, value in listOfInterval:
            currRooms += value
            maxRooms = max(maxRooms, currRooms)
        return maxRooms


            