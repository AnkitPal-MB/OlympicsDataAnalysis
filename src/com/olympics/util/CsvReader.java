package com.olympics.util;

import com.olympics.model.AthleteEvent;
import com.olympics.model.NocRegion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CsvReader {

    private Integer parseInteger(String value) {

        if (value == null || value.isBlank() || value.equals("NA")) {
            return null;
        }

        return Integer.parseInt(value);
    }

    private Double parseDouble(String value) {

        if (value == null ||
                value.isBlank() ||
                value.equals("NA")) {

            return null;
        }

        return Double.parseDouble(value);
    }

    private AthleteEvent createAthleteEvent(String[] columns) {

        AthleteEvent athlete = new AthleteEvent();

        athlete.setId(Integer.parseInt(columns[0]));
        athlete.setName(columns[1]);
        athlete.setSex(columns[2]);
        athlete.setAge(parseInteger(columns[3]));
        athlete.setHeight(parseInteger(columns[4]));
        athlete.setWeight(parseDouble(columns[5]));
        athlete.setTeam(columns[6]);
        athlete.setNoc(columns[7]);
        athlete.setGames(columns[8]);
        athlete.setYear(Integer.parseInt(columns[9]));
        athlete.setSeason(columns[10]);
        athlete.setCity(columns[11]);
        athlete.setSport(columns[12]);
        athlete.setEvent(columns[13]);
        athlete.setMedal(columns[14]);

        return athlete;
    }

    private String[] parseLine(String line) {

        List<String> values = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            if (c == '"') {

                insideQuotes = !insideQuotes;

            } else if (c == ',' && !insideQuotes) {

                values.add(current.toString());
                current.setLength(0);

            } else {

                current.append(c);
            }
        }

        values.add(current.toString());

        return values.toArray(new String[0]);
    }


    public List<AthleteEvent> readAthleteEvents(String filePath) {

        List<AthleteEvent> athletes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filePath))) {

            // Skip header
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] columns = parseLine(line);

                AthleteEvent athlete = createAthleteEvent(columns);

                athletes.add(athlete);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return athletes;
    }

    public List<NocRegion> readNocRegions(String filePath) {

        List<NocRegion> regions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filePath))) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] columns = parseLine(line);

                NocRegion region = createNocRegion(columns);

                regions.add(region);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return regions;
    }
    private NocRegion createNocRegion(String[] columns) {

        NocRegion region = new NocRegion();

        region.setNoc(columns[0]);
        region.setRegion(columns[1]);

        if (columns.length > 2) {
            region.setNotes(columns[2]);
        }

        return region;
    }
}