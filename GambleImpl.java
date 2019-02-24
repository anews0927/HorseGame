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
	
	public GambleImpl(){ //기본생성자(파일 불러오기)
		
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
	
	@Override //로그인
	public void login() throws IOException {

		GambleException ge = new GambleException();

		char ch;

		for(int i = 0; i < 100; ++i){ //공간생성

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

		if(lists==null || lists.isEmpty()==true){	//lists가 없거나 lists가 비었을 경우

			System.out.println("입력된 회원 정보가 없습니다!!");
			System.out.println("회원가입을 진행해 주세요!!");	
			
			try {	//enter 시 다음 화면으로 넘어감
				char enter = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //공간생성

				System.out.println();

			}

		}else{

			do{ //로그인 아이디 검색

				System.out.print("ID를 입력하세요 ▶ ");
				id=sc.next();

				Iterator<GambleVO> it = lists.iterator();

				while(it.hasNext()){

					GambleVO vo = it.next();

					if(vo.getId().equals(id)){
						
						do{// 로그인 비밀번호 검색

							System.out.print("password를 입력하세요 ▶ ");
							pw=sc.next();

							if(vo.getPw1().equals(pw)){

								m++;
								break;

							}

							if(m==0){

								System.out.println("password가 틀렸습니다!!!");

								System.out.print("password 다시 입력하시겠습니까?[Y/N] ▶ ");

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

					System.out.println("존재하지 않는 회원입니다 !!!");

					System.out.print("다른 ID로 로그인하시겠습니까?[Y/N] ▶ ");

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

			for(int i = 0; i < 20; ++i){ //공간생성

				System.out.println();

			}

			System.out.println("		            \\\\\\///             ");
			System.out.println("		           / _  _ \\            ");
			System.out.println("		         (| (.)(.) |)          ");
			System.out.println("		.------.OOOo--()--oOOO.------. ");
			System.out.println("		|                            | ");
			System.out.println("		" + id + "   님이 입장하셨습니다!!   ");
			System.out.println("		|                            | ");
			System.out.println("		'------.oooO-----------------' ");
			System.out.println("		        (   )   Oooo.          ");
			System.out.println(" 		        \\ (    (   )          ");
			System.out.println(" 		         \\_)    ) /           ");
			System.out.println("   			       (_/            ");
			
			//System.out.println("   " + id + " 님이 입장하셨습니다!");

			HorseStart t1 = new HorseStart();
			
			for(int i = 0; i < 15; ++i){ //공간생성

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
	
	@Override // 회원가입
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
			System.out.println("회원가입");
			
			GambleVO vo = new GambleVO();
			
			int s = 0;
			char ch;
			int a = 0;
						
			do{
				try {
										
					System.out.print("ID(영문 + 숫자 8~15자리)를 입력하세요 ▶ ");
					id = sc.next();
					
					if(lists!=null){
						Iterator<GambleVO> it = lists.iterator();
					
						while(it.hasNext()){
						
							GambleVO ga = it.next();
							if(ga.getId().equals(id)){
								System.out.printf("동일한 아이디가 존재합니다.\n");
								
								System.out.print("다른 ID로 가입하시겠습니까?[Y/N] ▶ ");

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
					
			System.out.println("password 재입력시 동일해야합니다");
					
			System.out.print("password ▶ ");
					
			vo.setPw1(sc.next());

			String pw1 = vo.getPw1(); 
					
			do{
						
				try {

					System.out.print("password 재입력 ▶ ");

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
				
			System.out.print("이름 ▶ ");
			vo.setName(sc.next());
				
			do{
				try {
					
					System.out.print("성별[M/F] ▶ ");
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
						
						System.out.print("주민번호 [xxxxxx-xxxxxxx] ▶ ");
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
			
			System.out.println("회원가입이 완료되었습니다!");	
			System.in.skip(50);
			
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			for(int i = 0; i < 100; ++i){ //공간생성

				System.out.println();

			}
			
	}

	@Override //회원검색
	public void search(){
		
		String searchId;
		
		if(lists==null || lists.isEmpty()==true){

			System.out.println("입력된 회원 정보가 없습니다!!");
			System.out.println("회원가입을 진행해 주세요!!");	
			
			try {
				char ch = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //공간생성

				System.out.println();

			}

		}else{
		
			System.out.println("--------------------------");
			System.out.println("회원찾기");

			System.out.print("ID를 입력하세요 ▶ ");
			searchId = sc.next();

			Iterator<GambleVO> it = lists.iterator();

			boolean flag = false;

			while(it.hasNext()){
				GambleVO vo = it.next();

				if(vo.getId().equals(searchId)){

					System.out.println("검색한 ID 정보");
					System.out.println(vo.toString());
					flag = true;

				}

			}

			if(flag==false){
				System.out.println("회원정보가 없습니다");
			}
			
			try {
				char ch = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //공간생성

				System.out.println();

			}
		
		}
		
	}

	@Override //회원삭제
	public void delete(){
	
		String id2;
		String pw2;
		int a=0, b=0;
		
		if(lists == null || lists.isEmpty()==true){
			
			System.out.println("입력된 회원정보가 없습니다!!");
			System.out.println("회원가입을 진행해 주세요!!");	

			
			try {
				char ch = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //공간생성

				System.out.println();

			}
			
		}else{
			
			System.out.println("---------------------");

			System.out.println("회원탈퇴");
			
			Iterator<GambleVO> it = lists.iterator();
			
			System.out.print("ID를 입력하세요 ▶ ");
			id2 = sc.next();
			
			while(it.hasNext()){
				
				GambleVO vo = it.next();
				
				if(vo.getId().equals(id2)){
					
					a++;
					
					System.out.print("password를 입력하세요 ▶ ");
					pw2 = sc.next();
					
					if(vo.getPw1().equals(pw2)){
						
						b++;
					
						lists.remove(vo);
						
						System.out.println("---------------------");
						System.out.println("회원탈퇴가 완료 되었습니다");
						break;
						
					}
					
				}
				
			}
			
			if(a==0){
				System.out.println("입력된 회원정보가 없습니다!!");
			}else if(b==0){
				System.out.println("비밀번호가 틀렸습니다!!");
			}
			
			try {
				char ch = (char) System.in.read();
				System.in.skip(2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < 100; ++i){ //공간생성

				System.out.println();

			}
						
		}

	}

	@Override //파일 저장
	public void writeFile(){
	
		try {
			if(lists!=null){
				
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos =  new ObjectOutputStream(fos);
				
				oos.writeObject(lists);
				fos.close();
				oos.close();
				
				System.out.println("파일저장성공!");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
