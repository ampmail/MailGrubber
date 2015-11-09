import dclink.multilang.MultiLang;
import org.urish.openal.ALException;
import org.urish.openal.OpenAL;
import org.urish.openal.Source;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

/**
 * Created by ampuser on 06.11.2015.
 */
public class Start {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
        System.out.println(MultiLang.getMsg("welcome"));
        MultiLang.setCurrentLocale(MultiLang.Lang.UA);
        System.out.println(MultiLang.getMsg("welcome"));
        System.out.println(MultiLang.getMsgByLang(MultiLang.Lang.RU, "welcome"));
        System.out.println(MultiLang.getMsgByLang(MultiLang.Lang.EN, "welcome"));

        try {
            OpenAL openal = new OpenAL();
            Source source = openal.createSource(new File("sample.wav"));
            source.play();
        } catch (ALException e) {
            e.printStackTrace();
        }
    }
}
