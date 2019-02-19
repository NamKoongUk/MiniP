package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.UserManager;
import model.vo.User;


public class UserInfoPage extends JPanel implements KeyListener{
	
	private MainFrame mf;
	private JPanel uip;
	private UserMenuPage ump;
	
	private JLabel charactorLabel = new JLabel(new ImageIcon("images/userMenuImages/userImage.PNG"));
	private Image userInfoBackground = new ImageIcon("images/userInfoPage.png").getImage();
	private JLabel playTimeLabel;
	private JLabel createTime;
	private JLabel goldLabel;
	private JLabel getPokeLabel;
	private JLabel userNameLabel;
	private JButton backButton = new JButton(new ImageIcon("images/userMenuImages/backButtonBasic.PNG"));
	private User user;
	
	public UserInfoPage(MainFrame mf,UserMenuPage ump,User user) {
		UserManager um = new UserManager(user);
		System.out.println("유저 정보 페이지");
		System.out.println(user);
		this.mf = mf;
		this.uip = this;
		this.ump = ump;
		uip.setOpaque(false);
		uip.setBounds(0, 0, 1024, 768);
		

		
		userNameLabel = um.viewUserName();
		playTimeLabel = new JLabel();
		//playTimeLabel.setText(um.viewUserTime());
		playTimeLabel.setText(Integer.toString(user.getScd()) + "초");
		createTime = um.viewCreateTime();
		goldLabel = um.getUserGold();
		getPokeLabel = um.viewUserGetPoke();
		
		mf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == UserMenuPage.ESC) {
					mf.remove(uip);
					uip.setVisible(false);
				}
			}
		});
		JLabel label = new JLabel();
		label.setText("유저 정보 페이지");

		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);
		backButton.setBounds(900, 610, 90, 120);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		//뒤로가기 버튼
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(new ImageIcon("images/userMenuImages/backButtonEntered.PNG"));
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(new ImageIcon("images/userMenuImages/backButtonBasic.PNG"));
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				mf.remove(uip);
				ump.setVisible(true);
				mf.requestFocus();
			}
		});
		
		label.setBounds(450, 20, 200, 40);
		
		charactorLabel.setBounds(150, 190, 250, 450);
		userNameLabel.setBounds(680, 115, 200, 120);
		createTime.setBounds(753, 278, 300, 120);
		createTime.setFont(new Font("",Font.CENTER_BASELINE, 18));
		playTimeLabel.setBounds(830, 350, 300,100);
		playTimeLabel.setFont(new Font("",Font.CENTER_BASELINE, 18));
		goldLabel.setBounds(550, 460, 300, 100);
		getPokeLabel.setBounds(550, 550, 300, 100);
		
		
		this.add(label);
		this.add(backButton);
		this.add(charactorLabel);
		this.add(userNameLabel);
		this.add(playTimeLabel);
		this.add(createTime);
		this.add(goldLabel);
		this.add(getPokeLabel);
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	   public void paintComponent(Graphics g) {
		   
		      g.drawImage(userInfoBackground, 0, 0, 1024, 729, this);
	   }
}
