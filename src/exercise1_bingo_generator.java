import java.util.Random;
import java.util.ArrayList;

public class exercise1_bingo_generator {

    public static void main(String[] args) {

        //Utility
        Random randGen = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

        //Variables
        int[][] bingoLayout  = new int[5][5];
        int[] minValues  = {1,16,31,46,61};
        int rangeRand = 15;
        int position = 0;
        int rows = bingoLayout.length;
        int columns = bingoLayout[0].length;

        //Generating Card
        for(int i = 0; i < columns; i++){
            //Filling Arraylist with Values according to Column-Range (minValues[])
            for(int addedNumber = minValues[i]; addedNumber < rangeRand+minValues[i];addedNumber++){
                randomNumbers.add(addedNumber);
            }
            for(int j = 0; j < rows;j++){
                //Make RandGen pick a Number, than remove that number from Array, than pick number out of that array
                if(!(i==2 && j==2)) {
                    position = randGen.nextInt(randomNumbers.size()-1);
                    bingoLayout[j][i] = randomNumbers.get(position);
                    randomNumbers.remove(position);
                }
            }
            //Clear Array-List for new Column
            randomNumbers.clear();
        }
        OutputCard(bingoLayout,rows,columns);
    }

    public static void OutputCard(int[][] bingoLayout, int rows, int columns){
        System.out.print("\n-------------------------------\n");
        System.out.printf("|  %-3s|  %-3s|  %-3s|  %-3s|  %-3s|", "Bingo".split(""));
        System.out.print("\n-------------------------------\n");

        for(int i = 0;i< rows; i++){
            System.out.printf("|");
            for(int j = 0; j < columns; j++){
                if(!(i==2 && j==2)) {
                    System.out.printf(" %2d  |", bingoLayout[i][j]);
                }
                else{
                    System.out.printf(" %2s  |", "");
                }
            }
            System.out.printf("\n");
        }
        System.out.println("-------------------------------");
    }
}