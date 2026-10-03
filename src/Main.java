import com.olympics.model.AthleteEvent;
import com.olympics.model.NocRegion;
import com.olympics.repository.OlympicDataRepository;
import com.olympics.service.OlympicAnalysisService;
import com.olympics.util.CsvReader;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader();

        OlympicDataRepository repository =
                new OlympicDataRepository(csvReader);


        //----------------------first Problem------------------------------------------------


//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//
//       Map<Integer, Map<String,Integer>> result=service.getGoldMedalsByYear();
//
//        System.out.println(
//                "\n===== NUMBER OF GOLD MEDALS WON BY EACH PLAYERS   ====="
//
//        );
//
//       for(Map.Entry<Integer,Map<String,Integer>> yearEntry :result.entrySet()){
//           Integer year =yearEntry.getKey();
//
//           Map<String,Integer> athletes=yearEntry.getValue();
//
//           System.out.println("\nYear" +year);
//
//           for(Map.Entry<String,Integer> athleteEntry :athletes.entrySet()){
//               System.out.println(athleteEntry.getKey()
//                                +"->"
//                                +athleteEntry.getValue());
//           }
//       }


       //-----------------------------------------end------------------------------------------------------



        //----------------------------------------second problem-------------------------------------------



//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//
//        List<AthleteEvent> youngGoldMedalists1980= service.getYoungGoldMedalists1980();
//
//        for(AthleteEvent athlete :youngGoldMedalists1980){
//            System.out.println(
//                    "Id: "+athlete.getId()
//                            +"| Name: "+athlete.getName()
//                            +"| Age:  "+athlete.getAge()
//                            +"| sprot:  "+athlete.getSport()
//                            +"| Event:  "+athlete.getEvent()
//            );
//        }
//        System.out.println("Total: "+youngGoldMedalists1980.size());




        //-----------------------------------------end---------------------------------------------------------


    //--------------------------------------------third problem-------------------------------------------------


//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//        Map<String, Map<String, Integer>> eventMedals=service.getMedalCountByEvent1980();
//
//        for(Map.Entry<String,Map<String,Integer>> eventEntry :eventMedals.entrySet()){
//
//            String event=eventEntry.getKey();
//
//            Map<String,Integer> medalCount=eventEntry.getValue();
//
//            System.out.println("\nEvent "+event);
//
//            for(Map.Entry<String,Integer> medalEntry : medalCount.entrySet()){
//
//                System.out.println(
//                        "  "
//                        +medalEntry.getKey()
//                        +" : "
//                        +medalEntry.getValue()
//                );
//            }
//        }


        //---------------------------------------end--------------------------------------------------------


        //-------------------------------------- fourth problem---------------------------------------------


//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//        Map<String, String> footballWinners =
//                service.getFootballGoldWinners();
//        System.out.println(
//                "\n===== FOOTBALL GOLD WINNERS ====="
//        );
//
//        for (Map.Entry<String, String> entry
//                : footballWinners.entrySet()) {
//
//            System.out.println(
//                    entry.getKey()
//                            + " -> "
//                            + entry.getValue()
//            );
//        }


        //---------------------------------------end-----------------------------------------------------------


        //--------------------------------- fifth problem------------------------------------------------------



//        Map<Integer, Integer> goldMedalsByAthlete=service.getFemaleGoldMedalCounts();
//                System.out.println(
//                "\n===== FEMALE GOLD WINNERS ====="
//        );
//        int maxGoldMedals = 0;
//
//        for (Map.Entry<Integer, Integer> entry
//                : goldMedalsByAthlete.entrySet()) {
//
//            int count = entry.getValue();
//
//            if (count > maxGoldMedals) {
//                maxGoldMedals = count;
//            }
//        }
//
//        List<Integer> topAthleteIds = new ArrayList<>();
//
//        for (Map.Entry<Integer, Integer> entry
//                : goldMedalsByAthlete.entrySet()) {
//
//            if (entry.getValue() == maxGoldMedals) {
//                topAthleteIds.add(entry.getKey());
//            }
//        }
//
//        System.out.println(
//                "Maximum Gold Medals: " + maxGoldMedals
//        );
//
//        for (Integer athleteId : topAthleteIds) {
//
//            String name =
//                    service.getAthleteNameById(athleteId);
//
//            System.out.println(
//                    name + " -> "
//                            + maxGoldMedals
//                            + " Gold Medals"
//            );
//        }


        //-----------------------------------------------end-------------------------------------------------------



        //------------------------------------ six problem----------------------------------------------------




//        Map<Integer, HashSet<String>> participation =
//                service.getAthleteOlympicParticipations();
//
//        List<Integer> athletesMoreThan3Olympics=new ArrayList<>();
//
//        for( Map.Entry<Integer,HashSet<String>> entry : participation.entrySet()){
//            int athleteId=entry.getKey();
//            HashSet<String> games=entry.getValue();
//
//            if(games.size()>3){
//                athletesMoreThan3Olympics.add(athleteId);
//            }
//        }
//
//        System.out.println(
//                "\n===== ATHLETES PARTICIPATED IN MORE THAN 3 OLYMPICS ====="
//        );
//
//        for (Integer athleteId : athletesMoreThan3Olympics) {
//
//            String name =
//                    service.getAthleteNameById(athleteId);
//
//            int olympicCount =
//                    participation.get(athleteId).size();
//
//            System.out.println(
//                    name
//                            + " -> "
//                            + olympicCount
//                            + " Olympics"
//            );
//        }


        //---------------------------------end-----------------------------------------------------

        //Question-:Find the total number of Gold medals won by each NOC across all Olympics.



