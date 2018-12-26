package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;


public class BankController {
	public void start() {
		MemberBean bean = null;
		MemberService service = new MemberServiceImpl();
		
		while(true) {
			switch(JOptionPane.showInputDialog("[메뉴]\n0.종료\n"
					+ "1.회원가입\n"
					+ "2.회원정보\n"
					+ "3.이름검색\n"
					+ "4.아이디검색\n"
					+ "5.회원수보기\n"
					+ "6.로그인\n"
					+ "7.비밀번호변경\n"
					+ "8.회원탈퇴\n")) {
			case "0" : 
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1" :
				service.join(
						JOptionPane.showInputDialog("아이디"),
						JOptionPane.showInputDialog("성명"),
						JOptionPane.showInputDialog("주민등록번호"),
						JOptionPane.showInputDialog("비밀번호"));
						break;
			case "2" :
				JOptionPane.showMessageDialog(null,service.findAll());
				break;
				
			case "3" :
				
				break;
				
			case "4" :
				JOptionPane.showMessageDialog(null,service.findById(JOptionPane.showInputDialog("찾을 아이디를 입력하세요")));
				break;
				
			case "5" :
				JOptionPane.showMessageDialog(null, service.countMember()+"명 입니다");
				
				break;
			case "6" :
				if(service.existMember(JOptionPane.showInputDialog("로그인하실 아이디 그리고"), JOptionPane.showInputDialog("비밀번호를 입력하세요"))) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				break;
			case "7" :
				
				break;
			case "8" :
				break;
				
			}
		}
	}
}
