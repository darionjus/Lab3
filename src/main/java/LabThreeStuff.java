import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author darionjusuf
 *
 */
public class LabThreeStuff {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String urlText = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int length = urlText.length();
        int i = 0;
        int wordCount = 0;
        while (i < length - 2) {
            if (urlText.charAt(i) == 't' && urlText.charAt(i + 1) == 'h'
                    && urlText.charAt(i + 2) == 'e')  {
                wordCount++;
            }
            i++;
        }

        System.out.println(wordCount);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
