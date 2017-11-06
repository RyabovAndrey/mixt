import java.util.regex.Pattern;

public class validUrl {
    /* Проверка URL на валидность */

    public static void main(String[] args) {
        String[] urls = { "www.aelitasoft.ru", "aelita","1234567.67899",  "www.google.com", "195.208.1.103" };
        for (String url : urls) {
            System.out.println(url + " is " + (isUrlValid(url) ? "valid" : "invalid"));
        }
    }
    public static boolean isUrlValid(String url) {
        boolean result;
        Pattern ptr = Pattern.compile("^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$");
        if (ptr.matcher(url).matches()) result= true;
        else result= false;
        return result;
    }
}
