public class TimeFormatter {
    public static String formatDuration(int seconds) {
        // If we get 0 - return now
        if (seconds == 0)
            return "now";

        // Calculate all time parts
        int y = seconds / 31536000;
        int d = (seconds % 31536000) / 86400;
        int h = ((seconds % 31536000) % 86400) / 3600;
        int m = (((seconds % 31536000) % 86400) % 3600) / 60;
        int s = (((seconds % 31536000) % 86400) % 3600) % 60;

        StringBuilder sbResult = new StringBuilder();

        // Add formatted time parts
        sbResult.append(getCorrectString(y, "year"));
        sbResult.append(getCorrectString(d, "day"));
        sbResult.append(getCorrectString(h, "hour"));
        sbResult.append(getCorrectString(m, "minute"));
        sbResult.append(getCorrectString(s, "second"));

        // Replace last comma with space
        sbResult.setCharAt(sbResult.length() - 2, ' ');

        return replaceLastComma(sbResult.toString().strip());
    }


    // This function helps to get correct time part format
    private static String getCorrectString(int val, String timePart) {
        StringBuilder answer = new StringBuilder("%d %s".formatted(val, timePart));
        if (val == 0)
            return "";

        if (val != 1)
            answer.append("s");

        answer.append(", ");
        return answer.toString();
    }


    // Replace last comma with "and"
    private static String replaceLastComma(String original) {
        int lastIndex = original.lastIndexOf(",");

        // Target substring not found
        if (lastIndex == -1) {
            return original;
        }

        String before = original.substring(0, lastIndex);
        String after = original.substring(lastIndex + ",".length());

        return before + " and" + after;
    }
}
