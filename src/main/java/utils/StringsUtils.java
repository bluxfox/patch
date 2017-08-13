package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mad-man on 2017/8/13.
 */
public class StringsUtils{

    public static Integer matchNumber(String string) {
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(string);
        while(m.find()) {
            return Integer.valueOf(m.group(1));
        }
        return 0;
    }

}
