package cn.com.bluemoon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.InputStream;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class CPOMain {

	private JFrame frmF;
	private JTextField tableNameJTF;
	private JTextField packagePathJTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPOMain window = new CPOMain();
					window.frmF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CPOMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmF = new JFrame();
		frmF.setResizable(false);
		frmF.setTitle("mallerp\u7EC4DAO\u4E13\u7528\u751F\u6210\u5668V2.1");
		frmF.setBounds(100, 100, 450, 300);
		frmF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmF.getContentPane().setLayout(null);
		frmF.setSize(450, 203);
		frmF.setLocationRelativeTo(null);// 居中

		tableNameJTF = new JTextField();
		tableNameJTF.setText("\u8BF7\u8F93\u5165\u8868\u540D");
		tableNameJTF.setBounds(83, 13, 278, 24);
		tableNameJTF.setColumns(10);
		frmF.getContentPane().add(tableNameJTF);

		packagePathJTF = new JTextField();
		packagePathJTF.setToolTipText("\u8BF7\u8F93\u5165\u5305\u540D");
		packagePathJTF.setText("\u8BF7\u8F93\u5165\u5305\u540D");
		packagePathJTF.setColumns(10);
		packagePathJTF.setBounds(83, 59, 278, 24);
		frmF.getContentPane().add(packagePathJTF);

		JButton btnpo = new JButton("\u751F\u6210PO");
		btnpo.setBounds(50, 105, 344, 27);
		frmF.getContentPane().add(btnpo);
		
		JMenuBar menuBar = new JMenuBar();
		frmF.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u8BBE\u7F6E");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6570\u636E\u5E93\u914D\u7F6E");
		menu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u6587\u6863");
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5173\u4E8E");
		mnNewMenu.add(menuItem_1);

		btnpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tableName = tableNameJTF.getText().trim();
				String packagePath = packagePathJTF.getText().trim();
				if (tableName.equals("请输入表名") || packagePath.equals("请输入包名")) {
					/*
					 * JOptionPane.showMessageDialog(null,
					 * ClassLoader.getSystemResource(""));
					 * JOptionPane.showMessageDialog(null,
					 * CPOMain.class.getResource(""));
					 * JOptionPane.showMessageDialog(null,
					 * CPOMain.class.getResource("/"));
					 * JOptionPane.showMessageDialog(null, new
					 * File("/").getAbsolutePath());
					 * JOptionPane.showMessageDialog(null,
					 * System.getProperty("user.dir"));
					 * JOptionPane.showMessageDialog(null,
					 * CPOMain.class.getClassLoader().getResource(".").getPath()
					 * ); JOptionPane.showMessageDialog(null,
					 * FileSystemView.getFileSystemView().getHomeDirectory());
					 */
					/*try {
						System.out.println(ClassLoader.getSystemResource(""));
						System.out.println(CPOMain.class.getResource(""));
						System.out.println(CPOMain.class.getResource("/"));
						System.out.println(new File("/").getAbsolutePath());
						System.out.println(System.getProperty("user.dir"));
						
						 * System.out.println(CPOMain.class.getClassLoader().
						 * getResource(".").getPath()); System.out.println(
						 * FileSystemView.getFileSystemView().getHomeDirectory()
						 * );
						 
						JOptionPane.showMessageDialog(null, this.getClass() == null);
						InputStream is = CPOMain.class.getResourceAsStream("generatorConfig1.xml");
						System.out.println(is == null);
						String xsss = "is==null:" + (is == null);
						JOptionPane.showMessageDialog(null, xsss);
						File configFile = new File("Class-Path*:generatorConfig.xml");// new
																						// File("config/generatorConfig.xml");
						JOptionPane.showMessageDialog(null, "文件是否存在--" + configFile.exists());
						File configFile1 = new File(System.getProperty("user.dir") + "\\generatorConfig.xml");
						JOptionPane.showMessageDialog(null, "文件是否存在--" + configFile1.exists());
						JOptionPane.showMessageDialog(null, "输入有错");
					} catch (Exception eee) {
						JOptionPane.showMessageDialog(null, eee.getStackTrace());
					}*/
					JOptionPane.showMessageDialog(null, "输入有错");
					return;
				}
				try {
					JOptionPane.showMessageDialog(null, GeneratorSqlmap.generator(tableName, packagePath));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getStackTrace());
				}
			}
		});
	}
}
