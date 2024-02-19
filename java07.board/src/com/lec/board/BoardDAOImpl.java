package com.lec.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

public class BoardDAOImpl implements BoardDAOService {

	private BoardVO inputBoard() {
		
		BoardVO board = new BoardVO();
		
		String subjet = JOptionPane.showInputDialog("글제목을 입력하세요!");
		String writer = JOptionPane.showInputDialog("작성자를 입력하세요!");
		String content = JOptionPane.showInputDialog("글내용을 입력하세요!");

		board.setSubject(subjet);
		board.setWriter(writer);
		board.setContent(content);
		
		return board;
	}
	
	@Override
	public void createBoard() {
		// 글제목, 작성자, 글내용
		BoardVO board = inputBoard();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnetion();
		PreparedStatement pstmt = null;
		String sql = cf.getInsert();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			int row = pstmt.executeUpdate();
			System.out.println(row + "건이 성공적으로 등록되었습니다!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// dummy
			}
		}
	}

	@Override
	public ArrayList<BoardVO> listBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO viewBoard(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(int bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BoardVO> findBySubjectBoard(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> findByWriterBoard(String writer) {
		// TODO Auto-generated method stub
		return null;
	}

}
