package com.yeahbutstill.rest.webservices.restfulwebservices.business;


import com.yeahbutstill.rest.webservices.restfulwebservices.business.dataservice.DataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void findTheGreatTestFormAllDataScenario() {

        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new Integer[] {25, 100, 15, 5});
        Integer result = someBusiness.findTheGreatTestFormAllData();
        Assertions.assertEquals(100, result);

    }

    @Test
    void findTheGreatTestFormAllDataScenarioEmptyArray() {

        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new Integer[] {});
        Integer result = someBusiness.findTheGreatTestFormAllData();
        Assertions.assertEquals(Integer.MIN_VALUE, result);

    }

}