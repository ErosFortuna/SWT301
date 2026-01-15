package com.quoc.insurance.test;

import com.quoc.insurance.InsuranceClaim;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InsuranceClaimTest {

    private InsuranceClaim claim;

    // Runs once before all tests
    @BeforeAll
    void setUpAll() {
        System.out.println("=== Start InsuranceClaim Test Suite ===");
    }

    // Runs once after all tests
    @AfterAll
    void tearDownAll() {
        System.out.println("=== End InsuranceClaim Test Suite ===");
    }

    // Runs before each test
    @BeforeEach
    void setUp() {
        System.out.println("---- Before Test ----");
        claim = new InsuranceClaim("CL001", 1000);
    }

    // Runs after each test
    @AfterEach
    void tearDown() {
        System.out.println("---- After Test ----");
    }

    @Test
    @DisplayName("Process claim successfully when status is Pending")
    void testProcessClaimSuccess() {
        boolean result = claim.processClaim("Approved");
        assertTrue(result);
        assertEquals("Approved", claim.getClaimStatus());
    }

    @Test
    @DisplayName("Process claim fails when status is not Pending")
    void testProcessClaimFail() {
        claim.processClaim("Approved");
        assertFalse(claim.processClaim("Rejected"));
    }

    @Test
    @DisplayName("Calculate payout when claim is approved")
    void testCalculatePayoutApproved() {
        claim.processClaim("Approved");
        assertEquals(850, claim.calculatePayout());
    }

    @Test
    @DisplayName("Update claim amount with valid value")
    void testUpdateClaimAmountValid() {
        claim.updateClaimAmount(2000);
        assertEquals(2000, claim.getAmount());
    }

    // ===== NULL INPUT TESTS =====

    @Test
    @DisplayName("Constructor throws exception for null claim ID")
    void testConstructorNullClaimId() {
        assertThrows(IllegalArgumentException.class,
                () -> new InsuranceClaim(null, 1000.0));
    }

    @Test
    @DisplayName("Constructor throws exception for empty claim ID")
    void testConstructorEmptyClaimId() {
        assertThrows(IllegalArgumentException.class,
                () -> new InsuranceClaim("", 1000.0));
    }

    @Test
    @DisplayName("processClaim throws exception for null input")
    void testProcessClaimNullInput() {
        assertThrows(IllegalArgumentException.class,
                () -> claim.processClaim(null));
    }
}
