package org.eod.helper;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.eod.Main;
import org.eod.model.Nasabah;
import org.eod.model.Saldo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CustomerCSVReader {

    String fileName;
    List<Nasabah> listOfNasabah;

    public CustomerCSVReader(String fileName){
        this.fileName = fileName;
    }

    public List<Nasabah> getListOfNasabah() throws IOException {
        char delimiter = ';';
        InputStream inputStream = Main.class.getResourceAsStream("/"+fileName);
        InputStreamReader reader = new InputStreamReader(inputStream);
        CSVParser records = CSVFormat.newFormat(delimiter).withFirstRecordAsHeader().parse(reader);

        List<Nasabah> listOfNasabah = new ArrayList<Nasabah>();

        for (CSVRecord record : records) {
            int id = Integer.parseInt(record.get("id"));
            String name = record.get("Nama");
            int age = Integer.parseInt(record.get("Age"));
            Double saldo = Double.valueOf(record.get("Balanced"));
            Double saldoSebelum = Double.valueOf(record.get("Previous Balanced"));
            Double saldoRataRata = Double.valueOf(record.get("Average Balanced"));
            int gratisTransfer = Integer.parseInt(record.get("Free Transfer"));

            Saldo wallet = new Saldo(saldo, saldoSebelum, saldoRataRata, gratisTransfer);
            Nasabah customer = new Nasabah(id, name, age, wallet);

            listOfNasabah.add(customer);
        }
        return listOfNasabah;
    }

}
