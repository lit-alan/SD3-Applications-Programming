/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import model.Customer;


/**
 *
 * @author Alan.Ryan
 */
public class FileIO {
    
    public static List<Customer> readFile(String path) {
        List<Customer> customerList = new ArrayList();
        
        Path p = Paths.get(path);

        List<String> lines = null;
        try {
            lines = Files.readAllLines(p);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        if (lines == null || lines.isEmpty()) {
            System.err.println("ERROR: The requested file appears to be empty");
            System.exit(0);
        }

        lines.remove(0); //remove file header with the col headings

        for (String line : lines) {
            customerList.add(splitRecord(line)); //convert each record in the file to a Bout object
        }
        
        return customerList;
    }
    private static Customer splitRecord(String line) {

        int id;
        int yob;
        String education;
        String maritalStatus;
        double income;
        int kidsHome;
        int teensHome;
        Date dateJoined;
        int recency;
        double amtWines;
        double amtFruits;
        double amtMeatProducts;
        double amtFishProducts;
        double amtSweetProducts;
        double amtGoldProds;
        boolean complained;

        StringTokenizer st = new StringTokenizer(line);

        while (st.hasMoreElements()) {

            id = Integer.parseInt(st.nextToken());  
            yob = Integer.parseInt(st.nextToken());
            education = st.nextToken();
            maritalStatus = st.nextToken();
            income = Double.parseDouble(st.nextToken());
            kidsHome = Integer.parseInt(st.nextToken());
            teensHome = Integer.parseInt(st.nextToken());
            dateJoined = new Date(st.nextToken());
            recency = Integer.parseInt(st.nextToken());
            amtWines = Double.parseDouble(st.nextToken());
            amtFruits = Double.parseDouble(st.nextToken());
            amtMeatProducts = Double.parseDouble(st.nextToken());
            amtFishProducts = Double.parseDouble(st.nextToken());
            amtSweetProducts = Double.parseDouble(st.nextToken());
            amtGoldProds = Double.parseDouble(st.nextToken());
            complained = (Integer.parseInt(st.nextToken()) != 0); 
            return new Customer(id, yob, education, maritalStatus, income, kidsHome, teensHome, dateJoined, recency, amtWines, amtFruits, amtMeatProducts, amtFishProducts, amtSweetProducts, amtGoldProds, complained);
        }

        return null; //shouldn't get here
    }//end method splitRecord
    
}
