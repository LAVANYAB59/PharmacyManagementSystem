package com.wipro.pharmacy.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet; 
import com.wipro.pharmacy.bean.PharmacyBean;
import com.wipro.pharmacy.service.Administrator;

@WebServlet("/MainServlet")

public class MainServlet extends HttpServlet {

    Administrator admin = new Administrator();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        if ("newRecord".equals(operation)) {

            try {
                PharmacyBean bean = new PharmacyBean();
                bean.setMedicineName(request.getParameter("medicineName"));
                bean.setSupplierName(request.getParameter("supplierName"));
                bean.setPurchaseDate(new SimpleDateFormat("yyyy-MM-dd")
                        .parse(request.getParameter("purchaseDate")));
                bean.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                bean.setPrice(Integer.parseInt(request.getParameter("price")));
                bean.setRemarks(request.getParameter("remarks"));

                String result = admin.addRecord(bean);

                if (result.equals("FAIL") || result.contains("INVALID") || result.equals("ALREADY EXISTS"))
                    response.sendRedirect("Error.html");
                else
                    response.sendRedirect("Success.html");

            } catch (Exception e) {
                response.sendRedirect("Error.html");
            }

        } else if ("ViewRecord".equals(operation)) {

            try {
                String name = request.getParameter("medicineName");
                Date date = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(request.getParameter("purchaseDate"));

                PharmacyBean bean = admin.viewRecord(name, date);

                if (bean == null) {
                    request.setAttribute("message",
                            "No matching records exists! Please try again!");
                } else {
                    request.setAttribute("bean", bean);
                }

                RequestDispatcher rd = request.getRequestDispatcher("DisplayMedicine.jsp");
                rd.forward(request, response);

            } catch (Exception e) {
                response.sendRedirect("Error.html");
            }

        } else if ("ViewAllRecords".equals(operation)) {

            List<PharmacyBean> list = admin.viewAllRecords();

            if (list.isEmpty()) {
                request.setAttribute("message", "No records available!");
            } else {
                request.setAttribute("list", list);
            }

            RequestDispatcher rd = request.getRequestDispatcher("DisplayAllMedicines.jsp");
            rd.forward(request, response);
        }
    }
}