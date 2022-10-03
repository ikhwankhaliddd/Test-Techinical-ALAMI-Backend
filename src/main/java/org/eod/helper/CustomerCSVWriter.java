package org.eod.helper;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.eod.model.Nasabah;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomerCSVWriter {
    String filePath;
    String[] header;
    List<Nasabah> listOfNasabah;

    public CustomerCSVWriter(String filePath, String[] header, List<Nasabah> listOfNasabah){
        this.filePath = filePath;
        this.header = header;
        this.listOfNasabah = listOfNasabah;
    }

    public void write() throws IOException {
        char delimiter = ';';
        FileWriter fileWriter = new FileWriter(filePath);
        CSVPrinter csvprinter = new CSVPrinter(fileWriter, CSVFormat.Builder.create()
                .setDelimiter(delimiter).setRecordSeparator('\n').setHeader(header).build());
        for (Nasabah c : listOfNasabah) {
            csvprinter.printRecord(c.getId(), c.getName(), c.getAge(), c.saldo.getSaldo(), c.thread2b, c.thread3, c.saldo.getSaldoSebelum(), c.saldo.getSaldoRataRata(), c.thread1, c.saldo.getGratisTransfer(), c.thread2a);
        }
        csvprinter.flush();
    }


}
