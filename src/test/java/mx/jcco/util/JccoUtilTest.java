package mx.jcco.util;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

import mx.jcco.util.date.DateUtil;
import mx.jcco.util.file.FileUtil;

import org.testng.annotations.Test;

/**
 * Pruebas unitarias
 * 
 * @author Carlos Cortés
 */

// @ContextConfiguration(locations =
// {"classpath:ineval-sigu-persistence-test.xml"})
public class JccoUtilTest{

    @Test
    public void testPrepareSinceDate(){
	final Calendar c1 = Calendar.getInstance();

	assertNotNull(c1);

	c1.setTime(DateUtil.prepareSinceDate(null));

	assertTrue(c1.get(Calendar.YEAR) == 1900);
	assertTrue(c1.get(Calendar.MONTH) == 01);
	assertTrue(c1.get(Calendar.DAY_OF_MONTH) == 01);
	assertTrue(c1.get(Calendar.HOUR_OF_DAY) == 0);
	assertTrue(c1.get(Calendar.MINUTE) == 0);
	assertTrue(c1.get(Calendar.SECOND) == 0);

	final Calendar c2 = Calendar.getInstance();

	c2.set(2000, 10, 22);

	final Calendar c3 = Calendar.getInstance();

	c3.setTime(DateUtil.prepareSinceDate(c2.getTime()));

	assertTrue(c3.get(Calendar.YEAR) == 2000);
	assertTrue(c3.get(Calendar.MONTH) == 10);
	assertTrue(c3.get(Calendar.DAY_OF_MONTH) == 22);
	assertTrue(c3.get(Calendar.HOUR_OF_DAY) == 0);
	assertTrue(c3.get(Calendar.MINUTE) == 0);
	assertTrue(c3.get(Calendar.SECOND) == 0);
    }

    @Test
    public void testPrepareUntilDate(){
	final Calendar c1 = Calendar.getInstance();

	assertNotNull(c1);

	c1.setTime(DateUtil.prepareUntilDate(null));

	assertTrue(c1.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR));
	assertTrue(c1.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH));
	assertTrue(c1.get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	assertTrue(c1.get(Calendar.HOUR_OF_DAY) == 23);
	assertTrue(c1.get(Calendar.MINUTE) == 59);
	assertTrue(c1.get(Calendar.SECOND) == 59);

	final Calendar c2 = Calendar.getInstance();

	c2.set(2010, 10, 22);

	final Calendar c3 = Calendar.getInstance();

	c3.setTime(DateUtil.prepareUntilDate(c2.getTime()));

	assertTrue(c3.get(Calendar.YEAR) == 2010);
	assertTrue(c3.get(Calendar.MONTH) == 10);
	assertTrue(c3.get(Calendar.DAY_OF_MONTH) == 22);
	assertTrue(c3.get(Calendar.HOUR_OF_DAY) == 23);
	assertTrue(c3.get(Calendar.MINUTE) == 59);
	assertTrue(c3.get(Calendar.SECOND) == 59);
    }

    @Test
    public void testGetBytesFromSourceFile() throws IOException{
	final String filepath = "src/test/resources/file-util/text.txt";
	final byte[] bytes = FileUtil.getBytesFromSourceFile(filepath);
	
	assertNotNull(bytes);
	
	final Path path = Paths.get("src/test/resources/file-util/text2.txt");
	Files.write(path, bytes);
	final List<String> lines = Files.readAllLines(path);
	
	assertTrue(lines.size() == 2);
	assertTrue(lines.get(0).equals("Text for test"));
	assertTrue(lines.get(1).equals("Second text for test"));
	
	Files.delete(path);
    }
}
