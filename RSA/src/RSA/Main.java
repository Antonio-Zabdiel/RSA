package RSA;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Main 
{     
    static JButton panelbtn, cipherbtn, decipherbtn;
    static RSA rsa;
    
    public static void main(String[] args) throws Exception 
    {
        rsa = new RSA();
        
        JFrame frame = new JFrame("RSA");      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        frame.setSize(900, 550); 
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        String panelstr="  generar clave publica y privada";
        JLabel panellabel = new JLabel(panelstr);
        JTextArea panelpublictxt = new JTextArea(2, 5);
        panelpublictxt.setLineWrap(true);
        panelpublictxt.setWrapStyleWord(true);
        panelpublictxt.setEditable(false);
        JLabel panelpublic = new JLabel("clave publica: ");
        JTextArea panelprivatetxt = new JTextArea(2, 5);
        panelprivatetxt.setLineWrap(true);
        panelprivatetxt.setWrapStyleWord(true);
        panelprivatetxt.setEditable(false);
        JLabel keygenprivate = new JLabel("clabe privada: ");
        panelbtn = new JButton("generar claves");
        
        panelbtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String[] keys=rsa.getKeys();
                panelpublictxt.setText(keys[0]);
                panelprivatetxt.setText(keys[1]);
            }
        });
        
        panel.add(panellabel);
        panel.add(panelpublic);
        panel.add(panelpublictxt);
        panel.add(keygenprivate);
        panel.add(panelprivatetxt);
        panel.add(panelbtn);
        
        
        JPanel cipher = new JPanel();
        cipher.setLayout(new BoxLayout(cipher, BoxLayout.Y_AXIS));
        JLabel cipherin = new JLabel("Inserte numero a cifrar o valor cifrado: ");
        JTextArea cipherintxt = new JTextArea(5, 20);
        
        cipherintxt.setLineWrap(true);
        cipherintxt.setWrapStyleWord(true);
        
        JLabel cipherkey = new JLabel("ingrese la clave a usar: ");
        JTextArea cipherkeytxt = new JTextArea(5, 20);
        
        cipherkeytxt.setLineWrap(true);
        cipherkeytxt.setWrapStyleWord(true);
        
        cipher.add(cipherin);
        cipher.add(cipherintxt);
        cipher.add(cipherkey);
        cipher.add(cipherkeytxt);
        
        JLabel cipherres = new JLabel("valor resultante: ");
        JTextArea cipherrestxt = new JTextArea(5, 20);
        
        cipherrestxt.setLineWrap(true);
        cipherrestxt.setWrapStyleWord(true);
        cipherrestxt.setEditable(false);
        
        
        cipherbtn=new JButton("cifrar");
        
        cipherbtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res=rsa.cifrar(cipherintxt.getText(), cipherkeytxt.getText());
                cipherrestxt.setText(res);
            }
        });
        
        
        decipherbtn=new JButton("descifrar");
        
        decipherbtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res=rsa.decifrar(cipherintxt.getText(), cipherkeytxt.getText());
                cipherrestxt.setText(res);
            }
        });
        
        cipher.add(cipherres);
        cipher.add(cipherrestxt);
        cipher.add(cipherbtn);
        cipher.add(decipherbtn);
        
        
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, cipher);
        
        frame.setVisible(true); 
    }
}
