package com.horse;

import java.util.Calendar;

public class GambleException extends Thread{

	public void inputIdcheck(String str) throws Exception{
		
		char ch;
		int mat, eng, ent;
		
		mat = 0;
		eng = 0;
		ent = 0;
		
		if(str.length()<8 || str.length()>15){
			throw new Exception("���̵� �Է� ���� ����");
		}
		
		for(int i = 0;i<str.length();i++){
			
			ch = str.charAt(i);
							
				
			if((ch>=65&&ch<=90)||(ch>=97&&ch<=122)){
				eng = 1;
			}
				
			if((ch>=48&&ch<=57)){
				mat = 1;
			}
			
			if((ch>=33&&ch<=47)||(ch>=58&&ch<=64)||(ch>=91&&ch<=96)||(ch>=123&&ch<=126)){
				ent = 1;
			}

		}
		
		if(eng == 0)
		{
			throw new Exception("��� �Է��Ͻÿ�.");
		}
		
		if(mat == 0)
		{
			throw new Exception("���ڵ� �Է��Ͻÿ�.");
		}	
		
		if(ent == 1)
		{
			throw new Exception("Ư�����ڴ� �Է����� ���ÿ�.");
		}
		

	}

	public void inputPwCheck(int s) throws Exception{

		if(s<=0){

			throw new Exception("��й�ȣ�� �������� �ʽ��ϴ�!");

		}

	}

	public void inputGdcheck(int s) throws Exception{

		if(s<=0){

			throw new Exception("������ Male �Ǵ� Female �� �����մϴ�");

		}

	}
	
	public void inputJuCheck(int s) throws Exception{
		HorseImage hi=new HorseImage();
		Calendar now = Calendar.getInstance();
		int y, age;
		
		y = now.get(Calendar.YEAR);
		
		age = y-s+1;
				
		if(!(age>=20 &&age<=100)){
			
			throw new Exception();

		}
		
	}
	
	public void inputJaCheck(String jumin) throws Exception{
		
		if(jumin.length()!=14){
			throw new Exception("�ֹι�ȣ ���� ���� ((-) ���� 14�ڸ�)!!");
		}
		
	}

}
