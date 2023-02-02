package com.yeahbutstill.rest.webservices.restfulwebservices.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class ListTest {

    @Test
    void testMultimpleReturen() {
        List listMock = Mockito.mock(List.class);
        //listMock.size() => 3
        Mockito.when(listMock.size()).thenReturn(3).thenReturn(2);
        Assertions.assertEquals(3, listMock.size());
        Assertions.assertEquals(2, listMock.size());
    }

    @Test
    void testSpesicifParameters() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.get(0)).thenReturn("SomeString");
        Assertions.assertEquals("SomeString", listMock.get(0));
        Assertions.assertEquals(null, listMock.get(1));
    }

    @Test
    void genericParameters() {
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");
        Assertions.assertEquals("SomeString", listMock.get(0));
        Assertions.assertEquals("SomeString", listMock.get(1));
    }
}
