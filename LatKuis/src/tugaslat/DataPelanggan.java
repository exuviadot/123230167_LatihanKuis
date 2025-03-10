package tugaslat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DataPelanggan extends JFrame implements ActionListener {
    public JButton btnSimpan;
    private JTextField namaField, telpField, hariField;
    private JRadioButton[] kendaraanOptions;
    private ButtonGroup kendaraanGroup;
    private String jenisKendaraan;
    private int[] harga = {50000, 70000, 100000};

    public DataPelanggan(String jenis) {
        this.jenisKendaraan = jenis;
        setTitle("Detail Penyewaan - " + jenis);
        setSize(400, 300);
        setLayout(new GridLayout(6, 1));
        setLocationRelativeTo(null);

        namaField = new JTextField(20);
        telpField = new JTextField(20);
        hariField = new JTextField(5);

        add(new JLabel("Nama Penyewa:"));
        add(namaField);
        add(new JLabel("Nomor Telepon:"));
        add(telpField);
        add(new JLabel("Jumlah Hari Sewa:"));
        add(hariField);

        kendaraanOptions = new JRadioButton[3];
        kendaraanGroup = new ButtonGroup();
        JPanel kendaraanPanel = new JPanel(new GridLayout(3, 1));

        // Sesuaikan nama kendaraan berdasarkan jenis kendaraan
        String[] kendaraanNama;
        if (jenis.equals("Mobil")) {
            kendaraanNama = new String[]{"Avanza", "Ertiga", "Pajero"};
        } else {
            kendaraanNama = new String[]{"Beat", "Vario", "NMax"};
        }

        for (int i = 0; i < kendaraanOptions.length; i++) {
            kendaraanOptions[i] = new JRadioButton(kendaraanNama[i] + " - Rp " + harga[i]);
            kendaraanGroup.add(kendaraanOptions[i]);
            kendaraanPanel.add(kendaraanOptions[i]);
        }

        add(kendaraanPanel);

        btnSimpan = new JButton("Simpan");
        btnSimpan.addActionListener(this);
        add(btnSimpan);

        setVisible(true);
    }

    private void simpanData() {
        try {
            String nama = namaField.getText();
            String telp = telpField.getText();
            int hari = Integer.parseInt(hariField.getText());

            if (nama.isEmpty() || telp.isEmpty()) {
                throw new Exception("Nama dan nomor telepon tidak boleh kosong!");
            }

            int hargaTerpilih = -1;
            String kendaraanTerpilih = "";
            for (int i = 0; i < kendaraanOptions.length; i++) {
                if (kendaraanOptions[i].isSelected()) {
                    hargaTerpilih = harga[i];
                    kendaraanTerpilih = kendaraanOptions[i].getText();
                    break;
                }
            }

            if (hargaTerpilih == -1) {
                throw new Exception("Pilih salah satu kendaraan!");
            }

            new DetailPesanan(nama, telp, kendaraanTerpilih, hargaTerpilih, hari);
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Jumlah hari harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSimpan) {
            simpanData();
        }
    }
}
