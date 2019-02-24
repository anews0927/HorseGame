package com.horse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.naver.NaverVO;

public class GambleImpl extends Thread implements Gamble {

	ArrayList<GambleVO> lists;
	Scanner sc = new Scanner(System.in); 
	HorseImage hi = new HorseImage();
	HorseMain hm = new HorseMain();
	
	private File f =  new File("d:\\horse\\horse.txt");
	
	public GambleImpl(){ //�⺻������(���� �ҷ�����)
		
		try {
			
			if(!f.getParentFile().exists()){
				
				f.getParentFile().mkdirs();	
							
			}
			
			if(f.exists()){
				
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				lists = (ArrayList<GambleVO>)ois.readObject();
				
				ois.close();
				fis.close();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Override //�α���
	public void login() throws IOException {

		GambleException ge = new GambleException();

		char ch;

		for(int i = 0; i < 100; ++i){ //��������

			System.out.println();

		}

		for(int i=0;i<hi.horseid.length;i++){

			System.out.println(hi.horseid[i]);

			try {
				sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		String id,pw;
		int n = 0, m = 0;

		if(lists==null || lists.isEmpty()==true){	//lists�� ���ų� lists�� ����� ���

			System.out.println("�Էµ� ȸ�� ������ �����ϴ�!!");
			System.out.println("ȸ�������� ������ �ּ���!!");	
			
			try {	//enter �� ���� ȭ������ �Ѿ
				char enter = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //��������

				System.out.println();

			}

		}else{

			do{ //�α��� ���̵� �˻�

				System.out.print("ID�� �Է��ϼ��� �� ");
				id=sc.next();

				Iterator<GambleVO> it = lists.iterator();

				while(it.hasNext()){

					GambleVO vo = it.next();

					if(vo.getId().equals(id)){
						
						do{// �α��� ��й�ȣ �˻�

							System.out.print("password�� �Է��ϼ��� �� ");
							pw=sc.next();

							if(vo.getPw1().equals(pw)){

								m++;
								break;

							}

							if(m==0){

								System.out.println("password�� Ʋ�Ƚ��ϴ�!!!");

								System.out.print("password �ٽ� �Է��Ͻðڽ��ϱ�?[Y/N] �� ");

								do{

									ch = (char) System.in.read();

								}while(ch != 'y' && ch !='Y' && ch != 'n' && ch != 'N');

								if(ch == 'n' || ch =='N'){
									System.exit(0);

								}else if(ch == 'y' || ch == 'Y'){
									pw = null;

								}
							}

						}while(m==0);

						n++;

					}

				}

				if(n==0){

					System.out.println("�������� �ʴ� ȸ���Դϴ� !!!");

					System.out.print("�ٸ� ID�� �α����Ͻðڽ��ϱ�?[Y/N] �� ");

					do{

						ch = (char) System.in.read();

					}while(ch != 'y' && ch !='Y' && ch != 'n' && ch != 'N');

					if(ch == 'n' || ch =='N'){
						System.exit(0);
					}if(ch =='y' || ch =='Y'){
						id = null;
					}

				}

			}while(n==0);

			n=0;

			for(int i = 0; i < 20; ++i){ //��������

				System.out.println();

			}

			System.out.println("		            \\\\\\///             ");
			System.out.println("		           / _  _ \\            ");
			System.out.println("		         (| (.)(.) |)          ");
			System.out.println("		.------.OOOo--()--oOOO.------. ");
			System.out.println("		|                            | ");
			System.out.println("		" + id + "   ���� �����ϼ̽��ϴ�!!   ");
			System.out.println("		|                            | ");
			System.out.println("		'------.oooO-----------------' ");
			System.out.println("		        (   )   Oooo.          ");
			System.out.println(" 		        \\ (    (   )          ");
			System.out.println(" 		         \\_)    ) /           ");
			System.out.println("   			       (_/            ");
			
			//System.out.println("   " + id + " ���� �����ϼ̽��ϴ�!");

			HorseStart t1 = new HorseStart();
			
			for(int i = 0; i < 15; ++i){ //��������

				System.out.println();

			}

			try {
				sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}

			t1.start();
			try {
				t1.join();
			} catch (Exception e) {

			}

		}

	}
	
	@Override // ȸ������
	public void input() throws Exception{
		
		int sum;
		String id;
		
			GambleException ge = new GambleException();
						
			for(int i = 0; i < 100; ++i){
				
				System.out.println();
				
			}
			
			for(int i=0;i<hi.horseid.length;i++){
				System.out.println(hi.horseid[i]);

				try {
					sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
			
			System.out.println("--------------------------");
			System.out.println("ȸ������");
			
			GambleVO vo = new GambleVO();
			
			int s = 0;
			char ch;
			int a = 0;
						
			do{
				try {
										
					System.out.print("ID(���� + ���� 8~15�ڸ�)�� �Է��ϼ��� �� ");
					id = sc.next();
					
					if(lists!=null){
						Iterator<GambleVO> it = lists.iterator();
					
						while(it.hasNext()){
						
							GambleVO ga = it.next();
							if(ga.getId().equals(id)){
								System.out.printf("������ ���̵� �����մϴ�.\n");
								
								System.out.print("�ٸ� ID�� �����Ͻðڽ��ϱ�?[Y/N] �� ");

								do{

									ch = (char) System.in.read();
									System.in.skip(2);

								}while(ch != 'y' && ch !='Y' && ch != 'n' && ch != 'N');

								if(ch == 'n' || ch =='N'){
									id = null;
									return;
									
								}if(ch =='y' || ch =='Y'){
									id = null;
								}

							}
							
						}
						
					}
					
					ge.inputIdcheck(id);
					
				} catch (Exception e) {
					
					System.out.println(e.toString());
					id = null;
					
				}
								
			}while(id==null);
			
			vo.setId(id);
					
			System.out.println("password ���Է½� �����ؾ��մϴ�");
					
			System.out.print("password �� ");
					
			vo.setPw1(sc.next());

			String pw1 = vo.getPw1(); 
					
			do{
						
				try {

					System.out.print("password ���Է� �� ");

					vo.setPw2(sc.next());

					String pw2 = vo.getPw2(); 

					s=1;

					if(!pw1.equals(pw2)){
						s =0;
					}
					
					ge.inputPwCheck(s);
					
				} catch (Exception e) {
					System.out.println(e.toString());
				}

			}while(s<=0);
				
			System.out.print("�̸� �� ");
			vo.setName(sc.next());
				
			do{
				try {
					
					System.out.print("����[M/F] �� ");
					vo.setGender(sc.next());
					
					s=1;
					
					if(!vo.getGender().equals("M")&&!vo.getGender().equals("F")&&
							!vo.getGender().equals("m")&&!vo.getGender().equals("f")){
						s =0;
					}
					
					ge.inputGdcheck(s);
					
				} catch (Exception e) {
					
					System.out.println(e.toString());
					
				}
				
			}while(s<=0);
			
			try {
				
				do{
					try {
						
						System.out.print("�ֹι�ȣ [xxxxxx-xxxxxxx] �� ");
						vo.setJumin(sc.next());
						
						ge.inputJaCheck(vo.getJumin());
						
					} catch (Exception e) {
						System.out.println(e);
					}
					
				}while(vo.getJumin().length()!=14);
				
				if(vo.getJumin().substring(0,1).equals("0") || vo.getJumin().substring(0,1).equals("1") || vo.getJumin().substring(0,1).equals("2")){
					
					sum = 2000 + Integer.parseInt(vo.getJumin().substring(0,1))*10 + Integer.parseInt(vo.getJumin().substring(1,2));
					
				}else{
					
					sum = 1900 + Integer.parseInt(vo.getJumin().substring(0,1))*10 + Integer.parseInt(vo.getJumin().substring(1,2));

				}				
				
				ge.inputJuCheck(sum);
				
			} catch (Exception e) {
								
				for(int i=0;i<hi.airplane.length;i++){
					
					System.out.println(hi.airplane[i]);

					try {

						sleep(100);

					} catch (Exception e1) {
												
					}
										
				}
				
				System.exit(0);
				
			}
			
			if(lists==null)
				lists = new ArrayList<GambleVO>();
				
			lists.add(vo);
			
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�!");	
			System.in.skip(50);
			
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			for(int i = 0; i < 100; ++i){ //��������

				System.out.println();

			}
			
	}

	@Override //ȸ���˻�
	public void search(){
		
		String searchId;
		
		if(lists==null || lists.isEmpty()==true){

			System.out.println("�Էµ� ȸ�� ������ �����ϴ�!!");
			System.out.println("ȸ�������� ������ �ּ���!!");	
			
			try {
				char ch = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //��������

				System.out.println();

			}

		}else{
		
			System.out.println("--------------------------");
			System.out.println("ȸ��ã��");

			System.out.print("ID�� �Է��ϼ��� �� ");
			searchId = sc.next();

			Iterator<GambleVO> it = lists.iterator();

			boolean flag = false;

			while(it.hasNext()){
				GambleVO vo = it.next();

				if(vo.getId().equals(searchId)){

					System.out.println("�˻��� ID ����");
					System.out.println(vo.toString());
					flag = true;

				}

			}

			if(flag==false){
				System.out.println("ȸ�������� �����ϴ�");
			}
			
			try {
				char ch = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //��������

				System.out.println();

			}
		
		}
		
	}

	@Override //ȸ������
	public void delete(){
	
		String id2;
		String pw2;
		int a=0, b=0;
		
		if(lists == null || lists.isEmpty()==true){
			
			System.out.println("�Էµ� ȸ�������� �����ϴ�!!");
			System.out.println("ȸ�������� ������ �ּ���!!");	

			
			try {
				char ch = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //��������

				System.out.println();

			}
			
		}else{
			
			System.out.println("---------------------");

			System.out.println("ȸ��Ż��");
			
			Iterator<GambleVO> it = lists.iterator();
			
			System.out.print("ID�� �Է��ϼ��� �� ");
			id2 = sc.next();
			
			while(it.hasNext()){
				
				GambleVO vo = it.next();
				
				if(vo.getId().equals(id2)){
					
					a++;
					
					System.out.print("password�� �Է��ϼ��� �� ");
					pw2 = sc.next();
					
					if(vo.getPw1().equals(pw2)){
						
						b++;
					
						lists.remove(vo);
						
						System.out.println("---------------------");
						System.out.println("ȸ��Ż�� �Ϸ� �Ǿ����ϴ�");
						break;
						
					}
					
				}
				
			}
			
			if(a==0){
				System.out.println("�Էµ� ȸ�������� �����ϴ�!!");
			}else if(b==0){
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�!!");
			}
			
			try {
				char ch = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //��������

				System.out.println();

			}
						
		}

	}

	@Override //���� ����
	public void writeFile(){
	
		try {
			if(lists!=null){
				
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos =  new ObjectOutputStream(fos);
				
				oos.writeObject(lists);
				fos.close();
				oos.close();
				
				System.out.println("�������强��!");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
