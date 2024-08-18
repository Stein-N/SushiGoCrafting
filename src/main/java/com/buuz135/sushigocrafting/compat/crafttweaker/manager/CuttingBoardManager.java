package com.buuz135.sushigocrafting.compat.crafttweaker.manager;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.buuz135.sushigocrafting.proxy.SushiContent;
import com.buuz135.sushigocrafting.recipe.CuttingBoardRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.sushigocrafting.CuttingBoard")
public class CuttingBoardManager implements IRecipeManager<CuttingBoardRecipe> {

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, String foodOutput) {
        name = fixRecipeName(name);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new RecipeHolder<>(ResourceLocation.fromNamespaceAndPath("crafttweaker", name), new CuttingBoardRecipe(input.asVanillaIngredient(), foodOutput))));
    }

    @Override
    public void remove(IIngredient output) {
        throw new RuntimeException("Cutting Board recipes can only be removed by name, not output!");
    }

    @Override
    public RecipeType<CuttingBoardRecipe> getRecipeType() {
        return (RecipeType<CuttingBoardRecipe>) SushiContent.RecipeTypes.CUTTING_BOARD.get();
    }
}
