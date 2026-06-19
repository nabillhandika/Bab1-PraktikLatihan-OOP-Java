package tutorialjava;

import koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormSiswa extends JFrame {

    // Deklarasi Komponen
    private JLabel lblTitle, lblNis, lblNama, lblJurusan, lblJk, lblAlamat;
    private JTextField txtNis, txtNama;
    private JComboBox<String> cbJurusan, cbJk;
    private JTextArea txtAlamat;
    private JScrollPane scrollAlamat, scrollTable;
    private JButton btnSimpan, btnHapus, btnUpdate, btnReset;
    private JTable tableSiswa;
    private DefaultTableModel tableModel;

    public FormSiswa() {

        // Pengaturan JFrame
        setTitle("Form Siswa");
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Judul
        lblTitle = new JLabel("Form Siswa");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setBounds(50, 20, 200, 40);
        add(lblTitle);

        // NIS
        lblNis = new JLabel("NIS");
        lblNis.setBounds(20, 80, 80, 25);
        add(lblNis);

        txtNis = new JTextField();
        txtNis.setBounds(100, 80, 240, 25);
        add(txtNis);

        // Nama
        lblNama = new JLabel("Nama");
        lblNama.setBounds(20, 115, 80, 25);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(100, 115, 240, 25);
        add(txtNama);

        // Jurusan
        lblJurusan = new JLabel("Jurusan");
        lblJurusan.setBounds(20, 150, 80, 25);
        add(lblJurusan);

        String[] jurusan = {
            "Rekayasa Perangkat Lunak",
            "Teknik Komputer Jaringan",
            "Multimedia"
        };

        cbJurusan = new JComboBox<>(jurusan);
        cbJurusan.setBounds(100, 150, 240, 25);
        add(cbJurusan);

        // JK
        lblJk = new JLabel("JK");
        lblJk.setBounds(20, 185, 80, 25);
        add(lblJk);

        String[] jk = {"Laki-laki", "Perempuan"};

        cbJk = new JComboBox<>(jk);
        cbJk.setBounds(100, 185, 240, 25);
        add(cbJk);

        // Alamat
        lblAlamat = new JLabel("Alamat");
        lblAlamat.setBounds(20, 220, 80, 25);
        add(lblAlamat);

        txtAlamat = new JTextArea();
        scrollAlamat = new JScrollPane(txtAlamat);
        scrollAlamat.setBounds(100, 220, 240, 100);
        add(scrollAlamat);

        // Tombol
        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(100, 335, 115, 30);
        add(btnSimpan);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(225, 335, 115, 30);
        add(btnHapus);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100, 370, 115, 30);
        add(btnUpdate);

        btnReset = new JButton("Reset");
        btnReset.setBounds(225, 370, 115, 30);
        add(btnReset);

        // Table
        String[] kolom = {
            "NIS", "Nama", "Jurusan", "JK", "Alamat"
        };

        tableModel = new DefaultTableModel(kolom, 0);
        tableSiswa = new JTable(tableModel);

        scrollTable = new JScrollPane(tableSiswa);
        scrollTable.setBounds(360, 80, 450, 315);
        add(scrollTable);

        // Tampilkan data
        tampilData();

        // Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn = koneksi.Koneksi();

                    String sql = "INSERT INTO students (nis, nama, jurusan, jk, alamat) VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement pst = cn.prepareStatement(sql);

                    pst.setString(1, txtNis.getText());
                    pst.setString(2, txtNama.getText());
                    pst.setString(3, cbJurusan.getSelectedItem().toString());
                    pst.setString(4, cbJk.getSelectedItem().toString());
                    pst.setString(5, txtAlamat.getText());

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

                    tampilData();
                    resetForm();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        // Klik table
        tableSiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = tableSiswa.getSelectedRow();

                txtNis.setText(tableModel.getValueAt(row, 0).toString());
                txtNama.setText(tableModel.getValueAt(row, 1).toString());
                cbJurusan.setSelectedItem(tableModel.getValueAt(row, 2).toString());
                cbJk.setSelectedItem(tableModel.getValueAt(row, 3).toString());
                txtAlamat.setText(tableModel.getValueAt(row, 4).toString());

                txtNis.setEditable(false);
            }
        });

        // Update
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Connection cn = koneksi.Koneksi();

                    String sql = "UPDATE students SET nama=?, jurusan=?, jk=?, alamat=? WHERE nis=?";

                    PreparedStatement pst = cn.prepareStatement(sql);

                    pst.setString(1, txtNama.getText());
                    pst.setString(2, cbJurusan.getSelectedItem().toString());
                    pst.setString(3, cbJk.getSelectedItem().toString());
                    pst.setString(4, txtAlamat.getText());
                    pst.setString(5, txtNis.getText());

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

                    tampilData();
                    resetForm();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        // Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int jawab = JOptionPane.showConfirmDialog(
                            null,
                            "Yakin ingin menghapus?",
                            "Konfirmasi",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (jawab == JOptionPane.YES_OPTION) {

                        Connection cn = koneksi.Koneksi();

                        String sql = "DELETE FROM students WHERE nis=?";

                        PreparedStatement pst = cn.prepareStatement(sql);
                        pst.setString(1, txtNis.getText());

                        pst.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

                        tampilData();
                        resetForm();
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        // Reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
    }

    // Method tampil data
    public void tampilData() {

        tableModel.setRowCount(0);

        try {

            Connection cn = koneksi.Koneksi();
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {

                tableModel.addRow(new Object[]{
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("jurusan"),
                    rs.getString("jk"),
                    rs.getString("alamat")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Reset form
    public void resetForm() {
        txtNis.setText("");
        txtNama.setText("");
        cbJurusan.setSelectedIndex(0);
        cbJk.setSelectedIndex(0);
        txtAlamat.setText("");
        txtNis.setEditable(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormSiswa().setVisible(true);
            }
        });
    }
}