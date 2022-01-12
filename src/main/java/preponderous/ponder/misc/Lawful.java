/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

import java.util.ArrayList;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Lawful {
    void addLaw(String newLaw);
    boolean removeLaw(String lawToRemove);
    boolean removeLaw(int i);
    boolean editLaw(int i, String newString);
    int getNumLaws();
    ArrayList<String> getLaws();
}