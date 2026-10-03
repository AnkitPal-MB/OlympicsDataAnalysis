package com.olympics.service;

import com.olympics.model.AthleteEvent;
import com.olympics.repository.OlympicDataRepository;

import java.util.*;

public class OlympicAnalysisService {


    private final OlympicDataRepository repository;

    public OlympicAnalysisService(OlympicDataRepository repository){
        this.repository=repository;
    }

    //first problem
  public Map<Integer,Map<String,Integer>> getGoldMedalsByYear(){

        Map<Integer,Map<String,Integer>>goldMedalsByYear=new HashMap<>();

        List<AthleteEvent> athletes=repository.getAthleteEvents();


        for(AthleteEvent athlete:athletes){
            if("Gold".equals(athlete.getMedal())){
                int year=athlete.getYear();
                String name=athlete.getName();

                if(!goldMedalsByYear.containsKey(year)){
                    goldMedalsByYear.put(year,new HashMap<>());
                }
                Map<String,Integer> athleteMap=goldMedalsByYear.get(year);

                if(athleteMap.containsKey(name)){
                    int currentCount=athleteMap.get(name);
                    athleteMap.put(name,currentCount+1);
                }else{
                    athleteMap.put(name,1);
                }
            }
        }
        return goldMedalsByYear;
  }

  //second problem

    public List<AthleteEvent> getYoungGoldMedalists1980(){

        List<AthleteEvent> result=new ArrayList<>();

        Set<Integer> addedAthleteId=new HashSet<>();

        List<AthleteEvent> athletes=repository.getAthleteEvents();

        for(AthleteEvent athlete: athletes){

           if(athlete.getYear()==1980
                    && "Gold".equals(athlete.getMedal())
                    && athlete.getAge()!=null
                    && athlete.getAge()<30)
           {
               // result.add(athlete);
               if(!addedAthleteId.contains(athlete.getId())){
                   result.add(athlete);
                   addedAthleteId.add(athlete.getId());
               }
            }

        }
        return result;
    }

    //third problem

    public Map<String, Map<String, Integer>> getMedalCountByEvent1980() {


        Map<String,Map<String,Integer>> result=new HashMap<>();

        List<AthleteEvent> athletes=repository.getAthleteEvents();

        for(AthleteEvent athlete :athletes){
            if(athlete.getYear()!=1980){
                continue;
            }

           String medal=athlete.getMedal();
            if (!"Gold".equals(medal)
                    && !"Silver".equals(medal)
                    && !"Bronze".equals(medal)) {

                continue;
            }
            String event=athlete.getEvent();

            if(!result.containsKey(event)){
                result.put(event,new HashMap<>());
            }

            Map<String,Integer> medalCount=result.get(event);

            if(medalCount.containsKey(medal)){
                int currentCount=medalCount.get(medal);

                medalCount.put(medal,currentCount+1);
            }else{
                medalCount.put(medal,1);
            }
        }
        return result;
    }

//    fourth problem
public Map<String, String> getFootballGoldWinners() {

     Map<String,String> winners=new HashMap<>();

     List<AthleteEvent> athletes=repository.getAthleteEvents();

     for(AthleteEvent athlete :athletes){
         if (!"Football".equals(athlete.getSport())) {
             continue;
         }
         if (!"Gold".equals(athlete.getMedal())) {
             continue;
         }

         String games=athlete.getGames();
         String team=athlete.getTeam();

         if (!winners.containsKey(games)) {

             winners.put(games, team);

         }
     }
        return winners;
    }

    public Map<Integer, Integer> getFemaleGoldMedalCounts() {

        Map<Integer, Integer> goldMedalsByAthlete = new HashMap<>();

        List<AthleteEvent> athletes =
                repository.getAthleteEvents();

        for (AthleteEvent athlete : athletes) {


            if (!"F".equals(athlete.getSex())) {
                continue;
            }


            if (!"Gold".equals(athlete.getMedal())) {
                continue;
            }

            int athleteId = athlete.getId();

            if (goldMedalsByAthlete.containsKey(athleteId)) {

                int currentCount =
                        goldMedalsByAthlete.get(athleteId);

                goldMedalsByAthlete.put(athleteId, currentCount + 1);
            } else {

                goldMedalsByAthlete.put(
                        athleteId,
                        1
                );
            }
        }

        return goldMedalsByAthlete;
    }

    public String getAthleteNameById(int athleteId) {

        List<AthleteEvent> athletes =
                repository.getAthleteEvents();

        for (AthleteEvent athlete : athletes) {

            if (athlete.getId() == athleteId) {
                return athlete.getName();
            }
        }

        return "Unknown";
    }


    //problem 6

    public Map<Integer, HashSet<String>> getAthleteOlympicParticipations() {

        Map<Integer,HashSet<String>> participation=new HashMap<>();

        List<AthleteEvent> athletes =
                repository.getAthleteEvents();

        for(AthleteEvent athlete :athletes){

            int athleteId=athlete.getId();
            String games=athlete.getGames();

            if(!participation.containsKey(athleteId)){
                participation.put(athleteId,new HashSet<>());
            }

            HashSet<String> gameSet=participation.get(athleteId);

            gameSet.add(games);
        }

        return participation;
    }

//Question-: Find the total number of Gold medals won by each NOC across all Olympics.

