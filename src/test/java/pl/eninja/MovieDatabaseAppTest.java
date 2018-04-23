package pl.eninja;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MovieDatabaseAppTest extends TestCase {

  public MovieDatabaseAppTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(MovieDatabaseAppTest.class);
  }

  public void testApp() {
    assertTrue(true);
  }
}
