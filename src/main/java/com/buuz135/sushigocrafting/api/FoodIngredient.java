package com.buuz135.sushigocrafting.api;

import com.buuz135.sushigocrafting.proxy.SushiContent;
import net.minecraft.item.Item;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public enum FoodIngredient implements IFoodIngredient {
    RICE("rice", SushiContent.Items.COOKED_RICE),
    NORI("nori", SushiContent.Items.NORI_SHEET),
    TUNA_FILLET("tuna", SushiContent.Items.RAW_TUNA_FILLET),
    SALMON_FILLET("salmon", SushiContent.Items.RAW_SALMON_FILLET),
    AVOCADO("avocado", SushiContent.Items.AVOCADO),
    CUCUMBER("cucumber", SushiContent.Items.CUCUMBER_SEED),
    SESAME("sesame", SushiContent.Items.SESAME_SEED),
    CRAB("crab", SushiContent.Items.CRAB);

    private final Supplier<? extends Item> item;
    private final String name;

    FoodIngredient(String name, Supplier<? extends Item> item) {
        this.name = name;
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Nullable
    public static FoodIngredient fromItem(Item item) {
        for (FoodIngredient value : values()) {
            if (value.getItem().equals(item)) return value;
        }
        return null;
    }
}
