/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        //        Models supp = new Supplier("supplier");
        //        System.out.println(Arrays.deepToString(supp.selectAll()));
//        Barang br = new Barang("barang");
//        System.out.println(br.);
//        System.out.println(Arrays.deepToString(br.getDataBarangById(3)));
        Supplier sp = new Supplier("supplier");
//        System.err.println(Arrays.deepToString(sp.getList()));
        System.out.println(sp.findId("Carl Trading LLC"));
    }

}
