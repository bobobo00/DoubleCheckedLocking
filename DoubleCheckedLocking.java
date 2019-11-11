package others;
/**����ģʽ��
 * DCL����ģʽ����·���ڶ��̻߳����£��������һ������
 * 1.������˽�л�--�������ⲿnew������
 * 2���ṩ˽�еľ�̬����--���洢����ĵ�ַ��
 * 3���ṩ�����ľ�̬����--����ȡ����
 * @author dell
 *
 */

public class DoubleCheckedLocking {
	private static volatile DoubleCheckedLocking instance;//û��volatile�����߳̿��ܷ���һ��û�г�ʶ���Ķ���
	private DoubleCheckedLocking() {}

	public static DoubleCheckedLocking getInstance() {
		if(null!=instance) {
			return instance;//���ⲻ��Ҫ��ͬ�����Ѿ����ڶ���
		}
		synchronized(DoubleCheckedLocking.class) {
			if(null==instance) {
			instance=new DoubleCheckedLocking();
			//1�����ٿռ�2,��ʶ��������Ϣ3,���ض���ĵ�ַ������
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
