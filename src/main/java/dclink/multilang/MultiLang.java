package dclink.multilang;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by ampuser on 06.11.2015.
 */
public class MultiLang {

    private static ResourceBundle translation;
    private static Lang currentLocale = Lang.EN;

    public enum Lang {
        RU("ru"),
        UA("ua"),
        EN("en");

        String prefix;

        Lang(String prefix) {
            this.prefix = prefix;
        }

        String getPrefix() {
            return prefix;
        }
    }

    public static void setCurrentLocale(Lang currentLocale) {
        MultiLang.currentLocale = currentLocale;
    }

    public static StringBuffer getMsg(String msg) {
        return getMsgByLang(currentLocale, msg);
    }

    public static StringBuffer getMsgByLang(Lang lang, String msg) {
        translation = ResourceBundle.getBundle("multiLang");
        StringBuffer result;
        try {
            result = new StringBuffer(translation.getString(lang.getPrefix() + "." + msg));
        } catch (MissingResourceException exception) {
            result = new StringBuffer("TEXT NOT DEFINED!");
        }
        return result;
    }
}
