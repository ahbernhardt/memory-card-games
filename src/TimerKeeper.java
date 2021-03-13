import java.util.Date;

public class TimerKeeper {
    long startTime;
    long endTime;
    Date date = new Date();

    void beginTiming() {
        startTime = date.getTime();
    }

    void endTiming() {
        endTime = date.getTime();
    }

    long getTiming() {
        return endTime - startTime;
    }

}
