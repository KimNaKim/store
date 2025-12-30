package com.mtcoding.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductRepository {
    public int insert(int id, String pname, int price, int qty){
        //커넥션 생성
        Connection conn = DBConnection.getConnection();

        //sql 문장
        String sql = "insert into product_tb(id, pname, price, qty) values(?,?,?,?)";
        try{
            //preparedStatement 생성해서 sql 대입
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //버퍼에 입력받은 값 삽임
            pstmt.setInt(1,id);
            pstmt.setString(2,pname);
            pstmt.setInt(3,price);
            pstmt.setInt(4,qty);

            //쿼리 전송하기
            int result = pstmt.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateOne(int id, String pname, int price, int qty){
        //커넥션 생성
        Connection conn = DBConnection.getConnection();

        //sql 문장
        String sql = "update product_tb set pname=?, price=?, qty=? where id=?";
        try{
            //preparedStatement 생성해서 sql 대입
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //버퍼에 입력받은 값 삽임
            pstmt.setString(1,pname);
            pstmt.setInt(2,price);
            pstmt.setInt(3,qty);
            pstmt.setInt(4,id);

            //쿼리 전송하기
            int result = pstmt.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteOne(int id){
        //커넥션 생성
        Connection conn = DBConnection.getConnection();

        //sql 문장
        String sql = "delete from product_tb where id = ?";
        try{
            //preparedStatement 생성해서 sql 대입
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //버퍼에 입력받은 값 삽임
            pstmt.setInt(1,id);

            //쿼리 전송하기
            int result = pstmt.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
