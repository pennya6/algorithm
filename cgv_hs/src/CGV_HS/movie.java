package CGV_HS;

import java.util.*;

/*
 * movie : ��ȭ ��ü ���� Ŭ����
 *  cgv_hs���� movie ���̺�� ��ġ�Ǵ� Ŭ���� 
 * 
 * */

public class movie {
	String movieno; //��ȭ��ȣ
	String title; //��ȭ����
	String genre; //��ȭ�帣
	java.sql.Date date; //������
	int runtime; //�󿵽ð�
	String story; //����
	String avgGrade; //�������
	String cntsReview; //�����
	
	public movie(String moiveno, String title, String genre, Date date, int runtime, 
			String story, String avgGrade, String cntsReview) {
		this.movieno=movieno;
		this.avgGrade=avgGrade;
		this.cntsReview=cntsReview;
		this.date=new java.sql.Date(date.getTime());
		this.genre=genre;
		this.runtime=runtime;
		this.story=story;
		this.title=title;
	}
	
	//����� ����
	public void addcntsReview(int cntsReview) {
		cntsReview+=1;
	}
	
	

}
