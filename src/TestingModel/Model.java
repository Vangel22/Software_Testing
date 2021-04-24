package TestingModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

//Importi za avtomatizacija
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

class Model {

    private String message;

    public Model(String message) {
        this.message = message;
    }

    public String printMessage(){
        System.out.println(message);
        return message;
    }

    public String salutationMessage(){
        message = "Hi "+ message;
        System.out.println(message);
        return message;
    }
}

class Testing {
    String message = "Hello World";
    Model m = new Model(message);

    @Test //Passed
    public void testPrintMessage(){
        assertEquals(message,m.printMessage()); //message mi e originalot, dodeka m mi e String od druga klasa
    }

    @Test //Failed
    public void testPrintMessage2(){
        message = "New Word";
        assertEquals(message,m.printMessage()); //ovoj test pagja bidejki promenata na message e lokalna
    }
}

class Model2{
    String message = "Vangel";
    Model m = new Model(message);

    @Test //Failed
    public void testSalutationMessage(){
        System.out.println("Inside salutation message");
        message = "Hi!" + "Vangel";
        assertEquals(message,m.salutationMessage());
    }

    //aud 2
    @Test
    public void testPrintMessage1(){
        assertTimeout(Duration.ofMillis(50), () -> {
            System.out.println("Inside testPrintMessage");
            m.printMessage();
        });
    }

    //@ParameterizedTest -> ovozmozuva poveke pati da izvrsime nekoj test so razlicni parametri

}


@RunWith(Suite.class)
@SuiteClasses({Model.class, Model2.class})
class JUnitTestSuite{

}

class StandardTests{
    @BeforeAll
    static void initAll(){
        System.out.println("Before all");
    }

    @BeforeEach
    void init(){
        System.out.println("Before each");
    }

    @Test
    void succeedingTest(){
        assertEquals(2,1+1);
    }

    @Test
    void failingTest(){
        assertNotEquals(2,1);
        fail("A failing test"); //ako sakame testot da pomine ne treba da imame fail()
    }

    @Test
    @Disabled("for demonstation purposes")
    void skippedTest(){
        //not executed
    }

    @AfterEach
    void tearDown(){
        System.out.println("After each");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("After all");
    }
}

class PrimeNumberChecker {

    public Boolean validate(final Integer primeNumber) {
        for (int i = 2; i < Math.sqrt(primeNumber*1.0); i++) {
            if (primeNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class PrimeNumberCheckerTest {
    private PrimeNumberChecker primeNumberChecker;

    @BeforeEach
    public void setup() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                { 2, true },
                { 6, false },
                { 19, true },
                { 22, false },
                { 23, true }
        });
    }

    @ParameterizedTest
    @MethodSource("primeNumbers")
    public void testPrimeNumberChecker(int inputNumber, boolean expectedResult){
        System.out.println("Parameterized Number is: "+inputNumber);
        assertEquals(expectedResult,primeNumberChecker.validate(inputNumber));
    }

    //So assertThrows mozeme da testirame isklucoci
    public int divide(int a, int b){
        if(b == 0) {
            throw new ArithmeticException("Dividing by zero!");
        }
        return a/b;
    }

    @Test
    public void shouldThrowAnException() {
        assertThrows(ArithmeticException.class, () -> divide(4,0));
    }
}
