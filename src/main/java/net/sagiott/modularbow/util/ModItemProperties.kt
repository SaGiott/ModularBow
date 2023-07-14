package net.sagiott.modularbow.util

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.sagiott.modularbow.item.ModItems

class ModItemProperties
{
    companion object
    {
        fun addCustomItemProperties()
        {
            makeBow(ModItems.MODULAR_BOW.get())
        }

        private fun makeBow(item: Item)
        {
            ItemProperties.register(item, ResourceLocation("pull")
            ) { stack: ItemStack, _, entity: LivingEntity?, _ ->
                if (entity == null)
                {
                    return@register 0.0f
                }
                else
                {
                    return@register if (entity.useItem != stack) 0.0f else (stack.useDuration - entity.useItemRemainingTicks).toFloat() / 20.0f
                }
            }
            ItemProperties.register(item, ResourceLocation("pulling"))
            { stack: ItemStack, _, entity: LivingEntity?, _ ->
                if (entity != null && entity.isUsingItem && entity.useItem == stack) 1.0f else 0.0f
            }
        }
    }


}