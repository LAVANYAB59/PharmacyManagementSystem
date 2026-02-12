package com.wipro.pharmacy.service;

import java.util.*;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import com.wipro.pharmacy.bean.PharmacyBean;
import com.wipro.pharmacy.dao.PharmacyDAO;

public class Administrator {

    PharmacyDAO dao = new PharmacyDAO();

    public String addRecord(PharmacyBean bean) {

        try {

            if (bean == null || bean.getMedicineName() == null || bean.getPurchaseDate() == null)
                throw new InvalidInputException();

            if (bean.getMedicineName().length() < 2)
                return "INVALID MEDICINE NAME";

            if (dao.recordExists(bean.getMedicineName(), bean.getPurchaseDate()))
                return "ALREADY EXISTS";

            return dao.createRecord(bean);

        } catch (InvalidInputException e) {
            return "INVALID INPUT";
        }
    }

    public PharmacyBean viewRecord(String medicineName, Date purchaseDate) {
        return dao.fetchRecord(medicineName, purchaseDate);
    }

    public List<PharmacyBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}