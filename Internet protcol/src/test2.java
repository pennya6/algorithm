import java.util.Scanner;

public class test2 {
	static Scanner scan=new Scanner(System.in);
	static public void main(String[] args)
	{
		change ip = new change();
		
		while(true)		//�޴� ���� ����
		{
			System.out.println("����� ����");
			System.out.println("1. IP�ּ�, ȣ��Ʈ ���� �Է�");
			System.out.println("2. IP�ּ�, ����� ����ũ �Է�");
			System.out.println("3. ����");
			System.out.print("�޴��� �Է��Ͻÿ�.: ");
			int mode = scan.nextInt();
			if(mode==1)
				ip.host();
			else if(mode==2)
				ip.sub();
			else if(mode==3)
				break;
			else
				System.out.println("�߸� �Է��Ͽ����ϴ�");
		}
	}
}


class change // ��� �۾� �ϴ� �κ� ������
{
	Scanner scan=new Scanner(System.in);
	int[] broad={0,0,0,0};		//��ε� ĳ��Ʈ �ּ�
	int[] ip_num=new int[4]; 	//ip �ּ�
	int[] sub_num=new int[4];	//����� �ּ�
	int[] network=new int[4];	//��Ʈ��ũ �ּ�
	
	void host()
	{
		while(true)
		{
			get_ip();
			System.out.println("ȣ��Ʈ ������ �Է��Ͻÿ�");
			String host_String=scan.next();
			int host_int=Integer.parseInt(host_String);
			
			if(check_class(ip_num[0])=='C')
			{
				subnet(host_int);
				subnet_host(host_int);
				break;
			}
			else
				System.out.println(check_class(ip_num[0])+"Ŭ������ ���� �Ұ��� �մϴ�.");
		}
	}
	
	void sub()
	{
		while(true)	//���� ���� - �� ��� �Է°� ����� ������ break
		{
			get_ip();
			get_sub();			
			
			if(check_class(ip_num[0])=='C')
			{
				if(check_subnet())
				{
					System.out.println("�Է��Ͻ� IP�ּҴ� ");
					output_ip(ip_num);
					System.out.println("�Դϴ�.");
					
					System.out.println("�Է��Ͻ� ������ּҴ� ");
					output_ip(sub_num);
					System.out.println("�Դϴ�.");
					
					for(int i=0;i<4;i++)				//�Է¹��� IP�� ����� ����ũ AND
					{
						network[i]=ip_num[i] & sub_num[i];
					}	
					
					System.out.println("��Ʈ��ũ �ּҴ� ");
					output_ip(network);
					System.out.println("�Դϴ�.");
					
					broadcast();
					System.out.println("��ε� ĳ��Ʈ �ּҴ� ");
					output_ip(broad);
					System.out.println("�Դϴ�.");
					
					network[3]++;
					System.out.println("��� ������ �ּ� ������ ");
					output_ip(network);
					System.out.println(" ���� ");
					network[3]=--broad[3];
					output_ip(network);
					System.out.println(" ���� �Դϴ�.");
					break;
				}
				else
				{
					System.out.println("�ش� ������� ���� �Ұ� �Դϴ�.");
//					break;
				}
			}
			else
				System.out.println(check_class(ip_num[0])+"Ŭ������ ���� �Ұ��� �մϴ�.");
		}
	}
	
	void output_ip(int[] network) //xxx.xxx.xxx.xxx �������� ���
	{
		for(int n=0;n<4;n++)
		{
			System.out.print(network[n]);
			if(n<3)
				System.out.print(".");
		}
		System.out.println();
	}
	void output_ip(String[] network) //�����ε�
	{
		for(int n=0;n<4;n++)
		{
			System.out.print(network[n]);
			if(n<3)
				System.out.print(".");
		}
		System.out.println();
	}

	void subnet(int host)
	{
		int host_1=host+2;
		int net_num=1;
		String addr="";
		String[] addr_1=new String[4];
		int[] addr_int=new int[4];
		
		while(host_1/2!=0) //��Ʈ��ũ ��Ʈ �� Ȯ��
		{
			host_1=host_1/2;
			net_num++;
		}
//		System.out.println(net_num); //��Ʈ��ũ ��Ʈ �� ���
		
		/*����� ����ũ ����*/
		for(int i=32;i>net_num;i--)
		{
			addr=addr+"1";
		}
		for(;net_num>0;net_num--)
		{
			addr=addr+"0";
		}
		
		for(int i=0;i<4;i++)
			addr_1[i]=addr.substring(8*i, 8*i+8);	//���� 4���� �����ֱ�
		
		System.out.print("����� ����ũ 2���� �� ");
		output_ip(addr_1);		// ����� ����ũ 2���� ���
		
		for(int i=0;i<4;i++)
		{
			addr_int[i]=Integer.parseInt(addr_1[i]);
			for(int n=0,value=0,multiple=1; n<8; n++)	//2������ 10������ ��ȯ
			{
				value =  addr_int[i]%10;
//				sub_int[i] = sub_int[i] + value*multiple;
				sub_num[i] = sub_num[i] + value*multiple;
				multiple = multiple * 2;
				addr_int[i] = addr_int[i]/10;
			}
		}		
	}
	
