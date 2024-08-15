import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MorseCodeDecoder {

    /**
     * Given a string in Morse Code, returns the English translation.
     * Accept dots, dashes and spaces, returns human-readable message.
     */
    public static String decodeMorse(String morseCode) {
        if (morseCode.isEmpty())
            return "";

        // This variable will contain decoded string
        StringBuilder stringBuilder = new StringBuilder();

        // Split input Morse Code by triple spaces - split words
        String[] splitMorseCode = morseCode.strip().split("   ");

        // For each word
        for (String code : splitMorseCode) {
            // Split word by space - get array of symbols
            String[] splitCode = code.split(" ");

            // Decode each symbol
            for (String sym : splitCode) {
                stringBuilder.append(MorseCode.get(sym));
            }
            // Appending space between words
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().strip();
    }


    /**
     * Given a string of bits, which may or may not begin or end with '0's,
     * and which may have some variation in the length of the time unit used,
     * returns the Morse Code translation of this message.
     * <p>
     * Accepts 0s and 1s, return dots, dashes and spaces
     */
    public static String decodeBitsAdvanced(String bits) {
        // This variable will contain current accumulated sequence of bits
        StringBuilder curBitsSeq = new StringBuilder();

        // This variable will contain bits without leading and trailing zeros
        StringBuilder clearSeq = new StringBuilder();

        // This variable will contain have we meet ones or not
        boolean isOnesMeet = false;

        // In this loop we'll get sequence without leading and trailing zeros
        for (int i = 0; i < bits.length(); ++i) {
            char curChar = bits.charAt(i);
            // If we meet different symbol
            if (!curBitsSeq.isEmpty() && curChar != curBitsSeq.charAt(curBitsSeq.length() - 1)) {

                // If we meet ones
                if (bits.charAt(i - 1) == '1') {
                    isOnesMeet = true;
                }

                // Update sequence
                if (isOnesMeet)
                    clearSeq.append(curBitsSeq);

                // Reset current bits sequence
                curBitsSeq.setLength(0);
            }
            curBitsSeq.append(curChar);
        }

        // Add last subsequence to sequence if its contains ones
        if (!curBitsSeq.isEmpty() && curBitsSeq.charAt(curBitsSeq.length() - 1) == '1') {
            clearSeq.append(curBitsSeq);
        }

        // Init kMeans
        KMeans kMeans = new KMeans(clearSeq.toString(), 3);

        // Start algorithm
        kMeans.converge();

        // Calculate thresh range
        float thresh13 = (kMeans.getTimeUnit(0) + kMeans.getTimeUnit(1)) / 2;
        float thresh37 = (kMeans.getTimeUnit(1) + kMeans.getTimeUnit(2)) / 2;

        // Update thresh range
        if (clearSeq.length() > 5) {
            thresh13 *= 1.2;
            thresh37 *= 1.1;
        }

        // Reset current bits sequence for next loop
        curBitsSeq.setLength(0);

        // This variable will contain Morse Code (decoded input bits sequence)
        StringBuilder morseCode = new StringBuilder();

        // Start loop from end of leading zeros sequence (otherwise - start from 0)
        // The loop is running until i smaller than start of the ending zeros sequence (otherwise - until bits.length())
        for (int i = 0; i < clearSeq.length(); ++i) {
            char curChar = clearSeq.charAt(i);
            // If we meet different symbol
            if (!curBitsSeq.isEmpty() && curChar != curBitsSeq.charAt(curBitsSeq.length() - 1)) {
                // Update Morse Code
                morseCode.append(getCorrectSym(curBitsSeq, thresh13, thresh37));
                curBitsSeq.setLength(0);
            }
            curBitsSeq.append(curChar);
        }

        if (!curBitsSeq.isEmpty()) {
            morseCode.append(getCorrectSym(curBitsSeq, thresh13, thresh37));
        }

        return morseCode.toString().strip();
    }


    /**
     * Decode bits sequence as dash or dot
     */
    private static String getCorrectSym(StringBuilder curBitsSeq, float thresh13, float thresh37) {
        if (curBitsSeq.length() == 0)
            return "";


        if (curBitsSeq.charAt(curBitsSeq.length() - 1) == '1') {
            if (curBitsSeq.length() <= thresh13)
                return ".";
            return "-";
        }

        if ((curBitsSeq.length() >= thresh13) && (curBitsSeq.length() < thresh37))
            return " ";

        if (curBitsSeq.length() >= thresh37)
            return "   ";

        return "";
    }


    // Source: https://github.com/MolfarUA/CodeWars_Solutions/blob/87a130a952053614a2a40814885f81c37a7ea055/2%20kyu/Decode%20the%20Morse%20code%2C%20for%20real/solution.java
    private static class Cluster implements Comparable<Cluster> {
        private float location;
        private final ArrayList<Integer> currentPoints = new ArrayList<>();
        private ArrayList<Integer> previousPoints = new ArrayList<>();


        // Constructors
        private Cluster(float loc) {
            location = loc;
        }


        private Cluster() {
            location = -1;
        }


        // Methods for claiming currentPoints and calculating centroid
        private void addPoint(int i) {
            currentPoints.add(i);
        }


        private boolean didChange() {
            if (previousPoints.size() != currentPoints.size()) return true;
            else return !currentPoints.equals(previousPoints);
        }


        private void clearPoints() {
            previousPoints = new ArrayList<>(currentPoints);
            currentPoints.clear();
        }


        // After new points have been assigned to this cluster, this method
        // calculates the new centroid of the cluster and moves the cluster
        // to that location
        private void update() {
            float sum = 0;
            for (Integer p : currentPoints) {
                sum += p;
            }
            float centroid = sum / currentPoints.size();
            setLocation(centroid);
        }


        // Getters and Setters
        private float getLocation() {
            return location;
        }


        private float getDistance(int point) {
            return Math.abs(location - point);
        }


        private void setLocation(float loc) {
            location = loc;
        }


        @Override
        public int compareTo(Cluster t) {
            return Float.compare(this.getLocation(), t.getLocation());
        }
    }


    // Source: https://github.com/MolfarUA/CodeWars_Solutions/blob/87a130a952053614a2a40814885f81c37a7ea055/2%20kyu/Decode%20the%20Morse%20code%2C%20for%20real/solution.java
    private static class KMeans {
        // KMeans attributes
        private boolean converged = false;
        private final Cluster[] clusters;
        private final float[] timeUnits = {0, 0, 0};
        private final HashMap<Integer, Integer> dist = new HashMap<>();
        private final ArrayList<Integer> keys;


        public KMeans(String stream, int numClusters) {
            this.clusters = new Cluster[numClusters];
            stream = stream.replaceAll("^[0]+", ""); // remove leading 0s
            stream = stream.replaceAll("[0]+$", ""); // remove trailing 0s

            // For generating frequency dist
            String[] bitCollection;

            // The following if/else block populates this.bitCollection
            if (stream.length() == 0) {
                bitCollection = new String[1];
                bitCollection[0] = "";
            } else {
                String[] ones = stream.split("0+");
                String[] zeros = stream.split("1+");

                if (zeros.length == 0) {
                    bitCollection = new String[1];
                    bitCollection[0] = ones[0];
                } else {
                    bitCollection = new String[ones.length + zeros.length - 1];
                    for (int i = 0; i < ones.length - 1; i++) {
                        bitCollection[2 * i] = ones[i];
                        bitCollection[2 * i + 1] = zeros[i + 1];
                    }
                    bitCollection[bitCollection.length - 1] = ones[ones.length - 1];
                }
            }

            // The following for loop populates the this.dist HashMap
            for (String s : bitCollection) {
                int l = s.length();
                if (!dist.containsKey(l)) {
                    dist.put(l, 1);
                } else dist.put(l, dist.get(l) + 1);
            }
            this.keys = new ArrayList<>(dist.keySet());

            if (keys.size() == 1 || keys.size() == 2) {
                timeUnits[0] = keys.get(0);
                timeUnits[1] = keys.get(0) * 3;
                timeUnits[2] = keys.get(0) * 7;
                converged = true;
            } else {
                Collections.sort(keys);
                initializeClusters();
            }
        }


        // Populates this.clusters with this.numClusters Cluster objects,
        // whose initial locations are from this.keys (the minimum, the
        // maximum, and the middle between the two)
        private void initializeClusters() {
            clusters[0] = new Cluster(keys.get(0));
            clusters[2] = new Cluster(keys.get(keys.size() - 1));
            clusters[1] = new Cluster((float) (keys.get(keys.size() - 1) + keys.get(0)) / 2 + 1);
        }


        // Assigns cluster-labels to each length-point from the fuzzy input,
        // which is subsequently used by the clusters to re-calculate their
        // centroids and move accordingly
        public void assignToClosestCluster() {
            clear();
            for (Integer i : keys) {
                Cluster bestCluster = new Cluster();
                float closest = Float.MAX_VALUE;
                for (Cluster c : clusters) {
                    float d = c.getDistance(i);
                    if (d < closest) {
                        closest = d;
                        bestCluster = c;
                    }
                }
                for (int j = 0; j < dist.get(i); j++) {
                    bestCluster.addPoint(i);
                }
            }
        }


        // Populates this.timeUnits[] with the first, second, and third cluster
        // means, representing the average length of 1 time unit,
        // 3 time units, and 7 time units respectively
        public void calculateTimeUnits() {
            Cluster[] sortedClusters = clusters.clone();
            Arrays.sort(sortedClusters);
            timeUnits[0] = sortedClusters[0].getLocation();
            timeUnits[1] = sortedClusters[1].getLocation();
            timeUnits[2] = sortedClusters[2].getLocation();
        }


        public void clear() {
            for (Cluster c : clusters) c.clearPoints();
        }


        // Assigns the closest Cluster to each point, calculates the centroid
        // for those Clusters based off of those points, moves the Clusters
        // to their respective centroids, and repeats until assignment on the next
        // iteration is the same
        public void converge() {
            if (!converged) {
                assignToClosestCluster();
                while (!converged) {
                    update();
                    assignToClosestCluster();
                    if (!didChange()) converged = true;
                }
                calculateTimeUnits();
            }
        }


        public boolean didChange() {
            for (Cluster c : clusters) if (c.didChange()) return true;
            return false;
        }


        public void update() {
            for (Cluster c : clusters) c.update();
        }


        // Getters and Setters
        public float getTimeUnit(int index) {
            return this.timeUnits[index];
        }
    }
}