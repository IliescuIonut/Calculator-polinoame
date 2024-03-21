package GUI;
import javax.swing.*;
import java.awt.*;

public class Application extends JFrame{

     JButton plus;
     JButton minus;
     JButton multiplication;
     JButton division;
     JButton derivation;
     JButton integration;
     JTextField polinom1;
     JTextField polinom2;
     JTextField polinom3;
  public Application(){
       JFrame frame=new JFrame();

       plus=new JButton();
       plus.setBounds(556, 95, 64, 64);
       ImageIcon plusIcon=new ImageIcon("src/main/java/GUI/plus.png");
       plus.setIcon(plusIcon);
       plus.setBackground(new Color(38,38,38));
       plus.setBorder(BorderFactory.createEmptyBorder());

       minus=new JButton();
       minus.setBounds(640, 95, 64, 64);
       ImageIcon minusIcon=new ImageIcon("src/main/java/GUI/remove.png");
       minus.setIcon(minusIcon);
       minus.setBackground(new Color(38,38,38));
       minus.setBorder(BorderFactory.createEmptyBorder());

       multiplication=new JButton();
       multiplication.setBounds(556, 179, 64, 64);
       ImageIcon multIcon=new ImageIcon("src/main/java/GUI/multiplication.png");
       multiplication.setIcon(multIcon);
       multiplication.setBackground(new Color(38,38,38));
       multiplication.setBorder(BorderFactory.createEmptyBorder());

       division=new JButton();
       division.setBounds(640, 179, 64, 64);
       ImageIcon divIcon=new ImageIcon("src/main/java/GUI/division.png");
       division.setIcon(divIcon);
       division.setBackground(new Color(38,38,38));
       division.setBorder(BorderFactory.createEmptyBorder());

       derivation=new JButton();
       derivation.setBounds(556, 263, 64, 64);
       ImageIcon derIcon=new ImageIcon("src/main/java/GUI/math.png");
       derivation.setIcon(derIcon);
       derivation.setBackground(new Color(38,38,38));
       derivation.setBorder(BorderFactory.createEmptyBorder());

       integration=new JButton();
       integration.setBounds(640, 263, 64, 64);
       ImageIcon intIcon=new ImageIcon("src/main/java/GUI/integral-mathematical-sign.png");
       integration.setIcon(intIcon);
       integration.setBackground(new Color(38,38,38));
       integration.setBorder(BorderFactory.createEmptyBorder());

       JLabel linie1=new JLabel();
       linie1.setBounds(0, 0, 800, 20);
       linie1.setBackground(new Color(128, 128, 128));
       linie1.setOpaque(true);

       JLabel linie2=new JLabel();
       linie2.setBounds(440, 0, 40, 500);
       linie2.setBackground(new Color(128, 128, 128));
       linie2.setOpaque(true);

       JLabel linie3=new JLabel();
       linie3.setBounds(0, 445, 800, 20);
       linie3.setBackground(new Color(128, 128, 128));
       linie3.setOpaque(true);

       JLabel linie4=new JLabel();
       linie4.setBounds(0, 0, 20, 500);
       linie4.setBackground(new Color(128, 128, 128));
       linie4.setOpaque(true);

       JLabel linie5=new JLabel();
       linie5.setBounds(766, 0, 20, 500);
       linie5.setBackground(new Color(128, 128, 128));
       linie5.setOpaque(true);

       JLabel labelp1=new JLabel();
       labelp1.setBounds(50, 70, 360, 20);
       labelp1.setBackground(new Color(38,38, 38));
       labelp1.setForeground(new Color(255,255, 255));
       labelp1.setFont(new Font("Arial",Font.PLAIN,15));
       labelp1.setText("Polynomial 1 (mandatory):");
       polinom1=new JTextField();
       polinom1.setBounds(50, 100, 360, 50);
       polinom1.setBackground(new Color(38,38, 38));
       polinom1.setForeground(new Color(255,255, 255));
       polinom1.setFont(new Font("Consolas",Font.PLAIN,20));
       polinom1.setBorder(BorderFactory.createLineBorder(new Color(128, 128, 128),5));
       polinom1.setCaretColor(Color.white);

       JLabel labelp2=new JLabel();
       labelp2.setBounds(50, 170, 360, 20);
       labelp2.setBackground(new Color(38,38, 38));
       labelp2.setForeground(new Color(255,255, 255));
       labelp2.setFont(new Font("Arial",Font.PLAIN,15));
       labelp2.setText("Polynomial 2:");
       polinom2=new JTextField();
       polinom2.setBounds(50, 200, 360, 50);
       polinom2.setBackground(new Color(38,38, 38));
       polinom2.setForeground(new Color(255,255, 255));
       polinom2.setFont(new Font("Consolas",Font.PLAIN,20));
       polinom2.setBorder(BorderFactory.createLineBorder(new Color(128, 128, 128),5));
       polinom2.setCaretColor(Color.white);

       JLabel labelp3=new JLabel();
       labelp3.setBounds(50, 270, 360, 20);
       labelp3.setBackground(new Color(38,38, 38));
       labelp3.setForeground(new Color(255,255, 255));
       labelp3.setFont(new Font("Arial",Font.PLAIN,15));
       labelp3.setText("Result:");
       polinom3=new JTextField();
       polinom3.setBounds(50, 300, 360, 50);
       polinom3.setBackground(new Color(38,38, 38));
       polinom3.setForeground(new Color(255,255, 255));
       polinom3.setFont(new Font("Consolas",Font.PLAIN,20));
       polinom3.setBorder(BorderFactory.createLineBorder(new Color(128, 128, 128),5));
       polinom3.setEditable(false);
       polinom3.setCaretColor(Color.white);

       frame.setTitle("POLYNOMIAL CALCULATOR");
       frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       frame.setResizable(false);
       frame.setSize(800, 500);
       ImageIcon icon=new ImageIcon("src/main/java/GUI/calculator.png");
       frame.setIconImage(icon.getImage());
       frame.getContentPane().setBackground(new Color(38,38,38));
       frame.setLocationRelativeTo(null);
       frame.setLayout(null);
       frame.add(plus);
       frame.add(minus);
       frame.add(multiplication);
       frame.add(division);
       frame.add(derivation);
       frame.add(integration);
       frame.add(linie1);
       frame.add(linie2);
       frame.add(linie3);
       frame.add(linie4);
       frame.add(linie5);
       frame.add(polinom1);
       frame.add(labelp1);
       frame.add(polinom2);
       frame.add(labelp2);
       frame.add(polinom3);
       frame.add(labelp3);
       frame.setVisible(true);
   }
}
