package org.mps.boundedqueue;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ArrayBoundedQueueTest {

    @Test //Testeo que el constructor de ArrayBoundedQueue tire la excepcion correspondiente
    void ArrayBoundedQueueMethodCheck() {
        ArrayBoundedQueue<Integer> queue;
        assertThatThrownBy(() -> new ArrayBoundedQueue<>(-2)).isInstanceOf(IllegalArgumentException.class).hasMessage("ArrayBoundedException: capacity must be positive");
        assertThatThrownBy(() -> new ArrayBoundedQueue<>(0)).isInstanceOf(IllegalArgumentException.class).hasMessage("ArrayBoundedException: capacity must be positive");
    }
    @Test //Testeo que el constructor de ArrayBoundedQueue inicialice correctamente los atributos
    void ArrayBoundedQueueMethodCheck2() {
        ArrayBoundedQueue<Integer> queue;
        queue = new ArrayBoundedQueue<>(4);
        assertThat(queue.isEmpty()).isTrue();
        assertThat(ReflectionTestUtils.getField(queue, "first")).isEqualTo(0); //Pruebo que al crearse la lista el first se inicializa en 0
        assertThat(ReflectionTestUtils.getField(queue, "nextFree")).isEqualTo(0); //Pruebo que al crearse la lista el nextFree se inicializa en 0
        assertThat(queue.size()).isEqualTo(0); //Pruebo que al crearse la lista el size se inicializa en 0
    }
    @Test //Testeo que funcione tanto el first como el nextFree como el size
    void ArrayBoundedQueueMethodCheck3() {
        ArrayBoundedQueue<Integer> queue;
        queue = new ArrayBoundedQueue<>(4);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        assertThat(queue.size()).isEqualTo(3);
        assertThat(ReflectionTestUtils.getField(queue, "first")).isEqualTo(0);
        assertThat(ReflectionTestUtils.getField(queue, "nextFree")).isEqualTo(3);
        assertThat(queue.size()).isEqualTo(3);

    }

    @Test //Testeo la excepcion de FullBoundedQueueException y que esté llena la cola
    void PutMethodCheck() {
        BoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);

        queue.put(1);
        queue.put(2);

        assertThat(queue.isFull()).isTrue();
        assertThatThrownBy(() -> queue.put(2)).isInstanceOf(FullBoundedQueueException.class);
    }
    @Test //Testeo la excepcion de IllegalArgumentException
    void PutMethodCheck2() {
        BoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);
        assertThatThrownBy(() -> queue.put(null)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test //testeo el iterator
    void PutMethodCheck3() {

        BoundedQueue<Integer> queue1 = new ArrayBoundedQueue<>(3);
        Iterator<Integer> iterator = queue1.iterator();

        queue1.put(1);
        queue1.put(2);

        int free = (int) ReflectionTestUtils.getField(queue1, "nextFree");
        iterator = queue1.iterator();
        for(int i = 0; i < free-1; i++){
            iterator.next();
        }

        assertThat(iterator.next()).isNotNull();
        assertThat(ReflectionTestUtils.getField(queue1, "first")).isEqualTo(0);
        assertThat(ReflectionTestUtils.getField(queue1, "nextFree")).isEqualTo(2);


    }

    @Test //Testeo la excepcion de EmptyBoundedQueueException
    void GetMethodCheck(){
        BoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);
        assertThatThrownBy(() -> queue.get()).isInstanceOf(EmptyBoundedQueueException.class);
    }

    @Test //Testeo que los elementos sean o nos null
    void GetMethodCheck2(){
        BoundedQueue<Integer> queue = new ArrayBoundedQueue<>(3);
        Iterator<Integer> iterator = queue.iterator();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.get();
        assertThat(queue.isEmpty()).isFalse();
        assertThat(iterator.next()).isNull();
        assertThat(iterator.next()).isNotNull();

    }

    @Test //Testeo que el first se inicialice en 0
    void GetMethodCheck3(){
        BoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);
        queue.put(1);
        assertThat(ReflectionTestUtils.getField(queue, "first")).isEqualTo(0);

    }

    @Test //Testeo la excepcion de NosuchElementException
    void AdvanceMethodCheck(){
        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);
        Iterator<Integer> iterator = queue.iterator();

        queue.put(1);
        queue.put(2);

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1).isNotNull();
        assertThatThrownBy(() -> {
            for(int i = 0; i < 2; i++){
                iterator.next();
            }
        }).isInstanceOf(NoSuchElementException.class).hasMessage("next: bounded queue iterator exhausted");

    }

    @Test //Hago set de campos privados para testear despues una vez modificados con datos mayores ó menores
    void FirstCheck(){
        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);
        Iterator<Integer> iterator = queue.iterator();
        queue.put(1);
        queue.put(2);

        ReflectionTestUtils.setField(queue, "first", 1);
        ReflectionTestUtils.setField(queue, "nextFree", 0);
        ReflectionTestUtils.setField(queue, "buffer", null);
        ReflectionTestUtils.setField(queue, "size", 1);
        ReflectionTestUtils.setField(iterator, "current", 0);

        assertThat(ReflectionTestUtils.getField(queue, "first")).isEqualTo(1);
        assertThat(ReflectionTestUtils.getField(queue, "nextFree")).isEqualTo(0);
        assertThat(ReflectionTestUtils.getField(queue, "buffer")).isNull();
        assertThat(ReflectionTestUtils.getField(queue, "size")).isEqualTo(1);
        assertThat(ReflectionTestUtils.getField(iterator, "current")).isEqualTo(0);
    }

    @Test //Testeo que los elementos sean o no null
        void nullCheck(){
        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(3);
        Iterator<Integer> iterator = queue.iterator();

        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.get();

        assertThat(iterator.next()).isNull();
        assertThat(iterator.next()).isNotNull();
    }

    @Test //Hago set de campos privados para testear despues una vez modificados con datos mayores ó menores
    void FirstIndexCheck(){

        ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<>(2);
        Iterator<Integer> iterator = queue.iterator();

        queue.put(1);
        queue.put(2);
        queue.get();


        ReflectionTestUtils.setField(queue, "first", 0);
        ReflectionTestUtils.setField(queue, "nextFree", 1);
        ReflectionTestUtils.setField(queue, "buffer", null);
        ReflectionTestUtils.setField(queue, "size", 1);
        ReflectionTestUtils.setField(iterator, "current", 1);

        assertThat(ReflectionTestUtils.getField(queue, "first")).isEqualTo(0);
        assertThat(ReflectionTestUtils.getField(queue, "nextFree")).isEqualTo(1);
        assertThat(ReflectionTestUtils.getField(queue, "buffer")).isNull();
        assertThat(ReflectionTestUtils.getField(queue, "size")).isEqualTo(1);
        assertThat(ReflectionTestUtils.getField(iterator, "current")).isEqualTo(1);
    }

}