package top.anonymous.util;
import org.junit.Test;
import top.anonymous.env.Env;


public class ASTUtilTest {

    @Test
    public void testParseAstFromFiles(){
        String[] s = Env.SOURCE_FOLDER.split("/");
        System.out.println(s[s.length - 2] + "/" + s[s.length - 1]);
    }



}