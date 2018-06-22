package letter;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchLetterBrotherLetterTest {

    @Test
    public void sortLetter() {
        StringBuffer sb = new StringBuffer("sdf");
        System.out.println(SearchLetterBrotherLetter.sortLetter(sb).toString());
        System.out.println(SearchLetterBrotherLetter.sortLetter(new StringBuffer().append("a")).toString());
    }
}