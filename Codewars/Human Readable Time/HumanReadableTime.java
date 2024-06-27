public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int h = seconds / 3600;
        int min = (seconds - h * 3600) / 60;
        int sec = seconds - h * 3600 - min * 60;
        return "%02d:%02d:%02d".formatted(h, min, sec);
    }
}
