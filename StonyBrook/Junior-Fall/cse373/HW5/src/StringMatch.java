import java.util.ArrayList;

public class StringMatch {
    public static void main(String[] args) {
        String str1 = "watch the movie raising arizona?";
        String str2 = "watch da mets raze arizona?";
        int[][] dpTable = new int[str1.length() + 1][str2.length() + 1];
        int count = stringCompare(str1, str2, dpTable);
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("The edit distance is : " + count);
        System.out.println("This is the following DP Table: ");
        for(int i = 0; i <= str1.length(); i++) {
            for(int j = 0; j <= str2.length(); j++) {
                boxOut("\t" + dpTable[i][j] + "\t");
            }
            System.out.println();
        }

    }
    public static void boxOut(String str) {
        System.out.print(" | "); System.out.print(str); System.out.print(" | ");
    }
    public static void boxIn(int times) {
        for(int i = 0; i < times; i++) {
            System.out.print("   _   ");
        }
    }
    public static int stringCompare(String str1, String str2, int[][] dpTable) {
        int len1 = str1.length(), len2 = str2.length();
        initRow(dpTable,len2);
        initCol(dpTable,len1);
        for (int i = 0; i < len1; i++) {
            char first = str1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char second = str1.charAt(i);
                if (first == second) {
                    dpTable[i + 1][j + 1] = dpTable[i][j];
                } else {
                    int REPLACE = dpTable[i][j] + 1;
                    int INSERT = dpTable[i][j + 1] + 1;
                    int DELETE = dpTable[i + 1][j] + 1;
                    int min = REPLACE;
                    if(REPLACE > INSERT) {
                        min = INSERT;
                    }
                    if(DELETE > min) {
                    } else {
                        min = DELETE;
                    }
                    dpTable[i + 1][j + 1] = min;
                }
            }
        }
        return dpTable[len1][len2];
    }
    public static void initRow(int[][] dpTable, int len2) {
        for(int i = 0; i <= len2; i++) {
            dpTable[0][i] = i;
        }
    }
    public static void initCol(int[][] dpTable, int len1) {
        for(int i = 0; i <= len1; i++) {
            dpTable[i][0] = i;
        }
    }
}
