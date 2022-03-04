package org.cucumber.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataProvider {

    public static Iterator<Object[]> getData(String path) {
        File csvPath = new File(path);
        List<Object[]> dataLines = new ArrayList<>();
        boolean notDataHeader = false;
        String[] data;
        BufferedReader br;
        String line;

        try {
            br = new BufferedReader(new FileReader(csvPath.getAbsoluteFile()));
            while ((line = br.readLine()) != null) {
                data = line.split(";");
                if (notDataHeader) dataLines.add(data);
                notDataHeader = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dataLines.get(0));
        return dataLines.iterator();
    }


}



