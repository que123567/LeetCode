package easy;

/**
 * 36.Valid Sudoku
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: true
 * Example 2:
 * <p>
 * Input: board =
 * [['8','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *  
 * <p>
 * Constraints:
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 * <p>
 */
public class LeetCode36 {
    public static boolean isValidSudoku(char[][] board) {
        int baseNum = '0';

        int checkRow;
        int checkColumn;
        //9个小方格
        int[][] checkSquare = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkSquare[i][j] = 1 << 10;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            checkRow = 1 << 10;
            checkColumn = 1 << 10;
            for (int j = 0; j < board.length; j++) {
                //check row and square
                if (board[i][j] != '.') {
                    int thisValue = 1 << (board[i][j] - baseNum);

                    if ((thisValue & checkRow) != 0) {
                        return false;
                    }

                    checkRow |= thisValue;

                    int thisValue2 = 1 << (board[i][j] - baseNum);
                    if ((thisValue2 & checkSquare[i / 3][j / 3]) != 0) {
                        return false;
                    }
                    checkSquare[i / 3][j / 3] |= thisValue2;
                }
                //check column
                if (board[j][i] != '.') {
                    int thisValue3 = 1 << (board[j][i] - baseNum);
                    if ((thisValue3 & checkColumn) != 0) {
                        return false;
                    }
                    checkColumn |= thisValue3;
                }

            }
        }

        return true;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };

        char[][] board2 = new char[][]
                {{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                        {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                        {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                        {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        boolean test1 = isValidSudoku(board);
        boolean test2 = isValidSudoku(board2);
        System.out.println(test1);
        System.out.println(test2);
    }
}

