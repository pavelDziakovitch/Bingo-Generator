import java.util.Random;
public class exercise1_bingo_generator {

    public static void main(String[] args) {

        Random randGen = new Random();

        int[][] bingoLayout  = new int[5][5];
        int[][] ranges  = {{15,1},{15,16},{15,31},{15,46},{15,61}};
        int rows = bingoLayout.length;
        int columns = bingoLayout[0].length;
        boolean isClone;

        System.out.printf("|  %-3s|  %-3s|  %-3s|  %-3s|  %-3s|\n", "Bingo".split(""));
        System.out.print("-------------------------------\n");

        for(int i = 0; i < rows; i++){
            System.out.printf("|");
            for(int j = 0; j < columns;j++){
                if(!(i==2 && j==2)) {
                    do {
                        isClone = false;
                        bingoLayout[i][j] = randGen.nextInt(ranges[i][0]) + ranges[i][1];
                        for (int k = j - 1; k >= 0 && !isClone; k--) {
                            if(bingoLayout[i][j] == bingoLayout[i][k]) {
                                isClone = true;
                            }
                        }
                    } while (isClone);
                    System.out.printf(" %2d  |", bingoLayout[i][j]);
                }
                else{
                    System.out.printf(" %2s  |", "");
                }
            }
            System.out.printf("\n");
        }
    }
}
