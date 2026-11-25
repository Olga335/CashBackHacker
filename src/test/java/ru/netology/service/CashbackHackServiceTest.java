package ru.netology.service;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CashbackHackServiceTest {

    private final CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldReturnRemainForAmountLessThanBoundary() {
        int actual = service.remain(900);
        assertEquals(100, actual);
    }

    @Test
    public void shouldReturnZeroWhenAmountIsExactMultipleOfBoundary() {
        // Ожидается 0, фактически будет 1000 — тест упадёт
        int actual = service.remain(1000);
        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnRemainForAmountGreaterThanBoundary() {
        int actual = service.remain(1500);
        assertEquals(500, actual);
    }

    @Test
    public void shouldReturnBoundaryForAmountZero() {
        int actual = service.remain(0);
        assertEquals(1000, actual);
    }
}
