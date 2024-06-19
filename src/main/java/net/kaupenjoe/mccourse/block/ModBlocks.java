package net.kaupenjoe.mccourse.block;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.custom.MagicBlock;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Block> AZURITE_BLOCK = registerBlock("azurite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> AZURITE_ORE = registerBlock("azurite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURITE_DEEPSLATE_ORE = registerBlock("azurite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURITE_END_ORE = registerBlock("azurite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(5, 9),
                    BlockBehaviour.Properties.of().strength(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURITE_NETHER_ORE = registerBlock("azurite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 5),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noLootTable()));

    public static final RegistryObject<Block> AZURITE_STAIRS = registerBlock("azurite_stairs",
            () -> new StairBlock(ModBlocks.AZURITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURITE_SLAB = registerBlock("azurite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
