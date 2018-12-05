package praktikum.latihan.com.tugasmobpro.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import praktikum.latihan.com.tugasmobpro.model.MenuModel;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Menu.db";
    public static final String TABLE_NAME = "DataMenu";

    public static final String colom1 = "ID";
    public static final String colom2 = "nama";
    public static final String colom3 = "harga";
    public static final String colom4 = "jenis";
    public static final String colom5 = "keterangan";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " nama TEXT," +
                " harga TEXT ," +
                " jenis TEXT," +
                "keterangan TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public List<MenuModel> tampilData() {
        List<MenuModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String qr = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(qr, null);
        if (cursor.moveToFirst()) {
            do {
                MenuModel menu = new MenuModel(
                        (cursor).getString((cursor).getColumnIndex(colom1)),
                        (cursor).getString((cursor).getColumnIndex(colom2)),
                        (cursor).getString((cursor).getColumnIndex(colom3)),
                        (cursor).getString((cursor).getColumnIndex(colom4)),
                        (cursor).getString((cursor).getColumnIndex(colom5))
                );
                list.add(menu);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean MasukanData(String nama, String harga, String jenis, String keterangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues konten = new ContentValues();
        konten.put(colom2, nama);
        konten.put(colom3, harga);
        konten.put(colom4, jenis);
        konten.put(colom5, keterangan);

        long hasil = db.insert(TABLE_NAME, null, konten);
        db.close();

        if (hasil == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean EditData(String id, String nama, String harga, String jenis, String keterangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues konten = new ContentValues();
        konten.put(colom1, id);
        konten.put(colom2, nama);
        konten.put(colom3, harga);
        konten.put(colom4, jenis);
        konten.put(colom5, keterangan);

        int hasil = db.update(TABLE_NAME, konten, "ID =? ", new String[]{id});
        if (hasil > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Integer DeleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME, "ID=? ", new String[]{id});
        return i;
    }
}
