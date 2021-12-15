import java.util.Random;

public class exercise2_sorting_insertion {

    public static void main(String[] args) {

        int beeingSorted = 0;
        Random randomGen = new Random();

    //Create and Fill Array
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length;i++){
            numbers[i] = randomGen.nextInt(10);
        }
    //
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + "  ");
        }
        System.out.println("");

    //SORT
        for(int position = 0; position < numbers.length;position++ ){
            for(int currentPosition = position; currentPosition >= 1 && numbers[currentPosition] < numbers[currentPosition-1] ;currentPosition--){
                int temp = numbers[currentPosition-1];
                numbers[currentPosition-1] = numbers[currentPosition];
                numbers[currentPosition] = temp;
            }
            
        }
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }
}
