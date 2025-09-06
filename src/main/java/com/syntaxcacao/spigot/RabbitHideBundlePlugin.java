package com.syntaxcacao.spigot;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Map;

import static java.util.Map.entry;

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

        // HARNESS //

        final Map<Material, Material> harnessColors = Map.ofEntries(
                entry(Material.WHITE_HARNESS, Material.WHITE_WOOL),
                entry(Material.ORANGE_HARNESS, Material.ORANGE_WOOL),
                entry(Material.MAGENTA_HARNESS, Material.MAGENTA_WOOL),
                entry(Material.LIGHT_BLUE_HARNESS, Material.LIGHT_BLUE_WOOL),
                entry(Material.YELLOW_HARNESS, Material.YELLOW_WOOL),
                entry(Material.LIME_HARNESS, Material.LIME_WOOL),
                entry(Material.PINK_HARNESS, Material.PINK_WOOL),
                entry(Material.GRAY_HARNESS, Material.GRAY_WOOL),
                entry(Material.LIGHT_GRAY_HARNESS, Material.LIGHT_GRAY_WOOL),
                entry(Material.CYAN_HARNESS, Material.CYAN_WOOL),
                entry(Material.PURPLE_HARNESS, Material.PURPLE_WOOL),
                entry(Material.BLUE_HARNESS, Material.BLUE_WOOL),
                entry(Material.BROWN_HARNESS, Material.BROWN_WOOL),
                entry(Material.GREEN_HARNESS, Material.GREEN_WOOL),
                entry(Material.RED_HARNESS, Material.RED_WOOL),
                entry(Material.BLACK_HARNESS, Material.BLACK_WOOL)
        );

        for (Map.Entry<Material, Material> entry : harnessColors.entrySet()) {
            // Remove default harness recipe
            this.getServer().removeRecipe(NamespacedKey.minecraft(entry.getKey().getKeyOrThrow().getKey()));

            // Add new harness recipe
            ShapedRecipe harnessRecipe = new ShapedRecipe(new NamespacedKey(this, entry.getKey().getKeyOrThrow().getKey()), new ItemStack(entry.getKey()));
            harnessRecipe.shape(" S ", "GWG", "   ");
            harnessRecipe.setIngredient('S', Material.SADDLE);
            harnessRecipe.setIngredient('G', Material.GLASS);
            harnessRecipe.setIngredient('W', entry.getValue());

            this.getServer().addRecipe(harnessRecipe);
        }

        // Add new harness-to-saddle recipe

        ShapelessRecipe saddleRecipe = new ShapelessRecipe(new NamespacedKey(this, "harnesses_saddle"), new ItemStack(Material.SADDLE));
        saddleRecipe.addIngredient(new RecipeChoice.MaterialChoice(new ArrayList<>(harnessColors.keySet())));

        this.getServer().addRecipe(saddleRecipe);
    }
}
