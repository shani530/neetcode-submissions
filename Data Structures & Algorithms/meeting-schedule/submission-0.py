"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        intervals.sort( key = lambda x : x.start)
        meetList = {}
        n = len(intervals)
        for interval in intervals:
            startInt = interval.start
            endInt = interval.end
            meetList[startInt] = meetList.get(startInt , 0) + 1
            meetList[endInt] = meetList.get(endInt, 0) - 1
        
        sum = 0
        for time in sorted(meetList):
            sum += meetList.get(time)
            if(sum > 1):
                return False
        return True


        

