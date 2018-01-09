package com.gmail.litalways.icykingdoms;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber
@ObjectHolder("icykingdoms")
public class RegistryFunc {
    public static final growBlock GROWBLOCKBLOCK = new growBlock("growblock", "gb", Material.WOOD);
    public static final Item GROWBLOCKITEMBLOCK = new ItemBlock(GROWBLOCKBLOCK).setRegistryName(GROWBLOCKBLOCK.getRegistryName());

    @SubscribeEvent
    public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                GROWBLOCKBLOCK
        );
    }

    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                GROWBLOCKITEMBLOCK
        );
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onRegisterModels(ModelRegistryEvent event) {
        for (Block block : new Block[] { GROWBLOCKBLOCK })
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }

    public static void registerOreDictionaryEntries()
    {
        OreDictionary.registerOre("growTreasure", new ItemStack(GROWBLOCKBLOCK, 1, OreDictionary.WILDCARD_VALUE));
    }
}
