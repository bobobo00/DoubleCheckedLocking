package others;
/**懒汉模式：
 * DCL单例模式：套路，在多线程环境下，对外存在一个对象
 * 1.构造器私有化--》避免外部new构造器
 * 2，提供私有的静态属性--》存储对象的地址。
 * 3，提供公共的静态方法--》获取属性
 * @author dell
 *
 */

public class DoubleCheckedLocking {
	private static volatile DoubleCheckedLocking instance;//没有volatile其他线程可能访问一个没有初识化的对象。
	private DoubleCheckedLocking() {}

	public static DoubleCheckedLocking getInstance() {
		if(null!=instance) {
			return instance;//避免不必要的同步，已经存在对象
		}
		synchronized(DoubleCheckedLocking.class) {
			if(null==instance) {
			instance=new DoubleCheckedLocking();
			//1，开辟空间2,初识化对象信息3,返回对象的地址给引用
			}
		}
		return instance;
	}
	public static void main(String[] args) {
		Thread t=new Thread(()->{System.out.println(DoubleCheckedLocking.getInstance());});
		t.start();
		System.out.println(DoubleCheckedLocking.getInstance());
	}

}
