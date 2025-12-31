package com.mtcoding.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//store_tb 전담 레포지토리
public class StoreRepository {
    //CRUD

    //Read = select = get
    public Store selectOne(int id){
        //id로 상품 찾기
        //커넥션 접속하기
        Connection conn = DBConnection.getConnection();

        //row 삽입(데이터 추가)
        String sql = "select * from store_tb where id=?  ";
        try{
            //2. 버퍼 달기
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            //3. 쿼리 전송 - 객체에 결과 담기
            ResultSet rs = pstmt.executeQuery();

            //row의 커서 한 칸 내리기
            boolean isRow = rs.next();
            while(isRow){       //행이 존재할 시
                //해당 행을 하나씩 뽑아내기 (프로젝션&파싱)
                int c1 = rs.getInt("id");
                String c2 = rs.getString("name");
                int c3 = rs.getInt("price");
                int c4 = rs.getInt("qty");
                //파싱한 결과들을 객체로 생성
                Store store = new Store(c1, c2, c3, c4);
                return store;
            }
            //전송 결과 출력하기
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //Read = select = get
    public ArrayList<Store> selectAll(){
        //등록된 상품 모두 보기
        //커넥션 접속하기
        Connection conn = DBConnection.getConnection();

        //row 삽입(데이터 추가)
        String sql = "select * from store_tb";
        try{
            //2. 버퍼 달기
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //3. 쿼리 전송
            ResultSet rs = pstmt.executeQuery();

            //4. 리턴된 레코드를 객체에 담기
            //row의 커서 한 칸 내리기
            boolean isRow = rs.next();
            ArrayList<Store> stores = new ArrayList<>();
            while(isRow){       //행이 존재할 시
                //해당 행을 하나씩 뽑아내기 (프로젝션&파싱)
                int c1 = rs.getInt("id");
                String c2 = rs.getString("name");
                int c3 = rs.getInt("price");
                int c4 = rs.getInt("qty");
                Store store = new Store(c1, c2, c3, c4);
                //생성한 객체 컬렉션에 담기
                stores.add(store);
                isRow = rs.next();
                if(!isRow){
                    return stores;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Delete = delete = delete
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
    //Update = update = put
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
    //Create = insert = post
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
