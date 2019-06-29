package com.demo.dao;

import com.demo.model.Addition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
  *ClassNmae:  MemberDao
  *Description:  TODO
  *@author  MasonWu
  *@date  2019/6/1 13:21
  *@version  1.0
  *Copyright (c) 2018-2020 Koreancoco All Rights Reserved.
  **/
public class MemberDao extends BaseDao {
    String[] associations={
        "cakeass",
        "literatureass",
        "cubeass",
        "pinpongass",
        "guitarass"
    };

    // 向社团成员中添加记录
    public boolean addMember(Addition addition) {
        String sql="insert into "+associations[addition.getJoinass()]+"(member) values(?)";

        try {
            Connection conn=dataSource.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, addition.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    public int memberCount(int assid) {

        String sql="select count(joinass) membercount from memberinfo where joinass=?";
        int num=0;
        try {
            Connection conn=dataSource.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, assid);
            ResultSet rset= pstmt.executeQuery();
            if(rset.next()) {
                num=rset.getInt("membercount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return num;
        }


        return num;

    }

}
