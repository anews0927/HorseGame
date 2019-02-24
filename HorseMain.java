package com.horse;

import java.util.Scanner;

public class HorseMain extends Thread{

	public static void main(String[] args) throws Exception {

		HorseStart hs = new HorseStart();
		HorseImage hi = new HorseImage();
		Gamble ob =  new GambleImpl();
		Scanner sc = new Scanner(System.in);
		HorseMain hm = new HorseMain();
		
		while(true){

			for(int i=0;i<hi.hormain.length;i++){
				System.out.println(hi.hormain[i]);

				try {
					sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			char in;

			System.out.println("**********************************선택해주세요**********************************");

			do{

				System.out.print("입력 ▶ ");
				in = (char) System.in.read();
				
				System.in.skip(50);
				
				if(in<'1'||in>'5'){
					System.out.println("잘못 입력하셨습니다!!");
				}

			}while(in<'1'||in>'5');
			
			switch (in) {  
			case '1':
				ob.login();break;
			case '2':
				ob.input(); ob.writeFile(); break;
			case '3':
				ob.search(); break;
			case '4':
				ob.delete(); ob.writeFile(); break;

			default: 
				for(int i = 0; i < 50; ++i){ //공간생성

					System.out.println();

				}
				for(int i=0;i<hi.ending.length;i++){	//엔딩크레딧
					System.out.println(hi.ending[i]);

					try {
						sleep(30);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				System.exit(0);
			}
		}
	}

}
