/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaslat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetailPesanan extends JFrame implements ActionListener{
    public JButton btnSelesai;
    
    public DetailPesanan(String nama, String telp, String kendaraan, int harga, int hari) {
        setTitle("Detail Penyewaan");
        setSize(400, 200);
        setLayout(new GridLayout(6, 1));
        setLocationRelativeTo(null);

        int totalHarga = harga * hari;

        add(new JLabel("Nama: " + nama));
        add(new JLabel("Nomor Telepon: " + telp));
        add(new JLabel("Kendaraan: " + kendaraan));
        add(new JLabel("Harga per hari: Rp " + harga));
        add(new JLabel("Total Harga: Rp " + totalHarga));

        btnSelesai = new JButton("Selesai");
        btnSelesai.addActionListener(this);
        add(btnSelesai);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelesai){
            System.exit(0);
        }
    }
}
