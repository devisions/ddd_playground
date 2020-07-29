package pps.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PoliceInvestigationTest {

    PNCId pncId;
    Suspect suspect;
    PoliceInvestigation anInvestigation;

    @BeforeEach
    public void setup() {
        pncId = new PNCId("1234-ESDT");
        suspect = new Suspect(CriminalOffence.FALSE_ACCOUNTING);
        anInvestigation = new PoliceInvestigation(pncId, suspect);
    }

    @Test
    public void mustHaveAPoliceNationalComputerId() {
        assertNotNull(anInvestigation.pncId);
    }

    @Test
    public void cannotBeCreatedWithAnEmptyPoliceNationalComputerId() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> anInvestigation = new PoliceInvestigation(null, suspect));
        assertTrue(exception.getMessage().contains("You must provide a PNC Id"));
    }

    @Test
    public void cannotBeCreatedWithNoSuspect() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> anInvestigation = new PoliceInvestigation(pncId, null));
        assertTrue(exception.getMessage().contains("You must provide a suspect"));
    }

}
