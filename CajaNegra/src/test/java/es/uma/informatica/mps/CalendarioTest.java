package es.uma.informatica.mps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Month;

import static es.uma.informatica.mps.Calendario.diaSemana;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalendarioTest {
    @Test
    @Tag("1")
    @DisplayName("Meses posibles")
    void Mesesposiblesvalidos() {

        assertDoesNotThrow(() -> diaSemana(1, 1, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 2, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 3, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 4, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 5, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 6, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 7, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 8, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 9, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 10, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 11, 2020));
        assertDoesNotThrow(() -> diaSemana(1, 12, 2020));

    }
    @Test
    @Tag("2")@Tag("3")
    @DisplayName("Meses invalidos")
    void Mesesinvalidos() {
        assertThrows(IllegalArgumentException.class, () -> diaSemana(1, 13, 2020));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(1, 0, 2020));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(1, 14, 2020));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(1, -1, 2020));
    }

    @Test
    @Tag("4")
    @DisplayName("Dias validos en febrero en años bisiesto")
    void diasPosiblesFebreroBisesto() {
        Integer mes = 2;
        assertDoesNotThrow(() -> diaSemana(1, mes, 8));
        assertDoesNotThrow(() -> diaSemana(5, mes, 8));
        assertDoesNotThrow(() -> diaSemana(7, mes, 12));
        assertDoesNotThrow(() -> diaSemana(10, mes, 16));
        assertDoesNotThrow(() -> diaSemana(15, mes, 20));
        assertDoesNotThrow(() -> diaSemana(26, mes, 24));
        assertDoesNotThrow(() -> diaSemana(29, mes, 28));

    }

    @Test
    @Tag("5")@Tag("6")
    @DisplayName("Dias invalidos en febrero en años bisiesto")
    void diasnoPosiblesFebreroBisesto() {
        Integer mes = 2;
        assertThrows(IllegalArgumentException.class,() -> diaSemana(-1, mes, 8));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(0, mes, 8));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(30, mes, 12));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(40, mes, 16));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(50, mes, 20));
    }

    @Test
    @Tag("7")
    @DisplayName("Dias validos en febrero en años no bisiesto")
    void diasPosiblesFebreronoBisesto() {
        Integer mes = 2;
        assertDoesNotThrow(() -> diaSemana(1, mes, 9));
        assertDoesNotThrow(() -> diaSemana(5, mes, 11));
        assertDoesNotThrow(() -> diaSemana(7, mes, 13));
        assertDoesNotThrow(() -> diaSemana(10, mes, 17));
        assertDoesNotThrow(() -> diaSemana(15, mes, 21));
        assertDoesNotThrow(() -> diaSemana(26, mes, 25));
        assertDoesNotThrow(() -> diaSemana(28, mes, 29));

    }

    @Test
    @Tag("8")@Tag("9")
    @DisplayName("Dias invalidos en febrero en años no bisiesto")
    void diasnoPosiblesFebreronoBisesto() {
        Integer mes = 2;
        assertThrows(IllegalArgumentException.class,() -> diaSemana(-1, mes, 5));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(0, mes, 9));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(29, mes, 11));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(40, mes, 17));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(50, mes, 21));
    }

    @Test
    @Tag("10")
    @DisplayName("Dias validos en meses de 31 días")
    void diasPosiblesMeses31Dias() {
        Integer enero = 1;
        Integer marzo = 1;
        Integer mayo = 1;
        Integer julio = 1;
        Integer agosto = 1;
        Integer octubre = 1;
        Integer diciembre = 1;

        assertDoesNotThrow(() -> diaSemana(1, enero, 9));
        assertDoesNotThrow(() -> diaSemana(5, marzo, 11));
        assertDoesNotThrow(() -> diaSemana(7, mayo, 13));
        assertDoesNotThrow(() -> diaSemana(10, julio, 17));
        assertDoesNotThrow(() -> diaSemana(15, agosto, 21));
        assertDoesNotThrow(() -> diaSemana(26, octubre, 25));
        assertDoesNotThrow(() -> diaSemana(31, diciembre, 29));
    }

    @Test
    @Tag("11")@Tag("12")
    @DisplayName("Dias invalidos en meses de 31 días")
    void diasnoPosiblesMeses31Dias() {
        Integer enero = 1;
        Integer marzo = 1;
        Integer mayo = 1;
        Integer julio = 1;
        Integer agosto = 1;
        Integer octubre = 1;
        Integer diciembre = 1;

        assertThrows(IllegalArgumentException.class,() -> diaSemana(-1, enero, 5));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(0, marzo, 9));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(32, mayo, 11));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(40, julio, 17));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(42, agosto, 17));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(50, octubre, 17));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(60, diciembre, 17));
    }

    @Test
    @Tag("13")
    @DisplayName("Dias validos en meses de 30 días")
    void diasPosiblesMeses30Dias() {
        Integer abril = 4;
        Integer junio = 6;
        Integer septiembre = 9;
        Integer noviemrbre = 11;


        assertDoesNotThrow(() -> diaSemana(1, abril, 9));
        assertDoesNotThrow(() -> diaSemana(5, junio, 11));
        assertDoesNotThrow(() -> diaSemana(17, septiembre, 13));
        assertDoesNotThrow(() -> diaSemana(30, noviemrbre, 17));
    }

    @Test
    @Tag("14")@Tag("15")
    @DisplayName("Dias invalidos en meses de 30 días")
    void diasnoPosiblesMeses30Dias() {
        Integer abril = 4;
        Integer junio = 6;
        Integer septiembre = 9;
        Integer noviemrbre = 11;

        assertThrows(IllegalArgumentException.class,() -> diaSemana(-1, abril, 5));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(0, junio, 9));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(31, septiembre, 11));
        assertThrows(IllegalArgumentException.class,() -> diaSemana(40, noviemrbre, 17));}
    @Test
    @Tag("16")
    @DisplayName("fechas validas para introducir")
    void fechasPosibleParaIntroducir(){
        assertDoesNotThrow(() -> diaSemana(2, 3, 4));
        assertDoesNotThrow(() -> diaSemana(2, 4, 1000));
        assertDoesNotThrow(() -> diaSemana(4, 7, 2020));
        assertDoesNotThrow(() -> diaSemana(5, 8, 3000));
        assertDoesNotThrow(() -> diaSemana(1, 3, 4000));
    }

    @Test
    @Tag("17")@Tag("18")
    @DisplayName("fechas invalidas para introducir")
    void fechasnoPosibleParaIntroducir() {
        assertThrows(IllegalArgumentException.class, () -> diaSemana(-1, 3, 4));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(-2, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(-3, 5, 2));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(-4, 6, 1));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(-5, 7, 1582));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(5, 10, 1582));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(6, 10, 1582));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(7, 10, 1582));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(8, 10, 1582));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(14, 10, 1582));
    }

    @Test
    @Tag("19")
    @DisplayName("años bisiestos validos para introducir")
    void anoBisiestosPosibles(){
        assertDoesNotThrow(() -> diaSemana(2, 3, 4));
        assertDoesNotThrow(() -> diaSemana(2, 4, 8));
        assertDoesNotThrow(() -> diaSemana(4, 7, 12));
        assertDoesNotThrow(() -> diaSemana(5, 8, 1240));
        assertDoesNotThrow(() -> diaSemana(1, 3, 4040));
    }

    @Test
    @Tag("20")@Tag("21")
    @DisplayName("años bisiestos invalidos para introducir")
    void anoBisiestosnoPosibles() {
        assertThrows(IllegalArgumentException.class, () -> diaSemana(29, 2, 1700));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(29, 2, 1800));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(29, 2, 2100));
        assertThrows(IllegalArgumentException.class, () -> diaSemana(29, 2, 1801));
    }
}