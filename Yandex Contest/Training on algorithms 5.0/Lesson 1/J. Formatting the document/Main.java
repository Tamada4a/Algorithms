import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // The corresponding values will be stored in these variables
        int w = Integer.MAX_VALUE, h = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

        // It stores the states that we operate on during the work
        DataStorage dataStorage = new DataStorage();

        // A list of all the surrounded images with their characteristics
        ArrayList<SurroundedData> surroundedCoordinates = new ArrayList<>();

        // A string containing the coordinates of all images
        String coordinates = "";

        // A string containing the entire input file
        String inputLines = "";

        // Reading data
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                if (w == Integer.MAX_VALUE) {
                    w = scanner.nextInt();
                    h = scanner.nextInt();
                    c = scanner.nextInt();
                } else {
                    String line = scanner.nextLine();
                    if (line.length() == 0)
                        // A new paragraph is indicated by this set of characters
                        inputLines = inputLines.concat("\\T\\T");
                    else
                        inputLines = inputLines.concat(String.format("%s ", line));
                }
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> splitLine = splitLine(inputLines);
        for (String data : splitLine) {
            // New paragraph
            if (data.length() == 0) {
                dataStorage.curWidth = 0;
                dataStorage.totalHeight += dataStorage.curHeight;
                dataStorage.curHeight = h;
                dataStorage.lastElem = "";
                dataStorage.prevElem = "";
            } else {
                // Processing and writing logic
                int elemWidth;
                if (data.contains("layout=")) {
                    String imageType = getImageType(data);
                    elemWidth = getImageParam(data, "width");
                    int elemHeight = getImageParam(data, "height");
                    if (!imageType.equals("floating")) {
                        // Moving the element taking into account the positions of the surrounded images
                        checkRowFragments(w, c, h, elemWidth, surroundedCoordinates, dataStorage, imageType);

                        // Move the cursor to the end of the element
                        fixCurWidth(dataStorage, elemWidth, elemHeight, w, c, h, imageType);

                        // If the element runs over the surrounded image, we fix it
                        fixOverlaps(surroundedCoordinates, dataStorage, elemWidth, elemHeight, w, c, h, imageType);

                        // Sorting the surrounded images by the left "x"
                        if (imageType.equals("surrounded")) {
                            surroundedCoordinates.add(new SurroundedData(dataStorage.curWidth - elemWidth, elemHeight, elemWidth, dataStorage.totalHeight));
                            surroundedCoordinates.sort(Comparator.comparingInt(o -> o.leftBorder));
                        }

                        coordinates = addCoordinates(coordinates, String.format("%s %s", dataStorage.curWidth - elemWidth, dataStorage.totalHeight));
                        dataStorage.prevElem = "";
                    } else {
                        int dx = getImageParam(data, "dx");
                        int dy = getImageParam(data, "dy");
                        if (dataStorage.lastElem.equals("image floating")) {
                            // Processing going beyond the boundaries of the image
                            if (dataStorage.curWidthFloating + dx < 0) {
                                dx = -dataStorage.curWidthFloating;
                            } else if (dataStorage.curWidthFloating + dx + elemWidth > w) {
                                dx = w - dataStorage.curWidthFloating - elemWidth;
                            }

                            coordinates = addCoordinates(coordinates, String.format("%s %s", dataStorage.curWidthFloating + dx, dataStorage.curHeightFloating + dy));
                        } else {
                            // Processing going beyond the boundaries of the image
                            if (dataStorage.curWidth + dx < 0) {
                                dx = -dataStorage.curWidth;
                            } else if (dataStorage.curWidth + dx + elemWidth > w) {
                                dx = w - dataStorage.curWidth - elemWidth;
                            }

                            coordinates = addCoordinates(coordinates, String.format("%s %s", dataStorage.curWidth + dx, dataStorage.totalHeight + dy));
                        }

                        // Changing the coordinates that we will focus on when inserting floating images
                        if (dataStorage.lastElem.equals("image floating")) {
                            dataStorage.curHeightFloating += dy;
                            dataStorage.curWidthFloating += dx + elemWidth;
                        } else {
                            dataStorage.curHeightFloating = dataStorage.totalHeight + dy;
                            dataStorage.curWidthFloating = dataStorage.curWidth + dx + elemWidth;
                        }

                        if (!dataStorage.lastElem.equals("image floating"))
                            dataStorage.prevElem = dataStorage.lastElem;
                    }
                    dataStorage.lastElem = String.format("image %s", imageType);
                } else {
                    elemWidth = c * data.length();
                    // Moving the element taking into account the positions of the surrounded images
                    checkRowFragments(w, c, h, elemWidth, surroundedCoordinates, dataStorage, "");

                    // Move the cursor to the end of the element
                    fixCurWidth(dataStorage, elemWidth, -1, w, c, h, "");

                    // If the element runs over the surrounded image, we fix it
                    fixOverlaps(surroundedCoordinates, dataStorage, elemWidth, -1, w, c, h, "");

                    dataStorage.prevElem = "";
                    dataStorage.lastElem = "word";
                }
            }
        }

        System.out.print(coordinates);
    }


    // Converting the input file into an array of strings
    private static ArrayList<String> splitLine(String line) {
        ArrayList<String> listOfElems = new ArrayList<>();

        // We process it as long as there is one of the delimiter characters in the string
        while (line.contains(")") || line.contains(" ") || line.contains("\\T\\T")) {
            int start1 = line.indexOf(" ");
            int start2 = line.indexOf("(");
            int start3 = line.indexOf("\\T\\T");

            if (start1 == -1)
                start1 = Integer.MAX_VALUE;
            if (start2 == -1)
                start2 = Integer.MAX_VALUE;
            if (start3 == -1)
                start3 = Integer.MAX_VALUE;

            if (start1 < start2 && start1 < start3) {
                String subString = line.substring(0, start1);
                if (!subString.isEmpty())
                    listOfElems.add(subString);
                line = line.substring(start1 + 1);
            } else if (start2 < start1 && start2 < start3) {
                int end = line.indexOf(")", start2) + 1;
                listOfElems.add(line.substring(start2, end));
                line = line.substring(end);
            } else if (start3 < start1 && start3 < start2) {
                listOfElems.add("");
                line = line.substring(4);
            }
        }

        // Add the last element, if there is one
        if (!line.isEmpty())
            listOfElems.add(line);
        return listOfElems;
    }


    // Correct display of the added coordinates
    private static String addCoordinates(String coords, String newCoords) {
        if (coords.isEmpty())
            return newCoords;

        return String.format("%s\n%s", coords, newCoords);
    }


    // Getting the type of image
    private static String getImageType(String imageData) {
        if (imageData.contains("embedded"))
            return "embedded";

        if (imageData.contains("surrounded"))
            return "surrounded";

        return "floating";
    }


    // We get the necessary image parameter
    private static int getImageParam(String imageData, String param) {
        int start = imageData.indexOf(param) + 1;
        int end1 = imageData.indexOf(" ", start);
        int end2 = imageData.indexOf(")", start);
        if (end1 < end2 && end1 != -1)
            return Integer.parseInt(imageData.substring(start + param.length(), end1));

        return Integer.parseInt(imageData.substring(start + param.length(), end2));
    }


    // Moving the element taking into account the positions of the surrounded images
    private static void checkRowFragments(int w, int c, int h, int elemWidth, ArrayList<SurroundedData> surroundedCoordinates,
                                          DataStorage dataStorage, String imageType) {
        int prevElemWidth = elemWidth;
        for (int i = 0; i < surroundedCoordinates.size(); ++i) {
            // If necessary, add a space before the element
            if (isAddSpaceBefore(dataStorage, imageType))
                elemWidth += c;

            int imageLeftBorder = surroundedCoordinates.get(i).leftBorder;
            if (isCorrectHeight(dataStorage, surroundedCoordinates.get(i)) && dataStorage.curWidth + elemWidth > imageLeftBorder && dataStorage.curWidth <= imageLeftBorder + surroundedCoordinates.get(i).width) {

                dataStorage.curWidth = imageLeftBorder + surroundedCoordinates.get(i).width;

                // Adjusting the width of the element without taking into account the space
                if (isAddSpaceBefore(dataStorage, imageType))
                    elemWidth -= c;

                dataStorage.lastElem = "image surrounded";
                dataStorage.prevElem = "";

                // Switching to a new paragraph. If it happened, we go through all the surrounded images again
                if (dataStorage.curWidth + elemWidth > w) {
                    dataStorage.curWidth = 0;
                    dataStorage.totalHeight += dataStorage.curHeight;
                    dataStorage.curHeight = h;
                    dataStorage.lastElem = "";
                    dataStorage.prevElem = "";
                    i = -1;
                }
            }
            elemWidth = prevElemWidth;
        }

    }


    // Checking whether our element is below or on a level with the surrounded image
    private static boolean isCorrectHeight(DataStorage dataStorage, SurroundedData surroundedData) {
        return dataStorage.totalHeight < surroundedData.height + surroundedData.heightCord || dataStorage.totalHeight == surroundedData.heightCord;
    }


    // Is it necessary to add a space before the element
    private static boolean isAddSpaceBefore(DataStorage dataStorage, String imageType) {
        return (dataStorage.lastElem.equals("word") || dataStorage.lastElem.equals("image embedded") || dataStorage.lastElem.equals("image floating") && dataStorage.prevElem.equals("word")) && (imageType.equals("embedded") || imageType.isEmpty());
    }


    // Move the cursor to the end of the element
    private static void fixCurWidth(DataStorage dataStorage, int elemWidth, int elemHeight, int w, int c, int h, String imageType) {
        if (isAddSpaceBefore(dataStorage, imageType))
            elemWidth += c;

        if (dataStorage.curWidth + elemWidth > w) {
            if (isAddSpaceBefore(dataStorage, imageType))
                elemWidth -= c;

            dataStorage.curWidth = elemWidth;

            dataStorage.totalHeight += dataStorage.curHeight;
            dataStorage.curHeight = h;
            dataStorage.lastElem = "";
            dataStorage.prevElem = "";
        } else
            dataStorage.curWidth += elemWidth;

        if (elemHeight > dataStorage.curHeight && imageType.equals("embedded"))
            dataStorage.curHeight = elemHeight;
    }


    // If the element runs over the surrounded image, we fix it
    private static void fixOverlaps(ArrayList<SurroundedData> surroundedCoordinates, DataStorage dataStorage, int elemWidth,
                                    int elemHeight, int w, int c, int h, String imageType) {
        boolean isElemOverlapsBlock = false;
        for (int i = 0; i < surroundedCoordinates.size(); ++i) {
            if (isOverlapping(dataStorage, elemWidth, surroundedCoordinates.get(i))) {
                dataStorage.curWidth = surroundedCoordinates.get(i).leftBorder + surroundedCoordinates.get(i).width;
                fixCurWidth(dataStorage, elemWidth, elemHeight, w, c, h, imageType);
                isElemOverlapsBlock = true;
            }
            if (i == surroundedCoordinates.size() - 1 && isElemOverlapsBlock) {
                isElemOverlapsBlock = false;
                i = -1;
            }
        }
    }


    // Checking whether the element runs over the surrounded image
    private static boolean isOverlapping(DataStorage dataStorage, int elemWidth, SurroundedData surroundedData) {

        if (!isCorrectHeight(dataStorage, surroundedData))
            return false;

        int elemLeftBorder = dataStorage.curWidth - elemWidth;
        int blockRightBorder = surroundedData.leftBorder + surroundedData.width;

        if (elemLeftBorder <= surroundedData.leftBorder && blockRightBorder <= dataStorage.curWidth)
            return true;

        if (dataStorage.curWidth > surroundedData.leftBorder && dataStorage.curWidth <= blockRightBorder)
            return true;

        return elemLeftBorder >= surroundedData.leftBorder && elemLeftBorder < blockRightBorder;
    }


    // An object for storing the necessary states
    private static class DataStorage {
        public int curWidth;

        public String lastElem;

        public String prevElem;

        public int totalHeight; // верхняя граница

        public int curHeight; // нижняя граница

        public int curWidthFloating;

        public int curHeightFloating;
    }


    // An object for storing the necessary data about the surrounded image
    private static class SurroundedData {
        int leftBorder;

        int height;

        int width;

        int heightCord;


        public SurroundedData(int leftBorder, int height, int width, int heightCord) {
            this.leftBorder = leftBorder;
            this.height = height;
            this.width = width;
            this.heightCord = heightCord;
        }
    }
}