//        Map<String,Integer> countryWithGoldMedals=service.getGoldMedalsBYNoc();
//
//
//        System.out.println(
//                "\n=====NUMBER OF GOLD MEDALS WITH NOC  ====="
//
//        );
//
//        for (Map.Entry<String,Integer> entry :countryWithGoldMedals.entrySet()){
//
//            String noc=entry.getKey();
//            int medals=entry.getValue();
//
//            System.out.println(
//                    noc
//                        +" -> "
//                        +medals
//                        +" Medals "
//            );
//
//        }



        //---------------------------------------end-----------------------------------------------------------

 //Question-:Find how many Gold medals were won in each sport.


//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//        Map<String,Integer> goldMedalsInEachYear=service.getTotalGoldMedalsInEachYear();
//
//
//
//                for (Map.Entry<String,Integer> entry :goldMedalsInEachYear.entrySet()){
//
//            String sports=entry.getKey();
//            int medals=entry.getValue();
//
//            System.out.println(
//                    sports
//                        +" -> "
//                        +medals
//                        +" Medals "
//            );
//
//        }
//


                //-----------------------------end----------------------------


      //Question-:Find athletes who participated in the Olympics but never won any medal


//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//
//        Set<Integer> athletesNeverWonMedal=service.getAthletesNeverWonMedals();
//
//
//        List<String> athletesNames=new ArrayList<>();
//
//        for(Integer athleteId :athletesNeverWonMedal){
//
//            String athleteName= service.getAthleteNameById(athleteId);
//
//            athletesNames.add(athleteName);
//
//
//        }
//
//        System.out.println(
//                "\n===== ATHLETES WHO NEVER WON A MEDAL ====="
//        );
//        System.out.println("size"+athletesNames.size());
//
//        for (String name : athletesNames) {
//            System.out.println(name);
//        }


        //-------------------------------------end---------------

//Question-:Find the number of unique athletes who participated in each Olympic year.

//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//
//        Map<Integer,HashSet<Integer>> uniqueAthleteEachYear=service.getUniqueAthletesParticipatedEachYear();
//
//        for(Map.Entry<Integer,HashSet<Integer>> entry : uniqueAthleteEachYear.entrySet()){
//            System.out.println(
//                    entry.getKey()
//                    +" -> "
//                    +entry.getValue().size()
//                    +" unique athletes"
//            );
//        }


        //Question-:Find the number of unique athletes who participated in each Olympic year.

//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//        Map<Integer,HashSet<String>> athleteParticipatedMaximumDifferentOlympics=service.getAthleteMaximumNumberOfDifferentOlympics();
//
//        int maxOlympicParticipations=0;
//        int athleteIdParticipatedMaximum=0;
//        for(Map.Entry<Integer,HashSet<String>> entry: athleteParticipatedMaximumDifferentOlympics.entrySet()){
//
//           if(entry.getValue().size()>maxOlympicParticipations){
//               maxOlympicParticipations=entry.getValue().size();
//               athleteIdParticipatedMaximum=entry.getKey();
//           }
//
//        }
//
//        String name=service.getAthleteNameById(athleteIdParticipatedMaximum);
//
//
//        System.out.println(
//                name
//                +" ->"
//                +maxOlympicParticipations
//        );



        //Question-:For every Olympic year, find the number of unique athletes who won Gold.

//        OlympicAnalysisService service=new OlympicAnalysisService(repository);
//        Map<Integer,HashSet<Integer>> uniqueAthleteWonGoldEverOlympicYear=service.getNumberOfUniqueAthletesWhoWonGoldEveryOlympic();
//
//        for( Map.Entry<Integer,HashSet<Integer>> entry : uniqueAthleteWonGoldEverOlympicYear.entrySet()){
//
//            System.out.println(
//                    entry.getKey()
//                    +" -> "
//                    +entry.getValue().size()
//                    +" unique Gold-winning athletes"
//            );
//        }


        //Question-:Find the NOC that won the maximum number of Gold medals.

        OlympicAnalysisService service=new OlympicAnalysisService(repository);
        Map<String, Integer> goldMedalsByNoc =
                service.getNocWonMaximumGoldMedals();

        int maxGoldMedals = 0;
        String maxNoc = "";

        for (Map.Entry<String, Integer> entry
                : goldMedalsByNoc.entrySet()) {

            if (entry.getValue() > maxGoldMedals) {

                maxGoldMedals = entry.getValue();
                maxNoc = entry.getKey();
            }
        }

        System.out.println(
                maxNoc
                        + " -> "
                        + maxGoldMedals
                        + " Gold Medals"
        );

    }
}