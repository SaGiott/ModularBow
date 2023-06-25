package net.sagiott.modularbow.block

import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import net.sagiott.modularbow.ModularBow
import net.sagiott.modularbow.item.ModCreativeModeTab
import net.sagiott.modularbow.item.ModItems
import java.util.function.Supplier

class ModBlocks
{
    companion object
    {
        val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, ModularBow.MOD_ID)

        val ZIRCON_BLOCK: RegistryObject<Block> = registerBlock(
            "zircon_block",
            { Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops())},
            ModCreativeModeTab.TUTORIAL_TAB
        )

        val ZIRCON_ORE: RegistryObject<Block> = registerBlock(
            "zircon_ore",
            { DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)) },
            ModCreativeModeTab.TUTORIAL_TAB
        )

        val DEEPSLATE_ZIRCON_ORE: RegistryObject<Block> = registerBlock(
            "deepslate_zircon_ore",
            { DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)) },
            ModCreativeModeTab.TUTORIAL_TAB
        )

        val NETHERRACK_ZIRCON_ORE: RegistryObject<Block> = registerBlock(
            "netherrack_zircon_ore",
            { DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)) },
            ModCreativeModeTab.TUTORIAL_TAB
        )

        val ENDSTONE_ZIRCON_ORE: RegistryObject<Block> = registerBlock(
            "endstone_zircon_ore",
            { DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)) },
            ModCreativeModeTab.TUTORIAL_TAB
        )


        private fun <T : Block> registerBlock(name: String, block: Supplier<T>, tab: CreativeModeTab) : RegistryObject<T>
        {
            //Register the block to BLOCKS list
            val newBlock: RegistryObject<T> = BLOCKS.register(name, block)

            registerBlockItem(name, newBlock, tab)

            return newBlock
        }

        private fun <T : Block> registerBlockItem(name: String, block: Supplier<T>, tab: CreativeModeTab) : RegistryObject<Item>
        {
            //Register the block to ITEMS list
            return ModItems.ITEMS.register(name) { BlockItem(block.get(), Item.Properties().tab(tab)) }
        }
        fun register(eventBus: IEventBus)
        {
            BLOCKS.register(eventBus)
        }
    }
}