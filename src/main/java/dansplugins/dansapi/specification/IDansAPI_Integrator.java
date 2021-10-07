package dansplugins.dansapi.specification;

import dansplugins.dansapi.implementation.DansAPI;

public interface IDansAPI_Integrator {
    boolean isDansAPIPresent();
    DansAPI getAPI();
}
