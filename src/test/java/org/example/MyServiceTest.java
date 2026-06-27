package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("Mock Data");
        MyService service =
                new MyService(mockApi);

        String result =
                service.fetchData();

        assertEquals("Mock Data", result);
    }
        @Test
        public void testVerify() {
            System.out.println("Creating mock ExternalApi");
            ExternalApi mockApi = mock(ExternalApi.class);
            //Stub method
            when(mockApi.getData()).thenReturn("Mocked Response");
            MyService service = new MyService(mockApi);
            String result = service.fetchData();
            //Verification
            verify(mockApi).getData();
            assertEquals("Mocked Response", result);
            System.out.println("Verification Successfully Passed function was called and returned: " + result);
        }
    }
