public class StringCalculator {

    String[] numbers;

    String regexExpresion = ",|\n";

    public int add(String givenText){

        if (givenText == ""){
            return 0;
        }if(givenText.startsWith("//")){
            char deli = givenText.charAt(2);
            String regex=String.valueOf(deli);

            int total = 0;
            String[]  fragments = givenText.split("\n");

            numbers = fragments[1].split(regex);
            for (String number : numbers ) {
                total += Integer.parseInt(number);
            }
            return total;
            //pareAndAddNumbersByRegex(givenText, delimiter);

        }
        if (givenText.length() == 1){
            return parseStringToInteger(givenText);
        }else{
            return parseAndAddNumbers(givenText);
        }
    }

    public int parseStringToInteger(String givenText){
        return Integer.parseInt(givenText);
    }

    public int parseAndAddNumbers(String givenText){
        int total = 0;
        numbers = givenText.split(regexExpresion);
        for (String number : numbers ) {

            int num = Integer.parseInt(number);
            if (num <= 1000) {
                total += Integer.parseInt(number);
            }
        }
        return total;
    }
    //Este metodo seria la refactorizacion pero me falla el test no se porque
    public int pareAndAddNumbersByRegex(String givenText, String regex){

        int total = 0;
        String[]  fragments = givenText.split("\n");

        numbers = fragments[1].split(regex);
        for (String number : numbers ) {
            total += Integer.parseInt(number);
        }
        return total;
    }

}