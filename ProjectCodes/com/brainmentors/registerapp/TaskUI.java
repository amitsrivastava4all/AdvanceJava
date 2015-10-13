package com.brainmentors.registerapp;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TaskUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TrayIcon trayIcon;
    SystemTray tray;
	
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		
					TaskUI frame = new TaskUI();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 * @throws URISyntaxException 
	 * @throws MalformedURLException 
	 */
	public TaskUI() throws MalformedURLException, URISyntaxException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 418);
		this.getContentPane().setLayout(null);
		
		JLabel lblTodoListApp = new JLabel("Todo List App");
		lblTodoListApp.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblTodoListApp.setBounds(153, 95, 287, 72);
		getContentPane().add(lblTodoListApp);
		 if(SystemTray.isSupported()){
	            System.out.println("system tray supported");
	            tray=SystemTray.getSystemTray();

	            Image image=Toolkit.getDefaultToolkit().getImage(TaskUI.class.getResource("bmlogo.png").toURI().toURL());
	            ActionListener exitListener=new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("Exiting....");
	                    System.exit(0);
	                }
	            };
	
		 PopupMenu popup=new PopupMenu();
         MenuItem defaultItem=new MenuItem("Exit ToDoList App");
         defaultItem.addActionListener(exitListener);
         popup.add(defaultItem);
         defaultItem=new MenuItem("Open TodoList App");
         defaultItem.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 setVisible(true);
                 setExtendedState(JFrame.NORMAL);
             }
         });
         popup.add(defaultItem);
         trayIcon=new TrayIcon(image, "SystemTray Demo", popup);
         trayIcon.setImageAutoSize(true);
     }else{
         System.out.println("system tray not supported");
     }
     addWindowStateListener(new WindowStateListener() {
         public void windowStateChanged(WindowEvent e) {
             if(e.getNewState()==ICONIFIED){
                 try {
                     tray.add(trayIcon);
                     setVisible(false);
                     System.out.println("added to SystemTray");
                 } catch (AWTException ex) {
                     System.out.println("unable to add to tray");
                 }
             }
     if(e.getNewState()==7){
                 try{
         tray.add(trayIcon);
         setVisible(false);
         System.out.println("added to SystemTray");
         }catch(AWTException ex){
         System.out.println("unable to add to system tray");
     }
         }
     if(e.getNewState()==MAXIMIZED_BOTH){
                 tray.remove(trayIcon);
                 setVisible(true);
                 System.out.println("Tray icon removed");
             }
             if(e.getNewState()==NORMAL){
                 tray.remove(trayIcon);
                 setVisible(true);
                 System.out.println("Tray icon removed");
             }
         }
     });
     setIconImage(Toolkit.getDefaultToolkit().getImage(TaskUI.class.getResource("bmlogo.png").toURI().toURL()));
	 
	}
}
