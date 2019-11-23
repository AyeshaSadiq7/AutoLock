package aeminium.raytracer.withlock;
import top.anonymous.anno.Perm;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class Isect {
	public double t;
	public int enter;
	public Primitive prim;
	public Surface surf;
}
