package es.uma.informatica.mps;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static es.uma.informatica.mps.Calendario.diaSemana;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalendarioTest {
    @Test
    void testMain() {
        DayOfWeek dayofweek = diaSemana(1, 1, 2020);
        assertEquals(DayOfWeek.WEDNESDAY, dayofweek);
    }
    @Test
    void ExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> diaSemana(1, 13, 2020));
    }

    @Test
    void isleapyearTest() {
        DayOfWeek dayofweek = diaSemana(29, 2, 2024);
        assertDoesNotThrow(() -> dayofweek);
    }

    @Test
    void isnotleapyearTest() {
        assertThrows(IllegalArgumentException.class, () -> diaSemana(29, 2, 1700));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(29, 2, 1800));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(29, 2, 2100));
    }

    @Test
    void notexistingdays(){
        assertThrows(IllegalArgumentException.class, () -> {
                for(int dia = 5; dia < 15; dia++){
                    diaSemana(dia, 10, 1582);
                }
            }
        );
    }

    @Test
    void notexistingmonth(){
        int ano = 1583;
        while(ano > 1582 && ano % 400 == 0){
            int finalAno = ano;
            assertDoesNotThrow(() -> diaSemana(29, 2, finalAno));
            ano++;
        }
    }

}