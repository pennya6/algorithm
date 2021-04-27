/* 프로그램명 : Subnet Calculation Program
 * 작성자 : 김시연(컴퓨터공학부 / 201958008)
 * 작성일 : 2021-04-27
 * 프로그램 설명 
 * 1) 네트워크 주소를 입력받는다 -> 한줄로 받고 split하려 했으나 오류 미해결로 x,y,z,w를 따로 입력받는 형태로 수정
 * 2) 입력받은 기본 서브넷 수를 토대로 총 개수 구하기  -> Math.pow(2, 32-sn)-2
 * 3) 원하는 서브넷 수 대로 각 서브넷 할당 주소를 수 참고하여 각 subnet id를 구성해준다.
 * 4) network id는 subnet id 뒤에 마저 구성해준다.
 * 5) broadcast도 4번과 동일한 형태로 구성
 * 6) range구하기
 * 
 * */

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		System.out.println("네트위크 주소 : ");
		//String address="163.39.25.0";//s.next(); //네트워크 주소 한줄로 입력받기
		int x=s.nextInt();
		System.out.print(".");
		int y=s.nextInt();
		System.out.print(".");
		int z=s.nextInt();
		System.out.print(".");
		int w=s.nextInt();
		
		
		System.out.println("기본 Subnet : ");
		int sn=s.nextInt();
		
		System.out.println("원하는 서브넷 수 : ");
		int n=s.nextInt();
		
		
		System.out.println("각 서브넷 할당 주소 수 : ");
		
		int sni[]=new int[n+1];
			for(int i=1;i<=n;i++) {
				System.out.println("SN"+i+":");
				sni[i]=s.nextInt();
			}
			
			//System.out.println(x);
			
			String cla=check_class(x);
			//System.out.println(cla);
			// 총 개수 구하기
			int how=(int) (Math.pow(2, 32-sn)-2);
			//System.out.println(how);
			output(x,y,z,w,how,sni,sn);
			
			
			
	}
	//클래스 판별
	static String check_class(int x) {
		String output;
		 if(0<=x&&x<=127)  return output="A class";
		 else if(128<=x&&x<=191) return output="B class";
		 else if(192<=x&& x<=223) return output="C class";
		 return output="?";
	}
	//254 입력받아서 피자 나누기이후에 값 받기
	static void output(int x, int y, int z,int w, int how, int sni[],int sn) {
		int x1[]=new int[] {3,0,10,110,1110};
		
		//진수 출력
		  int nw_id1_int[]=new int[sni.length];
	      int broadcast_id_int[]=new int[sni.length];
	      int range1_int[]=new int[sni.length];
	      int range2_int[]=new int[sni.length];
	      
		//각 서브넷 할당 주소에 맞게 대입
		int sni_n[]=new int[sni.length];
		int cnt[]=new int[sni.length];
		for(int i=1;i<sni.length;i++) {
			if(62<sni[i]&&sni[i]<=124) {
				sni_n[i]=x1[1];
				cnt[i]=sn+1;
			}
			else if(36<sni[i]&&sni[i]<=62) {
				sni_n[i]=x1[2];
				cnt[i]=sn+2;
			}
			else if(18<sni[i]&&sni[i]<=36) {
				sni_n[i]=x1[3];
				cnt[i]=sn+3;
			}
			else {
				sni_n[i]=x1[4];
				cnt[i]=sn+4;
			}
		}
		//중복 해결
		for(int i=0;i<sni.length-1;i++) {
			if(sni_n[i]==sni_n[i+1]) {
				sni_n[i+1]=x1[i+1];
			}
		}
		for(int i=1;i<sni.length;i++) {
			//System.out.println(sni_n[i]);
		}
		//네트워크 아이디
		String nw_id[]=new String[sni_n.length];
		String nw_id1[]=new String[sni_n.length];
		System.out.println("Network id");
		for(int i=1;i<sni.length;i++) {
			
			if(sni_n[i]==0) {
				nw_id1[i]=sni_n[i]+"0000000";
				nw_id1_int[i]=Integer.valueOf(nw_id1[i], 2);
				nw_id[i]=x+"."+y+"."+z+"."+nw_id1_int[i];
				System.out.println(nw_id[i]);
			}
			else if(sni_n[i]==10) {
				nw_id1[i]=sni_n[i]+"000000";
				nw_id1_int[i]=Integer.valueOf(nw_id1[i], 2);
				nw_id[i]=x+"."+y+"."+z+"."+nw_id1_int[i];
				System.out.println(nw_id[i]);
			}
			else if(sni_n[i]==110) {
				nw_id1[i]=sni_n[i]+"00000";
				nw_id1_int[i]=Integer.valueOf(nw_id1[i], 2);
				nw_id[i]=x+"."+y+"."+z+"."+nw_id1_int[i];
				System.out.println(nw_id[i]);
			}
			else {
				nw_id1[i]=sni_n[i]+"0000";
				nw_id1_int[i]=Integer.valueOf(nw_id1[i], 2);
				nw_id[i]=x+"."+y+"."+z+"."+nw_id1_int[i];
				System.out.println(nw_id[i]);
			}
			
		}
		//브로드캐스트
		String broadcast_id[]=new String[sni_n.length];
		String broadcast_id1[]=new String[sni_n.length];
		System.out.println("broadcast");
		for(int i=1;i<sni.length;i++) {
			if(sni_n[i]==0) {
				broadcast_id1[i]=sni_n[i]+"1111111";
				 broadcast_id_int[i]=Integer.valueOf(broadcast_id1[i],2);
				broadcast_id[i]=x+"."+y+"."+z+"."+broadcast_id_int[i];
				System.out.println(broadcast_id[i]);
			}
			else if(sni_n[i]==10) {
				broadcast_id1[i]=sni_n[i]+"111111";
				 broadcast_id_int[i]=Integer.valueOf(broadcast_id1[i],2);
				broadcast_id[i]=x+"."+y+"."+z+"."+broadcast_id_int[i];
				System.out.println(broadcast_id[i]);
			}
			else if(sni_n[i]==110) {
				broadcast_id1[i]=sni_n[i]+"11111";
				 broadcast_id_int[i]=Integer.valueOf(broadcast_id1[i],2);
				broadcast_id[i]=x+"."+y+"."+z+"."+broadcast_id_int[i];
				System.out.println(broadcast_id[i]);
			}
			else {
				broadcast_id1[i]=sni_n[i]+"1111";
				 broadcast_id_int[i]=Integer.valueOf(broadcast_id1[i],2);
				broadcast_id[i]=x+"."+y+"."+z+"."+broadcast_id_int[i];
				System.out.println(broadcast_id[i]);
			}
		}
		//예외처리하기
		//range 구하기
		 String range1[]=new String[sni_n.length];
		 int a[]=new int[sni.length];
		 int b[]=new int [sni.length];
	      String range2[]=new String[sni_n.length];
	      System.out.println("range");
	      for(int i=1;i<sni.length;i++) {
	    	  a[i]=nw_id1_int[i]+1;
	    	  b[i]=broadcast_id_int[i]-1;
	        	 range1[i]=x+"."+y+"."+z+"."+a[i];
	        	 range2[i]=x+"."+y+"."+z+"."+b[i];
	            System.out.println(range1[i]+"~"+range2[i]+"  /"+cnt[i]);
	       
	      }


		//2진수 10진수 변환
	      for(int i=1;i<sni.length;i++) {
	    	  nw_id1_int[i]=Integer.valueOf(nw_id1[i], 2);
	    	  broadcast_id_int[i]=Integer.valueOf(broadcast_id1[i],2);
	    	  
	      }
	      
	      
	     

	      	
	}

}
