package com.in28minutes.mockito.mockitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockAnnotationsTest {
	
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;
	

	@Test
	void testFindTheGreatestFromAllData() {
				
//		dataServiceMock.retrieveAllData() => new int[] {24, 15, 3};
		//When.thenReturn
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24, 15, 3});
				
		assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}
	@Test
	void testFindTheGreatestFromAllData_ForOneValue() {
				
//		dataServiceMock.retrieveAllData() => new int[] {24, 15, 3};
		//When.thenReturn
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
				
		
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}
	@Test
	void testFindTheGreatestFromAllData_ForNoValue() {
		
//		dataServiceMock.retrieveAllData() => new int[] {24, 15, 3};
		//When.thenReturn
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		
		
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}

