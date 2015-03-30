package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UnitPanel extends GoalPanel {
	
	String unitName;
	Color c;
	JTextField input;
	JLabel pic;
	JLabel  name;
	boolean hasError;
	BufferedImage image;
	
	public static final String iconLocation = "img/";
	
	public UnitPanel(String unitName){
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
				
		this.unitName = unitName;
		Random r = new Random();
		this.c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

		
		try {
			System.out.println(unitName);
			image = ImageIO.read(new File(iconLocation + unitName + ".jpeg" ));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		input = new JTextField();
		pic = new JLabel(new ImageIcon(image));	
		

		
		
		
		name = new JLabel(unitName);
		
		c.gridx =0;
		c.gridy=0;
		c.gridheight=2;
		add(pic,c);
		
		c.gridx=1;
		c.gridheight=1;
		add(name,c);
		
		c.gridx=1;
		c.gridy=1;
		add(input,c);
		
		setPreferredSize(new Dimension(150,50));
		
	}
	
	public void paintComponent(Graphics g){
		g.setColor(c);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public String getUnitName(){
		return unitName;
	}
	
	public int getNumber() {
		int number = 0;
		try {
			String text = input.getText();
			number = Integer.parseInt(text);
		}catch (NumberFormatException | NullPointerException e){
			this.hasError = true;
		}
		return number;
	}
	
}
