public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        this.game = new boolean[1][1];
    }//default constructor

    public SnakeGame(boolean[][] arr, int x, int y) {
        this.game = new boolean[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                this.game[i][j] = arr[i][j];
            }
        }
        this.headPosition = new int[2];
        this.headPosition[0] = x;
        this.headPosition[1] = y;
    }//constructor

    public int[] findTailExhaustive() {
        resetCounters();
        boolean tailFound = false;
        int[] result = new int[3];
        int snakeLen = 0;//increment every time it is true
        for(int i = 0; i < this.game.length; i++) {//for1
            for(int j = 0; j < this.game[i].length; j++) {//for2
                boolean checkCell = game[i][j];
                if(!tailFound)
                    this.exhaustiveChecks++;
                if(checkCell) {//if1
                    snakeLen++;
                    int n = neighbors(i,j);
                    if(n == 1 && !(i == this.headPosition[0] && j == this.headPosition[1])) {//if2
                        result[0] = i;
                        result[1] = j;
                        tailFound = true;
                    }//end if2
                }//end if1
            }//end for2
        }//end for1
        result[2] = snakeLen;
        return result;
    }//end findTailEx

    public int[] findTailRecursive() {
        resetCounters();
        return findTailRecursive(headPosition,headPosition);
    }//end findTailRec

    public int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        int[] result = new int[3];//x,y,snakeLen
        int snakeLen = 0;
        int x = currentPosition[0];
        int y = currentPosition[1];
        int p1 = previousPosition[0];
        int p2 = previousPosition[1];

        boolean isSnake = false;
        if(this.game[x][y]) {
            isSnake = true;
            snakeLen++;
        }
        if(neighbors(x,y) == 1 && !(x == p1 && y == p2)) {
            //recursiveChecks++;
            result[0] = x;
            result[1] = y;
            result[2] = snakeLen;
        }
        else {
            int[] n = neighborsPosition(x,y,p1,p2);
            previousPosition[0] = x;
            previousPosition[1] = y;
            findTailRecursive(n,previousPosition);
        }
        return result;
    }//end findTailRec

    private void resetCounters() {
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;
    }//end resetCounters


    public static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }//exhaustiveChecks getter

    public static int getRecursiveChecks() {
        return recursiveChecks;
    }//recursiveChecks getter

    public int neighbors(int r, int c) {//counts neighbors
        int count = 0;
        int up = r - 1;
        int down = r + 1;
        int left = c - 1;
        int right = c + 1;

        if(up > -1) {
            if(game[up][c])        count++;
        }
        if(left > -1) {
            if(game[r][left])      count++;
        }
        if(right < game[0].length) {
            if(game[r][right])     count++;
        }
        if(down < game.length) {
            if(game[down][c])      count++;
        }
        return count;
    }//end neighbors

    public int[] neighborsPosition(int r, int c, int p1, int p2) {
        int[] position = new int[2];
        int up = r - 1;
        int down = r + 1;
        int left = c - 1;
        int right = c + 1;

        if(up > -1) {
            if(game[up][c] && !(up == p1 && c == p2)) {
                recursiveChecks++;
                position[0] = up;
                position[1] = c;
            }
        }
        if(left > -1) {
            if(game[r][left] && !(r == p1 && left == p2)) {
                recursiveChecks++;
                position[0] = r;
                position[1] = left;
            }
        }
        if(right < game[0].length) {
            if(game[r][right] && !(r == p1 && right == p2)) {
                recursiveChecks++;
                position[0] = r;
                position[1] = right;
            }
        }
        if(down < game.length) {
            if(game[down][c] && !(down == p1 && c == p2)) {
                recursiveChecks++;
                position[0] = down;
                position[1] = c;
            }
        }
        return position;
    }//neighborsPosition

    public void printBoard() {
        for(int r = 0; r < game.length; r++) {
            for(int c = 0; c < game[r].length; c++) {
                if(game[r][c])
                    System.out.print("x" + " ");
                else
                    System.out.print("-" + " ");
            }
            System.out.println();
        }
    }//end printBoard
}//end class
