package Homework4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class Calendar {
    /**
     * @param month1
     * @param day1
     * @param month2
     * @param day2
     * @param year
     * @return the number of days between the two given days in the same year
     *
     * preconditions: day1 and day2 must be in same year
     * 1 <= month1, month2 <= 12
     * 1 <= day1, day2 <= 31
     * month1 <= month2
     * The range for year: 1 ... 10000
     */
    public static int cal(int month1, int day1, int month2, int day2, int year) {
        int numDays;
        if (month2 == month1) //if this is true than numDays value changes
            numDays = day2 - day1;
        else {
            int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int m4 = year % 4;
            int m100 = year % 100;
            int m400 = year % 400;
            //if this is true than daysIn changes
            if ((m4 != 0) || ((m100 == 0) && (m400 != 0))) //prestapna godina
                daysIn[2] = 28;
            else
                //if not than a different value is added to daysIn
                daysIn[2] = 29;
            numDays = day2 + (daysIn[month1] - day1);
            for (int i = month1 + 1; i <= month2 - 1; i++)
                numDays = daysIn[i] + numDays;
        }
        return (numDays);
    }
}

class Testing {
    boolean month1 = false;
    boolean month2 = false;
    //m4!=0 || m100 == 0 && m400
    boolean m4 = false;
    boolean m100 = false;
    boolean m400 = false;

    public void month1_true(){
        this.month1 = true;
    }
    public void month2_true(){
        this.month2 = true;
    }

    public void m4_true() { this.m4 = true; }
    public void m100_true() { this.m100 = true; }
    public void m400_true() { this.m400 = true; }

    public boolean isSatisfactoryFirstCondition() {
        // when T F, F T, F F
        return !(this.month1 == this.month2);// when T T
    }

    public boolean isSatisfactorySecondCondition() {
        return (((this.m4) || (this.m100)) && (this.m400)); // when F F T
    }

    //month2 is major and changes values in RACC here in tests_1 while month1 is TRUE in both cases
    //=====================================================================================================
    @Test
    public void test_isSatisfactory1_0() {
        month1_true();
        month2_true();
        assertFalse(this.isSatisfactoryFirstCondition()); // T == T -> returns FALSE
    }

    @Test
    public void test_isSatisfactory1_1() {
        month1_true();
        assertTrue(this.isSatisfactoryFirstCondition()); // F == T -> returns TRUE
    }
    //=====================================================================================================


    // by picking m400 as a major i have 4 test cases
    //=====================================================================================================
    @Test
    public void test_isSatisfactory2_0() {
        m4_true();
        m100_true();
        m400_true();
        assertTrue(this.isSatisfactorySecondCondition()); // when T T T
    }

    @Test
    public void test_isSatisfactory2_1() {
        m4_true();
        m100_true();
        assertFalse(this.isSatisfactorySecondCondition()); // when T T F
    }

    @Test
    public void test_isSatisfactory2_2() {
        m4_true();
        assertFalse(this.isSatisfactorySecondCondition()); // when T F F
    }

    @Test
    public void test_isSatisfactory2_3() {
        m100_true();
        assertFalse(this.isSatisfactorySecondCondition()); // when F T F
    }
    //=====================================================================================================

}