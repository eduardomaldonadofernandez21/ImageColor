package com.mycompany.imagecolor;

import static com.mycompany.imagecolor.UtilsPractica5.seleccionarComponentes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Lienzo extends JPanel{
    private BufferedImage imagen = null;
    private BufferedImage base = null;
    private BufferedImage logo = null;
    private int posX;
    private int posY; 
    
    public Lienzo(){
        try {
            imagen = ImageIO.read(new URL("https://d25nlln9isiu5y.cloudfront.net/wp-content/uploads/2018/01/0028856119-1024x575.jpg"));
            logo = ImageIO.read(new File("bitcoin.png"));
            base = imagen;
            posX = 510;
            posY = -50;
            this.setPreferredSize(new Dimension(750, 450));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);    
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        if(logo == null || imagen == null){
            return;
        }
        super.paintComponent(g);
        g.drawImage(imagen.getScaledInstance(750, 450, Image.SCALE_DEFAULT),0,0,null);
        g.drawImage(logo.getScaledInstance(200, 150, Image.SCALE_DEFAULT),posX,posY, null);
        g.dispose();
    }
    
    public void checkBoxChange(boolean red, boolean green, boolean blue){
        imagen = seleccionarComponentes(base, red, green, blue);
        repaint();
    }
    
    public void setPositionLogo(int newX, int newY){
        posX = newX;
        posY = newY;
        repaint();
    }
    
    
}
