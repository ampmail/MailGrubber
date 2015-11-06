import dclink.multilang.MultiLang;

/**
 * Created by ampuser on 06.11.2015.
 */
public class Start {
    public static void main(String[] args) {
        System.out.println(MultiLang.getMsg("welcome"));
        MultiLang.setCurrentLocale(MultiLang.Lang.UA);
        System.out.println(MultiLang.getMsg("welcome"));
        System.out.println(MultiLang.getMsgByLang(MultiLang.Lang.RU, "welcome"));
    }
}
