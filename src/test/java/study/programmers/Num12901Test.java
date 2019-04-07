package study.programmers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Num12901Test {
    Num12901 clazz = new Num12901();
    @Test
    public void solutionTest(){
        String week = clazz.solution(5,24);
        assertThat(week).isEqualTo("TUE");
    }
}
