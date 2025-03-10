/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaslat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OpsiKendaraan extends JFrame implements ActionListener{
    public JButton btnMobil;
    public JButton btnMotor;
    
    public OpsiKendaraan() {
        setTitle("Pilih Kendaraan");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        btnMobil = new JButton("Mobil");
        btnMotor = new JButton("Motor");
        
        btnMobil.addActionListener(this);
        btnMotor.addActionListener(this);

        add(new JLabel("Pilih Kendaraan:"));
        add(btnMobil);
        add(btnMotor);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnMobil){
            new DataPelanggan("Mobil");
        } else if(e.getSource() == btnMotor){
            new DataPelanggan("Motor");
        }
    }
}
