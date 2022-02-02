package com.github.beastyboo.consumable;

import java.util.function.Predicate;

public interface Abilities {

    <T> void healthIncrease(Predicate<T> increase);

}
