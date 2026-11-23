import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LatihanGUI extends JFrame implements ActionListener {

  
    private BorderLayout layoutUtama;
    private GridLayout layoutAtas;
    private BorderLayout layoutTengah;
    private GridLayout layoutForm;
    private FlowLayout layoutTombol;
    private BorderLayout layoutHasil;

   
    private JPanel panelAtas;
    private JPanel panelTengah;
    private JPanel panelForm;
    private JPanel panelTombol;
    private JPanel panelHasil;

   
    private ImageIcon gambarMinato;
    private JLabel labelJudul;
    private JLabel labelGambar;
    private JLabel labelNama;
    private JLabel labelNim;
    private JLabel labelProdi;
    private JLabel labelKonfirmasi;
    private JLabel labelHasil;
    private JLabel labelStatus;
    private JTextField isianNama;
    private JTextField isianNim;
    private JComboBox<String> pilihanProdi;
    private JCheckBox checkKonfirmasi;
    private JTextArea areaHasil;
    private JScrollPane scrollHasil;
    private JButton tombolSimpan;
    private JButton tombolReset;
    private JButton tombolKeluar;

    public LatihanGUI() {
        layoutUtama = new BorderLayout(0, 8);
        layoutAtas = new GridLayout(2, 1, 0, 4);
        layoutTengah = new BorderLayout(0, 8);
        layoutForm = new GridLayout(4, 2, 8, 8);
        layoutTombol = new FlowLayout(FlowLayout.CENTER, 12, 0);
        layoutHasil = new BorderLayout(0, 4);

        panelAtas = new JPanel();
        panelTengah = new JPanel();
        panelForm = new JPanel();
        panelTombol = new JPanel();
        panelHasil = new JPanel();

        gambarMinato = new ImageIcon("assets/minato.png");
        labelJudul = new JLabel("Form Biodata Mahasiswa", SwingConstants.CENTER);
        labelGambar = new JLabel(gambarMinato, SwingConstants.CENTER);
        labelNama = new JLabel("Nama Lengkap");
        labelNim = new JLabel("NIM");
        labelProdi = new JLabel("Program Studi");
        labelKonfirmasi = new JLabel("Konfirmasi");
        labelHasil = new JLabel("Hasil Input");
        labelStatus = new JLabel("Siap");

        isianNama = new JTextField();
        isianNim = new JTextField();
        pilihanProdi = new JComboBox<String>();
        pilihanProdi.addItem("Teknik Informatika");
        pilihanProdi.addItem("Sistem Informasi");
        pilihanProdi.addItem("Ilmu Komputer");
        checkKonfirmasi = new JCheckBox("Data yang diisi sudah benar");

        areaHasil = new JTextArea(5, 20);
        areaHasil.setEditable(false);
        scrollHasil = new JScrollPane(areaHasil);

        tombolSimpan = new JButton("Simpan");
        tombolReset = new JButton("Reset");
        tombolKeluar = new JButton("Keluar");

        labelJudul.setFont(new Font("Arial", Font.BOLD, 18));
        labelHasil.setFont(new Font("Arial", Font.BOLD, 12));
        labelStatus.setFont(new Font("Arial", Font.BOLD, 12));
        labelStatus.setBorder(BorderFactory.createEmptyBorder(0, 16, 8, 0));

      
        tombolSimpan.addActionListener(this);
        tombolReset.addActionListener(this);
        tombolKeluar.addActionListener(this);

        panelAtas.setLayout(layoutAtas);
        panelAtas.add(labelJudul);
        panelAtas.add(labelGambar);

        panelForm.setLayout(layoutForm);
        panelForm.add(labelNama);
        panelForm.add(isianNama);
        panelForm.add(labelNim);
        panelForm.add(isianNim);
        panelForm.add(labelProdi);
        panelForm.add(pilihanProdi);
        panelForm.add(labelKonfirmasi);
        panelForm.add(checkKonfirmasi);

        panelTombol.setLayout(layoutTombol);
        panelTombol.add(tombolSimpan);
        panelTombol.add(tombolReset);
        panelTombol.add(tombolKeluar);

        panelHasil.setLayout(layoutHasil);
        panelHasil.add(labelHasil, BorderLayout.NORTH);
        panelHasil.add(scrollHasil, BorderLayout.CENTER);

        panelTengah.setLayout(layoutTengah);
        panelTengah.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 16));
        panelTengah.add(panelForm, BorderLayout.NORTH);
        panelTengah.add(panelTombol, BorderLayout.CENTER);
        panelTengah.add(panelHasil, BorderLayout.SOUTH);

        setLayout(layoutUtama);
        add(panelAtas, BorderLayout.NORTH);
        add(panelTengah, BorderLayout.CENTER);
        add(labelStatus, BorderLayout.SOUTH);

        setTitle("Form Biodata Mahasiswa");
        setSize(460, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolSimpan) {
            simpanData();
        } else if (e.getSource() == tombolReset) {
            resetForm();
        } else if (e.getSource() == tombolKeluar) {
            System.exit(0);
        }
    }

    private void simpanData() {
        String nama = isianNama.getText();
        String nim = isianNim.getText();

        if (nama.isEmpty() || nim.isEmpty()) {
            labelStatus.setText("Nama dan NIM tidak boleh kosong!");
        } else if (!checkKonfirmasi.isSelected()) {
            labelStatus.setText("Centang konfirmasi dulu!");
        } else {
            areaHasil.append("Nama : " + nama + "\n");
            areaHasil.append("NIM  : " + nim + "\n");
            areaHasil.append("Prodi: " + pilihanProdi.getSelectedItem() + "\n");
            areaHasil.append("------------------------------\n");
            labelStatus.setText("Data berhasil disimpan");
        }
    }

    private void resetForm() {
        isianNama.setText("");
        isianNim.setText("");
        pilihanProdi.setSelectedIndex(0);
        checkKonfirmasi.setSelected(false);
        areaHasil.setText("");
        labelStatus.setText("Siap");
    }

    public static void main(String[] args) {
        LatihanGUI aplikasi = new LatihanGUI();
        aplikasi.setVisible(true);
    }
}
