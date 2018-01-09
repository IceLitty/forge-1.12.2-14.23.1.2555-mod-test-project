package com.gmail.litalways.icykingdoms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit()
    {
        this.initializeConfiguration();
        this.registerLootTables();
        this.registerCreativeTabs();
    }

    public void init()
    {
        this.registerOreDictionaryEntries();
        this.registerWorldGenerator();
    }

    public void postInit()
    {

    }

    private void initializeConfiguration()
    {

    }

    private void registerLootTables()
    {

    }

    private void registerCreativeTabs()
    {

    }

    private void registerOreDictionaryEntries()
    {
        RegistryFunc.registerOreDictionaryEntries();
    }

    private void registerWorldGenerator()
    {

    }
}
