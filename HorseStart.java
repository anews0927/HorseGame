package com.horse;

import java.util.Scanner;

class HorseStart extends Thread{
	
	Scanner sc=new Scanner(System.in);
	GambleVO hv= new GambleVO();
	GambleImpl gi=new GambleImpl();
	
	@Override
	public void run() {
		
		HorseImage hi=new HorseImage();
		
		for(int i=0;i<hi.horseIm.length;i++){
			System.out.println(hi.horseIm[i]);

			try {
				sleep(40);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		String [] start={"             ��","   ��","   ��","   ��","   ��","   ��","   ��","   ��","   ��","   ��","!!!"};

		for(int i=0;i<start.length;i++){
			System.out.print(start[i]);

			try {

				sleep(100);

			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
			//Scanner sc = new Scanner(System.in);

			//int[] horse = new int[5];

			char sun=0;

			//String []horsesun={};
		
			do{
				
				try {
					
					char ch;
					System.out.println();
					System.out.println();
					System.out.println("\n���� �����Ͽ� �ֽʽÿ�!");
					System.out.println();
					System.out.println("����������������������    ����������������������    ����������������������");
					System.out.println("��1�� ��� : ��â�� ��    ��2�� ��� : ������ ��    ��3�� ��� : �ּ�ȭ ��");
					System.out.println("����������������������    ����������������������    ����������������������");
					System.out.println("           ����������������������      ����������������������");
					System.out.println("           ��4�� ��� : ������ ��      ��5�� ��� : �ֺ��� ��");
					System.out.println("           ����������������������      ����������������������");
					System.out.println();
					System.out.print("�� ���� �� ");
					sun = (char)System.in.read();
					System.in.skip(50);

					if(sun=='1' || sun=='2' || sun =='3' || sun=='4' || sun=='5'){
						System.out.println(sun + "�� ���� �����ϼ̽��ϴ�.");

						do{

							System.out.print(sun + "�� ���� �����Ͻðڽ��ϱ�?[y/n]");
							ch = (char) System.in.read();
							System.in.skip(50);

						}while(ch != 'y' && ch !='Y' && ch != 'n' && ch != 'N');

						if(ch == 'n' || ch =='N'){

							sun = '0';

						}

					}else{
						
						System.out.println("�߸� �Է��ϼ̽��ϴ�!!");
						System.out.println("���� ��ȣ�� 1~5������ �Դϴ�!!");
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}

			}while(sun!='1' && sun!='2' && sun !='3' && sun!='4' && sun!='5');
			
			Runhs run=new Runhs();
			
			System.out.println();
			
			run.start();

			try {
				
				run.join();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
						
	}

	}/*

		public static void main(String[] args) {
			HorseStart t1=new HorseStart();
			Runhs s=new Runhs();
			
			
			t1.start();

			try {
				t1.join();

			} catch (Exception e) {

			}
			
			
			
		}	

*/
	

