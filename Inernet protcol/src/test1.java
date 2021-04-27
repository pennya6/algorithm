/* ���α׷��� : Subnet Calculation Program
 * �ۼ��� : ��ÿ�(��ǻ�Ͱ��к� / 201958008)
 * �ۼ��� : 2021-04-27
 * ���α׷� ���� 
 * 1) ��Ʈ��ũ �ּҸ� �Է¹޴´� -> ���ٷ� �ް� split�Ϸ� ������ ���� ���ذ�� x,y,z,w�� ���� �Է¹޴� ���·� ����
 * 2) �Է¹��� �⺻ ����� ���� ���� �� ���� ���ϱ�  -> Math.pow(2, 32-sn)-2
 * 3) ���ϴ� ����� �� ��� �� ����� �Ҵ� �ּҸ� �� �����Ͽ� �� subnet id�� �������ش�.
 * 4) network id�� subnet id �ڿ� ���� �������ش�.
 * 5) broadcast�� 4���� ������ ���·� ����
 * 6) range���ϱ�
 * 
 * */

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		System.out.println("��Ʈ��ũ �ּ� : ");
		//String address="163.39.25.0";//s.next(); //��Ʈ��ũ �ּ� ���ٷ� �Է¹ޱ�
		int x=s.nextInt();
		System.out.print(".");
		int y=s.nextInt();
		System.out.print(".");
		int z=s.nextInt();
		System.out.print(".");
		int w=s.nextInt();
		
		
		System.out.println("�⺻ Subnet : ");
		int sn=s.nextInt();
		
		System.out.println("���ϴ� ����� �� : ");
		int n=s.nextInt();
		
		
		System.out.println("�� ����� �Ҵ� �ּ� �� : ");
		
		int sni[]=new int[n+1];
			for(int i=1;i<=n;i++) {
				System.out.println("SN"+i+":");
				sni[i]=s.nextInt();
			}
			
			//System.out.println(x);
			
			String cla=check_class(x);
			//System.out.println(cla);
			// �� ���� ���ϱ�
			int how=(int) (Math.pow(2, 32-sn)-2);
			//System.out.println(how);
			output(x,y,z,w,how,sni,sn);
			
			
			
	}
	//Ŭ���� �Ǻ�
	static String check_class(int x) {
		String output;
		 if(0<=x&&x<=127)  return output="A class";
		 else if(128<=x&&x<=191) return output="B class";
		 else if(192<=x&& x<=223) return output="C class";
		 return output="?";
	}
	//254 �Է¹޾Ƽ� ���� ���������Ŀ� �� �ޱ�
	static void output(int x, int y, int z,int w, int how, int sni[],int sn) {
		int x1[]=new int[] {3,0,10,110,1110};
		
		//���� ���
		  int nw_id1_int[]=new int[sni.length];
	      int broadcast_id_int[]=new int[sni.length];
	      int range1_int[]=new int[sni.length];
	      int range2_int[]=new int[sni.length];
	      
		//�� ����� �Ҵ� �ּҿ� �°� ����
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
		//�ߺ� �ذ�
		for(int i=0;i<sni.length-1;i++) {
			if(sni_n[i]==sni_n[i+1]) {
				sni_n[i+1]=x1[i+1];
			}
		}
		for(int i=1;i<sni.length;i++) {
			//System.out.println(sni_n[i]);
		}
		//��Ʈ��ũ ���̵�
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
		//��ε�ĳ��Ʈ
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
		//����ó���ϱ�
		//range ���ϱ�
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


		//2���� 10���� ��ȯ
	      for(int i=1;i<sni.length;i++) {
	    	  nw_id1_int[i]=Integer.valueOf(nw_id1[i], 2);
	    	  broadcast_id_int[i]=Integer.valueOf(broadcast_id1[i],2);
	    	  
	      }
	      
	      
	     

	      	
	}

}
