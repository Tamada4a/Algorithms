import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // The final answer will be stored in this StringBuilder
        StringBuilder result = new StringBuilder();

        // Declaring the root of the prefix tree
        TreeNode root = new TreeNode(' ');

        // Reading data
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayOfWords = line.split(" ");
                // We fill the tree with words from the dictionary
                if (root.children == null) {
                    // Add a dot to the end of the line as a sign of the end
                    // This is done in order to find the shortest word in the dictionary to replace
                    // the current word with
                    for (String word : arrayOfWords)
                        root.insert(String.format("%s.", word));
                }
                // We are looking for a substring of a word in the tree and add it to the resulting
                // string
                else {
                    for (String word : arrayOfWords) {
                        result.append(String.format("%s ", root.shortString(word)));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(result.toString().strip());
    }


    // Implementing the prefix tree class
    // The main idea is from here: https://github.com/Arhiser/java_tutorials/blob/master/src/ru/arhiser/prefix_tree/Main.java
    private static class TreeNode {
        // The symbol is a tree node
        char value;

        // Child nodes of the current node
        ArrayList<TreeNode> children;

        public TreeNode(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value='" + value + '\'' +
                    ", children=" + children +
                    '}';
        }

        // Recursive method of inserting a string into a tree
        public void insert(String data) {
            // The condition for exiting recursion is an empty string
            if (data.length() == 0) {
                return;
            }

            //Initializing an array of child nodes
            if (children == null) {
                children = new ArrayList<>();
            }

            // We get the first character of the string - a new node of the tree
            char c = data.charAt(0);

            // If there is no such node in the tree, we create
            TreeNode child = findNodeByChar(c);
            if (child == null) {
                child = new TreeNode(c);
                children.add(child);
            }

            // We call the insertion method from the node, removing the first character from the
            // string, which is now a node
            child.insert(data.substring(1));
        }

        // Searching for a node by symbol
        private TreeNode findNodeByChar(char c) {
            // If the node has child nodes
            if (children != null) {
                // We run through all child nodes
                // First, we are looking for a point, since we need to find the shortest occurrence
                for (TreeNode node : children) {
                    if (node.value == '.') {
                        return node;
                    }
                }

                // If we haven't found a point, we're looking for a match based on the passed character
                for (TreeNode node : children) {
                    if (node.value == c) {
                        return node;
                    }
                }
            }

            // If the node has no child nodes or has not found a dot/the desired symbol
            return null;
        }

        // Method for shortening a string
        private String shortString(String str) {
            // We start moving from the current node
            TreeNode current = this;

            // A shortened string will be stored here
            StringBuilder substring = new StringBuilder();

            // Running through all the characters of the original string
            for (int i = 0; i < str.length(); i++) {
                // We get the following node
                current = current.findNodeByChar(str.charAt(i));

                // If null, we have not found any suitable words from the dictionary.
                if (current == null)
                    break;
                // If the current node is a dot, then we have found the right word for us, and we can
                // exit the loop
                else if (current.value == '.')
                    return substring.toString();
                // Otherwise, we continue to collect the substring
                else
                    substring.append(str.charAt(i));
            }
            // If we did not find a substring, we return the original one
            return str;
        }
    }
}