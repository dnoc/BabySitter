public class BabySitter {


    public static void main(String[] args) {

    }

    public int calculateWage(final int startTime, final int bedTime, final int endTime) {

        if (startTime > 11 || startTime < 5) {
            return -1;
        }
        else if (endTime < startTime || endTime > 16) {
            return -1;
        }
        else if (startTime > bedTime || bedTime > endTime) {
            return -1;
        }

        return 0;
    }
}
