package com.wipro.pharmacy.dao;

import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.wipro.pharmacy.bean.PharmacyBean;
import com.wipro.pharmacy.util.DBUtil;

public class PharmacyDAO {

    public String createRecord(PharmacyBean bean) {
        String status = "FAIL";
        try (Connection con = DBUtil.getConnection()) {

            String recordId = generateRecordID(
                    bean.getMedicineName(),
                    bean.getPurchaseDate());

            bean.setRecordId(recordId);

            String sql = "INSERT INTO PHARMACY_TB VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bean.getRecordId());
            ps.setString(2, bean.getMedicineName());
            ps.setString(3, bean.getSupplierName());
            ps.setDate(4, new java.sql.Date(bean.getPurchaseDate().getTime()));
            ps.setInt(5, bean.getQuantity());
            ps.setInt(6, bean.getPrice());
            ps.setString(7, bean.getRemarks());

            int row = ps.executeUpdate();

            if (row > 0)
                status = bean.getRecordId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public PharmacyBean fetchRecord(String medicineName, Date purchaseDate) {
        PharmacyBean bean = null;
        try (Connection con = DBUtil.getConnection()) {

            String sql = "SELECT * FROM PHARMACY_TB WHERE MEDICINENAME=? AND PURCHASE_DATE=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, medicineName);
            ps.setDate(2, new java.sql.Date(purchaseDate.getTime()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new PharmacyBean();
                bean.setRecordId(rs.getString(1));
                bean.setMedicineName(rs.getString(2));
                bean.setSupplierName(rs.getString(3));
                bean.setPurchaseDate(rs.getDate(4));
                bean.setQuantity(rs.getInt(5));
                bean.setPrice(rs.getInt(6));
                bean.setRemarks(rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public String generateRecordID(String medicineName, Date purchaseDate) {
        String recordId = "";
        try (Connection con = DBUtil.getConnection()) {

            DateFormat format = new SimpleDateFormat("yyyyMMdd");
            String datePart = format.format(purchaseDate);

            String medPart = medicineName.substring(0, 2).toUpperCase();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT PHARMACY_SEQ.NEXTVAL FROM DUAL");

            if (rs.next()) {
                int seq = rs.getInt(1);
                recordId = datePart + medPart + seq;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordId;
    }

    public boolean recordExists(String medicineName, Date purchaseDate) {
        return fetchRecord(medicineName, purchaseDate) != null;
    }

    public List<PharmacyBean> fetchAllRecords() {
        List<PharmacyBean> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {

            String sql = "SELECT * FROM PHARMACY_TB";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PharmacyBean bean = new PharmacyBean();
                bean.setRecordId(rs.getString(1));
                bean.setMedicineName(rs.getString(2));
                bean.setSupplierName(rs.getString(3));
                bean.setPurchaseDate(rs.getDate(4));
                bean.setQuantity(rs.getInt(5));
                bean.setPrice(rs.getInt(6));
                bean.setRemarks(rs.getString(7));
                list.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}