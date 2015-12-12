package ru.spbstu.appmath.mamina;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.sbpstu.appmath.mamina.DataInFile;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestFile {

    private String in_name;
    private String out_name;
    private String interval;
    private String error;

    public TestFile(String in_name, String out_name, String interval, String error) {
        this.in_name = in_name;
        this.out_name = out_name;
        this.interval = interval;
        this.error = error;
    }

    private static final Object[][] TEST_FILE = new Object[][]{
            {"a.txt", "b.txt", "1:7", ""},
            {"c", "", "1:2:1", "File not found"},
            {"a.txt", "b.txt", "dkjakldk", "Problem with colon!"},
    };

    @Parameterized.Parameters
    public static Collection<Object[]> testFile() {
        return Arrays.asList(TEST_FILE);
    }

    @Test
    public void test() {
        try {
            final DataInFile file = new DataInFile();
            file.processFile(in_name, out_name, interval);
        } catch (Exception e) {
            Assert.assertTrue("Wrong answer", checkExceptionFile(e.getMessage()));
        }

    }

    private boolean checkExceptionFile(String exception) {
        System.out.println(exception);
        if (!exception.equals(error))
            return false;
        else return true;
    }


}