    public Map<String,Integer> getGoldMedalsBYNoc(){

        Map<String,Integer> goldMedalsByNoc=new HashMap<>();

        List<AthleteEvent> athletes =
                repository.getAthleteEvents();

        for(AthleteEvent athlete : athletes){



            if(!"Gold".equals(athlete.getMedal())){
                continue;
            }
            String noc=athlete.getNoc();

            if(!goldMedalsByNoc.containsKey(noc)){
                goldMedalsByNoc.put(noc,1);
            }else{
                int currentMedal=goldMedalsByNoc.get(noc);
                goldMedalsByNoc.put(noc,currentMedal+1);
            }

        }
        return goldMedalsByNoc;
    }


    //Question-:Find how many Gold medals were won in each sport.

    public Map<String,Integer> getTotalGoldMedalsInEachYear(){

        Map<String,Integer> totalGoldMedalsInEachYear=new HashMap<>();

        List<AthleteEvent> athletes=repository.getAthleteEvents();

        for( AthleteEvent athlete :athletes){

            String sport=athlete.getSport();

            if(!"Gold".equals(athlete.getMedal())){
                continue;
            }

            if(!totalGoldMedalsInEachYear.containsKey(sport)){
                totalGoldMedalsInEachYear.put(sport,1);
            }else{
                int currentMedals=totalGoldMedalsInEachYear.get(sport);
                totalGoldMedalsInEachYear.put(sport,currentMedals+1);
            }
        }
        return totalGoldMedalsInEachYear;
    }


    //-----Find athletes who participated in the Olympics but never won any medal.

    public Set<Integer> getAthletesNeverWonMedals(){

        Set<Integer> athletesNeverWonMedals=new HashSet<>();

        List<AthleteEvent> athletes=repository.getAthleteEvents();

        for(AthleteEvent athlete :athletes){

            if (!"NA".equals(athlete.getMedal())) {
                continue;
            }
            athletesNeverWonMedals.add(athlete.getId());
        }
        return athletesNeverWonMedals;
    }



    //Question-:Find the number of unique athletes who participated in each Olympic year.

public Map<Integer,HashSet<Integer>> getUniqueAthletesParticipatedEachYear(){

    Map<Integer,HashSet<Integer>> uniqueAthleteInEachYear=new HashMap<>();
    List<AthleteEvent> athletes=repository.getAthleteEvents();

    for( AthleteEvent athlete :athletes){

        int year=athlete.getYear();
        if(!uniqueAthleteInEachYear.containsKey(year)){
            uniqueAthleteInEachYear.put(year,new HashSet<>());
        }

        HashSet<Integer> athleteIds=uniqueAthleteInEachYear.get(year);
        athleteIds.add(athlete.getId());
    }
    return uniqueAthleteInEachYear;
}


//Question-:Find the number of unique athletes who participated in each Olympic year.

    public Map<Integer,HashSet<String>> getAthleteMaximumNumberOfDifferentOlympics(){


        Map<Integer,HashSet<String>> athleteMaximumNumberOfDifferentOlympics=new HashMap<>();

        List<AthleteEvent> athletes=repository.getAthleteEvents();

        for(AthleteEvent athlete:athletes){

            int athleteId=athlete.getId();

            if(!athleteMaximumNumberOfDifferentOlympics.containsKey(athleteId)){
                athleteMaximumNumberOfDifferentOlympics.put(athleteId,new HashSet<>());

            }

            HashSet<String> differentOlympics=athleteMaximumNumberOfDifferentOlympics.get(athleteId);

            differentOlympics.add(athlete.getGames());
        }
    return athleteMaximumNumberOfDifferentOlympics;

    }

    //problem-:For every Olympic year, find the number of unique athletes who won Gold.


    public Map<Integer,HashSet<Integer>> getNumberOfUniqueAthletesWhoWonGoldEveryOlympic(){

        Map<Integer,HashSet<Integer>> numberOfUniqueAthleteWhoWonGoldEverOlympic=new HashMap<>();

        List<AthleteEvent> athletes=repository.getAthleteEvents();

        for( AthleteEvent athlete :athletes){

            if(!"Gold".equals(athlete.getMedal())){
                continue;
            }

            int year=athlete.getYear();

            if(!numberOfUniqueAthleteWhoWonGoldEverOlympic.containsKey(year)){

                numberOfUniqueAthleteWhoWonGoldEverOlympic.put(year,new HashSet<>());
            }

            HashSet<Integer> getUniqueAthleteId=numberOfUniqueAthleteWhoWonGoldEverOlympic.get(year);

            int athleteId=athlete.getId();

            getUniqueAthleteId.add(athleteId);

        }
        return numberOfUniqueAthleteWhoWonGoldEverOlympic;
    }


    //Question-:Find the NOC that won the maximum number of Gold medals.

    public Map<String, Integer> getNocWonMaximumGoldMedals() {

        Map<String, Integer> goldMedalsByNoc =
                new HashMap<>();

        List<AthleteEvent> athletes =
                repository.getAthleteEvents();

        for (AthleteEvent athlete : athletes) {

            if (!"Gold".equals(athlete.getMedal())) {
                continue;
            }

            String noc = athlete.getNoc();

            if (!goldMedalsByNoc.containsKey(noc)) {

                goldMedalsByNoc.put(noc, 1);

            } else {

                int currentCount =
                        goldMedalsByNoc.get(noc);

                goldMedalsByNoc.put(
                        noc,
                        currentCount + 1
                );
            }
        }

        return goldMedalsByNoc;
    }





}
