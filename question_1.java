public class question_1{
    // public static void main (String[] args { //Syntax Error because missing ) after args 
    public static void main (String[] args){ //Code Improvements / Corrections 
        int baris = 6;
        // int nilai coef = 1; //Syntax Error because missing _ between nilai and coef
        int nilai_coef = 1; //Code Improvements / Corrections
        for(int a = 0; a < baris ; a++){
            // for(int space = 1; space < baris - a; +space){ //Syntax Error because wrong and missing ++
            for(int space = 1; space < baris - a; ++space){  //Code Improvements / Correction
                System.out.print("  "); //Code Improvements / Correction add more space to make the code more neat
            }
            for(int x = 0; x <= a; x++){
                if(x == 0 || a == 0)
                   // nilai_coef = 1 //Syntax Error because missing ;
                    nilai_coef = 1; //Code Improvements / Corrections;
                else
                    nilai_coef = nilai_coef * (a - x + 1) / x; //Code Improvements / Corrections
                System.out.printf("%4d", nilai_coef);
            }
            System.out.println();
        }
    }
}
