package com.akabynga.faang;

public class Search2DMatrix {


    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };
//        int target = 3;

        int[][] matrix = {{1}, {3}};
        int target = 2;

        boolean expected = true;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0 || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int row = -1;
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            row = low + ((high - low) / 2);
            if (target >= matrix[row][0] && target <= matrix[row][matrix[0].length - 1]) {
                break;
            } else if (target < matrix[row][0]) {
                high = row - 1;
            } else if (target > matrix[row][matrix[0].length - 1]) {
                low = row + 1;
            } else {
                return false;
            }
        }

        low = 0;
        high = matrix[row].length - 1;

        while (low <= high && low >= 0 && high < matrix[row].length) {
            int mid = low + ((high - low) / 2);
            if (matrix[row][mid] < target) {
                low = mid + 1;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } else if (matrix[row][mid] == target) {
                return true;
            }
        }

        return false;
    }
}
