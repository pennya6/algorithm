import java.util.Scanner;

public class test2 {
	static Scanner scan=new Scanner(System.in);
	static public void main(String[] args)
	{
		change ip = new change();
		
		while(true)		//메뉴 무한 루프
		{
			System.out.println("서브넷 계산기");
			System.out.println("1. IP주소, 호스트 갯수 입력");
			System.out.println("2. IP주소, 서브넷 마스크 입력");
			System.out.println("3. 종료");
			System.out.print("메뉴를 입력하시오.: ");
			int mode = scan.nextInt();
			if(mode==1)
				ip.host();
			else if(mode==2)
				ip.sub();
			else if(mode==3)
				break;
			else
				System.out.println("잘못 입력하였습니다");
		}
	}
}


class change // 모든 작업 하는 부분 ㅋㅋㅋ
{
	Scanner scan=new Scanner(System.in);
	int[] broad={0,0,0,0};		//브로드 캐스트 주소
	int[] ip_num=new int[4]; 	//ip 주소
	int[] sub_num=new int[4];	//서브넷 주소
	int[] network=new int[4];	//네트워크 주소
	
	void host()
	{
		while(true)
		{
			get_ip();
			System.out.println("호스트 갯수를 입력하시오");
			String host_String=scan.next();
			int host_int=Integer.parseInt(host_String);
			
			if(check_class(ip_num[0])=='C')
			{
				subnet(host_int);
				subnet_host(host_int);
				break;
			}
			else
				System.out.println(check_class(ip_num[0])+"클래스는 측정 불가능 합니다.");
		}
	}
	
	void sub()
	{
		while(true)	//무한 루프 - 단 모든 입력과 출력이 끝나면 break
		{
			get_ip();
			get_sub();			
			
			if(check_class(ip_num[0])=='C')
			{
				if(check_subnet())
				{
					System.out.println("입력하신 IP주소는 ");
					output_ip(ip_num);
					System.out.println("입니다.");
					
					System.out.println("입력하신 서브넷주소는 ");
					output_ip(sub_num);
					System.out.println("입니다.");
					
					for(int i=0;i<4;i++)				//입력받은 IP와 서브넷 마스크 AND
					{
						network[i]=ip_num[i] & sub_num[i];
					}	
					
					System.out.println("네트워크 주소는 ");
					output_ip(network);
					System.out.println("입니다.");
					
					broadcast();
					System.out.println("브로드 캐스트 주소는 ");
					output_ip(broad);
					System.out.println("입니다.");
					
					network[3]++;
					System.out.println("사용 가능한 주소 범위는 ");
					output_ip(network);
					System.out.println(" 부터 ");
					network[3]=--broad[3];
					output_ip(network);
					System.out.println(" 까지 입니다.");
					break;
				}
				else
				{
					System.out.println("해당 서브넷은 측정 불가 입니다.");
//					break;
				}
			}
			else
				System.out.println(check_class(ip_num[0])+"클래스는 측정 불가능 합니다.");
		}
	}
	
	void output_ip(int[] network) //xxx.xxx.xxx.xxx 형식으로 출력
	{
		for(int n=0;n<4;n++)
		{
			System.out.print(network[n]);
			if(n<3)
				System.out.print(".");
		}
		System.out.println();
	}
	void output_ip(String[] network) //오버로딩
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
		
		while(host_1/2!=0) //네트워크 비트 수 확인
		{
			host_1=host_1/2;
			net_num++;
		}
//		System.out.println(net_num); //네트워크 비트 수 출력
		
		/*서브넷 마스크 설정*/
		for(int i=32;i>net_num;i--)
		{
			addr=addr+"1";
		}
		for(;net_num>0;net_num--)
		{
			addr=addr+"0";
		}
		
		for(int i=0;i<4;i++)
			addr_1[i]=addr.substring(8*i, 8*i+8);	//각각 4개로 나눠주기
		
		System.out.print("서브넷 마스크 2진수 값 ");
		output_ip(addr_1);		// 서브넷 마스크 2진수 출력
		
		for(int i=0;i<4;i++)
		{
			addr_int[i]=Integer.parseInt(addr_1[i]);
			for(int n=0,value=0,multiple=1; n<8; n++)	//2진수를 10진수로 변환
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
//		broad[3]=sub_int[3] ^ 255; //서브넷 주소와 255를 XOR
		broad[3]=network[3]+(sub_num[3]^255);  //네트워크 주소  + 서브넷 주소와 255 XOR
	}
	
/*	void broadcast_sub()
	{
		for(int i=0;i<3;i++)
			broad[i]=ip_num[i];
		broad[3]=network[3]+(sub_num[3]^255);    //네트워크 주소  + 서브넷 주소와 255 XOR
//		System.out.println("network[3] "+network[3]+" sub_int[3]^255 "+(sub_num[3]^255));
	}*/

	void get_ip()		//ip 입력 받기
	{
		while(true)	//입력받은 주소가 맞는지 확인
		{
			System.out.println("아이피 주소 입력");
			String a=scan.next();
			boolean[] test=new boolean[4];
			
			String[] ip_add={"","","",""};
			int i=0;
			char[] arr=a.toCharArray();
			//for(int j=0; int ip_num[i]=Integer.parseInt(ip_add[i]);
			
//			output_ip(ip_num);			//ip주소 출력
			
			for(i=0;i<4;i++)		//0~255까지 범위
				test[i]=(ip_num[i]<256)&&(ip_num[i]>=0);
				
			if(test[0]&&test[1]&&test[2]&&test[3])	//범위에 맞나?
				break;
			else
				System.out.println("잘못된 IP주소 입니다");
		}
	}
	
	void get_sub()	//서브넷 주소 받기
	{
		while(true)	//입력받은 주소가 맞는지 확인
		{
			System.out.println("서브넷 주소 입력");
			String a=scan.next();
			boolean[] test=new boolean[4];
			
			String[] sub_add={"","","",""};
			
			char[] arr=a.toCharArray();
			//for(int i=0, j=0;i int
				//sub_num[i]=Integer.parseInt(sub_add[i]);
			
			output_ip(sub_num);			//서브넷 주소 출력
			
			for(int i=0;i<4;i++)		//0~255까지 범위
				test[i]=(sub_num[i]<256)&&(sub_num[i]>=0);
				
			if(test[0]&&test[1]&&test[2]&&test[3])	//범위에 맞나?
				break;
			else
				System.out.println("잘못된 서브넷 주소 입니다");
		}
	}
	
	char check_class(int check)		//class 확인
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
	
	boolean check_subnet()	//서브넷 마스크가 올바른지 확인
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
	
	void subnet_host(int host_num)	//호스트 갯수를 입력 받으면 출력하는 부분
	{
		System.out.print("서브넷 마스크 10진수 값 ");
		output_ip(sub_num);		// 서브넷 마스크 10진수 출력
		System.out.print("브로드 캐스트 값 ");
		for(int i=0;i<4;i++)				//입력받은 IP와 서브넷 마스크 AND
		{
			network[i]=ip_num[i] & sub_num[i];
		}	
		broadcast();
		output_ip(broad);
		
//		int[] network=new int[4];
		
		/*for(int i=0;i<4;i++)				//입력받은 IP와 서브넷 마스크 AND
		{
			network[i]=ip_num[i] & sub_int[i];
		}	*/	
		System.out.print("네트워크 주소 ");
		output_ip(network);		//네트워크 주소 출력
		
		System.out.println("IP 범위");	//호스트 숫자 정하자
		network[3]++;
		output_ip(network);
		network[3]+=+host_num-1;
		System.out.println("부터");
		output_ip(network);
	}
}