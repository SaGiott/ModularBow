package net.sagiott.modularbow.item

import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

class ModCreativeModeTab
{
    companion object
    {
        //New tab in creative mode inventory, add localization itemGroup
        val TUTORIAL_TAB: CreativeModeTab = object : CreativeModeTab("modularbow")
        {
            override fun makeIcon(): ItemStack
            {
                return ItemStack(ModItems.ZIRCON.get())
            }
        }
    }
}