	void broadcast()
	{
		for(int i=0;i<3;i++)
			broad[i]=ip_num[i];
//		broad[3]=sub_int[3] ^ 255; //����� �ּҿ� 255�� XOR
		broad[3]=network[3]+(sub_num[3]^255);  //��Ʈ��ũ �ּ�  + ����� �ּҿ� 255 XOR
	}
	
/*	void broadcast_sub()
	{
		for(int i=0;i<3;i++)
			broad[i]=ip_num[i];
		broad[3]=network[3]+(sub_num[3]^255);    //��Ʈ��ũ �ּ�  + ����� �ּҿ� 255 XOR
//		System.out.println("network[3] "+network[3]+" sub_int[3]^255 "+(sub_num[3]^255));
	}*/

	void get_ip()		//ip �Է� �ޱ�
	{
		while(true)	//�Է¹��� �ּҰ� �´��� Ȯ��
		{
			System.out.println("������ �ּ� �Է�");
			String a=scan.next();
			boolean[] test=new boolean[4];
			
			String[] ip_add={"","","",""};
			int i=0;
			char[] arr=a.toCharArray();
			//for(int j=0; int ip_num[i]=Integer.parseInt(ip_add[i]);
			
//			output_ip(ip_num);			//ip�ּ� ���
			
			for(i=0;i<4;i++)		//0~255���� ����
				test[i]=(ip_num[i]<256)&&(ip_num[i]>=0);
				
			if(test[0]&&test[1]&&test[2]&&test[3])	//������ �³�?
				break;
			else
				System.out.println("�߸��� IP�ּ� �Դϴ�");
		}
	}
	
	void get_sub()	//����� �ּ� �ޱ�
	{
		while(true)	//�Է¹��� �ּҰ� �´��� Ȯ��
		{
			System.out.println("����� �ּ� �Է�");
			String a=scan.next();
			boolean[] test=new boolean[4];
			
			String[] sub_add={"","","",""};
			
			char[] arr=a.toCharArray();
			//for(int i=0, j=0;i int
				//sub_num[i]=Integer.parseInt(sub_add[i]);
			
			output_ip(sub_num);			//����� �ּ� ���
			
			for(int i=0;i<4;i++)		//0~255���� ����
				test[i]=(sub_num[i]<256)&&(sub_num[i]>=0);
				
			if(test[0]&&test[1]&&test[2]&&test[3])	//������ �³�?
				break;
			else
				System.out.println("�߸��� ����� �ּ� �Դϴ�");
		}
	}
	
	char check_class(int check)		//class Ȯ��
	{
		char output;
		if(0<=check && check <=127)
			output='A';
		else if(128<=check && check<=191)
			output='B';
		else if(192<=check && check<=223)
			output='C';
		else
			output='?';
		
		return output;
	}
	
	boolean check_subnet()	//����� ����ũ�� �ùٸ��� Ȯ��
	{
		if(sub_num[0]==255 && sub_num[1]==255 && sub_num[2]==255 && sub_num[3]>=0)
			if(sub_num[3]==252 || sub_num[3]==248 || sub_num[3]==240 || sub_num[3]==224 
			|| sub_num[3]==192 || sub_num[3]==128 || sub_num[3]==0)
			{
				return true;
			}
			else
				return false;			
		else
			return false;
	}
	
	void subnet_host(int host_num)	//ȣ��Ʈ ������ �Է� ������ ����ϴ� �κ�
	{
		System.out.print("����� ����ũ 10���� �� ");
		output_ip(sub_num);		// ����� ����ũ 10���� ���
		System.out.print("��ε� ĳ��Ʈ �� ");
		for(int i=0;i<4;i++)				//�Է¹��� IP�� ����� ����ũ AND
		{
			network[i]=ip_num[i] & sub_num[i];
		}	
		broadcast();
		output_ip(broad);
		
//		int[] network=new int[4];
		
		/*for(int i=0;i<4;i++)				//�Է¹��� IP�� ����� ����ũ AND
		{
			network[i]=ip_num[i] & sub_int[i];
		}	*/	
		System.out.print("��Ʈ��ũ �ּ� ");
		output_ip(network);		//��Ʈ��ũ �ּ� ���
		
		System.out.println("IP ����");	//ȣ��Ʈ ���� ������
		network[3]++;
		output_ip(network);
		network[3]+=+host_num-1;
		System.out.println("����");
		output_ip(network);
	}
}