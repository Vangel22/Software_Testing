package Homework2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Testing {

    public static int patternIndex(String subject, String pattern){
        final int NOTFOUND = -1;
        int iSub = 0, rtnIndex = NOTFOUND;
        boolean isPat = false;
        int subjectLen = subject.length();
        int patternLen = pattern.length();

        while(isPat == false && iSub + patternLen - 1 < subjectLen){
            if(subject.charAt(iSub) == pattern.charAt(0)){
                //Starting at zero
                rtnIndex = iSub;
                isPat = true;
                for(int iPat = 1; iPat < patternLen; iPat++){
                    if(subject.charAt(iSub+iPat) != pattern.charAt(iPat)){
                        rtnIndex = NOTFOUND;
                        isPat = false;
                        break; //out of for loop
                    }
                }
            }
            iSub++;
        }
        return (rtnIndex);
    }
}
class Stutter
{
    // Class variables used in multiple methods.
    private static boolean lastdelimit = true;
    private static String curWord = "", prevWord = "";
    private static char delimits [] =
            {'	', ' ', ',', '.', '!', '-', '+', '=', ';', ':', '?',
                    '&', '{', '}', '\\'}; // First char in list is a tab

    //************************************************
    // main parses the arguments, decides if stdin
    // or a file name, and calls Stut().
    //************************************************
    public static void main (String[] args) throws IOException
    {
        String fileName;
        FileReader myFile;
        BufferedReader inFile = null;

        if (args.length == 0)
        {  // no file, use stdin
            inFile = new BufferedReader (new InputStreamReader(System.in));
        }
        else
        {
            fileName = args [0];
            if (fileName == null)
            {  // no file name, use stdin
                inFile = new BufferedReader (new InputStreamReader (System.in));
            }
            else
            {  // file name, open the file.
                myFile = new FileReader (fileName);
                inFile = new BufferedReader (myFile);
            }
        }

        stut (inFile);
    }

    //************************************************
    // Stut() reads all lines in the input stream, and
    // finds words. Words are defined as being surrounded
    // by delimiters as defined in the delimits[] array.
    // Every time an end of word is found, checkDupes()
    // is called to see if it is the same as the
    // previous word.
    //************************************************
    private static void stut (BufferedReader inFile) throws IOException
    {
        String inLine;
        char c;
        int linecnt = 1;
        while ((inLine = inFile.readLine()) != null)
        {  // For each line

            for (int i=0; i<inLine.length(); i++)
            {  // for each character
                c = inLine.charAt(i);

                if (isDelimit (c))
                {  // Found an end of a word.
                    checkDupes (linecnt);
                }
                else
                {
                    lastdelimit = false;
                    curWord = curWord + c;
                }
            }
            checkDupes (linecnt);
            linecnt++;

        }
    }  // end Stut

    //************************************************
    // checkDupes() checks to see if the globally defined
    // curWord is the same as prevWord and prints a message
    // if they are the same.
    //************************************************
    private static void checkDupes (int line)
    {
        if (lastdelimit)
            return; // already checked, keep skipping

        lastdelimit = true;
        if (curWord.equals(prevWord))
        {
            System.out.println ("Repeated word on line " + line + ": " +
                    prevWord+ " " + curWord);
        }
        else
        {
            prevWord = curWord;
        }
        curWord = "";
    }  // end checkDupes

    //************************************************
    // Checks to see if a character is a delimiter.
    //************************************************
    private static boolean isDelimit (char C)
    {
        for (int i = 0; i < delimits.length; i++)
            if (C == delimits [i])
                return (true);
        return (false);
    }
} // end class Stutter
