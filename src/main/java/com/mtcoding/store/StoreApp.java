package com.mtcoding.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class StoreApp {

    public static void main(String[] args) {
        StoreRepository repo = new StoreRepository();
     /*int result = repo.insert(2,"apple", 2000, 5);
        System.out.println("결과 : " + result);
        result = repo.updateOne(1, "apple", 300, 100);
        System.out.println("결과 : " + result);
        result = repo.deleteOne(1);
        System.out.println("결과 : " + result);*/

        Store store = repo.selectOne(3);
        System.out.println(store.toString());

        ArrayList<Store> stores = repo.selectAll();
        for(int i= 0; i<stores.size(); i++){
            System.out.println(stores.get(i).toString());
        }
    }
}
