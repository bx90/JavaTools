package filepath;

import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;


public class AbsoluteFIlePath {

    @Test
    public void addPath() {
        Path javaFile = Paths.get("filepath" , "AbsoluteFilePath.java");
        Path root = Paths.get("src");

        Path absolute = root.resolve(javaFile);

        String expected = "src/filepath/AbsoluteFilePath.java";
        String actual = absolute.toString();
        assertThat(actual, is(expected));
    }

    @Test
    public void substractPath() {
        Path absolute = Paths.get("src/main/java/com/airhacks/PathsTest.java");
        Path root = Paths.get("src", "main", "java");

        Path relative = root.relativize(absolute);

	    //ignoring the OS-specific separator
        String expected = "com/airhacks/PathsTest.java";
        String actual = relative.toString();
        assertThat(actual, is(expected));
    }

}