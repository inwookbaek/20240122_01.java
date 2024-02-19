package com.lec.board;

import javax.swing.JOptionPane;

public class BoardMenu {

	private double ver;
	
	public BoardMenu(double ver) {
		this.ver = ver;
	}
	
	public void mainBoardMenu() {
		
		BoardDAOImpl bddao = BoardFactory.getInstance();
		
		while(true) {
			int menuNo = mainMenuUi();
			switch(menuNo) {
			case 1: makeBoard(bddao); break;
			case 2: System.out.println("게시판목록조회"); break;
			case 3: System.out.println("게시판상세보기"); break;
			case 4: System.out.println("게시판수정하기"); break;
			case 5: System.out.println("게시판삭제하기"); break;
			case 6: System.out.println("게시판검색하기(제목)"); break;
			case 7: System.out.println("게시판검색하기(작성자)"); break;
			case 0: System.out.println("프로그램종료"); System.exit(0);
			}	
		}
	}

	private void makeBoard(BoardDAOImpl bddao) {
		bddao.createBoard();
	}

	private int mainMenuUi() {
		String menuNo = JOptionPane.showInputDialog(
				"==== 게시판관리프로그램 V"+this.ver + " ====\n\n" + 
			    "1. 새로운 글쓰기\n" +
			    "2. 전체글 목록 조회\n" +
			    "3. 본문글 보기\n" +
			    "4. 본문글 수정\n" +
			    "5. 본문글 삭제\n" +
			    "6. 제목으로 검색하기\n" +
			    "7. 작성자로 검색하기\n" +
			    "0. 종료\n\n" +
			    "처리할 작업번호를 입력하세요!!"
		);
		if((menuNo == null) || (menuNo.equals(""))) {
			return 0;
		} else {
			return Integer.parseInt(menuNo);
		}
	}
	
}
