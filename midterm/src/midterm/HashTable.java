package midterm;



public class HashTable {
	private int n; //해시테이블에 있는 아이템수
	private int m; //해시 테이블 크기
	private Object[] keys; //키 배열
	private Object[] values; //밸류배열
	
	//크기가 capacity인 해시테이블 초기화
	public HashTable(int capacity) {
		m=capacity;
		n=0;
		keys=new Object[m];
		values=new Object[m];
	}
	//해시값 구하기
	public int hashValue(Object key) {
		return (key.hashCode()&0x7fffffff)%m;
	}
	//키와 밸류를 해시테이블에 삽입
	public void put(Object key, Object val) {
		//int d=7-(key%7);
		//if(n>m/2)  
		int i;
		
		//선형조사
		for(i=hashValue(key);keys[i]!=null;i=(i+1)%m) {
			if(keys[i].equals(key)) { //중복이 있으면
				values[i]=val; //업데이트
				return;
			}
		}
		keys[i]=key;
		values[i]=val;
		n++;
	}
	
	//주어진 키로 검색
	public Object get(Object key) {
		for(int i=hashValue(key);keys[i]!=null;i=(i+1)%m)
			if(keys[i].equals(key))
				return values[i];
		return null;
	}
	//해시테이블 출력
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
