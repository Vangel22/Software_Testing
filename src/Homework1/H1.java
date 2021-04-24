package Homework1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class H1 {

    public static Set setDifference(Set set1, Set set2) throws NullPointerException{
//        if(set1 == null || set2 == null){
//            throw new NullPointerException();
//        }
        if (set1.isEmpty() || set2.isEmpty()) {
            throw new NullPointerException();
        } else {
            set1.removeAll(set2);
            return set1;
        }
    }

    //Interface
    @Test
    public void shouldThrowAnException() {
        Set test = null; //ova e mnozestvo so null element, ne pokazuva kon nisto
        test.clear();
        Set test2 = new TreeSet(); //ova e mnozesto so eden element -> prazno mnozestvo

        assertThrows(NullPointerException.class, () -> setDifference(test,test2));
    }

    //Interface
    @Test
    public void testSetDifferenceWithIntegers(){
        Set<Integer> test = new TreeSet<Integer>();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        System.out.println(test);

        Set<Integer> test2 = new TreeSet<Integer>();

        test2.add(1);
        test2.add(3);
        test2.add(10);
        test2.add(5);
        test2.add(11);

        System.out.println(test2);

        System.out.println(setDifference(test,test2));
    }

    //Interface
    @Test
    public void testSetDifferenceWithIntegerAndString(){
        Set<Integer> test = new TreeSet<Integer>();

        test.add(1);
        test.add(2);
        test.add(3);

        System.out.println(test);

        Set<String> test2 = new TreeSet<String>();

        test2.add("Vangel");
        test2.add("Aleksandar");


        System.out.println(test2);

        Set all = new TreeSet();
        all = setDifference(test,test2);
        assertEquals("1,2,3,Vangel,Aleksandar",all);
    }

    //Interface
    @Test
    public void testSetsWithStrings(){
        Set<String> test = new TreeSet<String>();

        test.add("Blagoj");
        test.add("Vangel");
        test.add("Dimitar");

        System.out.println(test);

        Set<String> test2 = new TreeSet<String>();

        test2.add("Dimitar");
        test2.add("Blagoj");
        test2.add("Petar");


        System.out.println(test2);

        Set all = new TreeSet();
        all = setDifference(test,test2);
        assertEquals("[Vangel]",all.toString());
    }

    //Functionality
    @Test
    public void testSetLength(){
        Set<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(2);
        Set<Integer> set2 = new TreeSet<>();
        set1.add(3);
        set1.add(4);
        assertEquals(4,set1.size(),set2.size());
    }

    //Functionality
    @Test
    public void testSetDifferenceOddNumbers(){
        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new TreeSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s2.add(2);
        s2.add(5);

        Set<Integer> result = setDifference(s1,s2);
        assertEquals("[1, 3]",result.toString());
    }

    //Functionality
    @Test
    public void testSetDifferenceEvenNumbers() {
        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new TreeSet<>();
        s1.add(2);
        s1.add(4);
        s1.add(6);
        s2.add(6);
        s2.add(3);

        Set<Integer> result = setDifference(s1, s2);
        assertEquals("[2, 4]", result.toString());
    }

    public int countVowels(Set<String> set){
        int count = 0;
        List<String> strings = new ArrayList<>(set);
        for(String s: strings){
            char[] vowels = s.toCharArray();
            for(int j=0; j<vowels.length; j++) {
                if (vowels[j] == 'a' || vowels[j] == 'e' || vowels[j] == 'i' || vowels[j] == 'o' || vowels[j] == 'u')
                    count++;
            }
        }
        return count;
    }

    //Functionality
    @Test
    public void testVowelsInTheSet(){
        Set<String> test = new TreeSet<String>();

        test.add("Blagoj");
        test.add("Vangel");
        test.add("Dimitar");

        System.out.println(test);

        Set<String> test2 = new TreeSet<String>();

        test2.add("Dimitar");
        test2.add("Blagoj");
        test2.add("Petar");

        Set<String> result = setDifference(test,test2);
        assertEquals(2,countVowels(result)); //broi samoglaski vo Vangel
    }
}
//    public String setOfEvenNumbers(Set<Integer> set1,Set<Integer> set2){
//        int even = 0;
//        for(int s : set1){
//            if(s%2 == 0){
//                even++;
//            }
//        }
//        for(int s : set2){
//            if(s%2 == 0){
//                even++;
//            }
//        }
//        if(set1.size()+set2.size() == even){
//            //System.out.println("All elements in set are even");
//            return "All elements in the set are even";
//        }
//        return "Not all elements in the set are even";
//    }

//    public String setOfOddNumbers(Set<Integer> set1,Set<Integer> set2){
//        int odd = 0;
//        for(int s : set1){
//            if(s%2 > 0){
//                odd++;
//            }
//        }
//        for(int s : set2){
//            if(s%2 > 0){
//                odd++;
//            }
//        }
//        if(set1.size()+set2.size() == odd){
//            //System.out.println("All elements in set are even");
//            return "All elements in the set are odd";
//        }
//        return "Not all elements in the set are odd";
//    }

//    @Test
//    public void testEvenSets(){
//        Set<Integer> set1 = new TreeSet<>();
//        set1.add(2);
//        set1.add(4);
//        Set<Integer> set2 = new TreeSet<>();
//        set2.add(6);
//        set2.add(8);
//        assertEquals("All elements in the set are even",setOfEvenNumbers(set1,set2));
//    }

//    @Test
//    public void testOddSet(){
//        Set<Integer> set1 = new TreeSet<>();
//        set1.add(1);
//        set1.add(3);
//        Set<Integer> set2 = new TreeSet<>();
//        set2.add(5);
//        set2.add(7);
//        assertEquals("All elements in the set are odd",setOfOddNumbers(set1,set2));
//    }


//Interface based characteristics:
//set1 is empty
//set2 is empty
//dvata slucai frlaat NullPointerException

//Functionality based characteristics:
//set1,set2 number of elements
//set1,set2 number of occurences of some element
//set1,set2 last,first occurence
//set1,set2 average length

//set1 is made of even numbers
//set2 is made of odd numbers
//set1,set2 number of vowels

//Primer za da definiram karakteristika:
//q1: niza od parni broevi
//q2: niza od neparni broevi
//q3: niza od prosti broevi