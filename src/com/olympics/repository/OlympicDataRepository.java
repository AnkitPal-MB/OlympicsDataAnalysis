package com.olympics.repository;

import com.olympics.model.AthleteEvent;
import com.olympics.model.NocRegion;
import com.olympics.util.CsvReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OlympicDataRepository {

    private final CsvReader csvReader;

    private final List<AthleteEvent> athleteEvents;
    private final Map<String, NocRegion> nocRegions;

    public OlympicDataRepository(CsvReader csvReader) {

        this.csvReader = csvReader;

        this.athleteEvents =
                csvReader.readAthleteEvents(
                        "data/athlete_events.csv"
                );

        List<NocRegion> regions =
                csvReader.readNocRegions(
                        "data/noc_regions.csv"
                );

        this.nocRegions = new HashMap<>();

        for (NocRegion region : regions) {

            this.nocRegions.put(
                    region.getNoc(),
                    region
            );
        }
    }

    public List<AthleteEvent> getAthleteEvents() {
        return athleteEvents;
    }

    public Map<String, NocRegion> getNocRegions() {
        return nocRegions;
    }

}