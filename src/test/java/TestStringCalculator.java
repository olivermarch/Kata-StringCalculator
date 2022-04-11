import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestStringCalculator {
    StringCalculator stringCalculator = new StringCalculator();

    /* TODO
     * "" -> 0
     * "1" -> 1
     * "1,2" -> 3
     * “1\n2,3” == 6
     * “//;\n1;2” == 3
     *
     */

    @Test
    public void parse_0_when_receive_no_num(){
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void parse_number_when_receive_StringNumber(){
        assertEquals(7, stringCalculator.add("7"));
    }

    @Test
    public void sum_numbers_when_receive_numbers_separated_by_comas(){
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void sum_numbers_when_receive_numbers_separated_by_comas_and_replace_line_breaks_for_comas(){
        assertEquals(7, stringCalculator.add("1\n2,4"));
    }

    @Test
    public void sum_using_expecific_delimiters(){
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void numbers_biger_than_1000_should_be_ignored(){
        assertEquals(2, stringCalculator.add("1001,2"));
    }



}