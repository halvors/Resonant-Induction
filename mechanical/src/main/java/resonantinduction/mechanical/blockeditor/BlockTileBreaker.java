package resonantinduction.mechanical.blockeditor;

import calclavia.lib.content.module.prefab.TileInventory;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

/**
 * @since 18/03/14
 * @author tgame14
 */
public class BlockTileBreaker extends TileInventory
{

    public BlockTileBreaker (String name, Material material)
    {
        super(name, material);
    }

    @Override
    public int getWeakRedstonePower (IBlockAccess access, int side)
    {
        int facing = access.getBlockMetadata(x(), y(), z());
        if (facing != side)
        {
            ForgeDirection dir = ForgeDirection.getOrientation(facing);
            Block block = Block.blocksList[access.getBlockId(x() + dir.offsetX, y() + dir.offsetY, z() + dir.offsetZ)];
            int candidateMeta = access.getBlockMetadata(x() + dir.offsetX, y() + dir.offsetY, z() + dir.offsetZ);
            boolean flag = true;
            for (ItemStack stack : block.getBlockDropped(getWorldObj(), x(), y(), z(), candidateMeta, 0))
                if (!this.canInsertItem(0, stack, facing))
                {
                    flag = false;
                }
            if (flag)
            {
                getWorldObj().destroyBlock(x() + dir.offsetX, y() + dir.offsetY, z(), false);
            }


        }

        return super.getWeakRedstonePower(access, side);
    }
}
