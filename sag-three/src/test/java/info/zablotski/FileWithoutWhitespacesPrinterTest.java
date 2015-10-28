package info.zablotski;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by zhenya on 10/27/15.
 */
public class FileWithoutWhitespacesPrinterTest {
    final static String FILENAME = "testFile.txt";
    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public SystemOutRule out = new SystemOutRule().enableLog();

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void createTempFile() throws IOException {
        final File tempFile = FileUtils.getFile("src","main", "resources", FILENAME);
        tempFile.createNewFile();
        tempFile.deleteOnExit();
    }

    @Test
    public void testNormalBehavior() throws Exception {
        final File tempFile = FileUtils.getFile("src","main", "resources", FILENAME);

        assertThat(tempFile.exists(), is(true));

        String stringWithWhitespaces = "1 23   45      56 78  \n      - \r\n  == == ";
        FileUtils.writeStringToFile(tempFile, stringWithWhitespaces);

        systemInMock.provideLines(FILENAME);

        FileWithoutWhitespacesPrinter fp = new FileWithoutWhitespacesPrinter();
        fp.run();

        assertTrue(out.getLog().contains(StringUtils.deleteWhitespace(stringWithWhitespaces)));
    }

    @Test
    public void testShouldCatchNullPointer() throws Exception {
        final String filename = "testFile.txt";

        systemInMock.provideLines(filename);

        FileWithoutWhitespacesPrinter fp = new FileWithoutWhitespacesPrinter();
        fp.run();

        assertTrue(out.getLog().contains("' does not exists"));
        assertTrue(out.getLog().contains(filename));
        assertTrue(out.getLog().contains("Error. File '"));
    }



}