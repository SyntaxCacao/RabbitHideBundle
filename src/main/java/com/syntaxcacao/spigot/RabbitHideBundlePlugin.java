package com.syntaxcacao.spigot;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class RabbitHideBundlePlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        // Remove default bundle recipe
        this.getServer().removeRecipe(NamespacedKey.minecraft("bundle"));

        // Add new bundle recipe
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "bundle"), new ItemStack(Material.BUNDLE));
        recipe.shape("SHS", "H H", "HHH");
        recipe.setIngredient('H', Material.RABBIT_HIDE);
        recipe.setIngredient('S', Material.STRING);

        this.getServer().addRecipe(recipe);
    }
}
