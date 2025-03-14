package com.ooz.Our.Own.Zeta.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CivilizationTest {

    @Test
    public void CivilizationStartsAtZero(){

        Civilization civilization = new Civilization();

        assertEquals(0,civilization.getAge());
        assertTrue(civilization.getResources().isEmpty(),"Resources is not empty");
        assertTrue(civilization.getDiscoveries().isEmpty(),"Discoveries is not empty");
        assertEquals(0,civilization.getPopulation());
        assertTrue(civilization.getImportantIndividuals().isEmpty(),"Individuals is not empty");
        assertTrue(civilization.getEventsLog().isEmpty(),"EventLogs is not empty");
    }

    @Test
    public void CivilizationAging5years(){
        Civilization civilization = new Civilization();
        civilization.passTime(5); //pasing 5 years
        assertEquals(5,civilization.getAge());
    }

    @Test
    public void creatingAScientist(){
        Civilization civilization = new Civilization();
        Person scientist = civilization.createImportantPerson(20,"Aki","Scientist",null,true,0);
        assertEquals(20,scientist.getAge());
        assertEquals("Aki",scientist.getName());
        assertEquals("Scientist",scientist.getField());
        assertTrue(scientist.getDiscoveries().isEmpty(),"Discoveries are not empty");
        assertTrue(scientist.isAlive(),"Person is not alive");
        assertEquals(0,scientist.getKnowledge());
    }

    @Test
    public void creatingAnArtist(){
        Civilization civilization = new Civilization();
        Person artist = civilization.createImportantPerson(20,"Aki","Scientist",null,true,0);
        assertEquals(20,artist.getAge());
        assertEquals("Aki",artist.getName());
        assertEquals("Scientist",artist.getField());
        assertTrue(artist.getDiscoveries().isEmpty(),"Discoveries are not empty");
        assertTrue(artist.isAlive(),"Person is not alive");
        assertEquals(0,artist.getKnowledge());
    }

    @Test
    public void creatingAnAthlete(){
        Civilization civilization = new Civilization();
        Person athlete = civilization.createImportantPerson(20,"Aki","Scientist",null,true,0);
        assertEquals(20,athlete.getAge());
        assertEquals("Aki",athlete.getName());
        assertEquals("Athlete",athlete.getField());
        assertTrue(athlete.getDiscoveries().isEmpty(),"Discoveries are not empty");
        assertTrue(athlete.isAlive(),"Person is not alive");
        assertEquals(0,athlete.getKnowledge());
    }

}