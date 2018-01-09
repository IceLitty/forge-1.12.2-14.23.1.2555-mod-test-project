package com.gmail.litalways.icykingdoms;

import com.sun.istack.internal.NotNull;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class growBlock extends Block implements IGrowable {

    public static final IProperty<Integer> STAGE = PropertyInteger.create("stage", 0, 1);
//    protected static final AxisAlignedBB GROWBLOCK_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
//    protected static final AxisAlignedBB GROWBLOCK_GROWUP_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);

    public growBlock(@NotNull String name, @NotNull String localName, Material materialIn) {
        super(materialIn);
        this.setBlockUnbreakable();
        this.setLightLevel(2 / 15f);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(CreativeTabs.FOOD);
        this.setUnlocalizedName(localName);
        this.setRegistryName(name);
//        this.setTickRandomly(true);
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(STAGE, 0)
        );
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, STAGE);
    }

//    @Override
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
//    {
//        if (state.getValue(STAGE).equals(1)) {
//            return GROWBLOCK_GROWUP_AABB;
//        } else {
//            return GROWBLOCK_AABB;
//        }
//    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            int before = state.getValue(STAGE);
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
            System.out.println("cycle " + before + ", now -> " + worldIn.getBlockState(pos).getValue(STAGE));
            worldIn.scheduleUpdate(pos, this, 0);
        }
    }
}
