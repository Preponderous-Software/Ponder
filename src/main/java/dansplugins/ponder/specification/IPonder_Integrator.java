package dansplugins.ponder.specification;

import dansplugins.ponder.implementation.PonderAPI;

public interface IPonder_Integrator {
    boolean isDansAPIPresent();
    PonderAPI getAPI();
}
