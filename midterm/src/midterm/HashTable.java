package midterm;



public class HashTable {
	private int n; //�ؽ����̺� �ִ� �����ۼ�
	private int m; //�ؽ� ���̺� ũ��
	private Object[] keys; //Ű �迭
	private Object[] values; //����迭
	
	//ũ�Ⱑ capacity�� �ؽ����̺� �ʱ�ȭ
	public HashTable(int capacity) {
		m=capacity;
		n=0;
		keys=new Object[m];
		values=new Object[m];
	}
	//�ؽð� ���ϱ�
	public int hashValue(Object key) {
		return (key.hashCode()&0x7fffffff)%m;
	}
	//Ű�� ����� �ؽ����̺� ����
	public void put(Object key, Object val) {
		//int d=7-(key%7);
		//if(n>m/2)  
		int i;
		
		//��������
		for(i=hashValue(key);keys[i]!=null;i=(i+1)%m) {
			if(keys[i].equals(key)) { //�ߺ��� ������
				values[i]=val; //������Ʈ
				return;
			}
		}
		keys[i]=key;
		values[i]=val;
		n++;
	}
	
	//�־��� Ű�� �˻�
	public Object get(Object key) {
		for(int i=hashValue(key);keys[i]!=null;i=(i+1)%m)
			if(keys[i].equals(key))
				return values[i];
		return null;
	}
	//�ؽ����̺� ���
	public void printHT() {
		System.out.println("Hash Table with size"+m+" and "+n+" elements");
		for(int i=0;i<m;i++) {
			if(keys[i]==null) {
				System.out.println("["+i+"]");
			}
			else
				System.out.println("["+i+"]"+keys[i]);		
		}
	}
}
