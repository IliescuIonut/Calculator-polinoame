package GUI;

import BusinessLogic.DivideBy0;
import BusinessLogic.InvalidInput;
import BusinessLogic.MissingInput;
import DataModels.Polynomial;
import BusinessLogic.Operations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends Application {
    public Controller()
    {
        Operations op=new Operations();
     plus.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
             try {
                 Polynomial p1 = op.stringToPol(polinom1.getText());
                 Polynomial p2 = op.stringToPol(polinom2.getText());
                 polinom3.setText(op.addition(p1, p2).toString());
             }catch(MissingInput x){
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),x.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             } catch (InvalidInput ex) {
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }
         }
     });
     minus.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 Polynomial p1 = op.stringToPol(polinom1.getText());
                 Polynomial p2 = op.stringToPol(polinom2.getText());
                 polinom3.setText(op.subtraction(p1, p2).toString());
             }catch(MissingInput x){
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),x.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }catch (InvalidInput ex) {
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }
         }

     });
     multiplication.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
                Polynomial p1 = op.stringToPol(polinom1.getText());
                Polynomial p2 = op.stringToPol(polinom2.getText());
                polinom3.setText(op.product(p1, p2).toString());
            }catch(MissingInput x){
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),x.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            }catch (InvalidInput ex) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            }
         }
     });
     division.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 Polynomial p1 = op.stringToPol(polinom1.getText());
                 Polynomial p2 = op.stringToPol(polinom2.getText());
                 polinom3.setText(op.division(p1, p2).toString());
             }catch(MissingInput x){
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),x.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             } catch (DivideBy0 ex) {
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }catch (InvalidInput ex) {
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }
         }
     });
     derivation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 Polynomial p1 = op.stringToPol(polinom1.getText());
                 polinom3.setText(op.derivate(p1).toString());
             }catch(MissingInput x){
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),x.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }catch (InvalidInput ex) {
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }
         }
     });
     integration.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             try {
                 Polynomial p1 = op.stringToPol(polinom1.getText());
                 polinom3.setText(op.integration(p1));
             }catch(MissingInput x){
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),x.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }catch (InvalidInput ex) {
                 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
             }
         }
     });
    }
}
