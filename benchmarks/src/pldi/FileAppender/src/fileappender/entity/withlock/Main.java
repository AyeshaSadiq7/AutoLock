package fileappender.entity.withlock;
import fileappender.entity.FileAppender;
import java.io.IOException;
import top.anonymous.anno.Perm;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class Main {
	public static void main(String[] args) throws IOException {
		FileAppender var0 = new FileAppender(null, "b", true, false, -100);
		var0.activateOptions();
		var0.activateOptions();
		var0.activateOptions();
		var0.setFile("[2", false, false, 1);
	}
}
