import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockedListExamplesTest {

  @Test
  void someMockingExamples() {
    // Step 1. Create the mock object
    List<String> mockedList = Mockito.mock(List.class);

    // Step 2. Use the mock object
    mockedList.add("blue");
    mockedList.add("while");
    mockedList.add("red");
    mockedList.add("blue");

    //int size = mockedList.size() ;

    // Step 3. Verify
    Mockito.verify(mockedList, Mockito.times(2)).add("blue");
    Mockito.verify(mockedList, Mockito.never()).add("yellow");
    Mockito.verify(mockedList, Mockito.times(4)).add(Mockito.anyString());
    Mockito.verify(mockedList, Mockito.atLeastOnce()).add("blue");
    Mockito.verify(mockedList, Mockito.never()).size();
  }

  @Test
  void someStubbingExamples() {
    // Step 1. Create the mock object
    List<String> mockedList = Mockito.mock(List.class);

    // Step 2. Use the mock object
    mockedList.add("blue");
    mockedList.add("while");
    mockedList.add("red");
    mockedList.add("blue");

    int currentListSize = 4;
    Mockito.when(mockedList.size()).thenReturn(currentListSize);

    int actualListSize = mockedList.size();
    assertEquals(currentListSize, actualListSize);
  }

  @Test
  void spyExample() {
    List<String> list = new ArrayList<>();
    List<String> spyList = Mockito.spy(list);

    spyList.add("green");
    spyList.add("red");

    /***************Falta un par de líneas******************/
  }

  private class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  @Test
  void dummyExample(){
  List<Person> list = new ArrayList<>();

  Person dummy = new Person("Ana", 16);
  list.add(dummy);

  assertEquals(1, list.size());
  }
}
