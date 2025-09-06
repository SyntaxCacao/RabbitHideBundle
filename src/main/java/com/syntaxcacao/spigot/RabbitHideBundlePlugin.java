package com.syntaxcacao.spigot;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

/** @noinspection unused  */
public class RabbitHideBundlePlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        // BUNDLE //

        // Remove default bundle recipe
        this.getServer().removeRecipe(NamespacedKey.minecraft("bundle"));

        // Add new bundle recipe
        ShapedRecipe bundleRecipe = new ShapedRecipe(new NamespacedKey(this, "bundle"), new ItemStack(Material.BUNDLE));
        bundleRecipe.shape("SHS", "H H", "HHH");
        bundleRecipe.setIngredient('H', Material.RABBIT_HIDE);
        bundleRecipe.setIngredient('S', Material.STRING);

        this.getServer().addRecipe(bundleRecipe);

        // LEAD //

        // Remove default lead recipe
        this.getServer().removeRecipe(NamespacedKey.minecraft("lead"));

        // Add new lead recipe
        ShapedRecipe leadRecipe = new ShapedRecipe(new NamespacedKey(this, "lead"), new ItemStack(Material.LEAD, 2));
        leadRecipe.shape(" SS", " BS", "S  ");
        leadRecipe.setIngredient('S', Material.STRING);
        leadRecipe.setIngredient('B', Material.SLIME_BALL);

        this.getServer().addRecipe(leadRecipe);

        // SADDLE //

        // Remove saddle recipe
        this.getServer().removeRecipe(NamespacedKey.minecraft("saddle"));
    }
}
