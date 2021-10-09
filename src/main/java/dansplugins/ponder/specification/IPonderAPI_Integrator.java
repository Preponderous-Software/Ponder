package dansplugins.ponder.specification;

import dansplugins.ponder.implementation.PonderAPI;

public interface IPonderAPI_Integrator {
    boolean isDansAPIPresent();
    PonderAPI getAPI();
}
