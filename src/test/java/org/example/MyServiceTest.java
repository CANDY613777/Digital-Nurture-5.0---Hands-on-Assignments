package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        // Step 1: Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub method
        when(mockApi.getData())
                .thenReturn("Mock Data");

        // Step 3: Inject mock
        MyService service =
                new MyService(mockApi);

        // Step 4: Call method
        String result =
                service.fetchData();

        // Step 5: Verify output
        assertEquals("Mock Data", result);
    }
}