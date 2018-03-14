package se.resonantri.stargazerutil.common.blocks;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.minecraft.block.properties.PropertyEnum;

import java.util.Collection;

public class PropertyTType extends PropertyEnum<ENUM_TTYPE> {
    protected PropertyTType(String name, Class<ENUM_TTYPE> valueClass, Collection<ENUM_TTYPE> allowedValues) {
        super(name, ENUM_TTYPE.class, allowedValues);
    }
    protected PropertyTType(String name, Collection<ENUM_TTYPE> values)
    {
        super(name, ENUM_TTYPE.class, values);
    }

    public static PropertyTType create(String name)
    {
        return create(name, Predicates.alwaysTrue());
    }

    public static PropertyTType create(String name, Predicate<ENUM_TTYPE> filter)
    {
        return create(name, Collections2.filter(Lists.newArrayList(ENUM_TTYPE.values()), filter));
    }

    public static PropertyTType create(String name, Collection<ENUM_TTYPE> values)
    {
        return new PropertyTType(name, values);
    }
}