import java.lang.Math;
import java.util.*;

class Solution {
    private int parseTimeToInt(String timeString) {
        String[] hrMinSec = timeString.split(":");
        int ret = 0;
        ret += Integer.parseInt(hrMinSec[0]) * 60 * 60;
        ret += Integer.parseInt(hrMinSec[1]) * 60;
        ret += Integer.parseInt(hrMinSec[2]);
        return ret;
    }
    
    private String intTimeToString(int timeInt) {
        int timeResidue = timeInt;
        String hour = String.valueOf(timeResidue / (60 * 60));
        if (hour.length() < 2) hour = "0" + hour;
        
        timeResidue -= (timeResidue / (60 * 60)) * 60 * 60;
        String min = String.valueOf(timeResidue / 60);
        if (min.length() < 2) min = "0" + min;
        
        timeResidue -= (timeResidue / 60) * 60;
        String sec = String.valueOf(timeResidue);
        if (sec.length() < 2) sec = "0" + sec;
        
        return hour + ":" + min + ":" + sec;
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int play_time_int = parseTimeToInt(play_time);
        int adv_time_int = parseTimeToInt(adv_time);
        
        int[] viewMarks = new int[play_time_int + 1];
        
        for (String log : logs) {
            int startTime = parseTimeToInt(log.substring(0, 8));
            int endTime = parseTimeToInt(log.substring(9));
            viewMarks[startTime] += 1;
            viewMarks[endTime] -= 1;
        }
        
        for (int i = 0; i < play_time_int; i++) {
            viewMarks[i + 1] += viewMarks[i];
        }
        
        int maxAtTime = 0;
        long currCumulative = 0;
        for (int i = 0; i < adv_time_int; i++)
            currCumulative += viewMarks[i];
        
        long maxCumulative = currCumulative;
        for (int i = adv_time_int; i < play_time_int; i++) {
            currCumulative += viewMarks[i] - viewMarks[i - adv_time_int];
            if (currCumulative > maxCumulative) {
                maxCumulative = currCumulative;
                maxAtTime = i - adv_time_int + 1;
            }
        }
        
        return intTimeToString(maxAtTime);
    }
}
