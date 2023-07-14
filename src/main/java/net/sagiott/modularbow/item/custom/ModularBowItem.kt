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
        var BLADES: Int = 0
        var SIGHT: Int = 0
        val GRIP: BooleanProperty = BooleanProperty.create("grip")
        val STABILIZER: BooleanProperty = BooleanProperty.create("stabilizer")
        val CLICKER: BooleanProperty = BooleanProperty.create("clicker")
        val STRING: BooleanProperty = BooleanProperty.create("string")
        val PULLEY: BooleanProperty = BooleanProperty.create("pulley")
    }
}