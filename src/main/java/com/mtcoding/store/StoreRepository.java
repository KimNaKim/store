package com.mtcoding.store;

import java.sql.Connection;
import java.sql.PreparedStatement;

//store_tb 전담 레포지토리
public class StoreRepository {
    public int deleteOne(int id){
        //커넥션 접속하기
        Connection conn = DBConnection.getConnection();

        //row 삽입(데이터 추가)
        String sql = "delete from store_tb where id=? ";
        try{
            //2. 버퍼 달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            //3. 쿼리 전송
            int result = pstmt.executeUpdate();
            //전송 결과 출력하기
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;

    }

    public int updateOne(int id, String name, int price, int qty){
        //커넥션 접속하기
        Connection conn = DBConnection.getConnection();

        //row 삽입(데이터 추가)
        String sql = "update store_tb set name=?, price=?, qty=? where id=? ";
        try{
            //2. 버퍼 달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, qty);
            pstmt.setInt(4, id);

            //3. 쿼리 전송
            int result = pstmt.executeUpdate();
            //전송 결과 출력하기
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;

    }

    public int insert(int id, String name, int price, int qty){
        //커넥션 접속하기
        Connection conn = DBConnection.getConnection();

        //row 삽입(데이터 추가)
        String sql = "insert into store_tb(id, name, price, qty) values(?,?,?,?)";
        try{
            //2. 버퍼 달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, price);
            pstmt.setInt(4, qty);

            //3. 쿼리 전송
            int result = pstmt.executeUpdate();
            //전송 결과 출력하기
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

}
