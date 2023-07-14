package net.sagiott.modularbow.item.custom

import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.BowItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.properties.BooleanProperty

class ModularBowItem(properties: Properties) : BowItem(properties)
{
    companion object
    {
        var BLADES: BowBlade? = null
        val HAS_GRIP: BooleanProperty = BooleanProperty.create("has_grip")
    }
}