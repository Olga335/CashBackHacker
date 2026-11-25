package ru.netology.service;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CashbackHackServiceTest {

    private final CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldReturnRemainForAmountLessThanBoundary() {
        // amount = 900, нужно докупить 100
        int actual = service.remain(900);
        assertEquals(actual, 100);
    }

    @Test
    public void shouldReturnZeroWhenAmountIsExactMultipleOfBoundary() {
        // amount = 1000, уже кратно, докупать не нужно, ожидается 0
        // Этот тест упадёт — это известный дефект
        int actual = service.remain(1000);
        assertEquals(actual, 0);
    }

    @Test
    public void shouldReturnRemainForAmountGreaterThanBoundary() {
        // amount = 1500, нужно докупить 500
        int actual = service.remain(1500);
        assertEquals(actual, 500);
    }

    @Test
    public void shouldReturnBoundaryForAmountZero() {
        // amount = 0, нужно докупить 1000
        int actual = service.remain(0);
        assertEquals(actual, 1000);
    }
}
