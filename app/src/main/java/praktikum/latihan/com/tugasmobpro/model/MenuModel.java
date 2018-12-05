package praktikum.latihan.com.tugasmobpro.model;

/**
 * Created by Muhamad Farid Padilah on 30/10/18.
 * Nim : 1157050094
 */

public class MenuModel {
    private String id, namaMenu, hargaMenu, jenisMenu, deskripsiMenu;
    //private int fotoMenu;


    public MenuModel(String id, String namaMenu, String hargaMenu, String jenisMenu, String deskripsiMenu) {
        this.id = id;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.jenisMenu = jenisMenu;
        this.deskripsiMenu = deskripsiMenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(String hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public String getJenisMenu() {
        return jenisMenu;
    }

    public void setJenisMenu(String jenisMenu) {
        this.jenisMenu = jenisMenu;
    }

    public String getDeskripsiMenu() {
        return deskripsiMenu;
    }

    public void setDeskripsiMenu(String deskripsiMenu) {
        this.deskripsiMenu = deskripsiMenu;
    }
}