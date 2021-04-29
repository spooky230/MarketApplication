package com.spooky.market.service;


import com.spooky.market.model.Cashier;
import com.spooky.market.model.Check;
import com.spooky.market.model.Item;
import com.spooky.market.model.Market;

import javax.sound.midi.Soundbank;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CheckService {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("y-MM-dd  hh-mm");

    public void writeReport(String report,String fileName) {
//        String FILE = "Report/check_" + DATE_FORMAT.format(check.getDate()) + ".txt";
        try {
            FileWriter writer =  new FileWriter(fileName);
            writer.write(report);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String prepareReport(Check check) {
        StringBuilder report = new StringBuilder();
        double cashAdder = 0;
        report.append(check.getMarket().getName() + System.lineSeparator());
        report.append("Cashier: " + check.getCashier().getFirstName() + " " + check.getCashier().getLastName()+ System.lineSeparator());
        report.append("Row: " + check.getRow()+ System.lineSeparator());
        report.append(DATE_FORMAT.format(check.getDate())+ System.lineSeparator());
        report.append("Products: "+ System.lineSeparator());
        for (Map.Entry<Item, Integer> entry : check.getItems().entrySet()) {
            report.append(entry.getKey().getName() + ":       " + entry.getValue() + " x " + entry.getKey().getPrice()
                    + " = " + (entry.getValue() * entry.getKey().getPrice()) + System.lineSeparator());
            cashAdder = cashAdder + (entry.getValue() * entry.getKey().getPrice());
        }
        report.append("______________________________________" + System.lineSeparator());
        report.append("Total: " + cashAdder + System.lineSeparator());
        return report.toString();
    }
    public void saveReports(Check check){
        String report = prepareReport(check);
        System.out.println(report);
        String txtFileName = createTxtFileName(check.getDate());
        String xmlFileName = createXmlFileName(check.getDate());
        writeReport(report,txtFileName);
        writeReportToXml(check,xmlFileName);
    }
    public String createXmlFileName(Date date){
        return "Report/check_" + DATE_FORMAT.format(date) + ".xml";
    }
    public String createTxtFileName(Date date){
        return "Report/check_" + DATE_FORMAT.format(date) + ".txt";
    }
    public void writeReportToXml(Check check, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Check.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(check, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
