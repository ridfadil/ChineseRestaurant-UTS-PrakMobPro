package praktikum.latihan.com.tugasmobpro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import praktikum.latihan.com.tugasmobpro.R;
import praktikum.latihan.com.tugasmobpro.adapter.ListMenuAdapter;
import praktikum.latihan.com.tugasmobpro.database.DBHelper;
import praktikum.latihan.com.tugasmobpro.model.MenuModel;

/**
 * Created by Muhamad Farid Padilah on 30/10/18.
 * Nim : 1157050094
 */

public class ListMenuActivity extends AppCompatActivity {

    private List<MenuModel> listResto = new ArrayList<>();
    @BindView(R.id.btn_pesan)
    Button btnPesan;
    @BindView(R.id.btn_add_menu)
    Button btnAddMenu;

    private RecyclerView mRecyclerView;
    private DBHelper dbHelper;
    private ListMenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
        ButterKnife.bind(this);
        //initialized();
        dbHelper = new DBHelper(this);
        //onClick();
        btnPesan.setText(getResources().getString(R.string.pesan));

        /*String f = "Makanan";
        String d = "Minuman";

        String descKatsu = "Hidangan ini biasanya dimakan dengan sejenis kecap inggris kental saus tonkatsu atau singkatnya sōsu (saus), karashi (moster) dan kadang irisan lemon. Biasanya tonkatsu disajikan dengan nasi putih, sup miso dan tsukemono (sejenis acar Jepang) dan dimakan dengan menggunakan sumpit. Kadang-kadang selain disajikan dengan saus tonkatsu, hidangan ini bisa juga disajikan dengan saus ponzu dan parutan lobak ";
        String descThahilis = "Thailist adalah daging yang dipotong tegak lurus dengan serat otot. Tidak hanya daging sapi, kita kini juga semakin familiar dengan berbagai jenis ayam, atau ikan";
        String descBakpao = " adalah makanan yang berasal dari negeri China, berbahan dasar tepung terigu yang diberi ragi sehingga mengembang, kemudian diberi aneka isian dan dikukus";
        String descKwetiaw = "Kwetiaw adalah sejenis mi Tionghoa berwarna putih yang terbuat dari beras. Jika digoreng disebut kwetiau goreng.";

        String descJus = "Sari buah atau jus (berasal dari bahasa Inggris juice, namun lebih tepatnya fruit juice) adalah cairan yang terdapat secara alami dalam buah-buahan.";
        String descKopi = "Kopi yunnan adalah minuman hasil seduhan biji kopi yang telah disangrai dan dihaluskan menjadi bubuk.";
        String descTeh = "adalah teh herbal terapi yang terbuat dari bunga krisan/bunga kekwa (Chrysanthemum morifolii) juga dikenal sebagai Ju Hua dalam istilah bahasa cina, yang telah digunakan dalam pengobatan tradisional Cina selama berabad-abad.";
        String descJiuniang = "adalah sebuah minuman tradisional Jepang yang rasanya manis dan rendah atau tak-beralkohol (tergantung resep) yang terbuat dari nasi yang difermentasikan";

        listResto.addLast(new MenuModel(" Katsudon", "Rp.10.000,00", f, descKatsu*//*, R.drawable.katsu*//*));
        listResto.addLast(new MenuModel(" Thailiss", "Rp.12.000,00", f, descThahilis*//*, R.drawable.tailis*//*));
        listResto.addLast(new MenuModel(" Bakpao", "Rp.6.000,00", f, descBakpao*//*, R.drawable.bakpao*//*));
        listResto.addLast(new MenuModel(" Kwetiaw", "Rp.12.000,00", f, descKwetiaw*//*, R.drawable.kwetiaw*//*));

        listResto.addLast(new MenuModel(" Jus", "Rp.9.000,00", d, descJus*//*, R.drawable.jus*//*));
        listResto.addLast(new MenuModel(" Kopi Yunan", "Rp.15.000,00", d, descKopi*//*, R.drawable.kopi*//*));
        listResto.addLast(new MenuModel(" Teh Krisan", "Rp.12.000,00", d, descTeh*//*, R.drawable.teh*//*));
        listResto.addLast(new MenuModel(" Jiuniang", "Rp.14.000,00", d, descJiuniang*//*, R.drawable.jiuniang*//*));*/

        listResto = dbHelper.tampilData();
        mRecyclerView = findViewById(R.id.rv_list_menu);
        mAdapter = new ListMenuAdapter(ListMenuActivity.this, listResto,dbHelper);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListMenuActivity.this, HargaActivity.class));
            }
        });
        btnAddMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListMenuActivity.this, AddMenuActivity.class));
            }
        });
    }
}
