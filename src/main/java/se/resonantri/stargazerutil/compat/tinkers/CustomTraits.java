package se.resonantri.stargazerutil.compat.tinkers;

import se.resonantri.stargazerutil.compat.tinkers.traits.TraitButtery;
import se.resonantri.stargazerutil.compat.tinkers.traits.TraitInfernal;
import se.resonantri.stargazerutil.compat.tinkers.traits.TraitStarascribed;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class CustomTraits {
    public static final AbstractTrait buttery = new TraitButtery();
    public static final AbstractTrait infernal = new TraitInfernal();
    public static final AbstractTrait starascribed1 = new TraitStarascribed(1);
    public static final AbstractTrait starascribed2 = new TraitStarascribed(2);
}
