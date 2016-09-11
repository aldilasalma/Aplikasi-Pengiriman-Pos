package id.sch.smktelkom_mlg.tugas01.xiirpl2003.dilatugas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etnama, etno, etnamapen, etni;
    RadioGroup jenis;
    RadioButton dokumen, uang, barang;
    Spinner kota1, kota2;
    TextView hnama, hno, hni, halpeng, halpene, hiden, hjp, hpene;
    Button daftar;
    CheckBox sim, ktp, pasport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnamapen = (EditText) findViewById(R.id.etnp);
        etnama = (EditText) findViewById(R.id.nama);
        etno = (EditText) findViewById(R.id.no);
        etni = (EditText) findViewById(R.id.noi);
        jenis = (RadioGroup) findViewById(R.id.jeniskelamin);
        dokumen = (RadioButton) findViewById(R.id.dokumen);
        barang = (RadioButton) findViewById(R.id.barang);
        uang = (RadioButton) findViewById(R.id.uang);
        hpene = (TextView) findViewById(R.id.hnamapener);
        kota1 = (Spinner) findViewById(R.id.spinner);
        kota2 = (Spinner) findViewById(R.id.spinner2);
        hnama = (TextView) findViewById(R.id.hnama);
        hno = (TextView) findViewById(R.id.hno);
        hni = (TextView) findViewById(R.id.hni);
        hjp = (TextView) findViewById(R.id.hjp);
        halpeng = (TextView) findViewById(R.id.halamatpeng);
        halpene = (TextView) findViewById(R.id.halamatpener);
        hiden = (TextView) findViewById(R.id.hidentitas);
        sim = (CheckBox) findViewById(R.id.checkBox);
        ktp = (CheckBox) findViewById(R.id.checkBox1);
        pasport = (CheckBox) findViewById(R.id.checkBox2);
        daftar = (Button) findViewById(R.id.buttonDaftar);


        findViewById(R.id.buttonDaftar).setOnClickListener(new View.OnClickListener() {
                                                               @Override
                                                               public void onClick(View view) {
                                                                   doClick();
                                                               }

                                                               private void doClick() {
                                                                   if (isValid()) {
                                                                       String nama = etnama.getText().toString();
                                                                       hnama.setText("Nama Pengirim : " + nama);
                                                                       String namapen = etnamapen.getText().toString();
                                                                       hpene.setText("Nama Penerima : " + namapen);
                                                                       int no = Integer.parseInt(etno.getText().toString());
                                                                       hno.setText("No Telephone : " + no);
                                                                       int ni = Integer.parseInt(etni.getText().toString());
                                                                       hni.setText("No Identitas : " + ni);
                                                                   }

                                                               }


                                                               private boolean isValid() {
                                                                   boolean valid = true;
                                                                   String hasil = null;
                                                                   if (dokumen.isChecked()) {
                                                                       hasil = dokumen.getText().toString();
                                                                       hjp.setText("Jenis Pengiriman   : Dokumen");
                                                                       valid = true;
                                                                   } else if (uang.isChecked()) {
                                                                       hasil = uang.getText().toString();
                                                                       hjp.setText("Jenis Pengiriman    : Uang");
                                                                       valid = true;
                                                                   } else if (barang.isChecked()) {
                                                                       hasil = barang.getText().toString();
                                                                       hjp.setText("Jenis Pengiriman    : Barang");
                                                                       valid = true;
                                                                   }

                                                                   String nama = etnama.getText().toString();
                                                                   String penerima = etnamapen.getText().toString();
                                                                   String no = etno.getText().toString();
                                                                   String noi = etni.getText().toString();

                                                                   if (nama.isEmpty()) {
                                                                       etnama.setError("Nama Belum diisi");
                                                                       valid = false;
                                                                   } else if (nama.length() < 3) {
                                                                       etnama.setError("Nama minimal 3 karakter");
                                                                       valid = false;
                                                                   } else {
                                                                       hnama.setText("Nama Pengirim : " + nama);
                                                                   }

                                                                   if (penerima.isEmpty()) {
                                                                       etnamapen.setError("Nama Belum diisi");
                                                                       valid = false;
                                                                   } else if (penerima.length() < 3) {
                                                                       etnamapen.setError("Nama minimal 3 karakter");
                                                                       valid = false;
                                                                   } else {
                                                                       hpene.setText("Nama Penerima : " + penerima);
                                                                   }
                                                                   if (no.isEmpty()) {
                                                                       etno.setError("Nomor Belum diisi");
                                                                       valid = false;
                                                                   } else {
                                                                       hno.setText("No Telephone : " + no);
                                                                   }
                                                                   if (noi.isEmpty()) {
                                                                       etni.setError("No Identitas belum diisi");
                                                                       valid = false;
                                                                   } else {
                                                                       hni.setText("No Identitas : " + noi);
                                                                   }

                                                                   halpeng.setText("Alamat Pengirim : " + kota1.getSelectedItem().toString());
                                                                   halpene.setText("Alamat Penerima : " + kota2.getSelectedItem().toString());

                                                                   String jenisidentitas = "Jenis Identitas yang digunakan : ";
                                                                   int startlen = jenisidentitas.length();
                                                                   if (sim.isChecked()) jenisidentitas += sim.getText() + " ";
                                                                   if (ktp.isChecked()) jenisidentitas += ktp.getText() + " ";
                                                                   if (pasport.isChecked()) jenisidentitas += pasport.getText() + " ";

                                                                   if (jenisidentitas.length() == startlen) jenisidentitas += "Tidak ada";

                                                                   hiden.setText(jenisidentitas);


                                                                   return false;
                                                               }
                                                           }

        );
    }
}