package preponderous.ponder.misc.modifiers;

import java.util.ArrayList;

public interface Nation extends dansplugins.factionsystem.objects.specification.generic.Group, dansplugins.factionsystem.objects.specification.generic.Diplomatic {

    // laws
    void addLaw(String newLaw);
    boolean removeLaw(String lawToRemove);
    boolean removeLaw(int i);
    boolean editLaw(int i, String newString);
    int getNumLaws();
    ArrayList<String> getLaws();

}