package ru.spbstu.appmath.mamina;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.sbpstu.appmath.mamina.ParserInterval;
import ru.sbpstu.appmath.mamina.WorkWithFile;
import ru.sbpstu.appmath.mamina.exception.ExpException;

import java.io.IOException;


public class FileTest {

    private static final String[][] testData = new String[][]{
            {"a.txt", "b.txt", "1:5"},
            {"a.txt", "b.txt", "dkjakldk"},
    };

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test() throws ExpException, IOException {
        final WorkWithFile file = new WorkWithFile();
        ParserInterval p = new ParserInterval(testData[0][2]);
        file.parseFile(testData[0][0], testData[0][1], p.getMin(), p.getMax(), p.getStep());
    }

    @Test
    public void testException1() throws ExpException, IOException {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Problem with interval!");

        final WorkWithFile file = new WorkWithFile();
        ParserInterval p = new ParserInterval(testData[1][2]);
        file.parseFile(testData[1][0], testData[1][1], p.getMin(), p.getMax(), p.getStep());
    }
}



