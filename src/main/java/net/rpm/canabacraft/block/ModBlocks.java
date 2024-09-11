package net.rpm.canabacraft.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rpm.canabacraft.CanabaCraft;
import net.rpm.canabacraft.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CanabaCraft.MOD_ID);

    //public static final DeferredBlock<Block> HEMP_CROP = BLOCKS.register("hemp_crop",
    //        () -> new HempCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final DeferredBlock<Block> KILO_BLOCK = registerBlock("kilo_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f, 2f)
                    .sound(SoundType.WET_GRASS)
                    .ignitedByLava()));


    //Adds blocks to register and then calls the block item function
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //Adds a holdable block item for the block
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
